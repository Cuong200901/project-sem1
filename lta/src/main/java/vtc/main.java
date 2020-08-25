package vtc;

import vtc.bl.AccountBL;
import vtc.dal.UtilDB;
import vtc.ui.EraserThread;
import vtc.ui.AccountUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(final String[] args) throws SQLException {
        // String strconn =
        // "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
        // try ( Connection conn = DriverManager.getConnection(strconn);)
        // {
        // System.out.println("Connected to MySql Server.");
        // } catch (SQLException ex) {
        // System.out.println("Connection Error!");
        // System.out.println(ex);
        // }

        // final Scanner sc = new Scanner(System.in);
        // while (true) {
        // cls();

        // final AccountBL accountBL = new AccountBL();
        // final AccountUI accountUI = new AccountUI();
        // String username;
        // String password;
        // System.out.println("[LTS] PF10 - Group6");

        // System.out.println("+-------------------------------------------+");
        // System.out.println("| WELLCOME |");
        // System.out.println("+-------------------------------------------+");
        // System.out.print(" [Username]: ");
        // username = nhap();
        // System.out.print(" [Password]: ");
        // password = nhap();
        // int check = accountBL.login(username, password);
        // if (check == -1) {
        // System.out.println("Tai khoan hoac mat khau khong chinh xac!");
        // System.out.printf("Nhan %s de tiep tuc:", "Enter");
        // String nh = sc.nextLine();
        // } else if (check == 1) {
        // accountUI.admin_main_menu(check);
        // } else {
        // accountUI.staff_main_menu(check);

        // }

        // }

        // }

        // private static String nhap() {
        // final Scanner input = new Scanner(System.in);
        // String a;
        // while (true) {
        // a = input.nextLine();
        // if (a.trim().compareTo("") == 0) {
        // System.out.print(" Nhap sai,moi nhap lai: ");

        // } else {
        // return a.trim();
        // }
        // }

        // String date = input_date();
        // System.out.println(date);
        int id = 1;
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

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }

    public static String readPassword(final String prompt) {
        final EraserThread et = new EraserThread(prompt);
        final Thread mask = new Thread(et);
        mask.start();

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try {
            password = in.readLine();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
        // stop masking
        et.stopMasking();
        // return the password entered by the user
        return password;
    }

    public static String input_date() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                a = LocalDate.parse(a, formatter).format(formatter2);
                return a;
            } catch (Exception e) {
                System.out.print("Error!, Enter again: ");
            }
        }
    }
}