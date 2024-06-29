# To demonstrate JDBC connectivity in Java on a Linux OS, follow these steps:

## Setup your development environment:

Ensure you have Java Development Kit (JDK) installed.
Ensure you have the necessary JDBC driver for your database (e.g., MySQL, PostgreSQL).
Write the Java code for JDBC connectivity:

## Load the JDBC driver.
Establish a connection to the database.
Create and execute an SQL statement.
Process the results.
Close the connection.
Compile and run the Java program:

Use javac to compile the Java code.
Use java to run the compiled code.
Here's a step-by-step guide with code:

### Step 1: Install JDK and JDBC Driver
Install JDK (if not already installed):

``` bash
sudo apt update
sudo apt install default-jdk
```
#### Download JDBC Driver for your database. For example, for MySQL:

``` bash
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.26.tar.gz
tar xzf mysql-connector-java-8.0.26.tar.gz
```

### Step 2: Write the Java Code
Save the following Java code in a file named JDBCDemo.java:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        // Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, user, password);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            String sql = "SELECT id, name FROM yourTable";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
```

### Step 3: Compile and Run the Java Program
Compile the program:

``` bash
javac -cp .:mysql-connector-java-8.0.26/mysql-connector-java-8.0.26.jar JDBCDemo.java
```

Run the program:

```bash 
java -cp .:mysql-connector-java-8.0.26/mysql-connector-java-8.0.26.jar JDBCDemo
```

#### Important Points:

<b>Database URL</b>: ``` jdbc:mysql://localhost:3306/yourDatabase``` should be replaced with your actual database URL.

<b>Username and Password</b>: Replace ```yourUsername``` and ```yourPassword``` with your actual database username and password.

<b>SQL Query</b>: Replace SELECT id, name FROM yourTable with your actual SQL query and table name.

<b>JDBC Driver Path</b>: Adjust the path to your JDBC driver JAR file as necessary.

<b>Next Steps:</b>

* Add error handling and logging for better debugging.

*  Implement parameterized queries to prevent SQL injection.