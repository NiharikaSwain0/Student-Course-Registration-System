import java.sql.*;

public class DAO {

    public static boolean validateLogin(String username, String password) {
        try (Connection con = Connect.getConnection()) {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public static boolean registerCourse(ModelClass m) {
        try (Connection con = Connect.getConnection()) {
            String query = "INSERT INTO registrations(username, course) VALUES(?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, m.getUsername());
            pst.setString(2, m.getCourse());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Registration error: " + e.getMessage());
            return false;
        }
    }
}
