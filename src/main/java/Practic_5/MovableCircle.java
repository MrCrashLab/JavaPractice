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
