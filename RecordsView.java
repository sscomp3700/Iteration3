import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;

public class RecordsView extends JFrame {

    private DefaultTableModel items = new DefaultTableModel(); // store information for the table!
    private JLabel panelRevenue = new JLabel();
    private JLabel panelNumOrders = new JLabel();


    public RecordsView() {


        this.setTitle("Business Report");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 200);

        this.getContentPane().add(panelNumOrders);
        this.getContentPane().add(panelRevenue);


        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));

    }
    public JLabel getPanelNumOrders(){ return panelNumOrders; }
    public JLabel getPanelRevenue(){return panelRevenue;}
}