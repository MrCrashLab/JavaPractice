# Практическая 1
### Класс Main.java
````java
package Practic_1;
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
````
# Практическая 2
### Класс Shape.java
````java
package Practic_2;

public class Shape{
    private int height = -1;
    private int weight = -1;
    private int depth = -1;

    public Shape(int height, int weight, int depth){
        this.height = height;
        this.weight = weight;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "height=" + height +
                ", weight=" + weight +
                ", depth=" + depth +
                '}';
    }
}
````
### Класс Main.java
````java
package Practic_2;

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
````
### Класс DogKennel.java
````java
package Practic_2;

public class DogKennel {
    private Dog[] kennel;
    private int count = 0;

    public DogKennel(int number){
        kennel = new Dog[number];
    }

    public void addDog(String name, int dog_age){
        kennel[count] = new Dog(name, dog_age);
        count++;
    }

    public void removeLastDog(int num_dog){
        kennel[count] = null;
        count--;
    }

    public Dog[] getKennel() {return kennel;}
    public void setKennel(Dog[] kennel) {this.kennel = kennel;}

    public int getCount() {return count;}

    @Override
    public String toString() {
        String tmp;
        tmp = "Количество собак в питомнике " + count;
        for (int i = 0; i<count; i++){
            tmp += "\n" + kennel[i].toString() ;
        }
        return tmp;
    }
}
````
### Класс Dog.java
````java
package Practic_2;

public class Dog {
    String name = "default";
    int dog_age = -1;
    int people_age = -1;

    public Dog(String name, int dog_age){
        this.dog_age = dog_age;
        this.people_age = dog_age * 7;
        this.name = name;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setDog_age(int dog_age){
        this.dog_age = dog_age;
        people_age = 7 * dog_age;
    }
    public int getDog_age(){return dog_age;}

    public int getPeople_age() {return people_age;}

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dog_age=" + dog_age +
                ", people_age=" + people_age +
                '}';
    }
}
````
### Класс Book.java
````java
package Practic_2;

public class Book {
    private int page = -1;
    private int weight = -1;
    private int depth = -1;

    public Book(int page, int weight, int depth){
        this.page = page;
        this.weight = weight;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Book{" +
                "page=" + page +
                ", weight=" + weight +
                ", depth=" + depth +
                '}';
    }
}
````
### Класс Ball.java
````java
package Practic_2;

public class Ball {
    private int radius = -1;
    private int diametr = -1;
    private float volume = -1;

    public Ball(int radius){
        this.radius = radius;
        this.diametr = radius * 2;
        this.volume = (float)(3.1415 * radius * radius);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                ", diametr=" + diametr +
                ", volume=" + volume +
                '}';
    }
}
````
# Практическая 3
### Класс BookTest.java
````java
package Practic_3.Third_3;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите автора книги: ");
        book.setAuthor(in.nextLine());

        System.out.println("Введите название книги: ");
        book.setName(in.nextLine());

        System.out.println("Введите год написания книги: ");
        book.setAge(in.nextInt());

        System.out.println("Введите колво страниц: ");
        book.setPage(in.nextInt());

        System.out.println(book.toString());


        //System.out.println(book.getWeight() + " " + book.getPage() + " " + book.getLenght());
    }
}
````
### Класс Book.java
````java
package Practic_3.Third_3;

public class Book {
    private int page = -1;
    private String name = "default";
    private int age = -1;
    private String author = "default";

    public void setPage(int page) {this.page = page;}
    public int getPage() {return page;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAge(int age) {this.age = age;}
    public int getAge() {return age;}

    public void setAuthor(String author) {this.author = author;}
    public String getAuthor() {return author;}

    @Override
    public String toString() {
        return "Book{" +
                "page=" + page +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", author='" + author + '\'' +
                '}';
    }
}
````
# Практическая 3
### Класс HumanTest.java
````java
package Practic_3.Third_2;

import java.util.Scanner;

public class HumanTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num_leg, num_head, num_hand;

