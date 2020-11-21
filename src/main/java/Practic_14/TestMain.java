package Practic_14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) {
        String str;
        String[] oldRules;
        String[] newRules;
        int numRules;
        Scanner scanner = new Scanner(System.in);

        numRules = scanner.nextInt();
        oldRules = new String[numRules];
        newRules = new String[numRules];
        for (int i = 0; i < numRules; i++) {
            oldRules[i] = scanner.next();
            newRules[i] = scanner.next();
        }
        str = scanner.next();
        System.out.println("Замена без регулярных выражений\n" + replaceDefault(oldRules, newRules, str));
        System.out.println("Замена через регулярные выражения\n" + replaceRegex(oldRules, newRules, str));

    }

    public static String replaceDefault(String[] oldR, String[] newR, String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < oldR.length; j++) {
                if (i + oldR[j].length() < str.length() && str.substring(i, i + oldR[j].length()).equals(oldR[j])) {
                    str = str.replace(oldR[j], newR[j] + " ");
                    i += newR[j].length();
                    break;
                }
            }
        }
        str = str.replaceAll(" ", "");
        return str;
    }

    public static String replaceRegex(String[] oldR, String[] newR, String str) {
        Pattern pattern;
        Matcher matchers;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < oldR.length; j++) {
                if (i + oldR[j].length() < str.length()) {
                    pattern = Pattern.compile(oldR[j]);
                    matchers = pattern.matcher(str.substring(i, i + oldR[j].length()));
                    if (matchers.find()) {
                        str = str.substring(0, i) + matchers.replaceFirst(newR[j] + " ") + str.substring(i + oldR[j].length());
                        i += newR[j].length();
                        break;
                    }
                }
            }
        }
        pattern = Pattern.compile(" ");
        matchers = pattern.matcher(str);
        str = matchers.replaceAll("");
        return str;
    }
}
