package Practic_02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp_name;
        int tmp_int;
        Book book = new Book(10,20,10);
        Ball ball = new Ball(15);
        Shape shape = new Shape(10,34,21);
        Dog dog = new Dog("Jack", 10);

        System.out.println("Введите размер питомника: ");
        DogKennel ken = new DogKennel(in.nextInt());
        for(int i = 0;i < ken.getKennel().length; i++){
            in.nextLine();
            System.out.println("Введите имя собаки: ");
            tmp_name = in.nextLine();
            System.out.println("Введите возраст собаки: ");
            tmp_int = in.nextInt();
            ken.addDog(tmp_name,tmp_int);
        }

        System.out.println(book.toString());
        System.out.println(ball.toString());
        System.out.println(shape.toString());
        System.out.println(dog.toString());
        System.out.println(ken.toString());



    }
}
