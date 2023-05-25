import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;

public class Admin extends  JFrame  {
    private JPanel jpannel2;
    private JTabbedPane tabbedPane1;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JPanel jp4;
    private JPanel jp5;
    private JButton jb;
    private JButton createNewNoticeButton;
    private JButton postedNoticeButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton postButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JButton fileAttachHereButton;
    private JTextField textField2;
    private JButton createProfileButton;
    private JButton removeProfileButton;
    private JButton createButton;
    private JLabel jt;
    private JLabel jsout;
    private JButton updateProfileButton;
    private JButton changePasswordButton;
    private JTextField textField5;
    private JTextField textField7;
    private JTextField textField3;
    private JTextField text1;

    Admin() {
        setSize(700, 300);
        setVisible(true);
        add(jpannel2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createNewNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Bvana();
            }
        });
        fileAttachHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileopen();
            }
        });
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Up_pro().adm_up_pro();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Up_pass();
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
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveData();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        postedNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Post_note();
            }
        });
        text1.setEditable(false);
        textField5.setEditable(false);
        textField7.setEditable(false);
        textField3.setEditable(false);
        jp1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mini_project", "root", "mycomputer");) {

                    Statement se = connection.createStatement();
                    ResultSet re = se.executeQuery("select * from Admin");
                    for (; re.next(); ) {
                        text1.setText(re.getString("ad_name"));
                        textField5.setText(re.getString("qualification"));
                        textField7.setText(re.getString("address"));
                        textField3.setText(re.getString("gender"));
                    }
                }catch (SQLException er) {
                }
            }
        });
    }
    void fileopen() {

        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Choose file");

        if (ret == JFileChooser.APPROVE_OPTION) {
            textField2.setText(fileopen.getSelectedFile().toString());
        }
    }



    private void SaveData()
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");){

            Statement ss = connection.createStatement();

            String file = textField2.getText();
            String des=textField1.getText();
            String dep= (String) comboBox1.getSelectedItem();
            String lev= (String) comboBox1.getSelectedItem();
            String sem= (String) comboBox1.getSelectedItem();
            String fileName = file.substring(file.lastIndexOf('\\')+1, file.length());
            String desFile = null;
            try {
                desFile = new File(".").getCanonicalPath() + "\\img\\" + fileName;
                Files.copy(Paths.get(file),Paths.get(desFile),
                        StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e1) {
            }
                int re=ss.executeUpdate("Insert into timeline(Department,level,semester,post_date,description,timetable) values ('"+dep+"','"+lev+"','"+ sem +"','"+ LocalDate.now()+"'+"+ des +"','"+ fileName +"')");

            textField2.setText("");

            JOptionPane.showMessageDialog(null," Inserted Successfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }


    }



		/*class notice extends JPanel {
            public notice() {
            class massage implements Runnable {
                Thread t;
                String s=" ... New Notice is there ... /\\ ";
                boolean b=true;

                public void init() {
                    setBackground(Color.yellow);
                }
                public void start() {
                    t=new Thread(this);
                    b=false;
                    t.start();

                }
                public void run() {
                    char c;
                    for(; ;) {
                        try {
                            repaint();

                            Thread.sleep(200);
                            c=s.charAt(1);
                            s=s.substring(1,s.length());
                            s+=c;
                            if(b) {
                                break;
                            }
                        }catch(InterruptedException e) {
                            System.out.print("Main Thred Intrrupted");
                        }
                    }
                }

                public void stop() {
                    b=true;
                    t=null;

                }
                public void paint(Graphics g) {
                    g.drawString(s,30,30);
                }
            }
        }*/

    public static void main(String[] args) {

                Admin a=new Admin();
    }
}
