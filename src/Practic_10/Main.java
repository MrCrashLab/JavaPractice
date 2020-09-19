package Practic_10;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Пункт 1. Треугольная последовательность.");
        triangularSequence(in.nextInt());

        System.out.println("\nПункт 2. От 1 до n.");
        System.out.println(allNumber(in.nextInt()));

        System.out.println("Пункт 3. От A до B.");
        System.out.println(AtoB(in.nextInt(), in.nextInt()));

        System.out.println("Пункт 4. Заданная сумма цифр.");
        System.out.println(sumOfDigits(0,0,in.nextInt(),in.nextInt()));

        System.out.println("Пункт 5. Сумма цифр числа.");
        System.out.println(sumOfDigitsNumber(in.nextInt()));

        System.out.println("Пункт 6. Проверка числа на простоту.");
        simplicityCheck(in.nextInt(), 2);

        System.out.println("Пункт 7. Разложение на множители.");
        factorization(in.nextInt(),2);

        System.out.println("Пункт 8. Палиндром.");
        palindrome();

        System.out.println("Пункт 9. Без двух нулей.");
        System.out.println(withoutTwoZeros(in.nextInt(), in.nextInt()));

        System.out.println("Пункт 10. Разворот числа.");
        System.out.println(numberReversal(in.nextInt(), 0));

        System.out.println("Пункт 11. Количество единиц.");
        numberOfUnits();

        System.out.println("Пункт 12. Нечетные числа последовательности.");
        oddSequenceNumbers();

        System.out.println("\nПункт 13. Члены последовательности с нечетными номерами.");
        oddNumberedSequenceMembers();

        System.out.println("\nПункт 14. Цифры числа слева направо.");
        System.out.println(digitsNumbersFromLeftToRight(in.nextInt()));

        System.out.println("Пункт 15. Цифры числа справа налево.");
        digitsNumbersFromRightToLeft(in.nextInt());

        System.out.println("\nПункт 16. Количество элементов, равных максимуму.");
        numberOfElementsEqualToMaximum(0,0);

        System.out.println("Пункт 17. Максимум последовательности.");
        System.out.println(maximumConsistency());
    }

    public static String triangularSequence(int num){
        int sum = 0;
        int tmp = 0;
        if (num == 1){
            System.out.print("1");
        }
        else {
            for (int i = 1; sum < num; i++) {
                sum += i;
                tmp = i;
            }
            System.out.print(triangularSequence(--num) + " " + tmp);
        }
        return "";
    }

    public static String allNumber(int num){
        if(num == 1)
            return "1";
        else
            return allNumber(num - 1) + " " + num;
    }

    public static String AtoB(int A, int B){
        if (A > B) {
            if (A == B)
                return Integer.toString(A);
            return A + " " + AtoB(A - 1, B);
        }
        else {
            if (A == B)
                return Integer.toString(A);
            return A + " " + AtoB(A + 1, B);
        }
    }

    public static int sumOfDigits(int len, int sum, int k, int s){
        int tmp, count = 0;
        if (len == k) {
            if (sum == s)
                return 1;
            else
                return 0;
        }
        if (len == 0)
            tmp = 1;
        else
            tmp = 0;
        for (int i = tmp; i < 10; i++) {
            count += sumOfDigits(len + 1, sum + i, k, s);
        }
        return count;
    }

    public static int sumOfDigitsNumber(int num){
        if(num <= 0) return num;
        return num % 10 + sumOfDigitsNumber(num / 10);
    }

    public static void simplicityCheck(int num, int cons) {
        if (num > 1) {
            if (num % cons != 0) {
                cons++;
                simplicityCheck(num, cons);
            }
            else if (num % cons == 0) {
                if (cons == num) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void factorization(int num, int cons){
        if (num % cons == 0 & cons != num) {
            System.out.print(cons + " ");
            factorization(num / cons, cons);
        }
        else{
            if(cons == num) System.out.println(cons);
            else{
                cons++;
                factorization(num, cons);
            }
        }
    }

    public static void palindrome(){
        String str = new String();
        in.nextLine();
        str = (in.nextLine());
        if(str.equals(new StringBuffer(str).reverse().toString())) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int withoutTwoZeros(int a, int b){
        if(a > b + 1) return 0;
        if(a == 0 || b ==0) return 1;
        return withoutTwoZeros(a, b-1) + withoutTwoZeros(a-1, b-1);
    }

    public static int numberReversal(int num, int tmp){
        if(num == 0) return tmp;
        else{
            tmp = tmp * 10 + num % 10;
            num /= 10;
            return numberReversal(num, tmp);
        }
    }

    public static void numberOfUnits(){
        int fir = in.nextInt();
        int sec = in.nextInt();
        int count = 0;
        while(fir != 0 || sec != 0){
            if(fir == 1) count++;
            fir = sec;
            sec = in.nextInt();
        }
        System.out.println(count);
    }

    public static void oddSequenceNumbers(){
        int[] arr = new int[100];
        int k = 0;
        int tmp = in.nextInt();
        while(tmp != 0){
            if(tmp % 2 != 0) {
                arr[k] = tmp;
                k++;}
            tmp = in.nextInt();
        }
        for (int i = 0;i<k;i++) System.out.print(arr[i] + " ");
    }

    public static void oddNumberedSequenceMembers(){
        int[] arr = new int[100];
        int k = 0;
        int tmp = in.nextInt();
        while(tmp != 0){
            arr[k] = tmp;
            k++;
            tmp = in.nextInt();
        }
        for (int i = 0;i < k;i += 2) System.out.print(arr[i] + " ");
    }

    public static String digitsNumbersFromLeftToRight(int num){
        if (num < 10){
            return Integer.toString(num);
        }
        else{
            return digitsNumbersFromLeftToRight(num / 10) + " " + num % 10;
        }
    }

    public static int digitsNumbersFromRightToLeft(int num){
        if (num <= 0) {
            return num;
        }
        else {
            System.out.print(num % 10 + " ");
            return digitsNumbersFromRightToLeft(num / 10);
        }
    }

    public static void numberOfElementsEqualToMaximum(int max, int count) {
        int n = in.nextInt();
        if (n > 0){
            if (n > max){
                numberOfElementsEqualToMaximum(n, 1);
            }
            else if (n == max){
                numberOfElementsEqualToMaximum(max, ++count);
            }
            else{
                numberOfElementsEqualToMaximum(max, count);
            }
        }
        else{
            System.out.println(count);
        }

    }

    public static int maximumConsistency(){
        int num = in.nextInt();
        if (num == 0) {
            return 0;
        }
        else {
            return Math.max(num, maximumConsistency());
        }
    }
}