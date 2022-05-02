import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
