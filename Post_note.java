import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class Post_note {

    // Creating frame
    JFrame f;

    // Creating Table

    // Creating label
    Post_note() {
        // Declaring Constructor
        // Initializing Frame
        f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTable j = null;
        // Setting Frame Title

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "mycomputer");) {
            Statement se = connection.createStatement();
            ResultSet re = se.executeQuery("select * from notice order by podate desc");

            Object[][] data = new Object[100][4];
            int row = 0;

            while (re.next()) {
                String filename = re.getString("filename");
                JLabel hyperlink = new JLabel("view more");
                hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                hyperlink.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            InputStream is = re.getBinaryStream("filecontent");
                            FileOutputStream fos = new FileOutputStream(filename);
                            byte[] buffer = new byte[4096];
                            int bytesRead = -1;
                            while ((bytesRead = is.read(buffer)) != -1) {
                                fos.write(buffer, 0, bytesRead);
                            }
                            fos.close();
                            is.close();
                            JOptionPane.showMessageDialog(null, "File downloaded successfully.");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                });

                data[row][0] = re.getString("podate");
                data[row][1] = re.getString("title");
                data[row][2] = re.getString("content");
                data[row][3] = hyperlink;

                row++;
            }

            String[] columnName = {"Date", "Notice","Content","Attachment"};
            j = new JTable(data, columnName);

        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "Error in Access to database");
            JOptionPane.showMessageDialog(null, E.getMessage());
            JOptionPane.showMessageDialog(null, E.getSQLState());
        }

        // Adding Data to be displayed
        // Column Names
        // String[] columnName = { "#No.","Name","Designation","Age"};

        // Initializing JTable
        j.setBounds(100, 50, 200, 400);
        f.setTitle("Recent Notices");

        // Adding Jtable to JScrollPane

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        // Setting Frame Size
        f.setSize(600, 250);

        // Set Frame Visible as true
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Post_note();
    }
}

