import java.util.ArrayList;

public class Invoice {

    String address;
    double amountDue;

    ArrayList<LineItem> items;

    Invoice(){
        String Address = "";
        amountDue = 0;
        items = new ArrayList<LineItem>();
    }

    public void addItem(LineItem toAdd){
        items.add(toAdd);
        amountDue += toAdd.getTotal();
    }
    public void setAddress(String newAddress){
        address = newAddress;
    }



    public String  printInvoice(){
        String toPrint = "";
        toPrint += address + "\n";
        toPrint+= "*******************************************************\n";
        toPrint+= "Item                             Qty     Price    Total\n";
        for (LineItem n: items) {
            toPrint+= n.printItem();
            
        }
        toPrint+= "*******************************************************\n";

        toPrint+=String.format("Amount Due $%.2f",amountDue);

        return toPrint;



    }
}
