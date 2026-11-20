public class CustomExceptionClass {

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

    public static class Phone {
        private final String name;
        private final String serialNumber;

        public Phone(String name, String serialNumber) throws ValidationException {
            if (name == null || name.isBlank()) {
                throw new ValidationException("Name cannot be empty.");
            }
            if (serialNumber == null || serialNumber.isBlank()) {
                throw new ValidationException("Serial number cannot be empty.");
            }
            if (serialNumber.length() != 16 ) {
                throw new ValidationException("Serial number must contain exactly 16 digits.");
            }
            this.name = name;
            this.serialNumber = serialNumber;
        }

        public String getInfo(){
            return "Phone Detail: " + name + " " + serialNumber;
        }
    }

    public static void main(String[] args) {
        demonstratePhone("Pixel", "1234567890123456");
        demonstratePhone("", "1234567890123456");
        demonstratePhone("iPhone", "12345");
    }

    private static void demonstratePhone(String name, String serialNumber) {
        try {
            Phone phone = new Phone(name, serialNumber);
            System.out.println("Created " + phone.getInfo());
        } catch (ValidationException exception) {
            System.out.println("Validation failed: " + exception.getMessage());
        }
    }
}
