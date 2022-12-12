package vendingmachine.util;

import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T handleInputException(Supplier<T> readInput) {
        try {
            return readInput.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return handleInputException(readInput);
        }
    }

    public static void handleAllException(Runnable doAction) {
        try {
            doAction.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            handleAllException(doAction);
        }
    }

    public static <T> T repeatWhenExceptionOccurs(Supplier<T> doAction) {
        try {
            return doAction.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return repeatWhenExceptionOccurs(doAction);
        }
    }

}
