package vtc.ui.AccountUI;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.AccountBL;

import vtc.persistance.Account;

public class AccountFunctionUI {
    static List<Account> accountsList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static AccountBL accountBL = new AccountBL();


    public static void login()
    {
        final Scanner sc = new Scanner(System.in);
        while (true) {
            
            final AccountBL accountBL = new AccountBL();
            final AccountMenuUI accountUI = new AccountMenuUI();
            String username;
            String password;
          
            System.out.println("[LTS] PF10 - Group6");

            System.out.println("+-------------------------------------------+");
            System.out.println("|               WELLCOME                    |");
            System.out.println("+-------------------------------------------+");
            System.out.print(" [Username]: ");
            username = sc.nextLine();
            System.out.print(" [Password]: ");
            password = sc.nextLine();
            int check = accountBL.login(username, password);
            if (check == -1) {
                System.out.println(" Wrong username or password");
                System.out.printf(" Press '%s' to go back:", "Enter");
                String nh = sc.nextLine();
            } else if (check == 1) {
                accountUI.admin_main_menu(check);
            } else {
                accountUI.staff_main_menu(check);

            }

        }
    }




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

    public static void insertaccount() {
        while (true) {

            AccountBL accountBL = new AccountBL();

            if (accountBL.addAccount(inputAccount())) {
                System.out.println("Insert account complete!");
            } else {
                System.err.println("Insert account failed!");
            }

            System.out.print("Continue Insert?(y/n): ");
            String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public static Account inputAccount() {
        Account account = new Account();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       
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
            cls();
            showAccountById(id);
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
            System.out.printf("Do you want to update(y/n):");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                accountsList.add(account);
                try {
                    accountBL.Update(account);
                } catch (Exception e) {
                    System.out.println("Error. can't Update!");
                }
            } else {
                System.out.println("Update stopped !");
            }
            System.out.print("Continued(y/n): ");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static String yesno() {
        String yn = null;
        while (true) {
            yn = sc.nextLine();
            if (yn.equals("N") || yn.equals("Y") || yn.equals("n")
                    || yn.equals("y")) {
                break;
            }
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
                System.out.print("  Wrong type, enter again: ");

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
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("  Wrong type, enter again: ");
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
                System.out.print("  Wrong type, enter again: ");
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