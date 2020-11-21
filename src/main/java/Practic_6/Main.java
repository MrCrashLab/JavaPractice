package Practic_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix;
        int[][] list;
        int size, max;

        size = in.nextInt();
        matrix = new int[size][size];
        list = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix[i][j] = in.nextInt();

        for (int i = size - 1; i >= 0; i--)
            for (int j = size - 1; j >= 0; j--) {
                if (i == size - 1 && j == size - 1)
                    list[i][j] = matrix[i][j];
                else if (i == size - 1)
                    list[i][j] = matrix[i][j] + list[i][j+1];
                else if (j == size - 1) {
                    list[i][j] = matrix[i][j] + list[i + 1][j];
                }
                else{
                    max = matrix[i][j] + list[i+1][j];
                    if(max<matrix[i][j] + list[i][j+1])
                        max = matrix[i][j] + list[i][j+1];
                    list[i][j] = max;
                }
            }
        System.out.println(list[0][0]);
    }
}
