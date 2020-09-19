package Practic_6_Not_final;

import Practic_5.Movable;

public class MovablePoints implements Movable {

    public int x_1 = 0;
    public int y_1 = 0;
    public int x_2 = 0;
    public int y_2 = 0;
    public int x_1Speed = 0;
    public int y_1Speed = 0;
    public int x_2Speed = 0;
    public int y_2Speed = 0;

    public MovablePoints(int x_1, int y_1, int x_2, int y_2, int x_Speed, int y_Speed){
        this.x_1 = x_1;
        this.y_1 = y_1;
        this.x_1Speed = x_Speed;
        this.y_1Speed = y_Speed;
        this.x_2Speed = x_Speed;
        this.y_2Speed = y_Speed;
    }

    public boolean checkSpeed(){
        if (x_1Speed == x_2Speed && y_1Speed == y_2Speed)
            return true;
        else{
            return false;
        }
    }

    public void equalizeSpeeds(){
        x_1Speed = x_2Speed;
        y_1Speed = y_2Speed;
    }

    @Override
    public String toString() {
        return "MovablePoints{" +
                "x_1=" + x_1 +
                ", y_1=" + y_1 +
                ", x_2=" + x_2 +
                ", y_2=" + y_2 +
                ", x_1Speed=" + x_1Speed +
                ", y_1Speed=" + y_1Speed +
                ", x_2Speed=" + x_2Speed +
                ", y_2Speed=" + y_2Speed +
                '}';
    }

    @Override
    public void moveUp() {
        y_1 += y_1Speed;
        y_2 += y_2Speed;
    }

    @Override
    public void moveDown() {
        y_1 -= y_1Speed;
        y_2 -= y_2Speed;
    }

    @Override
    public void moveLeft() {
        x_1 -= x_1Speed;
        x_2 -= x_2Speed;
    }

    @Override
    public void moveRight() {
        x_1 += x_1Speed;
        x_2 += x_2Speed;
    }
}
