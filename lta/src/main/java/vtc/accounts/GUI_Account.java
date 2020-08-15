package vtc.accounts;

public class GUI_Account {
    public void admin_main_menu() {
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
        System.out.println("");

    }

    public void staff_main_menu() {
        System.out.println("+-------------------------------------------+");
        System.out.println("|              Well come Staff              |");
        System.out.println("+-------------------------------------------+");
        System.out.println("|      1.Manage membership and profile      |");
        System.out.println("|      2.Manage order                       |");
        System.out.println("|      3.Logout                             |");
        System.out.println("|      0.Exit                               |");
        System.out.println("+-------------------------------------------+");
        System.out.print("   --> Enter your choice:");
        System.out.println("");

    }
}
