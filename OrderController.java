import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderController implements ActionListener {
    private OrderView view;
    private Order k;
    private PrintWriter printWriter;
    private double price;
    private static DecimalFormat decimalFormat = new DecimalFormat(".##");
    private double i = 0;
    public OrderController(OrderView view) {
        this.view = view;
        view.getToMain().addActionListener(this);
        view.getBtnReceipt().addActionListener(this);
        decimalFormat.format(i);
        try {
            printWriter = new PrintWriter("customer_receipt.txt","UTF-8");
            printReceipt(price);
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found!");
        } catch (UnsupportedEncodingException e){
            JOptionPane.showMessageDialog(null, "Unsupported encoding exception!");
        }
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getToMain()){
            Application.getInstance().getMainScreenCashier().setVisible(true);
        }
        if(e.getSource() == view.getBtnReceipt()) {
            printReceipt(i);
        }

    }
    public void printReceipt(double price) {
        printWriter.print("Total: " + price);
        printWriter.close();
    }

}
