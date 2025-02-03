import java.util.Scanner;

public class SquareRootCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        try {
            double num = Double.parseDouble(sc.nextLine());

            if (num < 0) {
                System.out.println("Error: Square root of a negative number is not defined for real numbers.");
            } else {
                System.out.println("Square root: " + Math.sqrt(num));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
        } finally {
            sc.close();
        }
    }
}
