package vtc.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAL_Account {
    public String check_account(String username, String password) {
        Connection conn = null;
        Statement start = null;
        ResultSet rs = null;
        String strconn = null;
        String position = null;
        int id = -1;
        try {
            strconn = "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
            conn = DriverManager.getConnection(strconn);
            start = conn.createStatement();
            rs = start.executeQuery(
                    "SELECT account_id,user_name FROM lemon_tee_shop.accounts where user_name = '" + username + "';");
            while (rs.next()) {
                if (username.equals(rs.getString("user_name"))) {
                    id = rs.getInt("account_id");
                } else {
                    id = -1;
                }

            }
            if (id == -1) {

                return null;
            } else {

                rs = start
                        .executeQuery("SELECT password FROM lemon_tee_shop.accounts where account_id = '" + id + "';");
                while (rs.next()) {
                    if (password.equals(rs.getString("Password"))) {
                        rs = start.executeQuery(
                                "SELECT position FROM lemon_tee_shop.accounts where account_id = '" + id + "';");
                        while (rs.next()) {
                            position = rs.getString("Position");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Co loi say ra!");
            System.out.println(e);
        }
        return position;
    }
}
