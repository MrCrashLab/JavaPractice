package Practic_7.Seventh_1;

public class FryingPan extends Dish {

    public FryingPan(float weight, String form, String color, String material){
        setWeight(weight);
        setForm(form);
        setColor(color);
        setMaterial(material);
    }

    @Override
    public String toString() {
        String tmp;
        tmp = "Я Сковородка!\nЯ вешу " + getWeight() +
                "\nЯ имею форму " + getForm() +
                "\nМой цвет " + getColor() +
                "\nЯ сделана из " + getMaterial();
        tmp+= getPure()?"\nЯ чистая сковородочка!":"\nЯ грязная, помой меня, иначе потом тебе же будет хуже!";
        return tmp;
    }

    @Override
    public void wish() {
        setPure(true);
        System.out.println("Сковородка помыта!");
    }

    @Override
    public void eat() {
        setPure(false);
        System.out.println("Вы пожарили яичницу и запачкали сковородку!");
    }
}
