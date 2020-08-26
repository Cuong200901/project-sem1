package vtc.bl;

import java.time.Year;
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

    public static void monneyEarnerByMonth() {
        while (true) {
            int year = 0;
        year = input_int();
        if (year >= 1990 && year <= 2050) {
            OrderDAL.monneyEarnByMonth(year);;
            break;
        } else {
            System.out.print(" Error! Enter again: ");
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
                return x;
            } catch (Exception e) {
                System.out.print("  Nhap sai,moi nhap lai: ");
            }
        }

    }
}