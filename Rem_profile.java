import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Rem_profile extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton removeButton;
    private JButton clearButton;
    private JPanel rempop;

    Rem_profile(){
       add(rempop) ;
       setLayout(new FlowLayout());
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(340,250);
       setVisible(true);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null,"Operation can't be recover.Are You sure ");
                remove();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
            }
        });
    }
    void remove(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            int r = ss.executeUpdate("delete from users where u_id='" + textField1.getText() + "' or '" + textField2.getText()+"'" );
            JOptionPane.showMessageDialog(null, "Profile Removed Successfully ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Rem_profile();
    }
}