        System.out.println("Введите количество ног: ");
        num_leg = in.nextInt();
        System.out.println("Введите количество голов: ");
        num_head = in.nextInt();
        System.out.println("Введите количество рук: ");
        num_hand = in.nextInt();
        Human human = new Human(num_leg, num_head,num_hand);


        for (int i = 0;i <num_leg; i++){
            System.out.println("Введите длину " +(i+1) + " ноги ");
            human.addLeg(new Human.Leg(in.nextInt()));
        }
        for (int i = 0;i < num_head;i++){
            System.out.println("Введите диаметр " +(i+1) + " головы ");
            human.addHead(new Human.Head(in.nextInt()));
        }
        for (int i = 0;i< num_hand;i++){
            System.out.println("Введите вес " +(i+1) + " руки ");
            human.addHand(new Human.Hand(in.nextInt()));
        }
        System.out.println(human.toString());

    }
}
````
### Класс Human.java
````java
package Practic_3.Third_2;

public class Human {
    private Leg[] legs;
    private Head[] heads;
    private Hand[] hands;
    int num_leg = 0, num_head = 0, num_hand = 0;

    public Human(int num_leg, int num_head, int num_hands){
        legs = new Leg[num_leg];
        heads = new Head[num_head];
        hands = new Hand[num_hands];
    }

    public Leg[] getLegs() {return legs;}
    public Head[] getHeads() {return heads;}
    public Hand[] getHands() {return hands;}

    public void addLeg(Leg leg){legs[num_leg] = leg;num_leg++;}
    public void addHead(Head head){heads[num_head] = head;num_head++;}
    public void addHand(Hand hand){hands[num_hand] = hand;num_hand++;}

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0;i< legs.length;i++){tmp += "Моя " +(i+1) + " нога в длину " + legs[i].getLength() + " cм\n";}
        for (int i = 0;i< heads.length;i++){tmp += "Диаметр моей " +(i+1) + " головы " + legs[i].getLength() + " см\n";}
        for (int i = 0;i< hands.length;i++){tmp += "Вес моей " +(i+1) + " руки " + legs[i].getLength() + " кг\n";}
        return tmp;
    }

    public static class Leg{
        private float length = -1;
        private float percent;

        public Leg(int length){this.length = length;this.percent = percent;}
        public float getLength() {return length;}
        public void setLength(float length){this.length = length;}
    }

    public static class Head{
        private int diametr = -1;
        public Head(int diametr){this.diametr = diametr;}
        public int getDiametr() {return diametr;}
        public void setDiametr(int diametr) {this.diametr = diametr;}
    }

    public static class Hand{
        private int heft = -1;
        public Hand(int heft){this.heft = heft;}
        public int getHeft() {return heft;}
        public void setHeft(int heft) {this.heft = heft;}
    }
}
````
# Практическая 3
### Класс CircleTest.java
````java
package Practic_3.Third_1;

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
````
### Класс Circle.java
````java
package Practic_3.Third_1;

public class Circle {
    private int radius = -1;
    private int diametr = -1;
    private float area = -1;

    public void setRadius(int radius){
        this.radius = radius;
        this.diametr = radius * 2;
        this.area = (float)(3.1415 * radius * radius);
    }
    public int getRadius(){return radius;}

    public void setDiametr(int diametr){
        this.diametr = diametr;
        this.radius = diametr/2;
        this.area = (float)(3.1415 * radius * radius);
    }
    public int getDiametr(){return diametr;}

    public void setArea(float area){
        this.area = area;
        this.radius = (int)(Math.sqrt(area)/3.1415);
        this.diametr = radius * 2;
    }
    public float getArea(){return area;}

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", diametr=" + diametr +
                ", area=" + area +
                '}';
    }
}
````
# Практическая 4
### Класс Square.java
````java
package Practic_4;

public class Square extends Shape{
    private double widlen = -1;
    public Square(double widlen, String color, boolean filled){
        super(color, filled);
        this.widlen = widlen;
    }
    public Square(){}

    public double getWidlen() {return widlen;}

