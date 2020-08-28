package vtc;

import vtc.bl.AccountBL;
import vtc.bl.ProductBL;
import vtc.dal.OrderDAL;
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

        final Scanner sc = new Scanner(System.in);
        while (true) {
        cls();

        final AccountBL accountBL = new AccountBL();
        final AccountUI accountUI = new AccountUI();
        String username;
        String password;
        System.out.println("[LTS] PF10 - Group6");

        System.out.println("+-------------------------------------------+");
        System.out.println("|                  WELLCOME                 |");
        System.out.println("+-------------------------------------------+");
        System.out.print(" [Username]: ");
        username = nhap();
        System.out.print(" [Password]: ");
        password = nhap();
        int check = accountBL.login(username, password);
        if (check == -1) {
        System.out.println("Tai khoan hoac mat khau khong chinh xac!");
        System.out.printf("Nhan %s de tiep tuc:", "Enter");
        String nh = sc.nextLine();
        } else if (check == 1) {
        accountUI.admin_main_menu(check);
        } else {
        accountUI.staff_main_menu(check);

        }

        }


        // System.out.print("Continue(Y/N): ");
        // yn = yesno();
        // if(yn.equals( "n") ||yn.equals("N"))
        // {
        // break;
        // }

    }

    public static String yesno() {
        final Scanner sc = new Scanner(System.in);
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }

    private static String nhap() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print(" Nhap sai,moi nhap lai: ");

            } else {
                return a.trim();
            }
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

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                return x;
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }
}