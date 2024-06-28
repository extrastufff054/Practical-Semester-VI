import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "myuser";
            String password = "mypassword";

            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Create a statement object
            Statement stmt = conn.createStatement();

            // 4. Execute a query
            String query = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // 6. Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}