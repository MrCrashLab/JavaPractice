package Practic_3.Third_3;

public class Book {
    private int page = -1;
    private String name = "default";
    private int age = -1;
    private String author = "default";

    public void setPage(int page) {this.page = page;}
    public int getPage() {return page;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAge(int age) {this.age = age;}
    public int getAge() {return age;}

    public void setAuthor(String author) {this.author = author;}
    public String getAuthor() {return author;}

    @Override
    public String toString() {
        return "Book{" +
                "page=" + page +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", author='" + author + '\'' +
                '}';
    }
}
