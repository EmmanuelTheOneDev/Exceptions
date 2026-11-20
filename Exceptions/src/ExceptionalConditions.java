import java.util.InputMismatchException;
import java.util.Scanner;


public class ExceptionalConditions {

    public static void main(String[] args) {
        demonstrateInvalidInput();
        demonstrateDivisionByZero();
        demonstrateNullReference();
        demonstrateInvalidArrayIndex();
    }

    private static void demonstrateInvalidInput() {

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter a letter: ");
                int number = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("InputMismatchException");
            }

    }

    private static void demonstrateDivisionByZero() {
        int numerator = 10;
        int denominator = 0;

        try {
            denominator = numerator / denominator;
        }
        catch (ArithmeticException exception) {
            System.out.println("Division by zero");
        }
    }

    private static void demonstrateNullReference() {
        String message = null;

        try {
            message.length();
        }
        catch (NullPointerException exception) {
            System.out.println("Null pointer");
        }
    }

    private static void demonstrateInvalidArrayIndex() {
        int[] numbers = {10, 20, 30};

        try {
            int number = numbers[4];
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Array index out of bounds");
        }
    }
}
