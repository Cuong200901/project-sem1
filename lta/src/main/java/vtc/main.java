package vtc;

import vtc.bl.AccountBL;

import vtc.ui.AccountUI.AccountMenuUI;



import java.io.IOException;

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
            final AccountBL accountBL = new AccountBL();
            final AccountMenuUI accountUI = new AccountMenuUI();
            String username;
            String password;
            System.out.println("[LTS] PF10 - Group6");

            System.out.println("+-------------------------------------------+");
            System.out.println("|               WELLCOME                    |");
            System.out.println("+-------------------------------------------+");
            System.out.print(" [Username]: ");
            username = sc.nextLine();
            System.out.print(" [Password]: ");
            password = sc.nextLine();
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

    }

    // private static String nhap() {
    //     final Scanner input = new Scanner(System.in);
    //     String a;
    //     while (true) {
    //         a = input.nextLine();
    //         if (a.trim().compareTo("") == 0) {
    //             System.out.print(" Nhap sai,moi nhap lai: ");

    //         } else {
    //             return a.trim();
    //         }
    //     }

    // }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }

}