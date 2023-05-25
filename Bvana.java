import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

public class Bvana extends  JFrame implements Lec {
    private JPanel pane3;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton fileAttachHereButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField lblFile;

    Bvana(){
        add(pane3);
        setSize(600,350);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fileAttachHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileopen();
            }
        });
        saveButton.addActionListener(new ActionListener() {
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

            String file = lblFile.getText();
            String fileName = file.substring(file.lastIndexOf('\\')+1, file.length());
            String desFile = null;
            try {
                desFile = new File(".").getCanonicalPath() + "\\img\\" + fileName;
                Files.copy(Paths.get(file),Paths.get(desFile),
                        StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e1) {
            }
            int r = ss.executeUpdate("insert into notice(podate,title,content,filename) values  ('" + LocalDate.now() + "','" + textField1.getText() + "','" + textArea1.getText() + "','"+fileName+"')");

            lblFile.setText("");

            JOptionPane.showMessageDialog(null," Inserted Successfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }


    }



}
