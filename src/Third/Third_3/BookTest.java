package Third.Third_3;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите автора книги: ");
        book.setAuthor(in.nextLine());

        System.out.println("Введите название книги: ");
        book.setName(in.nextLine());

        System.out.println("Введите год написания книги: ");
        book.setAge(in.nextInt());

        System.out.println("Введите колво страниц: ");
        book.setPage(in.nextInt());

        System.out.println(book.toString());


        //System.out.println(book.getWeight() + " " + book.getPage() + " " + book.getLenght());
    }
}
