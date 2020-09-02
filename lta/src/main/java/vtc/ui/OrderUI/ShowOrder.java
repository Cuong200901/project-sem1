package vtc.ui.OrderUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.AccountBL;
import vtc.bl.OrderBL;
import vtc.bl.ProductBL;
import vtc.dal.OrderDAL;
import vtc.persistance.*;

public class ShowOrder {

    static Scanner sc = new Scanner(System.in);
    static AccountBL accountBL = new AccountBL();
    static ProductBL productBL = new ProductBL();
    static OrderBL orderBL = new OrderBL();
    static OrderDetails orderDetails = new OrderDetails();
    static List<Account> accountsList = new ArrayList<>();
    static List<Product> productsList = new ArrayList<>();

    static List<OrderDetails> orderdetailssList = new ArrayList<>();

    public static void orderByMonth() {
        while (true) {
            int year = 0;
            System.out.print("Enter year: ");
            year = sc.nextInt();
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
        id = sc.nextInt();
        final List<Order> orderList = orderBL.getBill(id);

        final List<OrderDetails> orderDetailsList = orderBL.getBillDetails(id);

        for (Order order : orderList) {
            table = order.getTable();
            time = order.getTime();
            final List<Account> accountsList = accountBL.getById(order.getAccountId());
            for (Account account : accountsList) {
                staff = account.getfirstname().concat(" ").concat(account.getlastname());
                System.out.println(staff);
            }
        }
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                             Lemon tee shop                              |");
        System.out.println("|                                                                         |");
        System.out.printf("|   Staff name: %-15sTime: %-17s   Table: %-8s|\n", staff, time, table);
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                                                         |");
        System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", "Product name", "Price on unit", "Amount",
                "Total money");
        for (OrderDetails orderDetails : orderDetailsList) {
            List<Product> productsList = productBL.getAllById(orderDetails.getproductId());
            for (Product product : productsList) {
                productsName = product.getProductName();
                price = product.getPrice();
            }

            System.out.println("|                                |               |         |              |");
            // System.out.println("| |");
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
        a = sc.nextLine();
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            a = LocalDate.parse(a, formatter).format(formatter2);

        } catch (final Exception e) {
            System.out.printf("Nhan %s de quay lai:", "Enter");
            final String nh = sc.nextLine();

        }
        final OrderBL orderBL = new OrderBL();
        final List<Order> lo = orderBL.getOrderByDay(a);
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
                    System.out.printf("| %-10s | %-15s |\n", i, orderBL.monneyEarnByMonth(year, i));
                    System.out.println("+------------------------------+");
                }

            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showTableClear() {
        OrderDAL.showTableClear();
    }

    public static void showTableExit() {
        OrderDAL.showTableExsit();
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
                    System.out.print("  Nhap sai,moi nhap lai: ");
                }
            } catch (final Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }

}