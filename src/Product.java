public class Product {
    private String name;


    private double price;

    Product(String Name, double Price){
        name = Name;
        price = Price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
