package vendingmachine.view;

import vendingmachine.domain.dto.CoinDto;

import java.util.List;

public class OutputMessageFactory {
    private static final String ERROR_FORM = "[ERROR] %s";
    static final String COIN_INFO = "%s - %s";
    static final String LINE_SEPARATOR = "\n";

    public static String createErrorMessage(String message) {
        return String.format(ERROR_FORM, message);
    }

    static String createCoinInfo(List<CoinDto> coinDtos) {
        String result = "";
        for (CoinDto coinDto : coinDtos) {
            result += String.format(COIN_INFO, coinDto.getName(), coinDto.getCnt());
            result += LINE_SEPARATOR;
        }
        return result;
    }

}
