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
        final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Clear';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+--------------------------+");
            System.out.printf("| %-10s | %-20s |\n", "Id", "Status");
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+--------------------------+");
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    public static void showTableExsit() {
        final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Exsit';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+-----------------------------------+");
            System.out.printf("| %-10s | %-20s |\n", "Id", "Status");
            System.out.println("+-----------------------------------+");
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+-----------------------------------+");
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    public static void showOrderByDay(final String day) {
        final String sql = "SELECT * FROM lemon_tee_shop.order where time = '" + day + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {

            System.out.println(
                    "+-------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n", "Id", "Time", "Account Id", "note",
                    "Table id");
            System.out.println(
                    "+-------------------------------------------------------------------------------------------+");
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n", rs.getInt("order_id"),
                        rs.getString("time"), rs.getInt("account_id"), rs.getString("note"), rs.getInt("table_id"));
            }
            System.out.println(
                    "+-------------------------------------------------------------------------------------------+");
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
    }

    public static void showBill(final int id) {
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
                // "| |");
            }

        } catch (final SQLException ex) {

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
                // "| | | | |");
                System.out.println("|                                                                         |");
                System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", rs.getString("name"), rs.getDouble("price"),
                        rs.getInt("amount"), (totalmonney = rs.getDouble("price") * rs.getInt("amount")));

                billmonney = billmonney + totalmonney;
            }
            System.out.println("|                                                                         |");
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.println("|                                                                         |");
            System.out.printf("| Total bill: %-60s|\n", billmonney);
            System.out.println("|                                                                         |");
            System.out.println("+-------------------------------------------------------------------------+");

        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
    }

    public static void orderAmountByMonth(final int year) {
        int count = 0;
        System.out.println("+-----------------------------------+");
        System.out.println("|              " + year + "                 |");
        System.out.println("+-----------------------------------+");
        System.out.printf("| %-10s | %-20s |\n", "Month", "Amount");
        System.out.println("+-----------------------------------+");
        String sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year
                + " and month(order.time) = 1";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "1", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 2";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "2", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 3";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "3", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 4";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "4", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 5";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "5", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 6";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "6", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 7";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "7", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {
            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 8";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "8", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 9";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "9", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 10";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "10", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 11";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "11", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year + " and month(order.time) = 12";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                count++;
            }
            System.out.printf("| %-10s | %-20s |\n", "12", count);
            System.out.println("+-----------------------------------+");
            count = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
    }

    public static void monneyEarnByMonth(final int year) {
        double monneyEarner = 0;
        System.out.println("+-----------------------------------+");
        System.out.println("|              " + year + "                 |");
        System.out.println("+-----------------------------------+");
        System.out.printf("| %-10s | %-20s |\n", "Month", "Monney Earner");
        System.out.println("+-----------------------------------+");
        String sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 1;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "1", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 2;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "2", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 3;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "3", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 4;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "4", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 5;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "5", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 6;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "6", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 7;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "7", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 8;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "8", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 9;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "9", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 10;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "10", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 11;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "11", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
        sql = "SELECT amount, price  from lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id join lemon_tee_shop.order on order_details.order_id = order.order_id where year(order.time) = "
                + year + " and month(order.time) = 12;";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));

            }
            System.out.printf("| %-10s | %-20s |\n", "12", monneyEarner);
            System.out.println("+-----------------------------------+");
            monneyEarner = 0;
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    public static int completeOrder(final int table) {
        int count = 0;
        final String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (!rs.getString("status").equals("Clear")) {
                    count = 1;
                }
            }
        } catch (final SQLException ex) {
            return count;
        }
        if (count == 1) {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "UPDATE `lemon_tee_shop`.`table` SET `status` = 'Clear' WHERE (`table_id` = '" + table
                                    + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {
                    System.out.println("Successful!");
                    count = 2;
                } else {
                    System.out.println("Fail!");
                }
            } catch (final SQLException ex) {
                ex.printStackTrace();
                System.out.println("Update error!");

            }
        }
        if (count == 0) {
            System.out.println("Wrong table!");
        }
        return count;
    }

    public static int createOrder(final int staff_id, final int table_id, final String note) {
        int count = 0;
        final String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table_id + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (rs.getString("status").equals("Clear")) {
                    count = 1;

                } else {
                    count = 2;
                }
            }
        } catch (final SQLException ex) {

            return count;
        }

        if (count == 1) {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con
                            .prepareStatement("UPDATE lemon_tee_shop.table SET status = 'Exsit' WHERE (table_id = '"
                                    + table_id + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {

                }
            } catch (final SQLException ex) {

                return count;
            }
            while (true) {
                try (Connection con = UtilDB.getConnection();
                        PreparedStatement pstm = con.prepareStatement(
                                "INSERT INTO lemon_tee_shop.order (time, account_id, note, table_id) VALUES ( '"
                                        + java.time.LocalDateTime.now() + "', '" + staff_id + "', '" + note + "', '"
                                        + table_id + "');");) {
                    final int rs = pstm.executeUpdate();
                    if (rs == 1) {

                    }
                } catch (final SQLException ex) {
                    return count;
                }
                break;
            }
            count = 3;
        }

        return count;
    }

    public static int productsInOrder(final int product_id, final int amount) {

        int count = 0;
        int order_id = 0;
        int productInStock = 0;
        String sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id  = '" + product_id + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (rs.getInt("products_in_stock") == 0) {
                    System.out.println("The product is out of stock!");

                } else if (rs.getInt("products_in_stock") < amount) {
                    System.out.println("Insufficient quantity of products!");

                } else {
                    count = 1;
                }

            }
        } catch (final SQLException ex) {
            return count;
        }

        if (count == 1) {
            sql = "SELECT max(order_id) FROM lemon_tee_shop.order;";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    order_id = rs.getInt("max(order_id)");
                    count = 2;

                }
            } catch (final SQLException ex) {
                return count;
            }
        }
        if (count == 2) {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con
                            .prepareStatement("INSERT INTO order_details (product_id, amount, order_id) VALUES ('"
                                    + product_id + "', '" + amount + "', '" + order_id + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {
                    System.out.println("Successful!");
                    count = 3;
                } else {
                    System.out.println("Fail!");
                }
            } catch (final SQLException ex) {
                return count;

            }
            sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id = '" + product_id + "';";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    productInStock = rs.getInt("products_in_stock") - amount;
                    System.out.println(productInStock);
                }
            } catch (final SQLException ex) {
                System.out.println(ex.toString());
            }
            System.out.println(productInStock);
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con
                            .prepareStatement("UPDATE lemon_tee_shop.products SET products_in_stock = '"
                                    + productInStock + "' WHERE (product_id = '" + product_id + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {
                    System.out.println("Successful!");
                    count = 3;
                } else {
                    System.out.println("Fail!");
                }
            } catch (final SQLException ex) {
                System.out.println(ex);
                return count;

            }
        }
        if (count == 0) {
            System.out.println("Product not exsit!");
        }
        return count;

    }

    public static int updateOrder(final int table) {
        int order_id = 0;
        int count = 0;
        String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (!rs.getString("status").equals("Clear")) {
                   return count = 1;
                   
                }
                else
                {  
                    System.out.println("Table clear!");
                }
            }
        } catch (final SQLException ex) {
            System.out.println(ex);
        }

       System.out.println(count);
        if (count ==  1 ){
            sql = "SELECT max(order_id) FROM lemon_tee_shop.order where table_id = '" + table + "';";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    order_id = rs.getInt("max(order_id)");
                    System.out.println(order_id);
    
                }
            } catch (final SQLException ex) {
                System.out.println(ex);
            }
        }

        System.out.println(order_id);
        return order_id;
    }

}