package vtc.ui.ProductsUI;

import java.util.List;

import vtc.bl.ProductBL;
import vtc.persistance.Product;

public class ShowProduct {
    
    public static void showProduct() {
        ProductBL productBL = new ProductBL();
        List<Product> lst = productBL.getAll();

        System.out.println("\nItem List: ");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n", "ID", "Product name",
                "Cost", "Discount", "Price", "Promotion", "Category", "Products In Stock");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Product product : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n",
                    product.getProductId(), product.getProductName(), product.getCost(), product.getDiscount(),
                    product.getPrice(), product.getPromotion(), product.getCategory(), product.getProductsInStock());
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }

}