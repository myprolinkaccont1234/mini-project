import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;

public class Lecture extends JFrame{
    public  JFrame jf;
    public static String cb;
    public static String cg;
    private JTabbedPane tabbedPane1;
    private JPanel jpannel3;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JPanel jp4;
    private JPanel jp5;
    private JPanel jp6;
    private JButton button1;
    private  JButton postNoticeButton;
    private JTextField textField1;
    private JTextPane textPane1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField2;
    private JButton findButton;
    private JProgressBar progressBar1;
    private JComboBox comboBox1;
    private JButton checkAttaindanceButton;
    private JComboBox comboBox5;
    private JTextField textField3;
    private JButton checkAttaindenceButton;
    private JButton findDetailsButton;
    private JTextField textField4;
    private JButton saveButton;
    private JButton updateProfileButton;
    private JButton changePasswordButton;
    private JComboBox comboBox6;
    private JButton createNewNoticesButton;
    private JLabel jq;
    private JLabel jn;
    private JLabel js;
    private JLabel ja;
    private JLabel jd;
    private JLabel jt;
    private JLabel jsout;
    private JComboBox comboBox7;
    public JTextField lblFile;
    private JComboBox comboBox8;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    String use= String.valueOf(All_Login.use_name);

    public Lecture() throws SQLException {

        add(jpannel3);

        setSize(800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        String use=All_Login.use_name[0];

        textField2.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
        textField8.setEditable(false);



            postNoticeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   new Post_note();


                }
            });

            createNewNoticesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Bvana();

                }
            });

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

            Statement ss = connection.createStatement();
            ResultSet r = ss.executeQuery("select C_code from Account where username='" + use + "'");
            for (; r.next(); ) {
                comboBox7.addItem(r.getString("c_code"));
            }
        }catch(SQLException e){

            }

            findButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        cg = (String) comboBox8.getSelectedItem();
                        cb = (String) comboBox6.getSelectedItem();
                        new Ad_marks();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fileopen();
                }
            });


            updateProfileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    new Up_pro().lec_up_pro();
                }
            });

            jsout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            jsout.addMouseListener((MouseListener) new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showConfirmDialog(jsout, "Are you sure about log out");
                    JOptionPane.showMessageDialog(null, "Thank you Using System");
                    dispose();
                    new All_Login();

                }
            });


            findDetailsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = textField1.getText();

                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {

                        Statement ss = connection.createStatement();
                        ResultSet re = ss.executeQuery("select max(q1,q2,q3)+midexam+endexam+Assignment1+Assignment2+Assignment13 from ICT2123 where std_no='" + s + "'");
                        ResultSet g = ss.executeQuery("select * from std_info");
                        for (; g.next(); ) {
                            textPane1.setText(g.getString("name"));
                            textPane1.setText(g.getString("age"));
                            textPane1.setText(g.getString("Telephone number"));
                            textPane1.setText(g.getString("name"));
                        }
                        textPane1.setText(re.getString("select max(q1,q2,q3)+midexam+endexam+Assignment1+Assignment2+Assignment13 from ICT2123 where std_no='" + s + "'"));
                    } catch (SQLException ex) {

                    }
                }
            });
            changePasswordButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   new Up_pass();
                }
            });
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    SaveData();
                }
            });

        jp1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mini_project", "root", "mycomputer");) {

                    Statement se = connection.createStatement();
                    ResultSet re = se.executeQuery("select * from lecture");
                    for (; re.next(); ) {
                        textField2.setText(re.getString("lec_name"));
                        textField5.setText(re.getString("qualification"));
                        textField6.setText(re.getString("graduate"));
                        textField7.setText(re.getString("address"));
                        textField8.setText(re.getString("sub_code"));
                    }
                }catch (SQLException ef) {
                }
            }
        });
    }
    public static Connection ConnectDB() {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, e.getSQLState());
        }
        return null;
    }


    void fileopen() {

        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Choose file");

        if (ret == JFileChooser.APPROVE_OPTION) {
            lblFile.setText(fileopen.getSelectedFile().toString());
        }
    }



    private void SaveData()
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");){

            Statement ss = connection.createStatement();
            ResultSet r=ss.executeQuery("select C_code from Account where username='"+use+"'");
            for (;r.next();) {
                comboBox7.addItem(r.getString("c_code"));
            }
            String p = (String) comboBox7.getSelectedItem();

            String file = lblFile.getText();
            String fileName = file.substring(file.lastIndexOf('\\')+1, file.length());
            String desFile = null;
            try {
                desFile = new File(".").getCanonicalPath() + "\\img\\" + fileName;
                Files.copy(Paths.get(file),Paths.get(desFile),
                        StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e1) {
            }
            if(file==""){
                int re=ss.executeUpdate("Insert into course_mat(subject_code,mt_name,material) values ('"+p+"','"+fileName+"','"+ fileName +"')");

            }
            else {
                int re=ss.executeUpdate("Insert into course_mat(subject_code,mt_name,material) values ('"+p+"','"+file+"','"+ fileName +"')");

            }
            lblFile.setText("");

            JOptionPane.showMessageDialog(null," Inserted Successfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }


    }








    public static void main(String[] args) throws SQLException {
       new Lecture();


        }
    }



