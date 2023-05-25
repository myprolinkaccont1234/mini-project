import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Up_lec extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton createButton;
    private JButton clearButton;
    private JButton upadateButton;
    private JComboBox comboBox1;
    private JCheckBox maleCheckBox;
    private JCheckBox femaleCheckBox;
    private JPanel propane;
    private JPasswordField passwordField1;
    private JTextField textField8;
    private JPasswordField passwordField2;
    private JComboBox comboBox2;
    private JLabel scode;
    private JLabel Qual;
    private JLabel gragu;
    private JLabel dep;
    private JTextField textField9;
    private JLabel birth;
    private JTextField textField10;
    private JLabel stdno;
    private JLabel gender;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
    public Up_lec() {
        add(propane);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 520);
        setVisible(true);


        s8 = (String) comboBox1.getSelectedItem();
        s13 = (String) comboBox2.getSelectedItem();

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox2.getSelectedItem() == "Lecture") {
                    lec_create();
                } else if (comboBox2.getSelectedItem() == "Admin") {
                    adm_create();
                } else if (comboBox2.getSelectedItem() == "Student") {
                    std_create();
                } else if (comboBox2.getSelectedItem() == "Tecnical officer") {
                    tec_create();
                }
            }
        });
        upadateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s13 == "Lecture") {
                    lec_update();
                } else if (s13 == "Admin") {
                    adm_update();
                } else if (s13 == "Student") {
                    std_update();
                } else if (s13 == "Tecnical officer") {
                    tec_update();
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are You Sure Want to Clear");
                clear();
            }
        });

        if (textField1.getText() != "") {
            s1 = textField1.getText();
        } else {
            s1 = null;
        }
        if (textField2.getText() != "") {
            s2 = textField2.getText();
        } else {
            s2 = null;
        }
        if (textField3.getText() != "") {
            s3 = textField3.getText();
        } else {
            s3 = null;
        }
        if (textField4.getText() != "") {
            s4 = textField4.getText();
        } else {
            s4 = null;
        }
        if (textField5.getText() != "") {
            s5 = textField5.getText();
        } else {
            s5 = null;
        }
        if (textField6.getText() != "") {
            s6 = textField6.getText();
        } else {
            s6 = null;
        }
        if (textField7.getText() != "") {
            s7 = textField7.getText();
        } else {
            s7 = null;
        }
        if (textField8.getText() != "") {
            s10 = textField8.getText();
        } else {
            s10 = null;
        }
        if (textField9.getText() != "") {
            s15 = textField9.getText();
        } else {
            s15 = null;
        }
        if (textField10.getText() != "") {
            s16 = textField8.getText();
        } else {
            s16 = null;
        }

        if (passwordField1.getText() != "") {
            s11 = String.valueOf(passwordField1);
        } else {
            s11 = null;
        }
        if (passwordField1.getText() != "") {
            s12 = String.valueOf(passwordField2);

        } else {
            s12 = null;
        }

        if (femaleCheckBox.isSelected()) {
            s9 = "Female";
        } else if (maleCheckBox.isSelected()) {
            s9 = "Male";
        } else {
            s9 = null;
        }

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox2.getSelectedItem()=="Student") {
                    gragu.hide();
                    textField5.hide();
                    Qual.hide();
                    textField6.hide();
                    scode.hide();
                    textField7.hide();
                    dep.show(true);
                    comboBox1.show(true);
                    stdno.show(true);
                    textField9.show(true);
                    birth.show(true);
                    textField10.show(true);

                } else if (comboBox2.getSelectedItem()=="Admin") {
                    stdno.hide();
                    textField9.hide();
                    dep.hide();
                    comboBox1.hide();
                    scode.hide();
                    textField7.hide();
                    birth.hide();
                    textField10.hide();
                    Qual.show(true);
                    textField6.show(true);

                } else if (comboBox2.getSelectedItem()== "Tecnical officer") {
                    scode.hide();
                    textField7.hide();
                    stdno.hide();
                    textField9.hide();
                    gragu.hide();
                    textField5.hide();
                    dep.show(true);
                    comboBox1.show(true);
                    birth.hide();
                    textField10.hide();
                    Qual.show(true);
                    textField6.show(true);
                } else if (comboBox2.getSelectedItem()=="Lecture") {
                    stdno.hide();
                    textField9.hide();
                    birth.hide();
                    textField10.hide();
                    gragu.show(true);
                    textField5.show(true);
                    Qual.show(true);
                    textField6.show(true);
                    scode.show(true);
                    textField7.show(true);
                }
            }
        });
    }


        void lec_create () {
            if (s11.equals(s12)) {
                s14 = s12;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Password Doesn't match. try Again");
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

                Statement ss = connection.createStatement();
                ResultSet r = ss.executeQuery("insert into lecture(l_id,lec_name,Deprtment,age,gender,address,graduate,qualification,sub_code)" +
                        " values ('" + s1 + "','" + s2 + "','" + s8 + "','" + s3 + "','" + s9 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')");
                ResultSet s = ss.executeQuery("insert into users(u_id,username,passsword) " +
                        "values('" + s1 + "','" + s10 + "','" + s14 + "','" + s13 + "','" + s7 + "')");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        void adm_create () {
            if (s11.equals(s12)) {
                s14 = s12;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Password Doesn't match. try Again");
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

                Statement ss = connection.createStatement();
                ResultSet r = ss.executeQuery("insert into admin(a_id,ad_name,age,address,gender,qualification)" +
                        " values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s9 + "','" + s6 + "')");
                ResultSet s = ss.executeQuery("insert into users(u_id,username,passsword) " +
                        "values('" + s1 + "','" + s10 + "','" + s14 + "','" + s13 + "','" + s7 + "')");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        void tec_create () {
            if (s11.equals(s12)) {
                s14 = s12;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Password Doesn't match. try Again");
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

                Statement ss = connection.createStatement();
                ResultSet r = ss.executeQuery("insert into Tec_Officer(t_id,to_name,age,gender,Deprtment,address,qualification)" +
                        " values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s9 + "','" + s8 + "','" + s4 + "','" + s6 + "')");
                ResultSet s = ss.executeQuery("insert into users(u_id,username,passsword) " +
                        "values('" + s1 + "','" + s10 + "','" + s14 + "','" + s13 + "','" + s7 + "')");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    void std_create(){
        if(s11.equals(s12)){
            s14=s12;
        }
        else{
            JOptionPane.showMessageDialog(null,"Entered Password Doesn't match. try Again");
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("insert into student(s_id,std_no,Deprtment,name,gender,address,birthday)" +
                    " values ('" +s1 + "','" +s16 + "','" +s8 + "','" +s2 + "','" +s9 + "','" +s4 + "','" +s15 + "')");
            ResultSet s= ss.executeQuery("insert into users(u_id,username,passsword) " +
                    "values('" +s1 + "','" +s10 + "','" +s14 + "','" +s13 + "','" +s7 + "')");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    void lec_update(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("update lecture where l_id='" +s1 + "',lec_name='" +s2 + "',Deprtment='" +s8 + "',age='" +s3 + "',gender='" +s9 + "',address='" +s4 + "',graduate='" +s5 + "',qualification='" +s6 + "',sub_code'" +s7 + "')");
            ResultSet s= ss.executeQuery("update users where (u_id='" +s1 + "',username='" +s10 + "',passsword='" +s14 + "',state='" +s13 + "',c_code='" +s7 + "')");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    void adm_update(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("update admin where a_id='" +s1 + "',ad_name='" +s2 + "',Deprtment='" +s8 + "',age='" +s3 + "',gender='" +s9 + "',address='" +s4 + "',graduate='" +s5 + "',qualification='" +s6 + "')");
            ResultSet s= ss.executeQuery("update users where (u_id='" +s1 + "',username='" +s10 + "',passsword='" +s14 + "',state='" +s13 + "',c_code='" +s7 + "')");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    void tec_update(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("update Tec_Officer where t_id='" +s1 + "',to_name='" +s2 + "',Deprtment='" +s8 + "',age='" +s3 + "',gender='" +s9 + "',address='" +s4 + "',qualification='" +s6 + "')");
            ResultSet s= ss.executeQuery("update users where (u_id='" +s1 + "',username='" +s10 + "',passsword='" +s14 + "',state='" +s13 + "',c_code='" +s7 + "')");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    void std_update(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("update student where s_id='" +s1 + "',std_no='" +s16 + "',name='" +s2 + "',Deprtment='" +s8 + "',age='" +s3 + "',gender='" +s9 + "',address='" +s4 + "',birthday='" +s15 + "')");
            ResultSet s= ss.executeQuery("update users where (u_id='" +s1 + "',username='" +s10 + "',passsword='" +s14 + "',state='" +s13 + "',c_code='" +s7 + "')");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    void clear(){
        textField1.setText("");textField2.setText("");textField3.setText("");textField4.setText("");textField5.setText("");textField6.setText("");
        textField7.setText("");textField8.setText("");passwordField1.setText("");passwordField2.setText("");
    }


    public static void main(String[] args) {
        new Up_lec();
    }
}
