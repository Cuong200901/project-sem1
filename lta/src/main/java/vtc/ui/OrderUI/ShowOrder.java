// package vtc.ui.OrderUI;

// import java.util.Scanner;

// import vtc.dal.OrderDAL;

// public class ShowOrder {
//     public static void orderByMonth() {
//         while (true) {
//             int year = 0;
//             System.out.print("Enter year: ");
//             year = input_int();
//             if (year >= 1990 && year <= 2050) {
//                 OrderDAL.orderAmountByMonth(year);
//                 break;
//             } else {
//                 System.out.print(" Error! Enter again: ");
//             }
//         }
//     }

//     public static void showBill() {

//         System.out.print("Enter id:");
//         int id = input_int();     
//             OrderDAL.showBill(id);
       

//     }

//     public static void monneyEarnerByMonth() {
//         while (true) {
//             int year = 0;
//             System.out.print("Enter year: ");
//             year = input_int();
//             if (year >= 1990 && year <= 2050) {
//                 OrderDAL.monneyEarnByMonth(year);
//                 ;
//                 break;
//             } else {
//                 System.out.print(" Error! Enter again: ");
//             }
//         }
//     }

//     public static void showTableClear() {
//         OrderDAL.showTableClear();
//     }

//     public static void showTableExit() {
//         OrderDAL.showTableExsit();
//     }

    
//     public static int input_int() {
//         final Scanner input = new Scanner(System.in);
//         int x = 0;
//         String a;
//         while (true) {
//             a = input.nextLine();
//             try {
//                 x = Integer.parseInt(a);
//                 if (x > 0) {
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

// }