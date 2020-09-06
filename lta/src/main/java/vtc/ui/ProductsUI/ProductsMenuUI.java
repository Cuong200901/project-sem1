package vtc.ui.ProductsUI;


import java.io.IOException;

import java.util.Scanner;

public class ProductsMenuUI {
    Scanner sc = new Scanner(System.in);
    String nh = null;

    public void admin_products_menu() {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("[LTS] PF10 - Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|              Products manage              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Add product                       |");
            System.out.println("|      2. Update products                   |");
            System.out.println("|      3. Update products in stock          |");
            System.out.println("|      4. View products                     |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    ProductFunctionUI.insertProduct();
                    break;
                case "2":
                    cls();
                    ProductFunctionUI.showProduct();
                    ProductFunctionUI.inputInfoUpdate();
                    break;
                case "3":
                    cls();
                    ProductFunctionUI.showProduct();
                    ProductFunctionUI.inputProductsInStock();
                    break;
                case "4":
                    cls();
                    ProductFunctionUI.showProduct();
                    System.out.printf("Nhan %s de quay lai:", "Enter");
                    nh = sc.nextLine();
                    break;
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    nh = sc.nextLine();
            }
        }
    }

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
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    nh = sc.nextLine();
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
