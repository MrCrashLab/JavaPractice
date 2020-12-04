package Practic_05;

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
