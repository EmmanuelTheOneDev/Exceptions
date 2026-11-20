public class ExceptionsWithSuperclass {

    public static class ExceptionA extends Exception {
        ExceptionA(String message) {
            super(message);
        }
    }

    public static class ExceptionB extends ExceptionA {
        ExceptionB(String message) {
            super(message);
        }
    }

    public static class ExceptionC extends ExceptionB {
        ExceptionC(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        demonstrateCatch(new ExceptionB("This is an ExceptionB"));
        demonstrateCatch(new ExceptionC("This is an ExceptionC"));
    }

    private static void demonstrateCatch(ExceptionA exception) {
        try {
            throw exception;
        } catch (ExceptionA caught) {
            System.out.println("Caught by catch (ExceptionA): "
                    + caught.getClass().getSimpleName() + " - " + caught.getMessage());
        }
    }
}
