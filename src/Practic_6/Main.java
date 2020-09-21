package Practic_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix;
        int size;

        size = in.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                matrix[i][j] = in.nextInt();
            }


    }

}
