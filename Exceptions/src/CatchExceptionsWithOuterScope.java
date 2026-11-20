public class CatchExceptionsWithOuterScope {

    public static void main(String[] args) {
        try {
            performOperations();
        } catch (ArithmeticException exception) {
            System.out.println("Outer scope caught: " + exception.getClass().getSimpleName());
        }
    }

    private static void performOperations() {
        try {
            System.out.println("Method's try block is running.");
            int result = 10 / 0;
            System.out.println(result);
        } catch (NullPointerException exception) {
            System.out.println("Method caught: " + exception);
        }
    }
}
