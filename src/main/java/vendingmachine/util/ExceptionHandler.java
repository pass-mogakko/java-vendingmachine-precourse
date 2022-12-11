package vendingmachine.util;

import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T handleException(Supplier<T> readInput) {
        try {
            return readInput.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return handleException(readInput);
        }
    }
}
