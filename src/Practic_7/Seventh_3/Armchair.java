package Practic_7.Seventh_3;

public class Armchair extends Furniture {

    public Armchair(float weight, float length, float width, float height, String color, int numSeats){
        super(weight, length, width, height, color, numSeats);
    }

    @Override
    public String toString() {
        return "Я Кресло!" +
                "\nМои размеры: " + getWidth() + " x " +
                getLength() + " x " + getHeight() +
                "\nЯ вешу " + getHeight() + " кг" +
                "\nМой цвет " + getColor() +
                "\nНа меня сядут(ет) " + getNumSeats() + " человек(а)";
    }
}
