package vtc.ui.AccountUI;

import java.io.IOException;
import java.util.Scanner;


import vtc.ui.OrderUI.OrderMenuUI;
import vtc.ui.ProductsUI.ProductsMenuUI;

public class AccountMenuUI {
    Scanner sc = new Scanner(System.in);
    ProductsMenuUI productsUI = new ProductsMenuUI();
OrderMenuUI orderUI = new OrderMenuUI();
    public void admin_main_menu(int id) {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("+-------------------------------------------+");
            System.out.println("|               [LTS] - Group6              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|               Wellcome Admin              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Manage membership and profile     |");
            System.out.println("|      2. Manage staff                      |");
            System.out.println("|      3. Manage products                   |");
            System.out.println("|      4. Financial management              |");
            System.out.println("|      5. Logout                            |");
            System.out.println("|      0. Exit                              |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice: ");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                cls(); 
                AccountFunctionUI.inputInfoUpdateById(id);
                break;
                case "2":
                    cls();
                manage_staff_menu();
                    break;
                case "3":
                    cls();
                    productsUI.admin_products_menu();
                    break;
                    case "4":
                    cls();
                    orderUI.financial_management_menu();
                    break;
                case "5":
                    back = false;
                    break;
                case "0":
                    System.exit(0);
                default:
                System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
            }
        }
    }

    public void staff_main_menu(int id) {
        boolean back = true;
        while (back) {
            cls();
        
            System.out.println("+-------------------------------------------+");
            System.out.println("|               [LTS] - Group6              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|               Wellcome Staff              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Manage membership and profile     |");
            System.out.println("|      2. Manage order                      |");
            System.out.println("|      3. Logout                            |");
            System.out.println("|      0. Exit                              |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                cls();
              
                AccountFunctionUI.inputInfoUpdateById(id);
                break;
                case "2":
                cls();
                orderUI.manage_order_menu(id);
                break;
                case "3":
                    back = false;
                    break;
                case "0":
                    System.exit(0);
                default:
                System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
            }
        }

    }

    public void manage_staff_menu() {
        boolean back = true;
        String chose;
        while (back) {
            cls();
            System.out.println("+-------------------------------------------+");
            System.out.println("|               [LTS] - Group6              |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|               Manage staff                |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Add new staff                     |");
            System.out.println("|      2. Update staff                      |");
            System.out.println("|      3. View all staff                    |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            chose = sc.nextLine();
            switch (chose) {
                case "1":
                cls();
                AccountFunctionUI.insertaccount();;
                    break;  
                case "2":
                cls();
                
                AccountFunctionUI.inputInfoUpdate();
                    break;
                case "0":
                    back = false;
                    break;
                case "3":
                cls();
                AccountFunctionUI.viewAccount();
                    break;
                default:
                System.out.printf("Wrong, Press '%s' to go back:", "Enter");
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
