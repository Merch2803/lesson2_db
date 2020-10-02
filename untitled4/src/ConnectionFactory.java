import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionFactory {
    public static Connection getInstance() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/autho",
                    "root", "root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Something went wrong during DB connection");
        }
    }
}
