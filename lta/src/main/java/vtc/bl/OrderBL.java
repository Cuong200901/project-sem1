package vtc.bl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vtc.persistance.*;
import vtc.dal.OrderDAL;

public class OrderBL {
    static Scanner sc = new Scanner(System.in);
    static List<Order> orderList = new ArrayList<>();
    static List<OrderDetails> orderDetailsList = new ArrayList<>();
    public static int completeOrder(final int table) {
        return OrderDAL.completeOrder(table);
    };

    public static int createOrder(Order order) {
        return OrderDAL.createOrder(order);
    };

    public static int productsInOrder(OrderDetails orderDetails) {
        return OrderDAL.productsInOrder(orderDetails);

    };

    public static void showTableClear() {
        OrderDAL.showTableClear();
    }

    public static void showTableExit() {
        OrderDAL.showTableExsit();
    }

    public static int updateOrder(final int table) {
        return OrderDAL.updateOrder(table);
    };

    

    public static List<Order> getOrderByDay(String day) {
        return OrderDAL.getOrderByDay(day);

    };

    public static List<OrderDetails> getOrderDetails(int id) {
        return OrderDAL.getOrderDetails(id);

    };


    public static List<OrderDetails> getBillDetails(int id) {
        return OrderDAL.getBillDetails(id);

    };

    public static List<Order> getBill(int id) {
        return OrderDAL.getBill(id);
    };
    public static List<Order> getOrderByMonth(int year, int month) {
        return OrderDAL.getOrderByMonth(year, month);
    };

    
}