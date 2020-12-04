package Practic_02;

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