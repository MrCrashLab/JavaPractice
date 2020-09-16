package Second;

public class Book {
    private int page = -1;
    private int weight = -1;
    private int depth = -1;

    public Book(int page, int weight, int depth){
        this.page = page;
        this.weight = weight;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Book{" +
                "page=" + page +
                ", weight=" + weight +
                ", depth=" + depth +
                '}';
    }
}