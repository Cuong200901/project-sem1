package vtc.dal;

import vtc.persistance.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAL {

    public static List<Product> getAll() {
        String sql = "SELECT * FROM lemon_tee_shop.products ORDER BY category ;";
        List<Product> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getProduct(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            
        }
        return lst;
    }

    public static List<Product> getAllById(int id) {
        String sql = "select * from lemon_tee_shop.products  WHERE product_id = '" + id + "';";
        List<Product> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getProduct(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            
        }
        return lst;
    }

    public static int insertProduct(Product product) {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "insert into products(name, price, category, products_in_stock) values (?,?,?,?);");) {
            pstm.setString(1, product.getProductName());       
            pstm.setDouble(2, product.getPrice());
            pstm.setString(3, product.getCategory());
            pstm.setInt(4, product.getProductsInStock());
            System.out.println(pstm.executeUpdate());
            return pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error insert!");
            
            return 0;

        }
    }

    public static Product getProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("name"));    
        product.setPrice(rs.getDouble("price"));
        product.setCategory(rs.getString("category"));
        product.setProductsInStock(rs.getInt("products_in_stock"));
        return product;
    }

    public int update(Product product) throws SQLException {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "UPDATE products SET name = ?, price = ?,  category = ?, products_in_stock = ? WHERE (product_id = ?);");) {
            pstm.setString(1, product.getProductName());
            pstm.setDouble(2, product.getPrice());        
            pstm.setString(3, product.getCategory());
            pstm.setInt(4, product.getProductsInStock());
            pstm.setInt(5, product.getProductId());

            int rs = pstm.executeUpdate();
            if (rs == 1) {
                System.out.println("Update Successful!");
            } else {
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Eror update!");
            return 0;

        }
    }

    public int updateProductsInStock(int id, int amount) throws SQLException {
        try (Connection con = UtilDB.getConnection();
                PreparedStatement pstm = con
                        .prepareStatement("UPDATE `lemon_tee_shop`.`products` SET `products_in_stock` = '" + amount
                                + "' WHERE (`product_id` = '" + id + "');");) {
            int rs = pstm.executeUpdate();
            if (rs == 1) {
                System.out.println("Update Successful!");
                return 1;
            } else {
                System.out.println("Update fail!");
                return 0;
            }
        } catch (SQLException ex) {
            return 0;
        }
        
    }

}
