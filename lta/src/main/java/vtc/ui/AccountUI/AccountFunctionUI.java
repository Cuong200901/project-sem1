package vtc.ui.AccountUI;

import java.io.Console;
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

    public static void login() {
        final Scanner sc = new Scanner(System.in);
        while (true) {
            Console console = System.console();
            final AccountBL accountBL = new AccountBL();
            final AccountMenuUI accountUI = new AccountMenuUI();
            String username;
            String password;
            cls();
            System.out.println("[LTS] PF10 - Group6");

            System.out.println("+-------------------------------------------+");
            System.out.println("|               WELLCOME                    |");
            System.out.println("+-------------------------------------------+");
            System.out.print(" [Username]: ");
            username = sc.nextLine();
            char[] passwordArray = console.readPassword(" [Password]: ");
            password = new String(passwordArray);
            int check = accountBL.login(username, password);
            // console.printf("Password entered was: %s%n", new String(passwordArray));
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
        System.out.println("+---------------------------------------------+");
        System.out.println("|               [LTS] - Group6                |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|                 Account List:               | ");
        System.out.println("+---------------------------------------------+");
        System.out.printf("| %-5s | %-15s | %-17s |\n", "ID", "User Name", "Name");
        System.out.println("+---------------------------------------------+");
        for (Account account : la) {
            System.out.printf("| %-5s | %-15s | %-17s |\n", account.getaccountId(), account.getusername(),
                    account.getfirstname() + " " + account.getlastname());
        }
        System.out.println("+---------------------------------------------+");
    }

    public static void viewAccount() {
        boolean back = true;
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        AccountBL accountBL = new AccountBL();
        while (back) {
            cls();
           showAccount();
            System.out.print(" --> Enter id (0 to come back): ");
            int id = input_int();
            List<Account> la = accountBL.getById(id);
            if (id == 0) {
                back = false;
                break;
            } else if (la.size() == 0) {      
                System.out.printf(" Not found, Press '%s' to go back:", "Enter");
                String nh = sc.nextLine();
            } else {
              showAccountById(id);
              System.out.printf(" Press '%s' to go back:", "Enter");
              String nh = sc.nextLine();
            }
        }
    }

    public static void showAccountById(int id) {
        cls();
        AccountBL accountBL = new AccountBL();
        List<Account> la = accountBL.getById(id);
        System.out.println("+---------------------------------------------+");
        System.out.println("|               [LTS] - Group6                |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|             Account Information             |");
        System.out.println("+---------------------------------------------+");
        for (Account account : la) {
            System.out.printf("| 1. Username    :  %-25s |\n", account.getusername());
            System.out.printf("| 2. Password    :  %-25s |\n", account.getuserpassword());
            System.out.printf("| 3. First name  :  %-25s |\n", account.getfirstname());
            System.out.printf("| 4. Last Name   :  %-25s |\n", account.getlastname());
            System.out.printf("| 5. Birth day   :  %-25s |\n", account.getbirthday());
            System.out.printf("| 6. Phone number:  %-25s |\n", account.getphonenumber());
            System.out.printf("| 7. Email       :  %-25s |\n", account.getemail());
            System.out.printf("| 8. Start time  :  %-25s |\n", account.getstarttime());
        }
        System.out.println("+---------------------------------------------+");

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

    public static void showAccountNewInfor(Account account) {
        cls();

        System.out.println("+---------------------------------------------+");
        System.out.println("|               [LTS] - Group6                |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|             Account Information             |");
        System.out.println("+---------------------------------------------+");
        System.out.printf("| 1. Username    :  %-25s |\n", account.getusername());
        System.out.printf("| 2. Password    :  %-25s |\n", account.getuserpassword());
        System.out.printf("| 3. First name  :  %-25s |\n", account.getfirstname());
        System.out.printf("| 4. Last Name   :  %-25s |\n", account.getlastname());
        System.out.printf("| 5. Birth day   :  %-25s |\n", account.getbirthday());
        System.out.printf("| 6. Phone number:  %-25s |\n", account.getphonenumber());
        System.out.printf("| 7. Email       :  %-25s |\n", account.getemail());
        System.out.printf("| 8. Start time  :  %-25s |\n", account.getstarttime());

        System.out.println("+---------------------------------------------+");
    }

    public static Account inputAccount() {
        Account account = new Account();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int count = 0;
        while (true) {
            account.setposition("Staff");
            while (true) {
                showAccountNewInfor(account);
                System.out.print("Username (6-10 characters): ");
                String username = username_password();
                System.out.print("Insert(y/n): ");
                String choice1 = yesno();
                if (choice1.equalsIgnoreCase("N")) {
                    System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    }
                    
                } else {
                    account.setusername(username);
                    count = 1;
                    break;
                }
            }
            if (count == 1) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("Password (6-10 characters): ");
                    String password = username_password();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setpassword(password);
                        count = 2;
                        break;
                    }
                }
            }

            if (count == 2) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("First name: ");
                    String fn = input_string();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setfirstname(fn);
                        count = 3;
                        break;
                    }
                }
            }
            if (count == 3) {
                while (true) {
                    showAccountNewInfor(account);

                    System.out.print("Last name: ");
                    String ln = input_string();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setlastname(ln);
                        count = 4;
                        break;
                    }
                }
            }
            if (count == 4) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("Birth day(dd-MM-yyy): ");
                    String date = input_date();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setbirthday(date);
                        count = 5;
                        break;
                    }
                }
            }
            if (count == 5) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("Phone number: ");
                    int phone = input_int();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setphonenumber(phone);
                        count = 6;
                        break;
                    }
                }
            }
            if (count == 6) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("Email: ");
                    String email = input_string();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                    };
                    } else {
                        account.setemail(email);
                        count = 7;
                        break;
                    }
                }
            }
            if (count == 7) {
                while (true) {
                    showAccountNewInfor(account);
                    System.out.print("Start time(dd-MM-yyy): ");
                    String time = input_date();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return account = new Account();
                        
                    };
                    } else {
                        account.setstarttime(time);
                        count = 8;
                        break;
                    }
                }
            }
            if (count == 8) {
                showAccountNewInfor(account);
                System.out.print("Insert staff(y/n): ");
                String choice1 = yesno();
                if (choice1.equalsIgnoreCase("N")) {
                    return account = new Account();
                }
                else
                {
                    return account;
                }
            }
           
            
        }
        

    }

    public static void inputInfoUpdate() {
        boolean back = true;
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        AccountBL accountBL = new AccountBL();
        while (back) {
            cls();
           showAccount();

            System.out.print(" --> Enter id (0 to come back): ");
            int id = input_int();
            List<Account> la = accountBL.getById(id);
            if (id == 0) {
                back = false;
                break;
            } else if (la.size() == 0) {      
                System.out.printf(" Not found, Press '%s' to go back:", "Enter");
                String nh = sc.nextLine();
            } else {
               inputInfoUpdateById(id);
              

            }
        }

    }

    public static void inputInfoUpdateById(int id) {

        Account account = new Account();
        account.setAccountId(id);
        AccountBL accountBL = new AccountBL();
        List<Account> la = accountBL.getById(id);
        for (Account account1 : la) {
            account.setusername(account1.getusername());
            account.setpassword(account1.getuserpassword());
            account.setfirstname(account1.getfirstname());
            account.setlastname(account1.getlastname());
            account.setbirthday(account1.getbirthday());
            account.setphonenumber(account1.getphonenumber());
            account.setemail(account1.getemail());
            account.setstarttime(account1.getstarttime());
            account.setposition(account1.getposition());
        }
        boolean back = true;
        while (back) {
            Scanner sc = new Scanner(System.in);
            showAccountNewInfor(account);
            System.out.println("|      0: Come back  ||  (OK/ok): Update      |");
            System.out.println("+---------------------------------------------+");
            System.out.print(" --> Enter your choice: ");
            String chose = sc.nextLine();
            switch (chose) {
                case "0":
                    back = false;
                    break;
                case "ok":
                    System.out.printf(" Do you want to update(y/n): ");
                    String choice = yesno();
                    if (choice.equalsIgnoreCase("y")) {
                        try {
                            accountBL.Update(account);
                            System.out.printf(" Press '%s' to go back:", "Enter");
                            String nh = sc.nextLine();
                            back = false;
                            break;
                        } catch (Exception e) {
                            System.err.println(" Insert account failed!");
                        }
                    } else {
                        System.out.println(" Update stopped !");
                        System.out.printf(" Press '%s' to go back:", "Enter");
                        String nh = sc.nextLine();
                        back = false;
                        break;
                    }
                case "OK":
                    System.out.printf(" Do you want to update(y/n):");
                    choice = yesno();
                    if (choice.equalsIgnoreCase("y")) {
                        try {
                            accountBL.Update(account);
                            System.out.printf(" Press '%s' to go back:", "Enter");
                            String nh = sc.nextLine();
                            back = false;
                            break;
                        } catch (Exception e) {
                            System.err.println(" Insert account failed!");
                        }
                    } else {
                        System.out.println(" Update stopped !");
                        System.out.printf(" Press '%s' to go back:", "Enter");
                        String nh = sc.nextLine();
                        back = false;
                        break;
                    }
                case "2":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print(" Password (6-10 characters): ");
                        String password = username_password();
                        System.out.print(" Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            account.setpassword(password);
                            break;
                        }
                    }
                    break;
                case "3":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("First name: ");
                        String fn = input_string();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            account.setfirstname(fn);

                            break;
                        }
                    }
                    break;
                case "4":
                    while (true) {
                        showAccountNewInfor(account);

                        System.out.print("Last name: ");
                        String ln = input_string();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            account.setlastname(ln);

                            break;
                        }
                    }
                    break;
                case "5":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("Birth day(dd-MM-yyy): ");
                        String date = input_date();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            account.setbirthday(date);

                            break;
                        }
                    }
                    break;
                case "6":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("Phone number: ");
                        int phone = input_int();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            account.setphonenumber(phone);
                            break;
                        }
                    }
                    break;
                case "7":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("Email: ");
                        String email = input_string();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {

                            break;

                        } else {
                            account.setemail(email);

                            break;
                        }
                    }
                    break;
                case "8":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("Start time(dd-MM-yyy): ");
                        String time = input_date();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {

                            break;

                        } else {
                            account.setstarttime(time);
                            break;
                        }
                    }
                    break;
                case "1":
                    while (true) {
                        showAccountNewInfor(account);
                        System.out.print("Password (6-10 characters): ");
                        String password = username_password();
                        System.out.print("Insert(y/n): ");
                        String choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {

                            break;

                        } else {
                            account.setpassword(password);

                            break;
                        }
                    }
                    break;
                default:
                    System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
            }

        }

    }

    public static String yesno() {
        final Scanner sc = new Scanner(System.in);
        String yn = null;
        while (true) {
            yn = sc.nextLine();
            if (yn.equals("N") || yn.equals("Y") || yn.equals("n") || yn.equals("y")) {
                break;
            } else {
                System.out.print("  Wrong type, enter again: ");
            }
        }

        return yn;
    }

    public static String username_password() {
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
            if (a.trim().compareTo("") == 0 || a.length()>30) {
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
                if (x >= 0) {
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
                if (x >= 0) {
                    return x;}
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