package vtc.ui.OrderUI;

import java.io.IOException;
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
import vtc.ui.ProductsUI.ShowProduct;

public class CreateOrder {
    static Scanner sc = new Scanner(System.in);
    static AccountBL accountBL = new AccountBL();
    static ProductBL productBL = new ProductBL();
    static OrderBL orderBL = new OrderBL();
    static OrderDetails orderDetails = new OrderDetails();
    static List<Account> accountsList = new ArrayList<>();
    static List<Product> productsList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();
    static List<OrderDetails> orderdetailssList = new ArrayList<>();

    public static Order inputOrder(final int staffid) {
        final Order order = new Order();
        order.setTime("" + java.time.LocalDateTime.now() + "");
        order.setAccountId(staffid);
        System.out.print("Enter table : ");
        order.setTable(sc.nextInt());
        System.out.print("Enter note : ");
        order.setNote(sc.nextLine());
        return order;

    }

    public static OrderDetails inputOrderDetails(final int orderid) {
        final OrderDetails orderDetails = new OrderDetails();
        System.out.print("Enter ProductId : ");
        orderDetails.setproductId(sc.nextInt());
        System.out.print("Enter amount : ");
        orderDetails.setamount(sc.nextInt());
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
        order.setNote(sc.nextLine());

        final int Count = OrderBL.createOrder(order);
        System.out.println(Count);
        if (Count == 3) {
            while (true) {
               ShowProduct.showProduct();
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
                System.out.println("Continue Insert?(y/n)");
                final String choice1 = yesno();
                if (choice1.equalsIgnoreCase("N")) {
                    break;
                }
            }
        } else if (Count == 2) {
            System.err.println("Table exsit!");
            System.out.printf("Nhan %s de quay lai:", "Enter");
            String nh = sc.nextLine();
        } else {
            System.err.println("Error");
            System.out.printf("Nhan %s de quay lai:", "Enter");
            String nh = sc.nextLine();
        }

    }

    public static void updateOrder() {
        System.out.print("Enter table: ");
       int table = sc.nextInt();
        final int Count = OrderBL.updateOrder(table);
        System.out.println(Count);
        if (Count == 0) {
            System.out.println("Table clear!");
        } else if (Count == -1) {
            System.out.println("Wrong table!");
        } else {
            while (true) {
                ShowProduct.showProduct();
                final OrderDetails orderDetails = new OrderDetails();
                System.out.print("Enter ProductId : ");
                orderDetails.setproductId(input_int());
                System.out.print("Enter amount : ");
                orderDetails.setamount(sc.nextInt());
                orderDetails.setOrderId(OrderBL.tableOrderExsit(table));
                final int count = OrderBL.productsInOrderUpdate(orderDetails);
                if (count == 3) {
                    System.out.println("Insert account complete!");
                } else if (count == -1) {
                    System.out.println("The product is out of stock!");

                } else if (count == -2) {
                    System.out.println("Insufficient quantity of products!");
                } else {
                    System.out.println(count);
                    System.out.println("Insert account failed!");
                }
                System.out.println("Continue Insert?(y/n)");
                String choice1 = yesno();
                if (choice1.equals("n") || choice1.equals("N")) {
                    break;
                }
            }
        }
    }

    // public static void createOrder(final int staff_id) {
    // int table_id;
    // String note;
    // int product_id;
    // int amount;
    // System.out.print("Enter table: ");
    // table_id = input_int();
    // System.out.print("Note: ");
    // note = sc.nextLine();
    // if (OrderDAL.createOrder(staff_id, table_id, note) == 3) {
    // while (true) {
    // ProductBL.showProduct();
    // System.out.print("Enter product id: ");
    // product_id = input_int();
    // System.out.print("Enter product amount: ");
    // amount = input_int();
    // System.out.print("Do you want to update(Y/N): ");
    // String yn = yesno();
    // if (yn.equals("y") || yn.equals("Y")) {
    // OrderDAL.productsInOrder(product_id, amount);
    // }
    // System.out.print("Continue(Y/N): ");
    // yn = yesno();
    // if (yn.equals("n") || yn.equals("N")) {
    // break;
    // }

    // }
    // } else if (OrderDAL.createOrder(staff_id, table_id, note) == 0) {
    // System.out.println("Wrong table");
    // System.out.println(OrderDAL.createOrder(staff_id, table_id, note));
    // System.out.printf("Nhan %s de quay lai:", "Enter");
    // String nh = sc.nextLine();
    // }else if(OrderDAL.createOrder(staff_id, table_id, note) ==2)
    // {
    // System.out.println("Table exsit");
    // System.out.printf("Nhan %s de quay lai:", "Enter");
    // String nh = sc.nextLine();
    // }

    // }

    // public static void updateOrder() {

    // int table_id;
    // int product_id;
    // int amount;

    // System.out.print("Enter table: ");
    // table_id = input_int();
    // if (OrderDAL.updateOrder(table_id) != 0) {
    // while (true) {
    // cls();
    // ProductBL.showProduct();
    // System.out.print("Enter product id: ");
    // product_id = input_int();
    // System.out.print("Enter product amount: ");
    // amount = input_int();
    // System.out.print("Do you want to update(Y/N): ");
    // String yn = yesno();
    // if (yn.equals("y") || yn.equals("Y")) {
    // OrderDAL.productsInOrder(product_id, amount);
    // }
    // System.out.print("Continue(Y/N): ");
    // yn = yesno();
    // if (yn.equals("n") || yn.equals("N")) {
    // break;
    // }

    // }
    // }
    // }

    // public static void cls() {
    // try {
    // if (System.getProperty("os.name").contains("Windows"))
    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    // else
    // Runtime.getRuntime().exec("clear");
    // } catch (IOException | InterruptedException ignored) {
    // }
    // }

    // private static String input_string() {
    // final Scanner input = new Scanner(System.in);
    // String a;
    // while (true) {
    // a = input.nextLine();
    // if (a.trim().compareTo("") == 0) {
    // System.out.print(" Nhap sai,moi nhap lai: ");

    // } else {
    // return a.trim();
    // }
    // }

    // }

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
    }
    else{
    System.out.print(" Nhap sai,moi nhap lai: ");
    }
    } catch (Exception e) {
    System.out.print(" Nhap sai,moi nhap lai: ");

    }
    }

    }

    public static String yesno() {

        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y") || yn.equalsIgnoreCase("n")
                || yn.equalsIgnoreCase("y")) {
            return yn;
        }
        return yn;
    }

}