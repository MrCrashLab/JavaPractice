package Practic_7.Seventh_3;

public class Bed extends Furniture {

    public Bed(float weight, float length, float width, float height, String color, int numSeats){
        super(weight, length, width, height, color, numSeats);
    }

    @Override
    public String toString() {
        return "Я Кровать!" +
                "\nМои размеры: " + getWidth() + " x " +
                getLength() + " x " + getHeight() +
                "\nЯ вешу " + getHeight() + " кг" +
                "\nМой цвет " + getColor() +
                "\nНа меня лягут " + getNumSeats() + " человек(а)";
    }
}
