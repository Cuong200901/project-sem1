package vtc.ui.ProductsUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.ProductBL;
import vtc.dal.ProductDAL;
import vtc.persistance.Product;

public class InputProduct {
    public static ProductDAL dal_product = new ProductDAL();
    static Scanner sc = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();
    static ProductBL productBL = new ProductBL();

    public static void insertProduct() {
        while (true) {

            ProductBL productBL = new ProductBL();

            if (productBL.addProduct(inputProduct())) {
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
        Double cost = input_double();
        product.setCost(cost);
        System.out.print("Unit discount: ");
        int discount = input_int();
        product.setDiscount(discount);
        System.out.print("Unit price: ");
        Double price = input_double();
        product.setPrice(price);
        System.out.print("Product promotion: ");
        product.setPromotion(inputString());
        System.out.print("Product category: ");
        product.setCategory(inputString());
        System.out.print("Products in stock: ");
        int productsInStock = input_int();
        product.setProductsInStock(productsInStock);

        // sc.close();
        return product;
    }

    public static void inputInfoUpdate() {

        while (true) {
            Product product = new Product();
           
            Scanner sc = new Scanner(System.in);
            System.out.print("Product_id : ");
            int id = input_int();
            product.setProductId(id);
            System.out.print("Product name: ");
            product.setProductName(inputString());
            System.out.print("Unit cost: ");
            Double cost = input_double();
            product.setCost(cost);
            System.out.print("Unit discount: ");
            int discount = sc.nextInt();
            product.setDiscount(discount);
            System.out.print("Unit price: ");
            Double price = input_double();
            product.setPrice(price);
            System.out.print("Product promotion: ");
            product.setPromotion(inputString());
            System.out.print("Product category: ");
            product.setCategory(inputString());
            System.out.print("Products in stock: ");
            int productsInStock = input_int();
            product.setProductsInStock(productsInStock);
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                productsList.add(product);
                try {
                    productBL.Update(product);
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
            
            Scanner sc = new Scanner(System.in);
            System.out.print("ProductId : ");
            int id = input_int();
            System.out.print("Products in stock: ");
            int productsInStock = input_int();
            try {
                productBL.UpdateProductsInStock(id, productsInStock);
            } catch (Exception e) {
            }
            System.out.println("Do you want to update(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                try {
                    productBL.UpdateProductsInStock(id, productsInStock);

                } catch (Exception e) {
                    System.out.println("Error. can't Update!");
                }
            }
            System.out.println("Continued(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                if (x >= 0) {
                    return x;
                }
                else{
                    System.out.print("  Nhap sai,moi nhap lai: ");
                }
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }

    private static String inputString() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print(" Nhap sai,moi nhap lai: ");

            } else {
                return a.trim();
            }
        }

    }

    public static double input_double() {
        final Scanner input = new Scanner(System.in);
        double x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Double.parseDouble(a);
                if (x >= 0) {
                    return x;
                }
                else{
                    System.out.print("  Nhap sai,moi nhap lai: ");
                }
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }

}