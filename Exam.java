import javax.swing.*;
import java.awt.*;

public class Exam extends  JFrame
{
    private JComboBox comboBox1;
    private JPanel jpane1;


    Exam(){
      add(jpane1);
      setLayout(new FlowLayout());
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(200,200);
      setVisible(true);
        comboBox1.addItem("Vanilla");


    }

    public static void main(String[] args) {

        new Exam();
    }
}
