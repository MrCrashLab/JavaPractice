package Practic_7.Seventh_3;

public class Sofa extends Furniture {

    public Sofa(float weight, float length, float width, float height, String color, int numSeats){
        super(weight, length, width, height, color, numSeats);
    }

    @Override
    public String toString() {
        return "Я Диван!" +
                "\nМои размеры: " + getWidth() + " x " +
                getLength() + " x " + getHeight() +
                "\nЯ вешу " + getHeight() + " кг" +
                "\nМой цвет " + getColor() +
                "\nНа меня сядут " + getNumSeats() + " человек";
    }
}
