
import java.util.Scanner;

public class cafe02 {

    public static void Menu(String customerName, boolean isMember) {
        System.out.println("Welcome, " + customerName + "!");
        if (isMember) {
            System.out.println("You are a member, enjoy 10% off every purchase!");
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

    public static int calculateTotalPriceAttendanceNo(int menuChoice, int itemCount) {
        int[] itemPrices = {15000, 20000, 22000, 12000, 10000, 18000};
        if (menuChoice < 1 || menuChoice > itemPrices.length) {
            System.out.println("Menu not available");
            return 0;
        }
        return itemPrices[menuChoice - 1] * itemCount;
    }

    public static int calculateDiscount(int total, String promoCode, boolean isMember) {
        int promoPercent = 0;
        if ("DISCOUNT50".equals(promoCode)) {
            promoPercent = 50;
        } else if ("DISCOUNT30".equals(promoCode)) {
            promoPercent = 30;
        } else {
            System.out.println("Invalid promo code");
        }

        int memberPercent = isMember ? 10 : 0;
        int totalDiscountPercent = promoPercent + memberPercent;

        // Multiply first before dividing by 100 to prevent integer truncation
        return (total * totalDiscountPercent) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Are you a member (y/n)? ");
        boolean isMember = sc.nextLine().trim().equalsIgnoreCase("y");

        Menu(customerName, isMember);

        int grandTotal = 0;
        String moreOrders;
        do {
            System.out.print("\nEnter the menu number you want to order: ");
            int menuChoice = sc.nextInt();

            if (menuChoice < 1 || menuChoice > 6) {
                System.out.println("Menu not available");
            } else {
                System.out.print("Enter the number of items you want to order: ");
                int itemCount = sc.nextInt();
                int subtotal = calculateTotalPriceAttendanceNo(menuChoice, itemCount);
                grandTotal += subtotal;
                System.out.println("Item subtotal: Rp" + subtotal);
            }

            System.out.print("Order another menu item? (y/n): ");
            moreOrders = sc.next();
        } while (moreOrders.equalsIgnoreCase("y"));

        sc.nextLine(); // consume trailing newline
        System.out.print("Enter promo code (or press Enter for none): ");
        String promoCode = sc.nextLine().trim();

        int discountAmount = calculateDiscount(grandTotal, promoCode, isMember);
        int amountToPay = grandTotal - discountAmount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total price: Rp" + grandTotal);
        System.out.println("Discount amount: Rp" + discountAmount);
        System.out.println("Total to be paid: Rp" + amountToPay);

        sc.close();
    }
}