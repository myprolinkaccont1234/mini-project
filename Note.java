import javax.swing.*;
import java.awt.*;

public class Note extends JFrame {
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel note;


    Note(){
        add(note);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(500,300);
    }
    public static void main(String[] args) {
        new Note();
    }


}
