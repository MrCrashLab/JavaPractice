package Practic_7.Seventh_3;

public class FurnitureShop {
    private Sofa sofa = new Sofa(30.0f, 12.0f, 13.0f, 4.0f, "красный",5);
    private Armchair armchair = new Armchair(5.0f, 3.0f, 4.0f, 4.0f, "синий",1);
    private Bed bed = new Bed(10.0f, 2.0f, 5.0f, 4.0f, "белый",2);

    public void shop(){
        System.out.println(sofa.toString());
        System.out.println(armchair.toString());
        System.out.println(bed.toString());
    }
}
