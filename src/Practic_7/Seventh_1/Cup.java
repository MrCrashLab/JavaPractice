package Practic_7.Seventh_1;

public class Cup extends Dish {

    public Cup(float weight, String form, String color, String material){
        setWeight(weight);
        setForm(form);
        setColor(color);
        setMaterial(material);
    }

    @Override
    public String toString() {
        String tmp;
        tmp = "Я Кружка!\nЯ вешу " + getWeight() +
                "\nЯ имею форму " + getForm() +
                "\nМой цвет " + getColor() +
                "\nЯ сделана из " + getMaterial();
        tmp += getPure()?"\nЯ чистая кружечка!":"\nЯ грязная, помой меня!";
        return tmp;
    }

    @Override
    public void wish() {
        setPure(true);
        System.out.println("Кружка помыта!");
    }

    @Override
    public void eat() {
        setPure(false);
        System.out.println("Вы выпили чай и запачкали кружку!");
    }
}

