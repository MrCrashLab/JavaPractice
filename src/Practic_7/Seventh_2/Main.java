package Practic_7.Seventh_2;

public class Main {

    public static void main(String[] args) {
        DalmatianDog dalmatianDog = new DalmatianDog("Джек", 5, "мальчик");
        GermanShepherdDog germanShepherdDog = new GermanShepherdDog("Боня", 8, "девочка");

        System.out.println(dalmatianDog.toString());
        dalmatianDog.walkToDog();
        dalmatianDog.wantToWalk();
        System.out.println(germanShepherdDog.toString());
        germanShepherdDog.walkToDog();

    }
}
