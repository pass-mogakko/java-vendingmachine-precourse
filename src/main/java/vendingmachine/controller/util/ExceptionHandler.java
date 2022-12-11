package vendingmachine.controller.util;

import java.util.function.Consumer;

public class ExceptionHandler {
    public static void retryForIllegalArgument(Runnable runnable, Consumer<String> errorPrint) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException exception) {
                errorPrint.accept(exception.getMessage());
            }
        }
    }
}
