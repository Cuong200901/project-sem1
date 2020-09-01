package vtc.ui.AccountUI;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.AccountBL;
import vtc.bl.ProductBL;
import vtc.dal.AccountDAL;
import vtc.persistance.Account;

public class InputAccount {
    static List<Account> accountsList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
static AccountBL accountBL = new AccountBL();
    public static void insertaccount() {
        while (true) {

            AccountBL accountBL = new AccountBL();

            if (accountBL.addAccount(inputAccount())) {
                System.out.println("Insert account complete!");
            } else {
                System.err.println("Insert account failed!");
            }

            System.out.println("Continue Insert?(y/n)");
            String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public static Account inputAccount() {
        Account account = new Account();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        // Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        account.setusername(password_value());
        System.out.print("Password: ");
        account.setpassword(password_value());
        System.out.print("First name: ");
        account.setfirstname(input_string());
        System.out.print("Last name: ");
        account.setlastname(input_string());
        System.out.print("Birth day: ");
        account.setbirthday(input_date());
        System.out.print("Phone number: ");
        account.setphonenumber(input_int());
        System.out.print("Email: ");
        account.setemail(input_string());
        account.setposition("Staff");
        account.setstarttime("");
        System.out.print("Shift: ");
        account.setshift(input_string());
       
        return account;
    }

    public static void inputInfoUpdate() {

        while (true) {
            Account account = new Account();
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Account ID : ");
            account.setAccountId(input_int());
            System.out.print("Username: ");
            account.setusername(password_value());
            System.out.print("Password: ");
            account.setpassword(password_value());
            System.out.print("First name: ");
            account.setfirstname(input_string());
            System.out.print("Last name: ");
            account.setlastname(input_string());
            System.out.print("Birth day: ");
            account.setbirthday(input_date());
            System.out.print("Phone number: ");
            account.setphonenumber(input_int());
            System.out.print("Email: ");
            account.setemail(input_string());
            account.setposition("Staff");
            System.out.print("Start time: ");
            account.setstarttime(input_date());
            System.out.print("Shift: ");
            account.setshift(input_string());
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                accountsList.add(account);
                try {
                    accountBL.Update(account);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error. can't Update!");
            }
            System.out.println("Continued(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }


    public static void inputInfoUpdateById(int id) {

        while (true) {
            Account account = new Account();
          
            Scanner sc = new Scanner(System.in);
            account.setAccountId(id);
            System.out.print("Username: ");
            account.setusername(password_value());
            System.out.print("Password: ");
            account.setpassword(password_value());
            System.out.print("First name: ");
            account.setfirstname(input_string());
            System.out.print("Last name: ");
            account.setlastname(input_string());
            System.out.print("Birth day: ");
            account.setbirthday(input_date());
            System.out.print("Phone number: ");
            account.setphonenumber(input_int());
            System.out.print("Email: ");
            account.setemail(input_string());
            if (id != 1) {
                account.setposition("Staff");
            } else {
                account.setposition("Admin");
            }
            System.out.print("Start time: ");
            account.setstarttime(input_date());
            System.out.print("Shift: ");
            account.setshift(input_string());
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                accountsList.add(account);
                try {
                    accountBL.Update(account);
                } catch (Exception e) {
                
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error. can't Update!");
            }
            System.out.println("Continued(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static String yesno() {
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }



    public static String password_value() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();

            if (a.length() < 6 || a.length() > 10 || a.trim().compareTo(a) != 0 || a.toLowerCase() != a
                    || a.matches("\\w+") == false) {
                System.out.print("  Nhap sai,moi nhap lai: ");

            } else {
                return a;
            }
        }
    }

    public static String input_string() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Nhap sai,moi nhap lai: ");

            } else {
                return a.trim();
            }
        }

    }

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                if (x > 0) {
                    return x;
                }
                else{
                    System.out.print("  Nhap sai,moi nhap lai: ");
                }
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }

    public static String input_date() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                a = LocalDate.parse(a, formatter).format(formatter2);
                return a;
            } catch (Exception e) {
                System.out.print("Error!, Enter again: ");
            }
        }
    }


    public static double input_double() {
        final Scanner input = new Scanner(System.in);
        double x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Double.parseDouble(a);
                return x;
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }


}