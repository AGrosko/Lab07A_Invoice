import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        InvoiceForm frame = new InvoiceForm();



        frame.setTitle("Invoice Form");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width =  (dimension.width)/2;
        int height  = (dimension.height)/2 + (dimension.height)/3;
        int x = (dimension.width - width) / 2;
        int y = (dimension.height - height) / 2;
        frame.setLocation(x,y);
        frame.setSize(width,height);
        System.out.println(dimension.width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}