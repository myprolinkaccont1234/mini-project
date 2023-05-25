import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

class UserPanel extends JFrame implements ActionListener {

    private JButton btnUpdateContact, btnUpdateProfilePic, btnAttendance, btnMedical, btnCourse, btnGrades, btnTimetables, btnNotices;

    public UserPanel() {
        setTitle("User Panel");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        btnUpdateContact = new JButton("Update Contact Details");
        btnUpdateProfilePic = new JButton("Update Profile Picture");
        btnAttendance = new JButton("View Attendance Details");
        btnMedical = new JButton("View Medical Details");
        btnCourse = new JButton("View Course Details");
        btnGrades = new JButton("View Grades and GPA");
        btnTimetables = new JButton("View Timetables");
        btnNotices = new JButton("View Notices");

        add(btnUpdateContact);
        add(btnUpdateProfilePic);
        add(btnAttendance);
        add(btnMedical);
        add(btnCourse);
        add(btnGrades);
        add(btnTimetables);
        add(btnNotices);

        btnUpdateContact.addActionListener(this);
        btnUpdateProfilePic.addActionListener(this);
        btnAttendance.addActionListener(this);
        btnMedical.addActionListener(this);
        btnCourse.addActionListener(this);
        btnGrades.addActionListener(this);
        btnTimetables.addActionListener(this);
        btnNotices.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdateContact) {
            // Code for updating contact details

            UpdateContactDetails updateContactDetails = new UpdateContactDetails();

        } else if (e.getSource() == btnUpdateProfilePic) {
            // Code for updating profile picture

            UpdateProfilePicture updateProfilePicture = new UpdateProfilePicture();

        } else if (e.getSource() == btnAttendance) {
            // Code for viewing attendance details

            AttendanceViewer attendanceViewer = new AttendanceViewer();

        } else if (e.getSource() == btnMedical) {
            // Code for viewing medical details

            try {
                // Replace "timetable.pdf" with the name of TimeTable PDF file
                File file = new File("timetable.pdf");
                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "File does not exist.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == btnCourse) {
            // Code for viewing course details

            class CourseDetails {
                private static final String DB_URL = "jdbc:mysql://localhost:3306/university";
                private static final String USER = "root";
                private static final String PASS = "password";

                public static void main(String[] args) {
                    try {
                        // Open a connection to the database
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                        // Execute a query to retrieve course details
                        Statement stmt = conn.createStatement();
                        String sql = "SELECT * FROM courses";
                        ResultSet rs = stmt.executeQuery(sql);

                        // Print the course details
                        while (rs.next()) {
                            String courseCode = rs.getString("course_code");
                            String courseName = rs.getString("course_name");
                            String instructor = rs.getString("instructor");
                            int credits = rs.getInt("credits");

                            System.out.println("Course Code: " + courseCode);
                            System.out.println("Course Name: " + courseName);
                            System.out.println("Instructor: " + instructor);
                            System.out.println("Credits: " + credits);
                            System.out.println();
                        }

                        // Close the resources
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (e.getSource() == btnGrades) {
            // Code for viewing grades and GPA
        } else if (e.getSource() == btnTimetables) {
            // Code for viewing timetables

            try {
                // Replace "timetable.pdf" with the name of TimeTable PDF file
                File file = new File("timetable.pdf");
                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "File does not exist.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == btnNotices) {
            // Code for viewing notices

            try {
                // Replace "notices.pdf" with the name of notices PDF file
                File file = new File("notices.pdf");
                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "File does not exist.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        UserPanel userPanel = new UserPanel();
    }
}