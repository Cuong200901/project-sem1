package vtc.bl;

import vtc.persistance.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.dal.AccountDAL;
import vtc.dal.UtilDB;
public class AccountBL {
    static List<Account> accountsList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public List<Account> getAll() {
        return AccountDAL.getAll();
    }
    AccountDAL dal_account = new AccountDAL();
    public int login(String username, String password)
    {
        return dal_account.check_account(username,password);
    }

    public static void showAccount() {
        AccountBL bl_account = new AccountBL();
        List<Account> la = bl_account.getAll();
        System.out.println("\nAccount List: ");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n", "ID", "User Name", "Password",
                "First name", "Last name", "Birth day", "Phone number", "Email","Position", "Start time","Shitf");
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Account account : la) {
            System.out.printf("| %-10s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-15s | %-10s | %-15s | %-15s |\n", account.getaccountId(), account.getusername(),
                   account.getuserpassword(), account.getfirstname(), account.getlastname(), account.getbirthday(),account.getphonenumber(),account.getemail(),account.getposition(),account.getstarttime(),account.getshitf());
        }
        System.out.println(
                "+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }

  
    

    // public static Account inputAccount() {
    //     Account account = new Account();
    //     // Scanner sc = new Scanner(System.in);
    //     System.out.print("account name: ");
    //     account.setaccountName(sc.nextLine());
    //     System.out.print("Unit cost: ");
    //     Double cost = sc.nextDouble();
    //     account.setCost(cost);
    //     System.out.print("Unit discount: ");
    //     int discount = sc.nextInt();
    //     account.setDiscount(discount);
    //     System.out.print("Unit price: ");
    //     Double price = sc.nextDouble();
    //     account.setPrice(price);
    //     System.out.print("account promotion: ");
    //     account.setPromotion(sc.nextLine());
    //     System.out.print("account category: ");
    //     account.setCategory(sc.nextLine());
    //     System.out.print("accounts in stock: ");
    //     int accountsInStock = sc.nextInt();
    //     account.setaccountsInStock(accountsInStock);


    //     // sc.close();
    //     return account;
    // }

    // public static void inputInfoUpdate() {

    //     while (true) {

    //         Account account = new Account();
    //         DAL_Account PD = new DAL_Account();
    //         Scanner sc = new Scanner(System.in);
    //         System.out.print("account_id : ");
    //         int id = sc.nextInt();
    //         account.setaccountId(id);
    //         System.out.print("account name: ");
    //         account.setaccountName(sc.nextLine());
    //         System.out.print("Unit cost: ");
    //         Double cost = sc.nextDouble();
    //         account.setCost(cost);
    //         System.out.print("Unit discount: ");
    //         int discount = sc.nextInt();
    //         account.setDiscount(discount);
    //         System.out.print("Unit price: ");
    //         Double price = sc.nextDouble();
    //         account.setPrice(price);
    //         System.out.print("account promotion: ");
    //         account.setPromotion(sc.nextLine());
    //         System.out.print("account category: ");
    //         account.setCategory(sc.nextLine());
    //         System.out.print("accounts in stock: ");
    //         int accountsInStock = sc.nextInt();
    //         account.setaccountsInStock(accountsInStock);
    //         System.out.println("Do you want to update(y/n)?");
    //         String choice = yesno();
    //         if (choice.equalsIgnoreCase("y")) {
    //             accountsList.add(account);
    //             try {
    //                 PD.update(account);
    //             } catch (Exception e) {
    //                 // TODO Auto-generated catch block
    //                 e.printStackTrace();
    //             }
    //         } else {
    //             System.out.println("Error. can't Update!");
    //         }
    //         System.out.println("Continued(y/n)?");
    //         String x = yesno();
    //         if (x.equalsIgnoreCase("n")) {
    //             break;
    //         }
    //     }
    // }


    public static String yesno() {
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }
    // public static void insertaccount() {
    //     while (true) {

    //         BL_Account bl_account = new BL_Account();

    //         if (bl_account.addAccount(inputAccount())) {
    //             System.out.println("Insert account complete!");
    //         } else {
    //             System.err.println("Insert account failed!");
    //         }

    //         System.out.println("Continue Insert?(y/n)");
    //         String choice1 = yesno();
    //         if (choice1.equalsIgnoreCase("N")) {
    //             break;
    //         }

    //     }
    // }
    // public boolean addAccount(Account account) {
    //     return DAL_Account.insertaccount(account) > 0;
    // }
}