    public void setWidlen(double widlen) {this.widlen = widlen;}

    @Override
    public double getArea() {return widlen * widlen;}
    @Override
    public double getPerimeter() {return widlen * 4;}

    @Override
    public String toString() {
        return "Square{" +
                "widlen=" + widlen +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
````
### Класс Shape.java
````java
package Practic_4;

public abstract class Shape {
    protected String color = "red";
    protected boolean filled = true;

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public Shape(){}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
````
### Класс Rectangle.java
````java
package Practic_4;

public class Rectangle extends Shape {
    protected double width = 1;
    protected double length = 1;

    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(){}

    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}

    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
````
### Класс Main.java
````java
package Practic_4;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5, "white", true);
        Square square = new Square(2,"blue",false);
        Rectangle rectangle = new Rectangle(2, 5, "red", true);
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}
````
### Класс Circle.java
````java
package Practic_4;

public class Circle extends Shape {
    protected double radius = 1;

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius){this.radius = radius;}

    public Circle(){}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override
    public double getArea() {
        return 3.1415 * 3.1415 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.1415 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
````
# Практическая 5
### Класс MovableRectangle.java
````java
package Practic_5;

public class MovableRectangle implements Movable {

    private MovablePoint point_UpLeft;
    private MovablePoint point_DownRight;

    public MovableRectangle(MovablePoint point_UpLeft, MovablePoint point_DownRight) {
        this.point_UpLeft = point_UpLeft;
        this.point_DownRight = point_DownRight;
    }

    public MovablePoint getPoint_UpLeft() {
        return point_UpLeft;
    }

    public MovablePoint getPoint_DownRight() {
        return point_DownRight;
    }

    public int getWidth() {
        return Math.abs(point_UpLeft.getX() - point_DownRight.getX());
    }

    public int getLength() {
        return Math.abs(point_UpLeft.getY() - point_DownRight.getY());
    }

    public void setLength(int tmp) {
        point_DownRight.setY(point_UpLeft.getY() + tmp);
    }

    public void setWidth(int tmp){
        point_DownRight.setX(point_UpLeft.getX() + tmp);
    }

    @Override
    public void moveUp() {
        point_UpLeft.moveUp();
        point_DownRight.moveUp();
    }

    @Override
    public void moveDown() {
        point_UpLeft.moveDown();
        point_DownRight.moveDown();
    }

    @Override
    public void moveLeft() {
        point_UpLeft.moveLeft();
        point_DownRight.moveLeft();
    }

    @Override
    public void moveRight() {
        point_UpLeft.moveUp();
        point_DownRight.moveUp();
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "point_UpLeft=" + point_UpLeft +
                ", point_DownRight=" + point_DownRight +
                '}';
    }
}
````
### Класс MovablePoint.java
````java
package Practic_5;

public class MovablePoint implements Movable {

    private int x = 0;
    private int y = 0;
    private int xSpeed = 0;
    private int ySpeed = 0;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public int getX_Speed() {return xSpeed;}
    public int getY_Speed() {return ySpeed;}

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public void setX_Speed(int xSpeed) {this.xSpeed = xSpeed;}
    public void setY_Speed(int ySpeed) {this.ySpeed = ySpeed;}

    @Override
    public void moveUp() {y += ySpeed;}

    @Override
    public void moveDown() {y -= ySpeed;}

    @Override
    public void moveLeft() {x -= xSpeed;}

    @Override
    public void moveRight() {x += xSpeed;}

}
````
### Класс MovableCircle.java
````java
package Practic_5;

import Practic_4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius = radius;
    }

    public MovablePoint getCenter() {return center;}
    public void setCenter(MovablePoint center) {this.center = center;}

    @Override
    public void moveUp() {center.moveUp();}

    @Override
    public void moveDown() {center.moveDown();}

    @Override
    public void moveLeft() {center.moveLeft();}

    @Override
    public void moveRight() {center.moveRight();}

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
````
### Класс Movable.java
````java
package Practic_5;

public interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();


}
````
### Класс Main.java
````java
package Practic_5;

