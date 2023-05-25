import java.sql.*;

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
