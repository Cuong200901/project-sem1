package vtc.dal;

import java.util.ArrayList;
import java.util.List;

import vtc.persistance.*;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

public class OrderDAL {

    // public static void showTableClear() {
    //     final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Clear';";
    //     try (Connection con = UtilDB.getConnection();
    //             Statement stm = con.createStatement();
    //             ResultSet rs = stm.executeQuery(sql)) {
    //         System.out.println("+-------------------------+");
    //         System.out.printf("| %-10s | %-10s |\n", "Id", "Status");
    //         System.out.println("+-------------------------+");
    //         while (rs.next()) {
    //             System.out.printf("| %-10s | %-10s |\n", rs.getInt("table_id"), rs.getString("status"));
    //         }
    //         System.out.println("+-------------------------+");
    //     } catch (final SQLException ex) {

    //         System.out.println(ex.toString());
    //     }
    // }

    // public static void showTableExist() {
    //     final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Exist';";
    //     try (Connection con = UtilDB.getConnection();
    //             Statement stm = con.createStatement();
    //             ResultSet rs = stm.executeQuery(sql)) {
    //         System.out.println("+-------------------------+");
    //         System.out.printf("| %-10s | %-10s |\n", "Id", "Status");
    //         System.out.println("+-------------------------+");
    //         while (rs.next()) {
    //             System.out.printf("| %-10s | %-10s |\n", rs.getInt("table_id"), rs.getString("status"));
    //         }
    //         System.out.println("+-------------------------+");
    //     } catch (final SQLException ex) {

    //         System.out.println(ex.toString());
    //     }

    // }

