// package vtc.ui.OrderUI;

// import java.io.IOException;
// import java.util.Scanner;

// import vtc.bl.ProductBL;
// import vtc.dal.OrderDAL;

// public class CreateOrder {
//     static Scanner sc = new Scanner(System.in);

//     public static void createOrder(final int staff_id) {
//         int table_id;
//         String note;
//         int product_id;
//         int amount;
//         System.out.print("Enter table: ");
//         table_id = input_int();
//         System.out.print("Note: ");
//         note = sc.nextLine();
//         if (OrderDAL.createOrder(staff_id, table_id, note) == 3) {
//             while (true) {

//                 ProductBL.showProduct();
//                 System.out.print("Enter product id: ");
//                 product_id = input_int();
//                 System.out.print("Enter product amount: ");
//                 amount = input_int();
//                 System.out.print("Do you want to update(Y/N): ");
//                 String yn = yesno();
//                 if (yn.equals("y") || yn.equals("Y")) {
//                     OrderDAL.productsInOrder(product_id, amount);
//                 }
//                 System.out.print("Continue(Y/N): ");
//                 yn = yesno();
//                 if (yn.equals("n") || yn.equals("N")) {
//                     break;
//                 }

//             }
//         } else if (OrderDAL.createOrder(staff_id, table_id, note) == 0) {
//             System.out.println("Wrong table");
//             System.out.println(OrderDAL.createOrder(staff_id, table_id, note));
//             System.out.printf("Nhan %s de quay lai:", "Enter");
//             String nh = sc.nextLine();
//         }else if(OrderDAL.createOrder(staff_id, table_id, note) ==2)
//         {
//             System.out.println("Table exsit");
//             System.out.printf("Nhan %s de quay lai:", "Enter");
//           String  nh = sc.nextLine();
//         }

//     }

//     public static void updateOrder() {

       
//         int table_id;
//         int product_id;
//         int amount;

//         System.out.print("Enter table: ");
//         table_id = input_int();
//         if (OrderDAL.updateOrder(table_id) != 0) {
//             while (true) {
//                 cls();
//                 ProductBL.showProduct();
//                 System.out.print("Enter product id: ");
//                 product_id = input_int();
//                 System.out.print("Enter product amount: ");
//                 amount = input_int();
//                 System.out.print("Do you want to update(Y/N): ");
//                 String yn = yesno();
//                 if (yn.equals("y") || yn.equals("Y")) {
//                     OrderDAL.productsInOrder(product_id, amount);
//                 }
//                 System.out.print("Continue(Y/N): ");
//                 yn = yesno();
//                 if (yn.equals("n") || yn.equals("N")) {
//                     break;
//                 }

//             }
//         }
//         }


    

//     public static void cls() {
//         try {
//             if (System.getProperty("os.name").contains("Windows"))
//                 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//             else
//                 Runtime.getRuntime().exec("clear");
//         } catch (IOException | InterruptedException ignored) {
//         }
//     }


//     private static String input_string() {
//         final Scanner input = new Scanner(System.in);
//         String a;
//         while (true) {
//             a = input.nextLine();
//             if (a.trim().compareTo("") == 0) {
//                 System.out.print(" Nhap sai,moi nhap lai: ");

//             } else {
//                 return a.trim();
//             }
//         }

//     }



//     public static int input_int() {
//         final Scanner input = new Scanner(System.in);
//         int x = 0;
//         String a;
//         while (true) {
//             a = input.nextLine();
//             try {
//                 x = Integer.parseInt(a);
//                 if (x >= 0) {
//                     return x;
//                 }
//                 else{
//                     System.out.print("  Nhap sai,moi nhap lai: ");
//                 }
//             } catch (Exception e) {
//                 System.out.print("  Nhap sai,moi nhap lai: ");
            
//             }
//         }

//     }

//     public static String yesno() {
      
//         String yn = sc.nextLine();
//         if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
//             return yn;
//         }
//         return yn;
//     }



// }