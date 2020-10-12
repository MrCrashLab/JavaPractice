package Practic_12;

import java.util.Random;
import java.util.RandomAccess;

public class TestPractice {

    public static void onePaintString(String str, ColorEnumeration color) {
        System.out.println(color.getControlExpression() + str);
    }

    public static void morePaintString(String str, ColorEnumeration[] colors) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(colors[i % colors.length].getControlExpression()
                    + str.charAt(i));
        }
    }

    public static void randomPaintString(String str, ColorEnumeration[] colors) {
        Random random = new Random();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(colors[random.nextInt(7)].getControlExpression()
                    + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        ColorEnumeration[] colors = ColorEnumeration.values();
        for (int i = 0; i < colors.length; i++) {
            onePaintString("[" + i + "] Hello world!", colors[i]);
        }
        morePaintString("Hello world!",colors);
        System.out.println("");
        randomPaintString("Hello world!",colors);
    }
}
