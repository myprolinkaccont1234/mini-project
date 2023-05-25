import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Up_pro extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel pane2;
    private JButton clearButton;
    private JButton updateButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    Up_pro(){
        add(pane2);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(450,200);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lec_up_pro();

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
    }
    void lec_up_pro(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {


            Statement se = connection.createStatement();
            int re = se.executeUpdate("update lecture where qualification='" + textField1.getText() + "',address='" + textField2.getText() + "'sub_code='" + textField3.getText() + "'");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E.getSQLState());
        }
    }

    void adm_up_pro(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {


            Statement se = connection.createStatement();
            int re = se.executeUpdate("update admin where qualification='" + textField1.getText() + "',address='" + textField2.getText()+"'");
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, E.getSQLState());
        }
    }


    public static void main(String[] args) {
        new Up_pro();
    }

}
