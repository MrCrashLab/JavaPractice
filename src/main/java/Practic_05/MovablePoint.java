package Practic_05;

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
