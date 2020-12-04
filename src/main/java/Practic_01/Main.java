package Practic_01;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        loops();
        commandLineOut(args);
        System.out.println("\nГармонический ряд");
        harmonicSeries(10);
        System.out.println("Массив рандомных чисел");
        randArray();
        System.out.println("\nФакториал");
        fact(10);
    }

    public static void loops(){
        int arr[] = {1, 2, 3, 4,5 ,6 ,7 ,8, 9, 10};
        int sum = 0;
        int y = 0;

        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        System.out.println(sum);

        sum = 0;
        for(int x: arr){
            sum += x;
        }
        System.out.println(sum);

        sum = 0;
        while(y<arr.length){
            sum += arr[y];
            y++;
        }
        System.out.println(sum);

        sum = 0;
        y = 0;
        do{
            sum += arr[y];
            y++;
        }while(y<arr.length);
        System.out.println(sum);
    }

    public static void commandLineOut(String[] args){
        for (String x: args) System.out.println(x);
    }

    public static void harmonicSeries(int n){
        double num = 1;
        for (int i = 1;i<=n;i++) System.out.printf("%.2f%n",num/i);
    }

    public static void randArray(){
        int[] array_1 = new int[10];
        int[] array_2 = new int[10];
        Random ran = new Random();

        for (int i = 0; i < array_1.length; i++) array_1[i] = (int)(Math.random()*100);
        for (int i = 0; i < array_2.length; i++) array_2[i] = Math.abs(ran.nextInt())/1000000;

        System.out.println("Первый массив");
        for(int x: array_1) System.out.print(x + " ");
        System.out.println("\nВторой массив");
        for(int x: array_2) System.out.print(x + " ");

        Arrays.sort(array_1);
        Arrays.sort(array_2);

        System.out.println("\nОтсортированный первый массив");
        for(int x: array_1) System.out.print(x + " ");
        System.out.println("\nОтсортированный второй массив");
        for(int x: array_2) System.out.print(x + " ");
    }

    public static void fact(int num){
        int fac = 1;
        for (int i = 1;i<=num; i++){
            System.out.println(fac);
            fac*=i;
        }
    }
}