public class RethrowingExceptions {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception exception) {
            throw exception;
        }
    }

    private static void someMethod2() throws Exception {
        throw new Exception("Exception initially thrown by someMethod2");
    }
}
