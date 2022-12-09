package vendingmachine.util;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Utils {

    public static final String NUMBER_REGEX = "^[0-9]+$";

    public static boolean isNumber(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

    public static <T> T requestInput(Supplier<T> requestInputFunction, Consumer<String> printErrorFunction) {
        try {
            return requestInputFunction.get();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return requestInput(requestInputFunction, printErrorFunction);
        }
    }

    public static void exceptionHandlingRepeatSelf(Runnable action, Consumer<String> printErrorFunction) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            exceptionHandlingRepeatSelf(action, printErrorFunction);
        }
    }
}
