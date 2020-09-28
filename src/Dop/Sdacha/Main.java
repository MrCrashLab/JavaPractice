package Dop.Sdacha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int tmp = 0;
        for (int i = 0; i <= (sum / 3); i++) {
            for (int j = 0; j <= (sum / 5); j++) {
                if (3 * i + 5 * j > sum) {
                    break;
                } else {
                    tmp++;
                }
            }
        }
        System.out.println(tmp);
    }
}
