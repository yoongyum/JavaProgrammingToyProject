import org.h2.Driver;

import java.sql.*;

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

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(stmt,conn);
    }
}
