package Practic_7.Seventh_1;

public class Plate extends Dish {

    public Plate(float weight, String form, String color, String material){
        setWeight(weight);
        setForm(form);
        setColor(color);
        setMaterial(material);
    }

    @Override
    public String toString() {
        String tmp = "Я тарелочка!\nЯ вешу " + getWeight() +
                "\nЯ имею форму " + getForm() +
                "\nМой цвет " + getColor() +
                "\nЯ сделана из " + getMaterial();
        tmp += getPure()?"\nЯ чистая!":"\nЯ грязная, помой меня!";
        return tmp;
    }

    @Override
    public void wish() {
        setPure(true);
        System.out.println("Тарелка помыта!");
    }

    @Override
    public void eat() {
        setPure(false);
        System.out.println("Вы поели и запачкали тарелку!");
    }
}
