import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckUncheckEx extends JFrame {

    private JCheckBox box1;
    private JCheckBox box2;
    private JCheckBox box3;
    private JCheckBox box4;
    private JCheckBox box6;
    private JCheckBox box7;
    private JCheckBox box8;
    private JCheckBox box12;
    private JCheckBox box13;
    private JCheckBox box11;
    private JCheckBox box9;
    private JCheckBox box10;
    private JCheckBox box5;
    private JCheckBox box14;
    private JCheckBox box15;
    private JCheckBox box16;
    private JButton checkAllButton;
    private JButton uncheckAllButton;
    private JPanel japane;

    public CheckUncheckEx() {
    add(japane);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        checkAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Component[] components = getContentPane().getComponents();
               box1.setSelected(true);
              /* for (Component comp : components) {

                    if (comp instanceof JCheckBox) {
                        JCheckBox box = (JCheckBox) comp;
                        box.setSelected(true);
                    }
                }*/
            }
        });
        uncheckAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Component[] components = getContentPane().getComponents();

                for (Component comp : components) {

                    if (comp instanceof JCheckBox) {
                        JCheckBox box = (JCheckBox) comp;
                        box.setSelected(false);
                    }
                }
            }
        });





       // JButton btn1 = new JButton("Check all");
       // checkAllButton.addActionListener(new CheckAllAction());

     /*   JButton btn2 = new JButton("Uncheck all");
        btn2.addActionListener(new UnCheckAllAction());
        add(box1 , "wrap");
        JSeparator f=new JSeparator();
        add(f);*/

        pack();

    //    setTitle("Check boxes");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
    }


    public static void main(String[] args) {

        CheckUncheckEx ex = new CheckUncheckEx();
        ex.setVisible(true);
    }
}