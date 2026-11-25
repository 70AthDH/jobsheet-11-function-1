
import java.util.Scanner;

public class cafe02 {

    public static void Menu(String customerName, boolean isMember, int visitHour) {
        System.out.println("Welcome, " + customerName + "!");
        if (isMember) {
            System.out.println("You are a member, enjoy 10% off every purchase!");
        }
        if (visitHour >= 14 && visitHour <= 16) {
            System.out.println("Happy Hour! 20% discount on all drinks");
        }
        System.out.println("===== CAFE RESTAURANT MENU =====");
        System.out.println("1. Black Coffee Rp 15,000");
        System.out.println("2. Cappuccino Rp 20,000");
        System.out.println("3. Latte Rp 22,000");
        System.out.println("4. Teh Tarik Rp 12,000");
        System.out.println("5. Toast Rp 10,000");
        System.out.println("6. Fried Noodles Rp 18,000");
        System.out.println("=====================");
        System.out.println("Please choose the menu you would like.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Are you a member (y/n)? ");
        boolean isMember = sc.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Enter visit hour (0-23): ");
        int visitHour = sc.nextInt();

        Menu(customerName, isMember, visitHour);
        sc.close();
    }
}