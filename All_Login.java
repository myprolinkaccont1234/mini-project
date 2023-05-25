import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;
public class All_Login extends JFrame {
    public static String[] use_name;
    private JTextField textField1;
    private JButton loginButton;
    private JButton clearButton;
    private JPanel jpannel;
    private JPasswordField passwordField1;

    public All_Login() {
        setLayout(new FlowLayout());
        setSize(300,150);
        setVisible(true);
        add(jpannel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "1234");
                    System.out.print("Connected");

                    String user = textField1.getText();
                    String pass = String.valueOf(passwordField1);

                    Statement se = connection.createStatement();
                    ResultSet re = se.executeQuery("select username,state,password from account where username='" + user+ "' and password='" + pass + "'");

                   // JLabel j8;
                    if(user ==null || pass ==null){
                        JOptionPane.showMessageDialog(null,"Username or Password cannot be Empty");

                    }
                    else {
                        for (; re.next(); ) {
                            if (re.getString("username") == user && re.getString("password") == pass) {
                                use_name[0] =re.getString("username");

                                if (re.getString("state") == "student") {
                                    Student s = new Student();
                                } else if (re.getString("state") == "lecture") {

                                    Lecture L = new Lecture();
                                } else if (re.getString("state") == "admin") {
                                    Admin A = new Admin();
                                } else if (re.getString("state") == "tec_officer") {
                                    Tec_officer T = new Tec_officer();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Your State is not Recognize Yet");

                                }

                            }
                        }

                    }
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null,"Error in Acess to database");
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");
            }
        });
    }
    public static void main(String args[]) {
        new All_Login();
    }

}