public class Main {

    public static void main(String[] args) {
		MovableCircle movableCircle = new MovableCircle(5,6,23,12, 25);
		MovablePoint movablePoint = new MovablePoint(3, 3,4,1);
		MovableRectangle movableRectangle = new MovableRectangle(new MovablePoint(5,4,12,32), new MovablePoint(10,11,12,32));
		System.out.println(movableCircle.toString());
		System.out.println(movablePoint.toString());
		System.out.println(movableRectangle.toString());
    }
}
````
# Практическая 6
### Класс Main.java
````java
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
````
# Практическая 7-8
### Класс TopManager.java
````java
package Practic_7_8;

public class TopManager implements EmployeePosition {
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + ((company.getIncome() >= 10_000_000) ? (baseSalary * 1.5) : 0);
    }
}
````
### Класс Test.java
````java
package Practic_7_8;

import java.util.List;

public class Test {
    Company company = new Company();
    private int baseSalary = 100_000;
    private final String[] name = {"Jack", "Leonardo", "Sarah", "Arnold", "Tony", "John", "Albert", "Anna", "Donatello"};
    private final String[] secondName = {"Smith", "Parker", "Einstein", "Edison", "Tordvalds", "Gates"};

    public Test() {
        createCompany();
        company.calcIncome();
        System.out.println("Доход компании " + company.getIncome());
        outputTopSalary(12);
        removeEmployee();
        System.out.println("Доход компании "+ company.getIncome());
        outputTopSalary(15);
        outputLowSalary(30);
    }

    public void createCompany() {
        for (int i = 0; i < 180; i++)
            company.hire(new Employee(name[i % 9], secondName[i % 6], baseSalary, new Operator()));
        for (int i = 0; i < 80; i++)
            company.hire(new Employee(name[(i + 2) % 9], secondName[(i + 4) % 6], baseSalary, new Manager()));
        for (int i = 0; i < 10; i++)
            company.hire(new Employee(name[(i + 5) % 9], secondName[(i + 3) % 6], baseSalary, new TopManager(company)));
    }

    public void removeEmployee() {
        System.out.println("Увольнение!!!");
        for (int i = 0; i < company.getStaffSize(); i += 1)
            company.fire(i);
    }

    public void outputTopSalary(int num) {
        List<Employee> tmp;
        tmp = company.getTopSalaryStaff(num);
        System.out.println(num + " высоких зарплат!");
        for (int i = 0; i < num; i++) {
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()));
            System.out.println(" руб\t\t" + tmp.get(i).getPosition().getJobTitle());
        }
    }

    public void outputLowSalary(int num) {
        List<Employee> tmp;
        tmp = company.getLowestSalaryStaff(num);
        System.out.println(num + " низких зарплат!");
        for (int i = 0; i < num; i++) {
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()));
            System.out.println(" руб\t\t" + tmp.get(i).getPosition().getJobTitle());
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
````
### Класс Operator.java
````java
package Practic_7_8;

public class Operator implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
````
### Класс Manager.java
````java
package Practic_7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    private Random random = new Random();
    private int money = 0;

    public int generateMoney() {
        this.money = random.nextInt(140_000 - 115_000) + 115_000;
        return money;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + money * 0.05;
    }
}
````
### Класс EmployeePosition.java
````java
package Practic_7_8;

public interface EmployeePosition {
    String getJobTitle();

    double calcSalary(double baseSalary);
}
````
### Класс Employee.java
````java
package Practic_7_8;

public class Employee {
    private String name;
    private String secondName;
    private double baseSalary;
    private EmployeePosition position;

