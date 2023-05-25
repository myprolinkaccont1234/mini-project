import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Tec_officer {
    private JTabbedPane tabbedPane1;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JPanel jp4;
    private JPanel jp5;
    private JComboBox comboBox1;
    private JButton addAttaindenceButton;
    private JTextPane textPane1;
    private JPanel Noticepane;

    public Tec_officer() {
        jp5.add(Noticepane);


        Noticepane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // Lecture.viewnotice();
            }
        });
    }

        void add_attain () {
            addAttaindenceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = (String) comboBox1.getSelectedItem();
                    JFrame jf = new JFrame();
                    jf.setLayout(new FlowLayout());
                    jf.setSize(450, 300);
                    jf.setVisible(true);

                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer")) {

                        Statement ne = connection.createStatement();
                        ResultSet re = ne.executeQuery("select std-mo,'" + s + "' from std_attendance ");
                        for (; re.next(); ) {
                            String[] titles = {"Student number", "Attaindence"};
                            JTable jt;
                            JCheckBox jc = new JCheckBox();
                            jc.setVisible(true);
                            Object[][] data = {{re.getString("std_no"), jc}};
                            jt = new JTable(data, titles);
                            JButton jb = new JButton("Add Attendance");
                            jf.add(jt);
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (jc.isSelected()) {
                                        int d = 0;
                                        try {
                                            d = Integer.parseInt(re.getString("ICT1221"));
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, ex.getMessage());
                                        }
                                        d++;
                                        try {
                                            int r = ne.executeUpdate("insert into std_attendance('" + s + "') values ('" + d + "')");
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, ex.getMessage());
                                        }

                                    }

                                }
                            });
                        }
                    } catch (SQLException E) {
                        JOptionPane.showMessageDialog(null, E.getSQLState());
                        JOptionPane.showMessageDialog(null, E.getMessage());


                    }
                }
            });
        }


    public static void main(String[] args) {
        new Tec_officer();
    }
}
