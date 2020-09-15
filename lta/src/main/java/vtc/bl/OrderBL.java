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
    public static int createOrder(final Order order) {
        return OrderDAL.createOrder(order);
    };

    public static int productsInOrder(final OrderDetails orderDetails) {
        return OrderDAL.productsInOrder(orderDetails);

    };

    public static List<Order> getOrderByDay(final String day) {
        return OrderDAL.getOrderByDay(day);

    };

    public static List<OrderDetails> getBillDetails(final int id) {
        return OrderDAL.getBillDetails(id);

    };

    public static List<Order> getBill(final int id) {
        return OrderDAL.getBill(id);
    };

    public static int getOrderByMonth(final int year, final int month) {
        return OrderDAL.getOrderByMonth(year, month);
    };

    public static double monneyEarnByMonth(final int year, final int month) {
        return OrderDAL.monneyEarnByMonth(year, month);
    }

    public static List<Order> orderUnconfimred() {
        return OrderDAL.orderUnconfimred();
    }

    public static int ConfirmOrder(final int id)
{
    return OrderDAL.ConfirmOrder(id);
}

}