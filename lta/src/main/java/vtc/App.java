package vtc;


import vtc.ui.AccountUI.AccountFunctionUI;

import java.io.IOException;

import java.sql.*;

public class App {

    public static void main(final String[] args) throws SQLException {

        cls();
           String strconn =
        "jdbc:mysql://localhost:3306/lemon_tee_shop?user=root&password=cuong2001";
        try ( Connection conn = DriverManager.getConnection(strconn);)
        {
        System.out.println("Connected to MySql Server.");
        } catch (SQLException ex) {
        System.out.println("Connection Error!");
        System.out.println(ex);
        }
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

}