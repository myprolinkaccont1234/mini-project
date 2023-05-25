import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame{
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton findCouseDetailsButton;
    private JPanel jpannel5;
    private JProgressBar progressBar1;
    private JTable table1;

    public Student() {
        add(jpannel5);
        setSize(600,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        findCouseDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] colHeads = { "Subject name", "Subject code", "No.Credit" };
                Object [][] data={{"English II","ENG1212","2"},{"English III","ENG2112","2"}};
                JFrame course_d=new JFrame();
                JTable cou_de=new JTable((Object[][]) data,colHeads);
                course_d.setSize(400,100);
                JSeparator js=new JSeparator();
                js.setSize(500,100);
                course_d.add(js);
                course_d.add(cou_de);
                course_d.setVisible(true);
                course_d.setLayout(new FlowLayout());

            }
        });
    }

    public static void main(String[] args) {
        new Student();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