    public Employee(String name, String secondName, int baseSalary, EmployeePosition position) {
        this.name = name;
        this.secondName = secondName;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public EmployeePosition getPosition() {
        return position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
}
````
### Класс Company.java
````java
package Practic_7_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private double income = 0;
    private ArrayList<Employee> employeeList = new ArrayList<>();


    public void hire(Employee employee) {
        employeeList.add(employee);
        calcIncome();
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
        calcIncome();
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
        calcIncome();
    }

    public void fire(int index) {
        employeeList.remove(index);
        calcIncome();
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> tmp = employeeList;
        Employee tm;
        for (int i = 0; i < tmp.size() - 1; i++)
            for (int j = i + 1; j < tmp.size(); j++) {
                if (tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()) < tmp.get(j).getPosition().calcSalary(tmp.get(j).getBaseSalary())) {
                    tm = tmp.get(j);
                    tmp.set(j, tmp.get(i));
                    tmp.set(i, tm);
                }
            }
        return tmp.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> tmp = employeeList;
        Employee tm;
        for (int i = 0; i < tmp.size() - 1; i++)
            for (int j = i + 1; j < tmp.size(); j++) {
                if (tmp.get(i).getPosition().calcSalary(tmp.get(i).getBaseSalary()) > tmp.get(j).getPosition().calcSalary(tmp.get(j).getBaseSalary())) {
                    tm = tmp.get(j);
                    tmp.set(j, tmp.get(i));
                    tmp.set(i, tm);
                }
            }
        return tmp.subList(0, count);
    }

    public void calcIncome() {
        this.income = 0;
        for (Employee emp : employeeList)
            if (emp.getPosition() instanceof Manager) {
                income += ((Manager) emp.getPosition()).generateMoney();
            }
    }

    public double getIncome() {
        return income;
    }

    public int getStaffSize() {
        return employeeList.size();
    }
}
````
# Практическая 9
### Класс Test.java
````java
package Practic_9;

import java.time.LocalDate;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();
        Holder holder = new Holder();
        Selector selector = new Selector(1980);
        final String[] name = {"Jack", "Leonardo", "Sarah", "Arnold", "Tony", "John", "Albert", "Anna", "Donatello"};
        final String[] secondName = {"Smith", "Parker", "Einstein", "Edison", "Tordvalds", "Gates"};
        final String[] location = {"Moscow", "New-York", "London"};
        for (int i = 0; i < 100; i++)
            company.hire(new Employee(
                    name[i % 9],
                    secondName[i % 6],
                    LocalDate.of(random.nextInt(2002 - 1960) + 1960, random.nextInt(11) + 1, random.nextInt(27) + 1),
                    location[i % 3],
                    "8800-555-35-35",
                    random.nextInt(1_000)));
        System.out.println("Salary more 900");
        company.handleEmployees(new EmployeeHolder() {
            @Override
            public void holderEmployee(Employee employee, int index) {
                System.out.println(index + "//////////" + employee);
            }
        }, new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getSalary() > 900;
            }
        });
        System.out.println("Second name "+ secondName[5]);
        company.handleEmployees(
                (employee, index) -> System.out.println(index + "++++++++++" + employee),
                employee -> employee.getSecondName().equals(secondName[5]));

        System.out.println("Later 1980");
        company.handleEmployees(holder, selector);
    }


}
````
### Класс Selector.java
````java
package Practic_9;

public class Selector implements EmployeeSelector {
    private int year;

    public Selector(int year) {
        this.year = year;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getDateOfBirth().getYear() > this.year;
    }
}
````
### Класс Holder.java
````java
package Practic_9;

public class Holder implements EmployeeHolder{
    @Override
    public void holderEmployee(Employee employee, int index) {
        System.out.println(index+"----------"+employee);
    }
}
````
### Класс EmployeeSelector.java
````java
package Practic_9;

public interface EmployeeSelector {
    boolean isNeedEmployee(Employee employee);
}
````
### Класс EmployeeHolder.java
````java
package Practic_9;

