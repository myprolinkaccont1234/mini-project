import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class UpdateProfilePicture extends JFrame implements ActionListener {
    private JButton chooseImageButton, updateButton;
    private JLabel imageLabel;
    private JFileChooser fileChooser;
    private File selectedFile;

    public UpdateProfilePicture() {
        super("Update Profile Picture");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create choose image button and add action listener
        chooseImageButton = new JButton("Choose Image");
        chooseImageButton.addActionListener(this);

        // create update button and add action listener
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        // create image label and set preferred size
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 300));

        // create file chooser
        fileChooser = new JFileChooser();

        // create panel for buttons and image label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(chooseImageButton);
        buttonPanel.add(updateButton);

        // add components to frame
        add(buttonPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // handle button actions here
        if (e.getSource() == chooseImageButton) {
            // open file chooser and get selected file
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                // display selected image in image label
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
            }
        } else if (e.getSource() == updateButton) {
            if (selectedFile != null) {
                // perform action for updating profile picture
                // you can write code here to save the selected file to the user's profile picture
                JOptionPane.showMessageDialog(null, "Profile picture updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Please choose an image file.");
            }
        }
    }

    public static void main(String[] args) {
        UpdateProfilePicture updateProfilePicture = new UpdateProfilePicture();
    }
}
