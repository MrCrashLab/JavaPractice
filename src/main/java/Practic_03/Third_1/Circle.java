package Practic_03.Third_1;

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