public class LineItem {

    Product product;
    int quantity;
    double total;

    LineItem(Product Product, int Quantity){
        product = Product;
        quantity = Quantity;
        total = quantity * product.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public String printItem(){
      return String.format("%15s %30d %10s $%.2f $%5.2f \n",product.getName(),quantity, "" ,product.getPrice(),total);
    }
}
