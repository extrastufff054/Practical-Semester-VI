import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagementExample {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Set the connection to manual commit mode
            conn.setAutoCommit(false);

            // Perform database operations
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO person VALUES ('1', 'USA', 'JACK')");
            stmt.executeUpdate();
            stmt = conn.prepareStatement("UPDATE person SET country = 'USA' WHERE name = 'JACK'");
            stmt.executeUpdate();

            // Commit the transaction
            conn.commit();

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            try {
                // Rollback the transaction if an error occurs
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackE) {
                System.out.println("Error rolling back transaction: " + rollbackE.getMessage());
            }
            System.out.println("Error performing database operations: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}