public interface EmployeeHolder {
    void holderEmployee(Employee employee, int index);
}
````
### Класс Employee.java
````java
package Practic_9;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String name;
    private String secondName;
    private LocalDate dateOfBirth;
    private String location;
    private String phoneNumber;
    private int salary;

    public Employee(String name, String secondName, LocalDate dateOfBirth, String location, String phoneNumber, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth=" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(dateOfBirth) +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
````
### Класс Company.java
````java
package Practic_9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public void fire(int index) {
        employeeList.remove(index);
    }

    public void handleEmployees(EmployeeHolder holder, EmployeeSelector selector){
        int count = 0;
        for (Employee emp: employeeList) {
                if(selector.isNeedEmployee(emp)) {
                    holder.holderEmployee(emp, count);
                    count++;
                }
        }
    }
}
````
# Практическая 10
### Класс MyPanel.java
````java
package Practic_10;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class MyPanel extends JPanel {
    private final JTextField textFieldA = new JTextField("");
    private final JTextField textFieldB = new JTextField("");
    private final JLabel titleLabel = new JLabel("Калькулятор", SwingConstants.CENTER);
    private final JLabel label = new JLabel("", SwingConstants.CENTER);
    private final JButton buttonP = new JButton("+");
    private final JButton buttonM = new JButton("-");
    private final JButton buttonS = new JButton("*");
    private final JButton buttonD = new JButton("/");
    private Container container = new Container();
    private DecimalFormat decimalFormat = new DecimalFormat("#.####");

    public MyPanel() {
        addComponent();
        addListener();
    }

    private void addComponent() {
        setLayout(new GridLayout(5, 1, 30, 30));
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        container.add(buttonP);
        container.add(buttonM);
        container.add(buttonS);
        container.add(buttonD);
        titleLabel.setForeground(Color.green);
        add(titleLabel);
        add(textFieldA);
        add(container);
        add(textFieldB);
        add(label);
    }

    private void addListener() {
        buttonP.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {

                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) +
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonM.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) -
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonS.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB)) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) *
                                        Float.parseFloat(textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });

        buttonD.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB) && Float.parseFloat(textFieldB.getText()) != 0) {
                label.setText(decimalFormat.format(
                                Float.parseFloat(
                                        textFieldA.getText()) /
                                        Float.parseFloat(
                                                textFieldB.getText())));
            }else
                label.setText("Введите числа");
        });
    }

    private boolean checkField(JTextField textField) {
        if (!textField.getText().equals("") && textField.getText().matches("[0-9.]+"))
            return true;
        else return false;
    }
}


````
### Класс MyApp.java
````java
package Practic_10;

import javax.swing.*;

public class MyApp extends JFrame {
    public MyApp() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 200);
        setResizable(false);
        setSize(400, 500);
        add(new MyPanel());
    }
}
````
### Класс Main.java
````java
package Practic_10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyApp app = new MyApp();
            app.setVisible(true);
        });
    }
}
````
# Практическая 11
### Класс ThreadMain.java
````java
package Practic_11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain {
    static long totalSum = 0;
    static AtomicInteger atomicTotalSum = new AtomicInteger();
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        long startTime, endTime;
        ArrayList<Thread> threads = new ArrayList<>();

        System.out.println("Первый метод - \"Чистый\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;


        System.out.println("Второй метод - \"Синхронизированный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> synWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;
        threads.clear();

        System.out.println("Третий метод - \"Атомичный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> atomicWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + atomicTotalSum.get());
        threads.clear();

        System.out.println("Четвертый метод - \"Заглушечный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> lockWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;
        threads.clear();
    }



    public static void work(int i) {
        long startLocalTime = System.currentTimeMillis();
        long result = hardWork(i * 1000, 100_000_000);
        long endLocalTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endLocalTime - startLocalTime));
    }


    public static void synWork(int i) {
        long startLocalTime = System.currentTimeMillis();
        long result = synHardWork(i * 1000, 100_000_000);
        long endLocalTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endLocalTime - startLocalTime));
    }


    public static void atomicWork(int i) {
        long startTime = System.currentTimeMillis();
        long result = atomicHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static void lockWork(int i) {
        long startTime = System.currentTimeMillis();
        long result = lockHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    public static long hardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        return a;
    }

    public static synchronized long synHardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        return a;
    }

    public static long atomicHardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            atomicTotalSum.getAndIncrement();
        }
        return a;
    }

    public static long lockHardWork(int num, int count) {
        long a = 0;
        lock.lock();
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        lock.unlock();
        return a;
    }
}
````
# Практическая 12
### Класс TestPractice.java
````java
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
            System.out.print(colors[random.nextInt(colors.length)].getControlExpression()
                    + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        ColorEnumeration[] colors = ColorEnumeration.values();
        for (int i = 0; i < colors.length; i++) {
            onePaintString("[" + i + "] Hello World!", colors[i]);
        }
        morePaintString("Hello World!",colors);
        System.out.println("");
        randomPaintString("Hello World!",colors);
        onePaintString("\nGoodbye World", ColorEnumeration.RED);
    }
}
````
### Класс ColorEnumeration.java
````java
package Practic_12;

