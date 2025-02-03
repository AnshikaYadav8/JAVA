class Product {
    private int id;
    private String name;
    private int price;
    public Product(int id, String name, int price) {
     this.id = id;
     this.name = name;
     this.price = price;
    }
    public void displayProduct() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }
}
public class ProductDetails {
    public static void main(String args[]){
        Product p = new Product(1, "Laptop", 50000);
        p.displayProduct();
    }
}
