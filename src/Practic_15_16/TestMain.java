package Practic_15_16;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Integer> inputData = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Imaginarium imaginarium = new Imaginarium();
        int tmp = 2;

        while (tmp != -1) {
            tmp = scanner.nextInt();
            if (tmp != -1) {
                inputData.add(tmp);
            }
        }
        imaginarium.job(inputData);
    }
}
