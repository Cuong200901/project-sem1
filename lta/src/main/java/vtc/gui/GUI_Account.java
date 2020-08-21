package vtc.gui;



import java.io.IOException;
import java.util.Scanner;

public class GUI_Account {
    Scanner sc = new Scanner(System.in);
    GUI_Products gui_products = new GUI_Products();
    public void admin_main_menu()
    {
        boolean back = true;
            while (back) {
                cls();
                System.out.println("[LTS] PF10-Group6");
                System.out.println("+-------------------------------------------+");
                System.out.println("|              Well come Admin              |");
                System.out.println("+-------------------------------------------+");
                System.out.println("|      1.Manage membership and profile      |");
                System.out.println("|      2.Manage staff                       |");
                System.out.println("|      3.Manage products                    |");
                System.out.println("|      4.Financial management               |");
                System.out.println("|      5.Logout                             |");
                System.out.println("|      0.Exit                               |");
                System.out.println("+-------------------------------------------+");
                System.out.print("   --> Enter your choice:");
                String chose = sc.nextLine();
                switch (chose) {
                    case "3":
                        cls();
                        gui_products.admin_products_menu();
                        break;
                    case "5":
                        back = false;
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                        String nh = sc.nextLine();
                }
            }
    }
    public void staff_main_menu()
    {
        cls();
        System.out.println("[LTS] PF10-Group6");
        System.out.println("+-------------------------------------------+");
        System.out.println("|              Well come Staff              |");
        System.out.println("+-------------------------------------------+");
        System.out.println("|      1.Manage membership and profile      |");
        System.out.println("|      2.Manage order                       |");
        System.out.println("|      3.Logout                             |");
        System.out.println("|      0.Exit                               |");
        System.out.println("+-------------------------------------------+");
        System.out.print("   --> Enter your choice:");


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

