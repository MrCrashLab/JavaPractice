package Practic_7.Seventh_1;

public abstract class Dish {
    private boolean pure = false;
    private float weight = 0.0f;
    private String form = "default";
    private String color = "default";
    private String material = "default";

    public void setPure(boolean pure) {this.pure = pure;}
    public boolean getPure() {return pure;}

    public void setWeight(float weight) {this.weight = weight; }
    public float getWeight() {return weight;}

    public void setForm(String form) {this.form = form;}
    public String getForm() {return form;}

    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}

    public void setMaterial(String material) {this.material = material;}
    public String getMaterial() {return material;}

    public abstract void wish();
    public abstract void eat();

}
