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