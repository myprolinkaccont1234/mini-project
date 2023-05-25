import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Up_pass extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel pane2;
    private JButton clearButton;
    private JButton updateButton;

    private JPasswordField passwordField1;

    private JPasswordField passwordField2;

    public Up_pass(){
        add(pane2);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(450,200);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = textField1.getText();
                String pass = String.valueOf(passwordField1);
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer")){

                    Statement se = connection.createStatement();
                    ResultSet re = se.executeQuery("select username,state,password from account where username='" + user + "' and password='" + pass + "'");
                    for (; re.next(); ) {
                        if (re.getString("username") == user && re.getString("password") == pass) {
                            String npass = String.valueOf(passwordField2);
                            JOptionPane.showConfirmDialog(null, "Confirm change password");
                            int a = se.executeUpdate("update account where username='" + user + "',password='" + npass + "'");
                            JOptionPane.showMessageDialog(null, "Your password change Successfully");

                        } else {
                            JOptionPane.showMessageDialog(null, "username or password doesn't match with Current information ");
                        }
                    }

                } catch (SQLException f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());

                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");
                passwordField2.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new Up_pass();
    }
}
