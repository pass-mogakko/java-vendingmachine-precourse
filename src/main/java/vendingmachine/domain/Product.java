package vendingmachine.domain;

import java.util.regex.Pattern;
import vendingmachine.constant.Constant;
import vendingmachine.constant.ErrorMessage;

public class Product {

    private static final String PRODUCT_FORM_REGEX = "^\\[[^ ]+,[0-9]+,[0-9]+\\]$";
    private final String name;
    private final int price;
    private int count;

    public Product(String userInput) {
        validateUserInput(userInput);
        userInput = deleteBrackets(userInput);
        String[] parsedUserInput = userInput.split(Constant.PRODUCT_SPLIT_REGEX);
        name = parsedUserInput[0];
        price = Integer.parseInt(parsedUserInput[1]);
        count = Integer.parseInt(parsedUserInput[2]);
        validateUserInput();
    }

    private String deleteBrackets(String userInput) {
        return userInput.substring(1, userInput.length() - 1);
    }

    private void validateUserInput(String userInput) {
        if (!Pattern.matches(PRODUCT_FORM_REGEX, userInput)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRODUCT_INPUT_FORM);
        }
    }

    private void validateUserInput() {
        if (price < Constant.PRODUCT_PRICE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRODUCT_PRICE);
        }
        if (price % Constant.TEN_WON_VALUE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_BE_DIVISIBLE_TEN_WON);
        }
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void buy() {
        if (count == 0) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_SOLD_OUT);
        }
        count--;
    }

    public boolean isSoldOut() {
        return count == 0;
    }

    public int getPrice() {
        return price;
    }
}
