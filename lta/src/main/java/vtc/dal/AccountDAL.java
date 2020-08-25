package vtc.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.persistance.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.sql.ResultSet;

public class AccountDAL {
    // public List<DAL_Account> getAll()
    // {
    // String sql = "select * from customers";
    // List<DAL_Account> lst = new ArrayList<>();
    // try (Connection con = DB_Util.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // while (rs.next()) {
    // lst.add(getAccount(rs));
    // }
    // } catch (SQLException ex) {
    // }
    // return lst;
    // }
    //
    // private Account getAccount(final ResultSet rs) throws SQLException {
    // Account account = new DAL_Account();
    // account.getaccountId(rs.getInt("customer_id"));
    // account.setCustomerName(rs.getString("customer_name"));
    // customer.setCustomerAddress(rs.getString("customer_address"));
    // return customer;
    // }

    public int check_account(String username, String password) {

        String position = null;
        int id = -1;
        try {
            String strconn = "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
            Connection conn = DriverManager.getConnection(strconn);
            Statement start = conn.createStatement();
            ResultSet rs = start.executeQuery(
                    "SELECT account_id,user_name FROM lemon_tee_shop.accounts where user_name = '" + username + "';");
            while (rs.next()) {
                if (username.equals(rs.getString("user_name"))) {
                    id = rs.getInt("account_id");
                } else {
                    id = -1;
                }

            }
            if (id == -1) {

                return id = -1;
            } else {

                rs = start
                        .executeQuery("SELECT password FROM lemon_tee_shop.accounts where account_id = '" + id + "';");
                while (rs.next()) {
                    if (password.equals(rs.getString("Password"))) {
                        return id;
                        }
                        else
                        {
                            return id = -1;
                        }
                    }
                }
            

        } catch (SQLException e) {
            System.out.println("Co loi say ra!");
            System.out.println(e);
        }
        return id;
    }

    public static Account getAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setusername(rs.getString("user_name"));
        account.setpassword(rs.getString("password"));
        account.setfirstname(rs.getString("first_name"));
        account.setlastname(rs.getString("last_name"));
        account.setbirthday(rs.getString("birthday"));
        account.setphonenumber(rs.getInt("phone_number"));
        account.setemail(rs.getString("email"));
        account.setposition(rs.getString("position"));
        account.setstarttime(rs.getString("start_time"));
        account.setshitf(rs.getString("shitf"));
        return account;
    }

    public static List<Account> getAll() {
        String sql = "select * from accounts";
        List<Account> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getAccount(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public int update(Account account) throws SQLException {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "UPDATE accounts SET user_name` = 'asd', `password` = '?', `first_name` = '?', `last_name` = '?', `birthday` = '?', `phone_number` = '?', `email` = '?', `shitf` = '?' WHERE (account_id = '?'");) {
            pstm.setString(1, account.getusername());
            pstm.setString(2, account.getuserpassword());
            pstm.setString(3, account.getfirstname());
            pstm.setString(4, account.getlastname());
            pstm.setString(5, account.getbirthday());
            pstm.setInt(6, account.getphonenumber());
            pstm.setString(7, account.getemail());
            pstm.setString(8, account.getshitf());
            pstm.setInt(9, account.getaccountId());
            int rs = pstm.executeUpdate();
            if (rs == 1) {
                System.out.println("Update Successful!");
            } else {
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;

        }
    }

    public static int insertaccount(Account account) {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "INSERT INTO accounts (`user_name`, `password`, `first_name`, `last_name`, `birthday`, `phone_number`, `email`, `position`, `start_time`, `shitf`) VALUES ('?', '?', '?', '?', '?', '?', '?', 'Staff', '"
                                + java.time.LocalDate.now() + "', '?')");) {
            pstm.setString(1, account.getusername());
            pstm.setString(2, account.getuserpassword());
            pstm.setString(3, account.getfirstname());
            pstm.setString(4, account.getlastname());
            pstm.setString(5, account.getbirthday());
            pstm.setInt(6, account.getphonenumber());
            pstm.setString(7, account.getemail());
            pstm.setString(8, account.getshitf());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error insert!");
            System.out.println(ex.toString());
            return 0;

        }
    }

}
