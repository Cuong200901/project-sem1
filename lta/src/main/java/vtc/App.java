package vtc;


import java.io.IOException;

import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.AccountBL;
import vtc.bl.OrderBL;
import vtc.bl.ProductBL;

import vtc.persistance.Account;
import vtc.persistance.Order;
import vtc.persistance.OrderDetails;
import vtc.persistance.Product;
import vtc.ui.AccountUI.AccountFunctionUI;


public class App {
    static Scanner sc = new Scanner(System.in);
    static AccountBL accountBL = new AccountBL();
    static ProductBL productBL = new ProductBL();
    static OrderBL orderBL = new OrderBL();
    static OrderDetails orderDetails = new OrderDetails();
    static List<Account> accountsList = new ArrayList<>();
    static List<Product> productsList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();
    static List<OrderDetails> orderdetailssList = new ArrayList<>();

    public static void main(final String[] args) throws SQLException {

        cls();
        AccountFunctionUI.login();
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

    public static String yesno() {
        final Scanner sc = new Scanner(System.in);
        String yn = null;
        while (true) {
            yn = sc.nextLine();
            if (yn.equals("N") || yn.equals("Y") || yn.equals("n") || yn.equals("y")) {
                break;
            } else {
                System.out.print("  Wrong type, enter again: ");
            }
        }

        return yn;
    }

    public static String username_password() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();

            if (a.length() < 6 || a.length() > 10 || a.trim().compareTo(a) != 0 || a.toLowerCase() != a
                    || a.matches("\\w+") == false) {
                System.out.print("  Nhap sai,moi nhap lai: ");

            } else {
                return a;
            }
        }
    }

    public static String input_string() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Wrong type, enter again: ");

            } else {
                return a.trim();
            }
        }

    }

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                if (x >= 0) {
                    return x;
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (final Exception e) {
                System.out.print("  Wrong type, enter again: ");
            }
        }

    }

    public static String input_date() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            try {
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                a = LocalDate.parse(a, formatter).format(formatter2);
                return a;
            } catch (final Exception e) {
                System.out.print("Error!, Enter again: ");
            }
        }
    }

    public static double input_double() {
        final Scanner input = new Scanner(System.in);
        double x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Double.parseDouble(a);
                return x;
            } catch (final Exception e) {
                System.out.print("  Wrong type, enter again: ");
            }
        }

    }

}