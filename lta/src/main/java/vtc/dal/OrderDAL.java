package vtc.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import vtc.persistance.Account;
import vtc.persistance.OrderDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.sql.ResultSet;

public class OrderDAL {

    public static void showTableClear() {
        String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Clear';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+--------------------------+");
            System.out.printf("| %-10s | %-20s |\n", "Id", "Status");
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+--------------------------+");
        } catch (SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    public static void showTableExsit() {
        String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Exsit';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+--------------------------+");
            System.out.printf("| %-10s | %-20s |\n", "Id", "Status");
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+--------------------------+");
        } catch (SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    // public static Account getAccount(ResultSet rs) throws SQLException {
    // OrderDetails orderDetails = new OrderDetails();
    // orderDetails.setOrderDetailsId(rs.getInt("order_details_id"));
    // account.setusername(rs.getString("user_name"));
    // account.setpassword(rs.getString("password"));
    // account.setfirstname(rs.getString("first_name"));
    // account.setlastname(rs.getString("last_name"));
    // account.setbirthday(rs.getString("birthday"));
    // account.setphonenumber(rs.getInt("phone_number"));
    // account.setemail(rs.getString("email"));
    // account.setposition(rs.getString("position"));
    // account.setstarttime(rs.getString("start_time"));
    // account.setshift(rs.getString("shift"));
    // return account;
    // }
    public static void showBill(int id)
    {
        double totalmonney = 0;
        double billmonney = 0;
        String sql = "SELECT order_id, time, table_id, note, first_name, last_name FROM lemon_tee_shop.order inner join accounts on order.account_id =  accounts.account_id where order_id = '"
                + id + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|                               Lemon tee shop                            |");
            System.out.println("|                                                                         |");
            while (rs.next()) {
                System.out.printf("|   Staff name: %-15sTime: %-15s   Table: %-8s|\n",
                        rs.getString("first_name").concat(" " + rs.getString("last_name")), rs.getString("time"),
                        rs.getInt("table_id"));
                // System.out.println(
                //         "|                                                                                   |");
            }
            
        } catch (SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT  name, price, amount ,order_id FROM lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id where order_id = '"
                + id + "' ;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|                                                                         |");
            System.out.printf("| %-30s | %-13s| %-7s | %-13s|\n", "Product name", "Price one unit", "Amount",
                    "Total money");
            
            while (rs.next()) {
                // System.out.println(
                //     "|                                |                   |            |                 |");
            System.out.println("|                                                                         |");
                System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", rs.getString("name"), rs.getDouble("price"),
                        rs.getInt("amount"), (totalmonney = rs.getDouble("price") * rs.getInt("amount")));
              
                billmonney = billmonney  +totalmonney;
            }
            System.out.println("|                                                                         |");
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|                                                                         |");
            System.out.printf("| Total bill: %-60s|\n", billmonney);
            System.out.println("|                                                                         |");
            System.out.println("+-------------------------------------------------------------------------+");

        } catch (SQLException ex) {

            System.out.println(ex.toString());
        }
    }

}