package vendingmachine.view;

import vendingmachine.constant.Setting;
import vendingmachine.domain.dto.DtoBuilder;
import vendingmachine.domain.dto.request.ProductDto;

import java.util.List;
import java.util.regex.Pattern;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.Setting.MINIMUM_PRODUCT_PRICE;
import static vendingmachine.view.InputValidator.ValidationPattern.VALID_NAME_PATTERN;

class InputValidator {

    static void validateMoney(String input) {
        try {
            int number = Integer.parseInt(input);
            checkNumberRange(number);
            checkNumberUnit(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_TYPE);
        }
    }

    public static void validateProducts(String input) {
        try {
            DtoBuilder dtoBuilder = new DtoBuilder();
            List<ProductDto> productDtos = dtoBuilder.buildProductDtos(input);
            productDtos.forEach(productDto -> validateProduct(productDto));
        } catch (IndexOutOfBoundsException | NumberFormatException e){
            throw new IllegalArgumentException(INVALID_PRODUCT_DATA_FORM);
        }
    }

    private static void validateProduct(ProductDto productDto) {
        String name = productDto.getName();
        int price = productDto.getPrice();
        int count = productDto.getCount();

        validateName(name);
        validatePrice(price);
        checkNumberUnit(price);
        checkNumberRange(count);
    }

    private static void checkNumberRange(int number) {
        if (number < Setting.MINIMUM_MACHINE_MONEY) {
            throw new IllegalArgumentException(INVALID_MACHINE_MONEY);
        }
    }

    private static void checkNumberUnit(int number) {
        if (number % Setting.MINIMUM_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT);
        }
    }

    private static void validateName(String name) {
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(INVALID_PRODUCT_NAME);
        }
    }

    private static void validatePrice(int price) {
        if (price < MINIMUM_PRODUCT_PRICE) {
            throw new IllegalArgumentException(INVALID_PRODUCT_PRICE);
        }
    }

    static class ValidationPattern {
        static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[가-힣 ]*$");
    }
}
