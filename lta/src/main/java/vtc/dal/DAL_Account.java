package vtc.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAL_Account {
//public List<DAL_Account> getAll()
//{
//    String sql = "select * from customers";
//    List<DAL_Account> lst = new ArrayList<>();
//    try (Connection con = DB_Util.getConnection();
//         Statement stm = con.createStatement();
//         ResultSet rs = stm.executeQuery(sql)) {
//        while (rs.next()) {
//            lst.add(getAccount(rs));
//        }
//    } catch (SQLException ex) {
//    }
//    return lst;
//}
//
//    private Account getAccount(final ResultSet rs) throws SQLException {
//        Account account = new DAL_Account();
//       account.getaccountId(rs.getInt("customer_id"));
//        account.setCustomerName(rs.getString("customer_name"));
//        customer.setCustomerAddress(rs.getString("customer_address"));
//        return customer;
//    }

    public String check_account(String username, String password) {

        String position = null;
        int id = -1;
        try {
            String  strconn = "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
            Connection  conn = DriverManager.getConnection(strconn);
            Statement  start = conn.createStatement();
            ResultSet rs = start.executeQuery("SELECT account_id,user_name FROM lemon_tee_shop.accounts where user_name = '" + username + "';");
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

                rs = start.executeQuery("SELECT password FROM lemon_tee_shop.accounts where account_id = '" + id + "';");
                while (rs.next()) {
                    if (password.equals(rs.getString("Password"))) {
                        rs = start.executeQuery("SELECT position FROM lemon_tee_shop.accounts where account_id = '" + id + "';");
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
