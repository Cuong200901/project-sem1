package vtc;

import vtc.bl.AccountBL;
import vtc.ui.EraserThread;
import vtc.ui.AccountUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
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
            final AccountBL bl_account = new AccountBL();
            final AccountUI ui_account = new AccountUI();
            String username;
            String password;
            System.out.println("[LTS] PF10-Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|                WELLCOME                   |");
            System.out.println("+-------------------------------------------+");
            System.out.print("      [Username]: ");
            username = nhap();
            System.out.print("      [Password]: ");
            password = nhap();
            int check = bl_account.login(username, password);
            if (check == -1) {
                System.out.println("Tai khoan hoac mat khau khong chinh xac!");
                System.out.printf("Nhan %s de tiep tuc:", "Enter");
                String nh = sc.nextLine();
            } else if (check == 1) {
                ui_account.admin_main_menu(check);
            } else {
                ui_account.staff_main_menu(check);
                
            }

        }
    }

  

    private static String nhap() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Nhap sai,moi nhap lai: ");
             
            } else {
                break;
            }
        }
        return a.trim();
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
}