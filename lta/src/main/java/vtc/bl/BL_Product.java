package vtc.bl;

import vtc.dal.DAL_Product;
import vtc.persistance.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BL_Product {
    public static DAL_Product dal_product = new DAL_Product();
    static Scanner sc = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();
    public List<Product> getAll() {
        return DAL_Product.getAll();
    }

    public boolean addProduct(Product product) {
        return DAL_Product.insertProduct(product) > 0;
    }

    // public boolean updatePro(Product product) throws SQLException {
    // return productDAL.update(product) > 0;
    // }

    public static void showProduct() {
        BL_Product bl_product = new BL_Product();
        List<Product> lst = bl_product.getAll();
        System.out.println("\nItem List: ");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n", "ID", "Product name", "Cost",
                "Discount", "Price", "Promotion", "Category", "Products In Stock");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Product product : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n", product.getProductId(), product.getProductName(),
                   product.getCost(), product.getDiscount(), product.getPrice(), product.getPromotion(),product.getCategory(),product.getProductsInStock());
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }



    // public static void showAllProduct() {
    // ProductBL pbl = new ProductBL();
    // System.out.println("\nItems List:");
    // List<Product> lst = pbl.getAll();
    // for (Product product : lst) {
    // System.out.println(product);
    // }
    // }

    public static void insertProduct() {
        while (true) {

            BL_Product bl_product = new BL_Product();

            if (bl_product.addProduct(inputProduct())) {
                System.out.println("Insert product complete!");
            } else {
                System.err.println("Insert product failed!");
            }

            System.out.println("Continue Insert?(y/n)");
            String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public static String yesno() {
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }



    public static Product inputProduct() {
        Product product = new Product();
        // Scanner sc = new Scanner(System.in);
        System.out.print("Product name: ");
        product.setProductName(sc.nextLine());
        System.out.print("Unit cost: ");
        Double cost = sc.nextDouble();
        product.setCost(cost);
        System.out.print("Unit discount: ");
        int discount = sc.nextInt();
        product.setDiscount(discount);
        System.out.print("Unit price: ");
        Double price = sc.nextDouble();
        product.setPrice(price);
        System.out.print("Product promotion: ");
        product.setPromotion(sc.nextLine());
        System.out.print("Product category: ");
        product.setCategory(sc.nextLine());
        System.out.print("Products in stock: ");
        int productsInStock = sc.nextInt();
        product.setProductsInStock(productsInStock);


        // sc.close();
        return product;
    }

    public static void inputInfoUpdate() {

        while (true) {

            Product product = new Product();
            DAL_Product PD = new DAL_Product();
            Scanner sc = new Scanner(System.in);
            System.out.print("Product_id : ");
            int id = sc.nextInt();
            product.setProductId(id);
            System.out.print("Product name: ");
            product.setProductName(sc.nextLine());
            System.out.print("Unit cost: ");
            Double cost = sc.nextDouble();
            product.setCost(cost);
            System.out.print("Unit discount: ");
            int discount = sc.nextInt();
            product.setDiscount(discount);
            System.out.print("Unit price: ");
            Double price = sc.nextDouble();
            product.setPrice(price);
            System.out.print("Product promotion: ");
            product.setPromotion(sc.nextLine());
            System.out.print("Product category: ");
            product.setCategory(sc.nextLine());
            System.out.print("Products in stock: ");
            int productsInStock = sc.nextInt();
            product.setProductsInStock(productsInStock);
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                productsList.add(product);
                try {
                    PD.update(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error. can't Update!");
            }
            System.out.println("Continued(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    public static void inputProductsInStock() {

        while (true) {
            Product product = new Product();
            DAL_Product PD = new DAL_Product();
            Scanner sc = new Scanner(System.in);
            System.out.print("Product_id : ");
            int id = sc.nextInt();
            product.setProductId(id);
            System.out.print("Products in stock: ");
            int productsInStock = sc.nextInt();
            product.setProductsInStock(productsInStock);
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                productsList.add(product);
                try {
                    PD.update(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error. can't Update!");
            }
            System.out.println("Continued(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}