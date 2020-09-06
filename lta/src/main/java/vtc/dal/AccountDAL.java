package vtc.dal;

import java.util.ArrayList;
import java.util.List;

import vtc.persistance.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

public class AccountDAL {
    
    public int check_account(String username, String password) {

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
                    } else {
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
        try {
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
            account.setshift(rs.getString("shift"));
            return account;
        } catch (Exception e) {
            return null;
        }
     
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
        }
        return lst;
    }

    public static List<Account> getById(int id) {
        String sql = "SELECT * FROM accounts where account_id = '" + id + "';";
        List<Account> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getAccount(rs));
            }
        } catch (SQLException ex) {
            lst = null;
        }
        return lst;
    }

    public int updateById(Account account, int id) throws SQLException {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "UPDATE accounts SET `password` = ?, `first_name` = ?, `last_name` = ?, `birthday` = ?, `phone_number` = ?, `email` = ?, `shift` = ? WHERE (account_id = ?);");) {

            pstm.setString(1, account.getuserpassword());
            pstm.setString(2, account.getfirstname());
            pstm.setString(3, account.getlastname());
            pstm.setString(4, account.getbirthday());
            pstm.setInt(5, account.getphonenumber());
            pstm.setString(6, account.getemail());
            pstm.setString(7, account.getshift());
            pstm.setInt(8, id);
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

    public int update(Account account) throws SQLException {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "UPDATE accounts SET  password= ?, first_name = ?, last_name = ?, birthday = ?, phone_number = ?, email = ?, shift = ? WHERE (account_id = ?);");) {
            pstm.setString(1, account.getuserpassword());
            pstm.setString(2, account.getfirstname());
            pstm.setString(3, account.getlastname());
            pstm.setString(4, account.getbirthday());
            pstm.setInt(5, account.getphonenumber());
            pstm.setString(6, account.getemail());
            pstm.setString(7, account.getshift());
            pstm.setInt(8, account.getaccountId());
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

        int id = -1;

        String sql = "SELECT account_id FROM lemon_tee_shop.accounts where user_name = '" + account.getusername()
                + "';";

        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                id = rs.getInt("account_id");
            }
        } catch (SQLException ex) {
            return 0;
        }
        if (id != -1) {
            return 0;
        } else {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "INSERT INTO accounts (user_name, password, first_name, last_name, birthday, phone_number, email,position, start_time, shift) VALUES (?, ?, ?, ?, ?,?, ?, 'Staff', "
                                    + java.time.LocalDate.now() + ", ?);");) {
                pstm.setString(1, account.getusername());
                pstm.setString(2, account.getuserpassword());
                pstm.setString(3, account.getfirstname());
                pstm.setString(4, account.getlastname());
                pstm.setString(5, account.getbirthday());
                pstm.setInt(6, account.getphonenumber());
                pstm.setString(7, account.getemail());
                pstm.setString(8, account.getshift());
                return pstm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error insert!");
                return -1;

            }
        }

    }

}
