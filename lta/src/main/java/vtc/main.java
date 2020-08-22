package vtc;

import vtc.bl.BL_Account;

import vtc.gui.EraserThread;
import vtc.gui.GUI_Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        // String  strconn = "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
        // try (  Connection  conn = DriverManager.getConnection(strconn);)
        //      {
        //     System.out.println("Connected to MySql Server.");
        // } catch (SQLException ex) {
        //     System.out.println("Connection Error!");
        //     System.out.println(ex);
        // }
        Scanner sc = new Scanner(System.in);
        while (true) {
            cls();
            BL_Account bl_account = new BL_Account();
            GUI_Account gui_account = new GUI_Account();
            String username;
            String password;
            System.out.println("[LTS] PF10-Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|                WELL COME                  |");
            System.out.println("+-------------------------------------------+");
            System.out.print("      *Username*");
            username = nhap();
            System.out.print("      *Password*");
            password = nhap();

            String check = bl_account.login(username, password);
            if (check == null) {
                System.out.println("Tai khoan hoac mat khau khong chinh xac!");
                System.out.printf("Nhan %s de tiep tuc:", "Enter");
                String nh = sc.nextLine();
            } else {
                if (check.equals("Admin")) {
                    gui_account.admin_main_menu();
                } else if (check.equals("Staff")) {
                    gui_account.staff_main_menu();
                }


            }
        }
    }

    private static String nhap() {
        Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.println("Nhap sai,moi nhap lai! ");
                System.out.print("#Chon: ");
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
    public static String readPassword (String prompt) {
        EraserThread et = new EraserThread(prompt);
        Thread mask = new Thread(et);
        mask.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try {
            password = in.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        // stop masking
        et.stopMasking();
        // return the password entered by the user
        return password;
    }
}