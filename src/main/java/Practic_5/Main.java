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
