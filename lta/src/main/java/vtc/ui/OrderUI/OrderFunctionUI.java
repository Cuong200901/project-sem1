package vtc.ui.OrderUI;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.AccountBL;
import vtc.bl.OrderBL;
import vtc.bl.ProductBL;

import vtc.persistance.Account;
import vtc.persistance.Order;
import vtc.persistance.OrderDetails;
import vtc.persistance.Product;


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
            cls();
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
                    int orderList = orderBL.getOrderByMonth(year, i);
                    System.out.printf("| %-10s | %-15s |\n", i, orderList);
                    System.out.println("+------------------------------+");
                }
                break;

            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showBill(int id) {

        String staff = null;
        String time = null;
        int cardnumber = 0;

        String totalBill = null;

        String productsName = null;

        final List<Order> orderList = OrderBL.getBill(id);

        final List<OrderDetails> orderDetailsList = OrderBL.getBillDetails(id);

        for (final Order order : orderList) {
            final DecimalFormat df = new DecimalFormat("#");
            totalBill = df.format(order.gettotalBill());
            time = order.getTime();
            cardnumber = order.getcardNumber();
            final List<Account> accountsList = accountBL.getById(order.getAccountId());
            for (final Account account : accountsList) {
                staff = account.getfirstname().concat(" ").concat(account.getlastname());
                System.out.println(staff);
            }
        }
        cls();
        String price = null;
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                             Lemon tee shop                              |");
        System.out.println("|                                                                         |");
        System.out.printf("|  Staff name: %-14sTime: %-17s  Card number: %-5s|\n", staff, time, cardnumber);
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                                                         |");
        System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", "Product name", "Price on unit", "Amount",
                "Total money");
        for (final OrderDetails orderDetails : orderDetailsList) {
            final List<Product> productsList = ProductBL.getAllById(orderDetails.getproductId());
            for (final Product product : productsList) {
                productsName = product.getProductName();
                final DecimalFormat df = new DecimalFormat("#");
                price = df.format(product.getPrice());
            }
            final DecimalFormat df = new DecimalFormat("#");
            String total = df.format(orderDetails.getmoney());
        

            System.out.println("|                                |               |         |              |");

            System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", productsName, price + "(VND)",
                    orderDetails.getamount(), total + "(VND)");

        }
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                                                                         |");
        System.out.printf("| Total bill: %-60s|\n", totalBill + "(VND)");
        System.out.println("|                                                                         |");
        System.out.println("+-------------------------------------------------------------------------+");

    }

    public static void showOrder() {
        while (true) {
            cls();
            System.out.print("Enter day(dd-MM-yyy) || Enter '0' to comeback : ");
            final Scanner sc = new Scanner(System.in);
            List<Order> lo = new ArrayList<Order>();
            String a;
            while (true) {
                a = sc.nextLine();
                if (a.equals("0")) {
                    break;
                } else {
                    try {
                        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        a = LocalDate.parse(a, formatter).format(formatter2);
                        lo = OrderBL.getOrderByDay(a);
                        break;
                    } catch (final Exception e) {
                        System.out.print("Error!, Enter again: ");
                    }
                }
            }
            if (a.equals("0")) {
                break;
            } else if (lo.size() == 0) {
                cls();
                System.out.println(" There are no order on that day!");
                System.out.printf(" Press '%s' to go back:", "Enter");
                String nh = sc.nextLine();

            } else {
                while (true) {
                    cls();
                    System.out.println("\nOrder List: ");
                    System.out.println("+-------------------------------------------------------------------------+");
                    System.out.printf("| %-10s | %-20s | %-20s | %-12s |\n", "Id", "Time", "Total bill(VND)",
                            "Card number");
                    System.out.println("+-------------------------------------------------------------------------+");
                    for (final Order order : lo) {
                        final DecimalFormat df = new DecimalFormat("#");
                        String total = df.format(order.gettotalBill());
                        System.out.printf("| %-10s | %-20s | %-20s | %-12s |\n", order.getOrderId(), order.getTime(),
                                total, order.getcardNumber());
                    }
                    System.out.println("+-------------------------------------------------------------------------+");
                    System.out.print("  Enter order id ('0' to comeback): ");
                    int id = input_int();
                    if (id == 0) {
                        break;
                    } else if (OrderBL.getBill(id).size() == 0) {
                        System.out.println(" Order not exist!");
                        System.out.printf(" Press '%s' to go back:", "Enter");
                        String nh = sc.nextLine();

                    } else {
                        int count = -1;
                        for (final Order order : lo) {
                            if (id == order.getOrderId()) {
                                count = 1;
                            }
                        }
                        if (count == -1) {
                            System.out.println(" Order is not on this day!");
                            System.out.printf(" Press '%s' to go back:", "Enter");
                            String nh = sc.nextLine();
                        } else {
                            showBill(id);
                            System.out.printf(" Press '%s' to go back:", "Enter");
                            String nh = sc.nextLine();

                        }

                    }

                }
            }
        }
    }

    public static void monneyEarnerByMonth() {
        while (true) {
            cls();

            int year = 0;
            System.out.print("Enter year: ");
            year = input_int();
            if (year >= 1990 && year <= 2050) {
                System.out.println("+---------------- -------------+");
                System.out.println("|             " + year + "             |");
                System.out.println("+------------------------------+");
                System.out.printf("| %-10s | %-15s |\n", "Month", "Amount(VND)");
                System.out.println("+------------------------------+");
                for (int i = 1; i <= 12; i++) {
                    DecimalFormat df = new DecimalFormat("#");
                    String fomart = df.format(OrderBL.monneyEarnByMonth(year, i));

                    System.out.printf("| %-10s | %-15s |\n", i, fomart);
                    System.out.println("+------------------------------+");
                }
                break;
            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static Order inputOrder(final int staffid) {
        final Order order = new Order();
        order.setTime("" + java.time.LocalDateTime.now() + "");
        order.setAccountId(staffid);
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

    public static double productAmountInNewOrder(List<OrderDetails> lo) {
        cls();
        int count = 0;
        double totalbill = 0;
        List<Product> lp = productBL.getAll();
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                                      [LTS] - Group 6                                      | ");
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        System.out.println(
                "|                                         Item List                                         | ");
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-30s | %-10s | %-7s | %-12s | %-10s |\n", "ID", "Product name", "Price(VND)",
                "Amount", "Order amount", "Total(VND)");
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        for (Product product : lp) {
            final DecimalFormat df = new DecimalFormat("#");
            final String fomart = df.format(product.getPrice());
            double money = lo.get(count).getmoney();
            final String total = df.format(money);
            totalbill = totalbill + money;
            System.out.printf("| %-5s | %-30s | %-10s | %-7s | %-12s | %-10s |\n", product.getProductId(),
                    product.getProductName(), fomart, product.getProductsInStock(), lo.get(count).getamount(), total);
            count++;
        }
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        System.out.printf("|         Total bill(VND): %-65s|\n", totalbill);
        System.out.println(
                "+-------------------------------------------------------------------------------------------+");
        return totalbill;
    }

    public static void createOrder(final int id) {
        final Order order = new Order();
        order.setTime("" + java.time.LocalDateTime.now() + "");
        order.setAccountId(2);
        System.out.print("Enter note (y/n): ");
        String choice1 = yesno();
        if (choice1.equalsIgnoreCase("N")) {
            order.setNote("No");
        } else {
            System.out.print("Enter note: ");
            order.setNote(input_string());
        }
        System.out.print("Enter card number : ");
        order.setcardNumber(input_int());
        double totalbill = 0;
        List<OrderDetails> lo = new ArrayList<OrderDetails>();
        List<Order> lorder = OrderBL.getOrderByDay("" + java.time.LocalDate.now() + "");
        final List<Product> lp = productBL.getAll();
        for (final Product product : lp) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(0);
            orderDetails.setamount(0);
            orderDetails.setmoney(0);
            orderDetails.setproductId(product.getProductId());
            lo.add(orderDetails);
        }
        while (true) {
            int proID = 0;
            String x = null;
            cls();
            totalbill = OrderFunctionUI.productAmountInNewOrder(lo);
            System.out.print("Enter product id (0. Comeback || (OK/ok). Create orer) : ");
            while (true) {
                x = sc.nextLine();
                if (x.equals("0") || x.equals("ok") || x.equals("OK")) {
                    break;
                } else {
                    try {
                        proID = Integer.parseInt(x);
                        if (proID >= 0) {
                            break;
                        } else {
                            System.out.print("  Wrong type, enter again: ");
                        }
                    } catch (final Exception e) {
                        System.out.print("  Wrong type, enter again: ");
                    }
                }
            }
            if (x.equals("0")) {
                break;
            } else if (x.equals("ok") || x.equals("OK")) {
                int orderid = 0;
                order.settotalBill(totalbill);
                OrderBL.createOrder(order);
                for (final OrderDetails orderDetails : lo) {
                    if (orderDetails.getamount() != 0) {
                        OrderBL.productsInOrder(orderDetails);
                    }
                }
                for (Order order2 : lorder) {
                    orderid = order2.getOrderId();
                }
                OrderFunctionUI.showBill(orderid);
                System.out.printf(" Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
                break;
            } else {
                List<Product> lpi = ProductBL.getAllById(proID);
                if (lpi.size() == 0) {
                    System.out.println(" Product not exist!");
                    System.out.printf(" Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
                } else {
                    int count = 0;
                    for (final Product product : lp) {
                        if (product.getProductId() == proID) {
                            if (product.getProductsInStock() == 0) {
                                System.out.println(" The product is out of stock!");
                                System.out.printf(" Press '%s' to go back:", "Enter");
                                String nh = sc.nextLine();
                            } else {
                                int amount = -1;
                                System.out.print("Enter amount: ");
                                amount = input_int();
                                if (amount > product.getProductsInStock()) {
                                    System.out.println(" Not enough products in stock!");
                                    System.out.printf(" Press '%s' to go back:", "Enter");
                                    String nh = sc.nextLine();
                                } else {
                                    lo.get(count).setamount(amount);
                                    lo.get(count).setmoney(product.getPrice() * lo.get(count).getamount());
                                }
                            }
                        }
                        count++;
                    }
                }
            }
        }

    }

    public static void confirmOrder() {
        int id = -1;
        int cardnumber = -1;
        String note = null;
        String productsName = null;
        List<Order> orderList = OrderBL.orderUnconfimred();
        if (orderList.size() == 0) {
            cls();
            System.out.println(" There are no order need to confirm!");
            System.out.printf(" Press '%s' to go back:", "Enter");
            String nh = sc.nextLine();
        } else {
            List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
            System.out.println(orderList.size());
            for (final Order order : orderList) {
                orderDetailsList = orderBL.getBillDetails(order.getOrderId());
                cardnumber = order.getcardNumber();
                note = order.getNote();
                id = order.getOrderId();
            }
            boolean back = true;
            while (back) {
                cls();
                System.out.println("+-------------------------------------------------------------------------+");
                System.out.println("|                             Lemon tee shop                              |");
                System.out.println("|                                                                         |");
                System.out.printf("|                             Card number: %-30s |\n", cardnumber);
                System.out.println("+-------------------------------------------------------------------------+");
                System.out.printf("|  Note: %-65s|\n", note);
                System.out.println("+-------------------------------------------------------------------------+");
                System.out.printf("|                    %-30s  |        %-12s|\n", "Product name", "Amount");
                System.out.println("|                                                    +                    |");
                for (final OrderDetails orderDetails : orderDetailsList) {
                    final List<Product> productsList = ProductBL.getAllById(orderDetails.getproductId());
                    for (final Product product : productsList) {
                        productsName = product.getProductName();
                    }

                    System.out.printf("| -%-50s|          %-10s|\n", productsName, orderDetails.getamount());
                    System.out.printf("| %-50s + %-18s |\n", "", "");

                }
                System.out.println("+-------------------------------------------------------------------------+");
                System.out.printf("|                     %-50s  |\n", "0. Come back || (OK/ok). Confirm");
                System.out.println("+-------------------------------------------------------------------------+");
                System.out.print(" --> Enter your choice: ");
                String chose = sc.nextLine();
                switch (chose) {
                    case "0":
                        back = false;
                        break;
                    case "ok":
                        System.out.printf(" Do you want to confirm(y/n): ");
                        String choice = yesno();
                        if (choice.equalsIgnoreCase("y")) {
                            try {
                                OrderBL.ConfirmOrder(id);
                                System.out.printf(" Press '%s' to go back:", "Enter");
                                String nh = sc.nextLine();
                                back = false;
                                break;
                            } catch (Exception e) {
                                System.err.println(" Failed!");
                            }
                        } else {
                            System.out.println(" Stopped !");
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
                                OrderBL.ConfirmOrder(id);
                                System.out.printf(" Press '%s' to go back:", "Enter");
                                String nh = sc.nextLine();
                                back = false;
                                break;
                            } catch (Exception e) {
                                System.err.println(" Failed!");
                            }
                        } else {
                            System.out.println(" Stopped !");
                            System.out.printf(" Press '%s' to go back:", "Enter");
                            String nh = sc.nextLine();
                            back = false;
                            break;
                        }
                    default:
                        System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                        String nh = sc.nextLine();
                }
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
