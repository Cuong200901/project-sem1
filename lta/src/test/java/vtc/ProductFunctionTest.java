package vtc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vtc.dal.ProductDAL;
import vtc.persistance.Product;

public class ProductFunctionTest {
    @Test
    public void InsertProductTest() {

        Product product = new Product();
        int result;
        int expected;
        try {

            product.setProductName("Tra da");
            product.setPrice((double) 3000);
            product.setCategory("Do uong");
            product.setProductsInStock(200);
            result = new ProductDAL().insertProduct(product);
            expected = 1;
            assertTrue(result == expected);

            
            product.setProductName("Tra da");
            product.setPrice((double) 3000);
            product.setCategory(null);   
            product.setProductsInStock((Integer) null);
            result = new ProductDAL().insertProduct(product);
            expected = -1;
            assertTrue(result == expected);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    public void UpdateProductTest() {
        Product product = new Product();
        int result;
        int expected;
        try {
            product.setProductId(2);
            product.setProductName("Tra xoai chanh vang");     
            product.setPrice((double) 20000);
            product.setCategory("Do uong");
            product.setProductsInStock(111);
            result = new ProductDAL().update(product);
            expected = 1;
            assertTrue(result == expected);

            product.setProductId(2);
            product.setProductName("Tra da");
            product.setPrice((double) 3000);
            product.setCategory(null);
            product.setProductsInStock(111);
            result = new ProductDAL().update(product);
            expected = -1;
            assertTrue(result == expected);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void UpdateProductsInStockTest() {
        
        int result;
        int expected;
        try {
            result = new ProductDAL().updateProductsInStock(2, 222);
            expected = 1;
            assertTrue(result == expected);
            result = new ProductDAL().updateProductsInStock((Integer) null, 222);
            expected = 0;
            assertTrue(result == expected);
            result = new ProductDAL().updateProductsInStock(2, (Integer) null);
            expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
