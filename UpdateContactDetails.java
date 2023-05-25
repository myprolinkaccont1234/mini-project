import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UpdateContactDetails extends JFrame implements ActionListener {

    // GUI components
    private JLabel nameLabel, emailLabel, phoneLabel, addressLabel;
    private JTextField nameField, emailField, phoneField, addressField;
    private JButton updateButton;

    public UpdateContactDetails() {
        super("Update Contact Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create labels and text fields
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        phoneLabel = new JLabel("Phone:");
        addressLabel = new JLabel("Address:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        addressField = new JTextField(20);

        // create update button
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        // create panel for labels, text fields, and button
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(new JLabel());
        panel.add(updateButton);

        // add panel to frame
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            try {
                // Replace "jdbc:mysql://localhost:3306/database" with your database connection URL
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "username", "password");

                // create SQL statement to update contact details
                String sql = "UPDATE contacts SET name=?, email=?, phone=?, address=? WHERE id=?";

                // get values from text fields
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();

                // replace ? placeholders with values
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, phone);
                statement.setString(4, address);
                statement.setInt(5, 1); // replace "1" with the ID of the contact you want to update

                // execute statement
                statement.executeUpdate();

                // display success message
                JOptionPane.showMessageDialog(null, "Contact details updated successfully.");

                // close connection and dispose of frame
                conn.close();
                dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        UpdateContactDetails updateContactDetails = new UpdateContactDetails();
    }
}
