import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceForm extends JFrame {

    JPanel mainPnl;

    JPanel addressPnl;
        JTextArea addressNameTA;
        JTextArea houseTA;
        JTextArea cityStateZipTA;
        JButton setAddressBtn;


    JPanel ItemPnl;
        JSpinner quantitySpn;
        JSpinner priceSpn;
        JTextArea itemNameTA;
        JButton addItemBtn;

    JPanel resultsPnl;
        JTextArea invoiceTA;
        JScrollPane invoiceScroll;
        JButton createInvoiceBtn;

    Invoice thisInvoice;



    public InvoiceForm(){

    mainPnl = new JPanel();
    mainPnl.setLayout(new BoxLayout(mainPnl,BoxLayout.Y_AXIS));
    addAddressPnl();
    addItemPnl();
    addResultsPnl();


    mainPnl.setVisible(true);
    this.add(mainPnl);


    thisInvoice = new Invoice();




    }

    private void addAddressPnl(){

    addressPnl = new JPanel();
        addressNameTA = new JTextArea(1,20);
        houseTA = new JTextArea(1,20);
        cityStateZipTA = new JTextArea(1,30);
        setAddressBtn = new JButton("Set Address");
        addressPnl.setLayout(new GridLayout(2,2));

        addressPnl.add(addressNameTA);
        addressNameTA.setBorder(new TitledBorder("Client Name"));
        addressPnl.add(houseTA);
        houseTA.setBorder(new TitledBorder("House Address"));
        addressPnl.add(cityStateZipTA);
        cityStateZipTA.setBorder(new TitledBorder("City State and Zip"));
        addressPnl.add(setAddressBtn);
        addressPnl.setBorder(new TitledBorder("Set Address"));
        mainPnl.add(addressPnl);
        addressPnl.setVisible(true);

        setAddressBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisInvoice.setAddress(addressNameTA.getText() + "\n" + houseTA.getText() + "\n" + cityStateZipTA.getText());
            }
        });

    }

    private void addItemPnl(){
        ItemPnl = new JPanel();
        quantitySpn = new JSpinner();
        priceSpn = new JSpinner(new SpinnerNumberModel(1,0.1,1000,0.01));
        itemNameTA = new JTextArea();
        addItemBtn = new JButton("Add Item");

        ItemPnl.setLayout(new GridLayout(2,2));

        ItemPnl.add(itemNameTA);
        ItemPnl.add(priceSpn);
        ItemPnl.add(quantitySpn);
        ItemPnl.add(addItemBtn);
        quantitySpn.setBorder(new TitledBorder("Set Quantity"));
        priceSpn.setBorder(new TitledBorder("Set Price"));
        itemNameTA.setBorder(new TitledBorder("Item Name"));
        ItemPnl.setBorder(new TitledBorder("Add Items"));
        mainPnl.add(ItemPnl);
        ItemPnl.setVisible(true);

        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisInvoice.addItem(new LineItem(new Product(itemNameTA.getText(), (Double) priceSpn.getValue()), (Integer) quantitySpn.getValue()));

                itemNameTA.setText("");
                priceSpn.setValue(1);
                quantitySpn.setValue(1);


            }
        });

    }
    private void addResultsPnl(){
        resultsPnl = new JPanel();
        resultsPnl.setBorder(new TitledBorder("Invoice"));
        invoiceTA  = new JTextArea(20,50);
        invoiceScroll = new JScrollPane();
        invoiceScroll.add(invoiceTA);

        createInvoiceBtn = new JButton("Create Invoice");
        resultsPnl.add(createInvoiceBtn);
        resultsPnl.add(invoiceTA);
        mainPnl.add(resultsPnl);
        resultsPnl.setVisible(true);

        createInvoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoiceTA.setText(thisInvoice.printInvoice());
            }
        });

    }



}
