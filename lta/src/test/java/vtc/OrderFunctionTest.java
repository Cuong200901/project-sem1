package vtc;

import static org.junit.Assert.assertTrue;

import java.lang.annotation.Target;

import org.junit.Test;

import vtc.dal.OrderDAL;
import vtc.persistance.Order;
import vtc.persistance.OrderDetails;

public class OrderFunctionTest {

    @Test
    public void CreateOrderTest() {
        Order order = new Order();
        int result;
        int expected;

        try {
            order.setAccountId(2);
            order.setNote(".");
            order.setOrderId(1);
            order.setcardNumber(2);
            order.setorderStatus("Unconfirmed");
            order.setTime("2020-09-01");
            order.settotalBill((double) 25000);
            result = new OrderDAL().createOrder(order);
            expected = 1;
            assertTrue(result == expected);

            order.setAccountId(2);
            order.setNote(".");
            order.setOrderId((Integer) null);
            order.setcardNumber(5);
            order.setorderStatus("Unconfirmed");
            order.setTime(null);
            order.settotalBill((double) 25000);
            result = new OrderDAL().createOrder(order);
            expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void InsertProductToOrderTest() {
        OrderDetails orderDetails = new OrderDetails();
        int result;
        int expected;
        try {
            orderDetails.setOrderId(20);
            orderDetails.setamount(20);
            orderDetails.setproductId(20);
            orderDetails.setmoney(25000);
            expected = 3;
            result = new OrderDAL().productsInOrder(orderDetails);
            assertTrue(result == expected);

            orderDetails.setOrderId(2);
            orderDetails.setamount(0);
            orderDetails.setproductId(2);
            orderDetails.setmoney(25000);
            expected = -1;
            result = new OrderDAL().productsInOrder(orderDetails);
            assertTrue(result == expected);

            orderDetails.setOrderId(20);
            orderDetails.setamount(9999);
            orderDetails.setproductId(20);
            orderDetails.setmoney(25000);
            expected = -2;
            result = new OrderDAL().productsInOrder(orderDetails);
            assertTrue(result == expected);

            orderDetails.setOrderId((Integer) null);
            orderDetails.setamount(20);
            orderDetails.setproductId((Integer) null);
            orderDetails.setmoney(25000);
            result = new OrderDAL().productsInOrder(orderDetails);
            expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
    @Test
    public void ConfirmOrderTest() {
        OrderDAL orderDAL = new OrderDAL();
        int result;
        int expected;
        try {
            result = new OrderDAL().ConfirmOrder(0);
            expected = 0;
            assertTrue(result == expected);


            result = new OrderDAL().ConfirmOrder(1);
            expected = 1;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}
