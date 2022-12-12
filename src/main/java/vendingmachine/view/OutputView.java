package vendingmachine.view;

import static vendingmachine.view.OutputMessageFactory.createErrorMessage;

public class OutputView {

    public static void printError(Exception e) {
        String errorMessage = createErrorMessage(e.getMessage());

        System.out.println();
        System.out.println(errorMessage);
        System.out.println();
    }

}
