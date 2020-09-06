package vtc.bl;

import vtc.dal.ProductDAL;
import vtc.persistance.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductBL {
    public static ProductDAL dal_product = new ProductDAL();
    static Scanner sc = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();

    public List<Product> getAll() {
        return ProductDAL.getAll();
    }

    public boolean addProduct(Product product) {
        return ProductDAL.insertProduct(product) > 0;
    }

    public boolean Update(Product product) throws SQLException {
        return dal_product.update(product) > 0;
    }

    public boolean UpdateProductsInStock(int id, int amount) throws SQLException {
        return dal_product.updateProductsInStock(id, amount) > 0;
    }

    public static void showProduct() {
    }

    public static List<Product> getAllById(int id) {
        return ProductDAL.getAllById(id);
    }

    

}