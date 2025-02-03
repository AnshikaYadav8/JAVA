import java.util.Scanner;

class Books {
    private String title;
    private String author;
    private int price;
    public Books (String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }
}
class Fiction extends Books{
    public Fiction(String title, String author, int price){
        super(title, author, price);
    }
    @Override
    public void display(){
        System.out.println("Type: Fiction");
        super.display();
    }
}
class NonFiction extends Books{
    public NonFiction(String title, String author, int price){
        super(title, author, price);
    }
    @Override
    public void display(){
        System.out.println("Type: Non-Fiction");
        super.display();
    }
}
public class LibraryManagement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Books[] books = new Books[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            System.out.print("Type (Fiction/NonFiction): ");
            String type = sc.nextLine();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Price: ");
            int price = sc.nextInt();
            sc.nextLine(); 

            if (type.equalsIgnoreCase("Fiction")) {
                books[i] = new Fiction(title, author, price);
            } else if (type.equalsIgnoreCase("NonFiction")) {
                books[i] = new NonFiction(title, author, price);
            } else {
                System.out.println("Invalid type! Defaulting to Fiction.");
                books[i] = new Fiction(title, author, price);
            }
        }
        System.out.println("\nLibrary Books:");
        for (Books book : books) {
            book.display();
        }
        sc.close();
    }
    }
