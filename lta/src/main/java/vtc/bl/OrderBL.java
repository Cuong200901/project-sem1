package vtc.bl;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import vtc.dal.OrderDAL;

public class OrderBL {
    static Scanner sc = new Scanner(System.in);

    public static void orderByMonth() {
        while (true) {
            int year = 0;
            year = input_int();
            if (year >= 1990 && year <= 2050) {
                OrderDAL.orderAmountByMonth(year);
                break;
            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showBill() {

        System.out.print("Enter id:");
        int id = input_int();     
            OrderDAL.showBill(id);
       

    }

    public static void monneyEarnerByMonth() {
        while (true) {
            int year = 0;
            year = input_int();
            if (year >= 1990 && year <= 2050) {
                OrderDAL.monneyEarnByMonth(year);
                ;
                break;
            } else {
                System.out.print(" Error! Enter again: ");
            }
        }
    }

    public static void showTableClear() {
        OrderDAL.showTableClear();
    }

    public static void showTableExit() {
        OrderDAL.showTableExsit();
    }

    public static void showOrderByDay() {
        System.out.print("Enter day:");
        String day = input_date();
        OrderDAL.showOrderByDay(day);
    }

    public static String input_date() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                a = LocalDate.parse(a, formatter).format(formatter2);
                return a;
            } catch (Exception e) {
                System.out.print("Error!, Enter again: ");
            }
        }
    }

    public static void completeOrder() {
        System.out.println("Enter table");
        int table = input_int();
        OrderDAL.completeOrder(table);
    }

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                return x;
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }
}