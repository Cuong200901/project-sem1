package vtc.ui.OrderUI;

import java.util.Scanner;

import vtc.dal.OrderDAL;

public class CompleteOrder {
    public static void completeOrder() {
        System.out.print("Enter table: ");
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