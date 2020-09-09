package vtc.ui.OrderUI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import vtc.bl.AccountBL;
import vtc.bl.OrderBL;
import vtc.bl.ProductBL;
import vtc.dal.OrderDAL;
import vtc.persistance.Account;
import vtc.persistance.Order;
import vtc.persistance.OrderDetails;
import vtc.persistance.Product;
import vtc.ui.ProductsUI.ProductFunctionUI;


public class OrderFunctionUI {

    static Scanner sc = new Scanner(System.in);
    static AccountBL accountBL = new AccountBL();
    static ProductBL productBL = new ProductBL();
    static OrderBL orderBL = new OrderBL();
    static OrderDetails orderDetails = new OrderDetails();
    static List<Account> accountsList = new ArrayList<>();
    static List<Product> productsList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();
    static List<OrderDetails> orderdetailssList = new ArrayList<>();

    public static void completeOrder() {
        System.out.print("Enter table: ");
        final int table = input_int();
        int count = OrderBL.completeOrder(table);
        if (count== 2)
        {
            System.out.println("Complete!");
        }
        else if (count == 0)
        {
            System.out.println("Error!");
        }
        else {
            System.out.println("Wrong table!");
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
                    System.out.printf("Wrong type, Press '%s' to go back:", "Enter");
                }
            } catch (final Exception e) {
                System.out.printf("Wrong type, Press '%s' to go back:", "Enter");
            
            }
        }

    }

    public static void orderByMonth() {
        while (true) {
            int year = 0;
            System.out.print("Enter year: ");
            year = input_int();
            if (year >= 1990 && year <= 2050) {
                System.out.println("+------------------------------+");
                System.out.println("|             " + year + "             |");
                System.out.println("+------------------------------+");
                System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
                System.out.println("+------------------------------+");
                for (int i = 1; i <= 12; i++) {
                    final List<Order> orderList = orderBL.getOrderByMonth(year, i);
                    System.out.printf("| %-10s | %-15s |\n", i, orderList.size());
                    System.out.println("+------------------------------+");
                }
                break;

            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showBill() {
        int id = 0;
        String staff = null;
        String time = null;
        int table = 0;
        double total = 0;
        double totalBill = 0;
        double price = 0;
        String productsName = null;
        System.out.print("Enter Order Id: ");
        id = input_int();
        final List<Order> orderList = orderBL.getBill(id);

        final List<OrderDetails> orderDetailsList = orderBL.getBillDetails(id);

        for (final Order order : orderList) {
            table = order.getTable();
            time = order.getTime();
            final List<Account> accountsList = accountBL.getById(order.getAccountId());
            for (final Account account : accountsList) {
                staff = account.getfirstname().concat(" ").concat(account.getlastname());
                System.out.println(staff);
            }
        }
        cls();
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                             Lemon tee shop                              |");
        System.out.println("|                                                                         |");
        System.out.printf("|   Staff name: %-15sTime: %-17s   Table: %-8s|\n", staff, time, table);
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                                                         |");
        System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", "Product name", "Price on unit", "Amount",
                "Total money");
        for (final OrderDetails orderDetails : orderDetailsList) {
            final List<Product> productsList = productBL.getAllById(orderDetails.getproductId());
            for (final Product product : productsList) {
                productsName = product.getProductName();
                price = product.getPrice();
            }

            System.out.println("|                                |               |         |              |");
          
            System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", productsName, price, orderDetails.getamount(),
                    total = price * orderDetails.getamount());
            totalBill = totalBill + total;
        }
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                                                         |");
        System.out.printf("| Total bill: %-60s|\n", totalBill);
        System.out.println("|                                                                         |");
        System.out.println("+-------------------------------------------------------------------------+");

    }

    public static void showOrderByDay() {
        System.out.print("Enter day: ");
        final Scanner sc = new Scanner(System.in);
        String a;
        a = input_date();
        final List<Order> lo = OrderBL.getOrderByDay(a);
        System.out.println("\nOrder List: ");
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n", "Id", "Time", "Account Id", "note",
                "Table id");
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        for (final Order order : lo) {
            System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n", order.getOrderId(), order.getTime(),
                    order.getAccountId(), order.getNote(), order.getTable());
        }
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
    }

    public static void monneyEarnerByMonth() {
        while (true) {
            int year = 0;
            System.out.print("Enter year: ");
            year = input_int();
            if (year >= 1990 && year <= 2050) {
                System.out.println("+---------------- -------------+");
                System.out.println("|             " + year + "             |");
                System.out.println("+------------------------------+");
                System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
                System.out.println("+------------------------------+");
                for (int i = 1; i <= 12; i++) {
                    System.out.printf("| %-10s | %-15s |\n", i, OrderBL.monneyEarnByMonth(year, i));
                    System.out.println("+------------------------------+");
                }
break;
            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showTableClear() {
        OrderDAL.showTableClear();
    }

    public static void showTableExit() {
        OrderDAL.showTableExist();
    }

    public static Order inputOrder(final int staffid) {
        final Order order = new Order();
        order.setTime("" + java.time.LocalDateTime.now() + "");
        order.setAccountId(staffid);
        System.out.print("Enter table : ");
        order.setTable(input_int());
        System.out.print("Enter note : ");
        order.setNote(input_string());
        return order;

    }

    public static OrderDetails inputOrderDetails(final int orderid) {
        final OrderDetails orderDetails = new OrderDetails();
        System.out.print("Enter ProductId : ");
        orderDetails.setproductId(input_int());
        System.out.print("Enter amount : ");
        orderDetails.setamount(input_int());
        orderDetails.setOrderId(orderid);
        return orderDetails;

    }

    public static void createOrder(final int id) {
        final Order order = new Order();
        order.setTime("" + java.time.LocalDateTime.now() + "");
        order.setAccountId(id);
        System.out.print("Enter table : ");
        order.setTable(input_int());
        System.out.print("Enter note : ");
        order.setNote(input_string());
        final int Count = OrderBL.createOrder(order);
        if (Count == 3) {
            while (true) {
                ProductFunctionUI.showProduct();
                final OrderDetails orderDetails = new OrderDetails();
                System.out.print("Enter ProductId : ");
                orderDetails.setproductId(input_int());
                System.out.print("Enter amount : ");
                orderDetails.setamount(input_int());
                orderDetails.setOrderId(0);
                final int count = OrderBL.productsInOrder(orderDetails);
                if (count == 3) {
                    System.out.println("Insert account complete!");
                } else if (count == -1) {
                    System.out.println("The product is out of stock!");

                } else if (count == -2) {
                    System.out.println("Insufficient quantity of products!");
                } else {
                    System.out.println("Insert account failed!");
                }
                System.out.print("Continue Insert(y/n): ");
                final String choice1 = yesno();
                if (choice1.equals("n") || choice1.equals("N")) {
                    break;
                }
            }
        } else if (Count == 2) {
            System.err.println("Table Exist!");
            System.out.printf(" Press '%s' to go back:", "Enter");
            final String nh = sc.nextLine();
        } else {
            System.err.println("Error");
            System.out.printf(" Press '%s' to go back:", "Enter");
            final String nh = sc.nextLine();
        }

    }

    public static void updateOrder() {
        System.out.print("Enter table: ");
        final int table = input_int();
        final int Count = OrderBL.updateOrder(table);
        System.out.println(Count);
        if (Count == 0) {
            System.out.println("Table clear!");
            System.err.println("Error");
            System.out.printf(" Press '%s' to go back:", "Enter");
            final String nh = sc.nextLine();
        } else if (Count == -1) {
            System.out.println("Wrong table!");
            System.err.println("Error");
            System.out.printf(" Press '%s' to go back:", "Enter");
            final String nh = sc.nextLine();
        } else {
            while (true) {
                ProductFunctionUI.showProduct();
                final OrderDetails orderDetails = new OrderDetails();
                System.out.print("Enter ProductId : ");
                orderDetails.setproductId(input_int());
                System.out.print("Enter amount : ");
                orderDetails.setamount(input_int());
                orderDetails.setOrderId(OrderBL.tableOrderExist(table));
                final int count = OrderBL.productsInOrderUpdate(orderDetails);
                if (count == 3) {
                    System.out.println("Insert account complete!");
                } else if (count == -1) {
                    System.out.println("The product is out of stock!");

                } else if (count == -2) {
                    System.out.println("Insufficient quantity of products!");
                } else {
                    System.out.println("Insert account failed!");
                }
                System.out.print("Continue Insert(y/n): ");
                final String choice1 = yesno();
                if (choice1.equals("n") || choice1.equals("N")) {
                    break;
                }
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

    public static String input_date() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            try {
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                a = LocalDate.parse(a, formatter).format(formatter2);
                return a;
            } catch (final Exception e) {
                System.out.print("Error!, Enter again: ");
            }
        }
    }

    public static String input_string() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.printf(" Press '%s' to go back:", "Enter");

            } else {
                return a.trim();
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