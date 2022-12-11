package vendingmachine.view;

public class OutputMessageFactory {
    private static final String ERROR_FORM = "[ERROR] %s";

    public static String createErrorMessage(String message) {
        return String.format(ERROR_FORM, message);
    }

}
