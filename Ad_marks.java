import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ad_marks extends JFrame {
    private JButton SAVEButton;
    private JButton clearButton;
    private  JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JPanel ad_mark;
    String Ex_type = null;
    Ad_marks() throws SQLException {
       // String Ex_type;
        String cb2;

        if(Lecture.cg=="Quiz 1"){
            Ex_type="quiz_1";
        }
        else if(Lecture.cg=="Quiz 2"){
            Ex_type="quiz_2";
        }
        else if(Lecture.cg=="Quiz 3"){
            Ex_type="quiz_3";
        }
        else if(Lecture.cg=="Assignment 1"){
            Ex_type="assignment_1";
        }
        else if(Lecture.cg=="Assignment 2"){
            Ex_type="assignment_2";
        }
        else if(Lecture.cg=="Assignment 3"){
            Ex_type="assignment_3";
        }
        else if(Lecture.cg=="Mid Examination"){
            Ex_type="mid_exam";
        }
        else if(Lecture.cg=="End Examination"){
            Ex_type="end_exam";
        }
        add(ad_mark);
        setSize(400,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
    }
    void add_marks() throws SQLException {
        int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
        s1= Integer.parseInt(textField1.getText());
        s2= Integer.parseInt(textField1.getText());
        s3= Integer.parseInt(textField1.getText());
        s4= Integer.parseInt(textField1.getText());
        s5= Integer.parseInt(textField1.getText());
        s6= Integer.parseInt(textField1.getText());
        s7= Integer.parseInt(textField1.getText());
        s8= Integer.parseInt(textField1.getText());
        s9= Integer.parseInt(textField1.getText());
        s10= Integer.parseInt(textField1.getText());
        s11= Integer.parseInt(textField1.getText());
        s12= Integer.parseInt(textField1.getText());
        s13= Integer.parseInt(textField1.getText());
        s14= Integer.parseInt(textField1.getText());
        s15= Integer.parseInt(textField1.getText());
        s16= Integer.parseInt(textField1.getText());

        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");){
            Statement se = connection.createStatement();

            ResultSet re = se.executeQuery("insert into '" + Lecture.cb + "'('" + Ex_type + "') values ('" +  s1+"'),('" +  s2+"'),('" +  s3+"'),('" +  s4+"'),('" +  s5+"'),('" +  s6+"'),('" +  s7+"'),('" +  s8+"'),('" +  s9+"'),('" +  s10+"'),('" +  s11+"'),('" +  s12+"'),('" +  s13+"'),('" +  s14+"'),('" +  s15+"'),('" +  s16+"')");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }



    }

   /* public Connection ConnectDB() {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            JOptionPane.showMessageDialog(null,e.getSQLState());
        }
        return null ;
    }*/


}
