
public class cafevisitors02 {

    static void listVisitors(int tableNumber, String... visitorNames) {
        System.out.println("Table " + tableNumber + " - Visitor Name List:");
        for (String name : visitorNames) {
            System.out.println("- " + name);
        }
    }

    static int calculateTotalPurchase(int... prices) {
        int total = 0;
        for (int price : prices) {
            total += price;
        }
        return total;
    }

    public static void main(String[] args) {
        listVisitors(1, "Ali", "Budi", "Citra");
        listVisitors(2, "Andi");
        listVisitors(3, "Doni", "Eti", "Fahmi", "Galih");
        listVisitors(4); // zero varargs arguments

        String[] guests = {"Rina", "Sari"};
        listVisitors(5, guests); // passing an array directly

        System.out.println("\nTotal (1 item): Rp" + calculateTotalPurchase(15000));
        System.out.println("Total (3 items): Rp" + calculateTotalPurchase(15000, 20000, 12000));
        System.out.println("Total (5 items): Rp" + calculateTotalPurchase(15000, 20000, 22000, 12000, 10000));
    }
}