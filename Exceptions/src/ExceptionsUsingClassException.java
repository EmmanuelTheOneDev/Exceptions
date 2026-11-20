import java.io.IOException;

public class ExceptionsUsingClassException {

    private static class ExceptionA extends Exception {
        ExceptionA(String message) {
            super(message);
        }
    }

    private static class ExceptionB extends ExceptionA {
        ExceptionB(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        demonstrate(new ExceptionA("ExceptionA"));
        demonstrate(new ExceptionB("ExceptionB"));
        demonstrateNullPointer();
        demonstrateIOException();
    }

    private static void demonstrate(Exception exception) {
        try {
            throw exception;
        } catch (Exception caught) {
            printCaught(caught);
        }
    }

    private static void demonstrateNullPointer() {
        try {
            String value = null;
            value.length();
        } catch (Exception exception) {
            printCaught(exception);
        }
    }

    private static void demonstrateIOException() {
        try {
            throw new IOException("IOException");
        } catch (Exception exception) {
            printCaught(exception);
        }
    }

    private static void printCaught(Exception exception) {
        System.out.println("Caught " + exception.getClass().getSimpleName()
                + ": " + exception.getMessage());
    }
}
