package vtc.ui.AccountUI;

import java.util.List;

import vtc.bl.AccountBL;
import vtc.persistance.Account;

public class ShowAccount {
    public static void showAccount() {
        AccountBL accountBL = new AccountBL();
        List<Account> la = accountBL.getAll();

        System.out.println("\nAccount List: ");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n",
                "ID", "User Name", "Password", "First name", "Last name", "Birth day", "Phone number", "Email",
                "Position", "Start time", "Shift");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Account account : la) {
            System.out.printf(
                    "| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n",
                    account.getaccountId(), account.getusername(), account.getuserpassword(), account.getfirstname(),
                    account.getlastname(), account.getbirthday(), account.getphonenumber(), account.getemail(),
                    account.getposition(), account.getstarttime(), account.getshift());
        }
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }
    public static void showAccountById(int id) {
        AccountBL accountBL = new AccountBL();
        List<Account> la = accountBL.getById(id);
        System.out.println("\nAccount List: ");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n",
                "ID", "User Name", "Password", "First name", "Last name", "Birth day", "Phone number", "Email",
                "Position", "Start time", "Shift");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Account account : la) {
            System.out.printf(
                    "| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n",
                    account.getaccountId(), account.getusername(), account.getuserpassword(), account.getfirstname(),
                    account.getlastname(), account.getbirthday(), account.getphonenumber(), account.getemail(),
                    account.getposition(), account.getstarttime(), account.getshift());
        }
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }

}