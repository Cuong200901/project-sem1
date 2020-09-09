// package vtc;

// import static org.junit.Assert.assertTrue;

// import java.lang.annotation.Target;

// import org.junit.Test;

// import vtc.dal.OrderDAL;
// import vtc.persistance.Order;
// import vtc.persistance.OrderDetails;

// public class OrderFunctionTest {
//     @Test
//     public void CompleteOrderTest() {
//         int result;
//         int expected;
//         try {
//             result = new OrderDAL().completeOrder(5);
//             expected = 2;
//             assertTrue(result == expected);

//             result = new OrderDAL().completeOrder(2);
//             expected = -1;
//             assertTrue(result == expected);

//             result = new OrderDAL().completeOrder(55);
//             expected = 0;
//             assertTrue(result == expected);

//         } catch (final Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Test
//     public void CreateOrderTest() {
//         Order order = new Order();
//         int result;
//         int expected;

//         try {
//             order.setAccountId(2);
//             order.setNote(".");
//             order.setOrderId(20);
//             order.setTable(2);
//             order.setTime("2020-09-01");
//             result = new OrderDAL().createOrder(order);
//             expected = 3;
//             assertTrue(result == expected);

//             order.setAccountId(5);
//             order.setNote(".");
//             order.setOrderId(20);
//             order.setTable(5);
//             order.setTime("2020-09-01");
//             result = new OrderDAL().createOrder(order);
//             expected = 2;
//             assertTrue(result == expected);

//             order.setAccountId(2);
//             order.setNote(".");
//             order.setOrderId((Integer) null);
//             order.setTable(5);
//             order.setTime(null);
//             result = new OrderDAL().createOrder(order);
//             expected = 0;
//             assertTrue(result == expected);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Test
//     public void InsertProductToOrderTest() {
//         OrderDetails orderDetails = new OrderDetails();
//         int result;
//         int expected;
//         try {
//             orderDetails.setOrderId(20);
//             orderDetails.setamount(20);
//             orderDetails.setproductId(20);
//             expected = 3;
//             result = new OrderDAL().productsInOrder(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId(20);
//             orderDetails.setamount(10);
//             orderDetails.setproductId(1);
//             expected = -1;
//             result = new OrderDAL().productsInOrder(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId(20);
//             orderDetails.setamount(9999);
//             orderDetails.setproductId(20);
//             expected = -2;
//             result = new OrderDAL().productsInOrder(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId((Integer) null);
//             orderDetails.setamount(20);
//             orderDetails.setproductId((Integer) null);
//             result = new OrderDAL().productsInOrder(orderDetails);
//             expected = 0;
//             assertTrue(result == expected);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }

//     }

//     @Test
//     public void UpdateProductInOrderTest() {
//         OrderDetails orderDetails = new OrderDetails();
//         int result;
//         int expected;
//         try {
//             orderDetails.setOrderId(20);
//             orderDetails.setamount(20);
//             orderDetails.setproductId(20);
//             expected = 3;
//             result = new OrderDAL().productsInOrderUpdate(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId(20);
//             orderDetails.setamount(10);
//             orderDetails.setproductId(1);
//             expected = -1;
//             result = new OrderDAL().productsInOrderUpdate(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId(20);
//             orderDetails.setamount(9999);
//             orderDetails.setproductId(20);
//             expected = -2;
//             result = new OrderDAL().productsInOrderUpdate(orderDetails);
//             assertTrue(result == expected);

//             orderDetails.setOrderId((Integer) null);
//             orderDetails.setamount(20);
//             orderDetails.setproductId((Integer) null);
//             result = new OrderDAL().productsInOrderUpdate(orderDetails);
//             expected = 0;
//             assertTrue(result == expected);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Test
//     public void UpdateOrderTest() {
//         int result;
//         int expected;
//         try {
//             result = new OrderDAL().updateOrder(5);
//             expected = 0;
//             assertTrue(result != expected);

//             result = new OrderDAL().updateOrder(1);
//             expected = 0;
//             assertTrue(result == expected);

//             result = new OrderDAL().updateOrder(55);
//             expected = 0;
//             assertTrue(result == expected);

//         } catch (final Exception e) {
//             // TODO: handle exception
//         }
//     }

// }