public enum ColorEnumeration {
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_MAGENTA("\u001B[95m")
    ;

    private String controlExpression;


    ColorEnumeration(String controlExpression) {
        this.controlExpression = controlExpression;
    }

    public String getControlExpression() {
        return controlExpression;
    }
}
````
# Практическая 13
### Класс TestMain.java
````java
package Practic_13;

public class TestMain {
    public static void main(String[] args){
        Animal giraffe = new Animal("Giraffe", 0, 0);
        try {
            giraffe.addAge(10);
            giraffe.setIdAnimal(123);

            giraffe.addAge(50);
            giraffe.setIdAnimal(12);
        } catch (AnimalException aex) {
            System.out.println("\u001B[31m" + "Animal age must be more 0" + "\u001B[0m");
        } catch (BigAnimalAgeException baae) {
            System.out.println("\u001B[31m" + "Animal age must be less 100" + "\u001B[0m");
        } catch (Exception ex) {
            System.out.println("\u001B[31m" + "Incorrect ID animal" + "\u001B[0m");
        } finally {
            System.out.println(giraffe.getName() + " age: " + giraffe.getAge());
            System.out.println("ID " + giraffe.getName() + " " + giraffe.getIdAnimal());
        }
        throw new BigAnimalAgeException();
    }
}
````
### Класс BigAnimalAgeException.java
````java
package Practic_13;

public class BigAnimalAgeException extends RuntimeException{
}
````
### Класс AnimalException.java
````java
package Practic_13;

public class AnimalException extends IllegalArgumentException{
}
````
### Класс Animal.java
````java
package Practic_13;

public class Animal {
    private String name;
    private int age;
    private int idAnimal;

    public Animal(String name, int age, int idAnimal) {
        this.name = name;
        this.age = age;
        this.idAnimal = idAnimal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addAge(int age) throws AnimalException, BigAnimalAgeException {
        if (age < 0)
            throw new AnimalException();
        else if(age>100)
            throw new BigAnimalAgeException();
        this.age += age;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) throws Exception {
        if(idAnimal<0)
            throw new Exception();
        this.idAnimal = idAnimal;
    }
}
````
# Практическая 14
### Класс TestMain.java
````java
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
````
# Практическая 15-16
### Класс TestMain.java
````java
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
````
### Класс Node.java
````java
package Practic_15_16;

import java.util.HashMap;

public class Node {
    private final HashMap<Integer, Integer> transitionMap = new HashMap<>();
    private final HashMap<Integer, Integer> actionMap = new HashMap<>();

    public Node(int trans0, int node0, int action0, int trans1, int node1, int action1) {
        transitionMap.put(trans0, node0);
        transitionMap.put(trans1, node1);
        actionMap.put(trans0, action0);
        actionMap.put(trans1, action1);
    }

    public HashMap<Integer, Integer> getTransitionMap() {
        return transitionMap;
    }

    public HashMap<Integer, Integer> getActionMap() {
        return actionMap;
    }
}
````
### Класс Imaginarium.java
````java
package Practic_15_16;

import java.util.ArrayList;
import java.util.HashMap;

public class Imaginarium {
    private final ArrayList<Node> nodeList = new ArrayList<>();
    private final HashMap<Integer, String> transitionAction = new HashMap<>();

