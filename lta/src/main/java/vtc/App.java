package vtc;

import java.io.IOException;

import vtc.ui.AccountUI.AccountFunctionUI;



public class App {

    public static void main(String[] args) {
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

}