package vtc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Util {

    public static Connection getConnection() throws SQLException {
        String password = "cuong2001";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/lemon_tee_shop";
        return DriverManager.getConnection(url, user, password);
    }
    public static boolean executeStatement(final String sql) {
        boolean exeResult = false;
        try (Statement stm = DB_Util.getConnection().createStatement();) {
            exeResult = stm.execute(sql);
        } catch (final SQLException e) {
            exeResult = false;
        }
        return exeResult;
    }
}
