package Second;

public class Shape{
    private int height = -1;
    private int weight = -1;
    private int depth = -1;

    public Shape(int height, int weight, int depth){
        this.height = height;
        this.weight = weight;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "height=" + height +
                ", weight=" + weight +
                ", depth=" + depth +
                '}';
    }
}
