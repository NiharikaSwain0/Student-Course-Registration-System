import java.sql.*;

public class Connect {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_system";
        String user = "root";
        String password = "Harsh1112004@"; // Change this!
        return DriverManager.getConnection(url, user, password);
    }
}