    public Imaginarium() {
        createTransitAction();
        createNodeList();
    }

    public void job(ArrayList<Integer> transition) {
        int startNode = 0;
        for (int i = 0; i < transition.size(); i++) {
            System.out.println(transitionAction.get(nodeList.get(startNode).getActionMap().get(transition.get(i))));
            startNode = nodeList.get(startNode).getTransitionMap().get(transition.get(i));
        }
    }

    private void createNodeList() {
        Node tmp = new Node(0, 1, 0, 1, 4, 1);
        nodeList.add(tmp);
        tmp = new Node(0, 2, 3, 1, 3, 5);
        nodeList.add(tmp);
        tmp = new Node(0, 3, 5, 1, 4, 1);
        nodeList.add(tmp);
        tmp = new Node(0, 2, 2, 1, 4, 4);
        nodeList.add(tmp);
        tmp = new Node(0, 0, 4, 1, 2, 2);
        nodeList.add(tmp);
    }

    private void createTransitAction() {
        transitionAction.put(0, "create_project");
        transitionAction.put(1, "add_library");
        transitionAction.put(2, "restart");
        transitionAction.put(3, "test");
        transitionAction.put(4, "deploy");
        transitionAction.put(5, "drop_db");
    }


}
````
# Практическая 17-18
### Класс TestMain.java
````java
package Practic_17_18;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args){
        CreatorMarkDown creatorMarkDown = new CreatorMarkDown("src");
        creatorMarkDown.createMD();
    }
}
````
### Класс CreatorMarkDown.java
````java
package Practic_17_18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class CreatorMarkDown {
    private final String mainPath;
    private final File file;
    private final File mdFile;
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private final ArrayList<Integer> keys = new ArrayList<>();
    private final Stack<File> files = new Stack<>();
    private final StringBuilder sb = new StringBuilder();
    private String nowPath = "default";

    public CreatorMarkDown(String basePath){
        this.mainPath = basePath + "/Practic_17_18";
        file = new File(basePath);
        mdFile = new File("G:/Java code/JavaPractice" + "/" + "README.md");
        createRootList();

        try {
            mdFile.createNewFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }

    }

    public void createMD() {
        files.add(file);
        for (Integer key : keys) {
            files.add(new File(file.getAbsolutePath() + "/" + hashMap.get(key)));
            while (files.size() > 1) {
                File currentFile = files.pop();
                if (currentFile.getAbsolutePath().endsWith(".java")) {
                    readWriteMD(currentFile);
                }

                if (!currentFile.isFile()) {
                    for (int j = 0; j < currentFile.list().length; j++) {
                        files.add(new File(currentFile.getAbsolutePath() + "/" + currentFile.list()[j]));
                    }
                }
            }
        }
    }

    private void readWriteMD(File currentFile) {
        try (PrintWriter writer = new PrintWriter(mdFile);
             BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
            if (!currentFile.getParentFile().getAbsolutePath().equals(nowPath)) {
                sb.append("# Практическая " + currentFile.getParentFile().getAbsolutePath().split("[_\\\\]")[5]);
                if (currentFile.getParentFile().getAbsolutePath().split("[_\\\\]").length > 6)
                    sb.append("-" + currentFile.getParentFile().getAbsolutePath().split("[_\\\\]")[6]);
                sb.append("\n");
                nowPath = currentFile.getParentFile().getAbsolutePath();
            }

            sb.append("### Класс " + currentFile.getName());
            sb.append("\n" + "````java" + "\n");
            String line = reader.readLine();
            while (line != null) {
                sb.append(line + "\n");
                line = reader.readLine();
            }
            sb.append("````\n");
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void createRootList() {
        for (int i = 0; i < file.list().length; i++) {
            if (file.list()[i].split("_").length > 1) {
                hashMap.put(Integer.valueOf(file.list()[i].split("_")[1]), file.list()[i]);
                keys.add(Integer.valueOf(file.list()[i].split("_")[1]));
            }
        }
        Collections.sort(keys);
    }
}
````