    public static double monneyEarnByMonth(final int year, int month) {
        double monneyEarner = 0;
        String sql = "SELECT sum(total_bill) FROM lemon_tee_shop.orders where year(orders.time) = " + year
                + " and month(orders.time) = " + month + ";";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                monneyEarner = rs.getInt("sum(total_bill)");
            }
        } catch (final SQLException ex) {

            return -1;
        }
        return monneyEarner;
    }

    // public static int completeOrder(final int table) {
    //     int count = 0;
    //     final String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
    //     try (Connection con = UtilDB.getConnection();
    //             Statement stm = con.createStatement();
    //             ResultSet rs = stm.executeQuery(sql)) {
    //         while (rs.next()) {
    //             if (!rs.getString("status").equals("Clear")) {
    //                 count = 1;
    //             } else {
    //                 count = -1;
    //             }

    //         }
    //     } catch (final SQLException ex) {
    //         return 0;
    //     }
    //     if (count == 1) {
    //         try (Connection con = UtilDB.getConnection();
    //                 PreparedStatement pstm = con.prepareStatement(
    //                         "UPDATE `lemon_tee_shop`.`table` SET `status` = 'Clear' WHERE (`table_id` = '" + table
    //                                 + "');");) {
    //             final int rs = pstm.executeUpdate();
    //             if (rs == 1) {
    //                 return count = 2;
    //             } else {
    //                 return 0;
    //             }
    //         } catch (final SQLException ex) {
    //             return 0;

    //         }
    //     }
    //     if (count == -1) {
    //         return count = -1;
    //     }
    //     return count;
    // }

    public static int createOrder(Order order) {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "INSERT INTO orders (time, order_status, account_id, total_bill,card_number, note) VALUES (?, 'Unconfimred',?,?,?,?);");) {
            pstm.setString(1, order.getTime());
            pstm.setInt(2, order.getAccountId());
            pstm.setDouble(3, order.gettotalBill());
            pstm.setInt(4, order.getcardNumber());
            pstm.setString(5, order.getNote());
            pstm.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            return 0;
        }
    }
  

    public static int productsInOrder(OrderDetails orderDetails) {

        int count = 0;
        int order_id = 0;
        int productInStock = 0;
        String sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id  = '"
                + orderDetails.getproductId() + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (rs.getInt("products_in_stock") == 0) {

                    return count = -1;
                } else if (rs.getInt("products_in_stock") < orderDetails.getamount()) {

                    return count = -2;
                } else {
                    count = 1;
                }

            }
        } catch (final SQLException ex) {
            return count;
        }

        if (count == 1) {
            sql = "SELECT max(order_id) FROM lemon_tee_shop.orders;";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    order_id = rs.getInt("max(order_id)");
                    count = 2;
                }
            } catch (final SQLException ex) {
                return count = 0;
            }
        }
        if (count == 2) {

            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "INSERT INTO order_details (order_id, product_id,amount, monney) VALUES (?,?,?,?);");) {
                pstm.setInt(1, order_id);
                pstm.setInt(2, orderDetails.getproductId());
                pstm.setInt(3, orderDetails.getamount());
                pstm.setDouble(4, orderDetails.getmoney());
                pstm.executeUpdate();
            } catch (SQLException ex) {

                return count = 0;

            }

            sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id = '"
                    + orderDetails.getproductId() + "';";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    productInStock = rs.getInt("products_in_stock") - orderDetails.getamount();

                }
            } catch (final SQLException ex) {

                return count = 0;
            }

            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "UPDATE lemon_tee_shop.products SET products_in_stock = '" + productInStock
                                    + "' WHERE (product_id = '" + orderDetails.getproductId() + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {

                    return count = 3;
                } else {
                    return count = 0;
                }
            } catch (final SQLException ex) {

                return count;

            }
        }

        return count;

    }

    // public static int productsInOrderUpdate(OrderDetails orderDetails) {
    //     int count = 0;
    //     int productInStock = 0;
    //     String sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id  = '"
    //             + orderDetails.getproductId() + "';";
    //     try (Connection con = UtilDB.getConnection();
    //             Statement stm = con.createStatement();
    //             ResultSet rs = stm.executeQuery(sql)) {
    //         while (rs.next()) {
    //             if (rs.getInt("products_in_stock") == 0) {

    //                 return count = -1;
    //             } else if (rs.getInt("products_in_stock") < orderDetails.getamount()) {

    //                 return count = -2;
    //             } else {
    //                 count = 1;
    //             }

    //         }
    //     } catch (final SQLException ex) {
    //         return count;
    //     }

    //     if (count == 1) {

    //         try (Connection con = UtilDB.getConnection();
    //                 PreparedStatement pstm = con.prepareStatement(
    //                         "INSERT INTO order_details (product_id, amount, order_id) VALUES (?, ?, ?);");) {
    //             pstm.setInt(1, orderDetails.getproductId());
    //             pstm.setInt(2, orderDetails.getamount());
    //             pstm.setInt(3, orderDetails.getOrderId());
    //             pstm.executeUpdate();
    //         } catch (SQLException ex) {

    //             return count = 0;

    //         }

    //         sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id = '"
    //                 + orderDetails.getproductId() + "';";
    //         try (Connection con = UtilDB.getConnection();
    //                 Statement stm = con.createStatement();
    //                 ResultSet rs = stm.executeQuery(sql)) {
    //             while (rs.next()) {
    //                 productInStock = rs.getInt("products_in_stock") - orderDetails.getamount();

    //             }
    //         } catch (final SQLException ex) {

    //             return count = 0;
    //         }

    //         try (Connection con = UtilDB.getConnection();
    //                 PreparedStatement pstm = con.prepareStatement(
    //                         "UPDATE lemon_tee_shop.products SET products_in_stock = '" + productInStock
    //                                 + "' WHERE (product_id = '" + orderDetails.getproductId() + "');");) {
    //             final int rs = pstm.executeUpdate();
    //             if (rs == 1) {

    //                 return count = 3;
    //             } else {
    //                 return count = 0;
    //             }
    //         } catch (final SQLException ex) {

    //             return count;
    //         }
    //     }

    //     return count;

    // }

    // public static int updateOrder(final int table) {
    //     int order_id = 0;
    //     int count = 0;
    //     String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
    //     try (Connection con = UtilDB.getConnection();
    //             Statement stm = con.createStatement();
    //             ResultSet rs = stm.executeQuery(sql)) {
    //         while (rs.next()) {
    //             if (!rs.getString("status").equals("Clear")) {
    //                 count = 1;
    //             } else {
    //                 return 0;
    //             }
    //         }
    //     } catch (final SQLException ex) {
    //         return count = 0;
    //     }

    //     if (count == 1) {
    //         sql = "SELECT max(order_id) FROM lemon_tee_shop.orders where table_id = '" + table + "';";
    //         try (Connection con = UtilDB.getConnection();
    //                 Statement stm = con.createStatement();
    //                 ResultSet rs = stm.executeQuery(sql)) {
    //             while (rs.next()) {
    //                 order_id = rs.getInt("max(order_id)");

    //             }
    //         } catch (final SQLException ex) {
    //             return 0;
    //         }
    //     }

    //     return order_id;
    // }

    public static Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setTime(rs.getString("time"));
        order.setAccountId(rs.getInt("account_id"));
        order.setNote(rs.getString("note"));
        order.setcardNumber(rs.getInt("card_number"));
        order.settotalBill(rs.getDouble("total_bill"));
        order.setorderStatus(rs.getString("order_status"));
        return order;
    }

    public static OrderDetails getOrderDetails(ResultSet rs) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setproductId(rs.getInt("product_id"));
        orderDetails.setamount(rs.getInt("amount"));
        orderDetails.setOrderId(rs.getInt("order_id"));
        orderDetails.setmoney(rs.getDouble("monney"));
        return orderDetails;
    }

    public static List<Order> getOrderByDay(String day) {
        String sql = "SELECT * FROM lemon_tee_shop.orders where date(time) = '" + day + "';";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
        }
        return lst;
    }

    public static List<OrderDetails> getBillDetails(int id) {
        String sql = "SELECT * FROM lemon_tee_shop.order_details  where order_id = '" + id + "' ;";
        List<OrderDetails> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrderDetails(rs));
            }
        } catch (SQLException ex) {
            lst = null;
        }
        return lst;
    }

    public static List<Order> getBill(int id) {
        String sql = "SELECT * FROM lemon_tee_shop.orders where order_id = '" + id + "';";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
        }
        return lst;
    }

    public static int getOrderByMonth(int year, int month) {
        int amount = 0;
        String sql = "SELECT count(order_id) FROM lemon_tee_shop.orders where year(orders.time) = " + year
                + " and month(orders.time) = " + month + "";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                amount = rs.getInt("count(order_id)");
            }
        } catch (final SQLException ex) {

            return -1;
        }
        return amount;
    }

    public static List<Order> orderUnconfimred() {
        String sql = "SELECT * FROM lemon_tee_shop.orders where order_status = 'Unconfimred' limit 1;";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
        }
        return lst;

    }

    public static int ConfirmOrder(int id) {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "UPDATE `lemon_tee_shop`.`orders` SET `order_status` = 'Confirmed' WHERE (`order_id` = '" + id
                                + "');");) {
            final int rs = pstm.executeUpdate();
            if (rs == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException ex) {
            return 0;

        }

    }

}