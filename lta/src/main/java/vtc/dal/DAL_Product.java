package vtc.dal;

import vtc.persistance.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAL_Product {

    public static List<Product> getAll() {
        String sql = "select * from products";
        List<Product> lst = new ArrayList<>();
        try (Connection con = DB_Util.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getProduct(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public static int insertProduct(Product product) {
        try (Connection con = DB_Util.getConnection();
             PreparedStatement pstm = con.prepareStatement(
                                          "insert into products(name, cost, discount, price,promotion, category, products_in_stock) values (?,?,?,?,?,?,?)");) {
            pstm.setString(1, product.getProductName());
            pstm.setDouble(2, product.getCost());
            pstm.setInt(3, product.getDiscount());
            pstm.setDouble(4, product.getPrice());
            pstm.setString(5,product.getPromotion());
            pstm.setString(6,product.getCategory());
            pstm.setInt(7,product.getProductsInStock());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("loi insert!");
            System.out.println(ex.toString());
            return 0;

        }
    }

    public static Product getProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("name"));
        product.setCost(rs.getDouble("cost"));
        product.setDiscount(rs.getInt("discount"));
        product.setPrice(rs.getDouble("price"));
        product.setPromotion(rs.getString("promotion"));
        product.setCategory(rs.getString("category"));
        product.setProductsInStock(rs.getInt("products_in_stock"));
        return product;
    }

    public int update(Product product) throws SQLException {
        try (Connection con = DB_Util.getConnection();
             PreparedStatement pstm = con.prepareStatement(
                     "UPDATE products SET name = '?', cost = '?', discount = '?', price = '?', promotion = '?', category = '?', products_in_stock = '?' WHERE (product_id = '?'");) {
            pstm.setString(1, product.getProductName());
            pstm.setDouble(2, product.getCost());
            pstm.setInt(3, product.getDiscount());
            pstm.setDouble(4, product.getPrice());
            pstm.setString(5,product.getPromotion());
            pstm.setString(6,product.getCategory());
            pstm.setInt(7,product.getProductsInStock());
            pstm.setInt(8,product.getProductId());


            int rs = pstm.executeUpdate();
            if (rs==1) {
                System.out.println("Update Successful!");
            }else{
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;

        }
    }

    public int updateProductsInStock(Product product) throws SQLException {
        try (Connection con = DB_Util.getConnection();
             PreparedStatement pstm = con.prepareStatement(
                     "UPDATE products SET products_in_stock = '?' WHERE (product_id = '?'");) {
            pstm.setInt(1,product.getProductsInStock());
            pstm.setInt(2,product.getProductId());


            int rs = pstm.executeUpdate();
            if (rs==1) {
                System.out.println("Update Successful!");
            }else{
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;

        }
    }

}
