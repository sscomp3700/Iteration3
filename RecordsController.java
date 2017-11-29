import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RecordsController {
    private RecordsView recordsView;
    private DataAdapter dataAdapter; // to save and load product
    private Record record = new Record();

    public RecordsController(RecordsView recordsView, DataAdapter dataAdapter) {
        this.recordsView = recordsView;
        this.dataAdapter = dataAdapter;
        loadRecords();
    }

    public void loadRecords() {
        Record record = new Record();
        this.record = dataAdapter.loadRecords();
        recordsView.getPanelNumOrders().setText("Number of Sales: " + record.getNumOrders());
        recordsView.getPanelRevenue().setText("Revenue: " + record.getRevenue());
    }
}

