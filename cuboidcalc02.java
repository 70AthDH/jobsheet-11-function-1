
import java.util.Scanner;

public class cuboidcalc02 {

    static int calculateArea(int length, int width) {
        return length * width;
    }

    static int calculateVolume(int height, int a, int b) {
        return calculateArea(a, b) * height;
    }

    static int calculateCuboidSurfaceArea(int length, int width, int height) {
        return 2 * (calculateArea(length, width)
                + calculateArea(length, height)
                + calculateArea(width, height));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single interactive cuboid (e.g., length=4, width=3, height=5)
        System.out.print("Enter the length: ");
        int length = input.nextInt();

        System.out.print("Enter the width: ");
        int width = input.nextInt();

        System.out.print("Enter the height: ");
        int height = input.nextInt();

        int area = calculateArea(length, width);
        int surfaceArea = calculateCuboidSurfaceArea(length, width, height);
        int volume = calculateVolume(height, length, width);

        System.out.println("The area of the base rectangle is " + area);
        System.out.println("The surface area of the cuboid is " + surfaceArea);
        System.out.println("The volume of the cuboid is " + volume);

        // Testing 3 cuboids of different sizes
        int[][] cuboids = {
            {4, 3, 5},
            {2, 6, 4},
            {7, 2, 3}
        };

        System.out.println("\n--- Testing 3 Cuboids ---");
        for (int i = 0; i < cuboids.length; i++) {
            int l = cuboids[i][0];
            int w = cuboids[i][1];
            int h = cuboids[i][2];
            System.out.println("Cuboid " + (i + 1) + " (" + l + "x" + w + "x" + h + "): "
                    + "Base Area = " + calculateArea(l, w)
                    + ", Surface Area = " + calculateCuboidSurfaceArea(l, w, h)
                    + ", Volume = " + calculateVolume(h, l, w));
        }

        input.close();
    }
}