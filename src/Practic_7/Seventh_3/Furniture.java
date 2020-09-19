package Practic_7.Seventh_3;

public abstract class Furniture {
    private float weight = -1.0f;
    private float length = -1.0f;
    private float width = -1.0f;
    private float height = -1.0f;
    private String color = "default";
    private int numSeats = -1;

    public Furniture(float weight, float length, float width, float height, String color, int numSeats){
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.numSeats = numSeats;
    }

    public void setWeight(float weight) {this.weight = weight;}
    public float getWeight() {return weight;}

    public void setLength(float length) {this.length = length;}
    public float getLength() {return length;}

    public void setWidth(float width) {this.width = width;}
    public float getWidth() {return width;}

    public void setHeight(float height) {this.height = height;}
    public float getHeight() {return height;}

    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}

    public void setNumSeats(int numSeats) {this.numSeats = numSeats;}
    public int getNumSeats() {return numSeats;}

}
