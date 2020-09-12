package vtc.ui.ProductsUI;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.ProductBL;
import vtc.dal.ProductDAL;
import vtc.persistance.Product;

public class ProductFunctionUI {
  
    static Scanner sc = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();
    static ProductBL productBL = new ProductBL();

    public static void showProduct() {
        cls();
        final ProductBL productBL = new ProductBL();
        final List<Product> lst = productBL.getAll();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              [LTS] - Group 6                              | ");
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                 Item List                                 | ");
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-30s | %-10s | %-9s | %-7s |\n", "ID", "Product name", "Price", "Category",
                "Amount");
        System.out.println("+---------------------------------------------------------------------------+");
        for (final Product product : lst) {
            final DecimalFormat df = new DecimalFormat("#");
            final String fomart = df.format(product.getPrice());
            System.out.printf("| %-5s | %-30s | %-10s | %-9s | %-7s |\n", product.getProductId(),
                    product.getProductName(), fomart, product.getCategory(), product.getProductsInStock());
        }
        System.out.println("+---------------------------------------------------------------------------+");

    }

    public static void showProductById(final int id) {
        cls();

        final ProductBL productBL = new ProductBL();
        final List<Product> lp = productBL.getAllById(id);
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                     [LTS] - Group6                    |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                    Product Information                |");
        System.out.println("+-------------------------------------------------------+");
        for (final Product product : lp) {
            System.out.printf("| 1. Product name      : %-30s |\n", product.getProductName());
            System.out.printf("| 2. Price             : %-30s |\n", product.getPrice());
            System.out.printf("| 3. Category          : %-30s |\n", product.getCategory());
            System.out.printf("| 4. Products in stock : %-30s |\n", product.getProductsInStock());
        }
        System.out.println("+-------------------------------------------------------+");

    }

    public static void showProductNewInfor(final Product product) {
        cls();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                     [LTS] - Group6                    |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                    Product Information                |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| 1. Product name      : %-30s |\n", product.getProductName());
        System.out.printf("| 2. Price             : %-30s |\n", product.getPrice());
        System.out.printf("| 3. Category          : %-30s |\n", product.getCategory());
        System.out.printf("| 4. Products in stock : %-30s |\n", product.getProductsInStock());
        System.out.println("+-------------------------------------------------------+");
    }

    public static void insertProduct() {
        while (true) {
            if (productBL.addProduct(inputProduct())) {
                System.out.println("Insert product complete!");
            } else {
                System.err.println("Insert product failed!");
            }
            System.out.print("Continued(y/n): ");
            final String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static String yesno() {
        final Scanner sc = new Scanner(System.in);
        String yn = null;
        while (true) {
            yn = sc.nextLine();
            if (yn.equals("N") || yn.equals("Y") || yn.equals("n") || yn.equals("y")) {
                break;
            } else {
                System.out.print("  Wrong type, enter again: ");
            }
        }

        return yn;
    }

    public static Product inputProduct() {
        Product product = new Product();
        final Product productDefault = new Product();
        productDefault.setPrice((double) -1);
        productDefault.setProductsInStock(-1);
        int count = 0;
        while (true) {
            while (true) {
                showProductNewInfor(product);
                System.out.print("Product name: ");
                final String name = inputString();
                System.out.print("Insert(y/n): ");
                String choice1 = yesno();
                if (choice1.equalsIgnoreCase("N")) {
                    System.out.print("Continue Insert(y/n): ");
                    choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        return productDefault;
                    }

                } else {
                    product.setProductName(name);
                    count = 1;
                    break;
                }
            }
            if (count == 1) {
                while (true) {
                    showProductNewInfor(product);
                    System.out.print("Unit price: ");
                    final Double price = input_double();
                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                        choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            return productDefault;
                        }
                        ;
                    } else {
                        product.setPrice(price);
                        count = 2;
                        break;
                    }
                }
            }

            if (count == 2) {
                while (true) {
                    String category = null;
                    while (true) {
                        showProductNewInfor(product);
                        System.out.println(" 1. Drink / 2. Food / 3. Topping");
                        System.out.print(" Product category: ");
                        final int choice = input_int();
                        if (choice == 1) {
                            category = "Drink";
                            break;
                        } else if (choice == 2) {
                            category = "Food";
                            break;
                        } else if (choice == 3) {
                            category = "Topping";
                            break;
                        } else {
                            System.out.print(" Not found! ");
                            System.out.print(" Continue Insert(y/n): ");
                            final String choice1 = yesno();
                            if (choice1.equalsIgnoreCase("N")) {
                                return productDefault;
                            }

                        }
                    }

                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                        choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            return productDefault;
                        }
                    } else {
                        product.setCategory(category);
                        count = 3;
                        break;
                    }
                }
            }
            if (count == 3) {
                while (true) {
                    showProductNewInfor(product);

                    System.out.print("Products in stock: ");
                    final int productsInStock = input_int();

                    System.out.print("Insert(y/n): ");
                    String choice1 = yesno();
                    if (choice1.equalsIgnoreCase("N")) {
                        System.out.print("Continue Insert(y/n): ");
                        choice1 = yesno();
                        if (choice1.equalsIgnoreCase("N")) {
                            return productDefault;
                        }

                    } else {
                        product.setProductsInStock(productsInStock);
                        count = 4;
                        break;
                    }
                }
            }
            if (count == 4) {
                showProductNewInfor(product);
                System.out.print("Insert staff(y/n): ");
                final String choice1 = yesno();
                if (choice1.equalsIgnoreCase("N")) {
                    return productDefault;
                } else {
                    return product;
                }
            }

        }
    }

    public static void inputInfoUpdate() {

        boolean back = true;
        final Scanner sc = new Scanner(System.in);
        final Product product = new Product();
        final ProductBL productBL = new ProductBL();
        while (back) {
            cls();
            showProduct();

            System.out.print(" --> Enter id (0 to come back): ");
            final int id = input_int();
            final List<Product> la = ProductBL.getAllById(id);
            if (id == 0) {
                back = false;
                break;
            } else if (la.size() == 0) {
                System.out.printf(" Not found, Press '%s' to go back:", "Enter");
                final String nh = sc.nextLine();
            } else {

                product.setProductId(id);

                final List<Product> lp = productBL.getAllById(id);
                for (final Product product1 : lp) {
                    product.setProductName(product1.getProductName());
                    product.setPrice(product1.getPrice());
                    product.setCategory(product1.getCategory());
                    product.setProductsInStock(product1.getProductsInStock());
                }
                back = true;
                while (back) {

                    showProductNewInfor(product);
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("|            0: Come back  ||  (OK/ok): Update          |");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.print(" --> Enter your choice: ");
                    final String chose = sc.nextLine();
                    switch (chose) {
                        case "0":
                            back = false;
                            break;
                        case "ok":
                            System.out.printf(" Do you want to update(y/n): ");
                            String choice = yesno();
                            if (choice.equalsIgnoreCase("y")) {
                                try {
                                    productBL.Update(product);
                                    System.out.printf(" Press '%s' to go back:", "Enter");
                                    final String nh = sc.nextLine();
                                    back = false;
                                    break;
                                } catch (final Exception e) {
                                    System.err.println(" Insert account failed!");
                                }
                            } else {
                                System.out.println(" Update stopped !");
                                System.out.printf(" Press '%s' to go back:", "Enter");
                                final String nh = sc.nextLine();
                                back = false;
                                break;
                            }
                        case "OK":
                            System.out.printf(" Do you want to update(y/n):");
                            choice = yesno();
                            if (choice.equalsIgnoreCase("y")) {
                                try {
                                    productBL.Update(product);
                                    System.out.printf(" Press '%s' to go back:", "Enter");
                                    final String nh = sc.nextLine();
                                    back = false;
                                    break;
                                } catch (final Exception e) {
                                    System.err.println(" Insert account failed!");
                                }
                            } else {
                                System.out.println(" Update stopped !");
                                System.out.printf(" Press '%s' to go back:", "Enter");
                                final String nh = sc.nextLine();
                                back = false;
                                break;
                            }
                        case "2":
                            while (true) {
                                showProductNewInfor(product);
                                System.out.print("Unit price: ");
                                final Double price = input_double();
                                System.out.print("Insert(y/n): ");
                                final String choice1 = yesno();
                                if (choice1.equalsIgnoreCase("N")) {
                                    break;
                                } else {
                                    product.setPrice(price);

                                    break;
                                }
                            }
                            break;
                        case "3":
                            while (true) {
                                String category = null;
                                while (true) {
                                    showProductNewInfor(product);
                                    System.out.println(" 1. Drink / 2. Food / 3. Topping");
                                    System.out.print(" Product category: ");
                                    final int choice1 = input_int();
                                    if (choice1 == 1) {
                                        category = "Drink";
                                        break;
                                    } else if (choice1 == 2) {
                                        category = "Food";
                                        break;
                                    } else if (choice1 == 3) {
                                        category = "Topping";
                                        break;
                                    } else {
                                        System.out.print(" Not found! ");
                                        System.out.print(" Continue Insert(y/n): ");
                                        choice = yesno();
                                        if (choice.equalsIgnoreCase("N")) {
                                            continue;
                                        }

                                    }
                                }
                                System.out.print("Insert(y/n): ");
                                final String choice1 = yesno();
                                if (choice1.equalsIgnoreCase("N")) {
                                    break;
                                } else {
                                    product.setCategory(category);

                                    break;
                                }
                            }
                            break;
                        case "4":
                            while (true) {
                                showProductNewInfor(product);

                                System.out.print("Products in stock: ");
                                final int productsInStock = input_int();

                                System.out.print("Insert(y/n): ");
                                final String choice1 = yesno();
                                if (choice1.equalsIgnoreCase("N")) {
                                    break;
                                } else {
                                    product.setProductsInStock(productsInStock);

                                    break;
                                }
                            }
                            break;

                        case "1":
                            while (true) {
                                showProductNewInfor(product);
                                System.out.print("Product name: ");
                                final String name = inputString();
                                System.out.print("Insert(y/n): ");
                                final String choice1 = yesno();
                                if (choice1.equalsIgnoreCase("N")) {
                                    break;

                                } else {
                                    product.setProductName(name);

                                    break;
                                }
                            }
                        default:
                            System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                            final String nh = sc.nextLine();
                    }

                }

            }
        }
    }

    public static void inputProductsInStock() {
        boolean back = true;
        while (true) {
            cls();
            showProduct();
            final Scanner sc = new Scanner(System.in);
            System.out.print("ProductId(0 to come back): ");
            final int id = input_int();
            final List<Product> la = ProductBL.getAllById(id);
            if (id == 0) {
                back = false;
                break;
            } else if (la.size() == 0) {
                System.out.printf(" Press '%s' to go back:", "Enter");
                final String nh = sc.nextLine();
                back = false;
            } else {
                System.out.print("Products in stock: ");
                final int productsInStock = input_int();
                System.out.print("Do you want to update(y/n):");
                final String choice = yesno();
                if (choice.equalsIgnoreCase("y")) {
                    try {
                        productBL.UpdateProductsInStock(id, productsInStock);
                        showProduct();
                    } catch (final Exception e) {
                        System.out.println("Error. can't Update!");
                    }
                }
                System.out.print("Continued(y/n): ");
                final String x = yesno();
                if (x.equalsIgnoreCase("n")) {
                    back = false;
                    ;
                }
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
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (final Exception e) {
                System.out.print("  Wrong type, enter again: ");
            }
        }

    }

    private static String inputString() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Wrong type, enter again: ");

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
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (final Exception e) {
                System.out.print("  Wrong type, enter again: ");
            }
        }

    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }

}