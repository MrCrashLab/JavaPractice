package Third.Third_1;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args){
        Circle circle = new Circle();
        Scanner in = new Scanner(System.in);

        System.out.println("Что вы хотите ввести? (1 - Диаметр, 2 - Радиус, 3 - Площадь) ");
        switch (in.nextInt()) {
            case 1:
                System.out.println("Введите диаметр окружности: ");
                circle.setDiametr(in.nextInt());
                System.out.println(circle.toString());
                break;
            case 2:
                System.out.println("Введите радиус окружности: ");
                circle.setRadius(in.nextInt());
                System.out.println(circle.toString());
                break;
            case 3:
                System.out.println("Введите площадь окружности: ");
                circle.setArea(in.nextInt());
                System.out.println(circle.toString());
                break;
            default:
                System.out.println("Вы ошиблись!");
        }
    }
}