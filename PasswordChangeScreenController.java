import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChangeScreenController implements ActionListener {
    private PasswordChangeScreen passwordChangeScreen;
    private DataAdapter dataAdapter; // to save and load product information

    public PasswordChangeScreenController(PasswordChangeScreen passwordChangeScreen, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.passwordChangeScreen = passwordChangeScreen;

        passwordChangeScreen.getBtnUpdatePassword().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passwordChangeScreen.getBtnUpdatePassword())
            updatePassword();
    }

    private void updatePassword() {
        String userPassword;
        int userID;
        userPassword = passwordChangeScreen.getTxtUserPassword().getText().trim();
        userID = Integer.parseInt(passwordChangeScreen.getTxtUserId().getText().trim());
        if (userPassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid user password! Please provide a non-empty user password!");
            return;
        }


        // Done all validations! Make an object for this product!

        Employee employee = new Employee();
        employee.setUserID(userID);

        // Store the product to the database

        dataAdapter.updateUser(userPassword, employee);
    }

}

