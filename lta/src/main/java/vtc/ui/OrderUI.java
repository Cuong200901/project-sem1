package vtc.ui;

import java.io.IOException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.ScalarOrBuilder;

public class OrderUI {
    Scanner sc = new Scanner(System.in);

    public void financial_management_menu() {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("[LTS] PF10 - Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|            Financial management           |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Order amount by month             |");
            System.out.println("|      2. Money earner by month             |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();

                    break;
                case "2":
                    cls();

                    break;

                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    String nh = sc.nextLine();
            }
        }
    }

    public void manage_order_menu(int id) {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("[LTS] PF10 - Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|                Manage order               |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Create order                      |");
            System.out.println("|      2. Update order                      |");
            System.out.println("|      3. Complete order                    |");
            System.out.println("|      4. View order                        |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    break;
                case "2":
                    cls();

                    break;

                case "3":
                    cls();

                    break;
                case "4":
                    cls();

                    break;
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    String nh = sc.nextLine();
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
}