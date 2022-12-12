package vendingmachine.view;

import vendingmachine.domain.dto.response.CoinDto;

import java.util.List;

public class OutputMessageFactory {
    private static final String ERROR_FORM = "[ERROR] %s";
    private static final String COIN_INFO = "%s - %s개";
    private static final String LINE_SEPARATOR = "\n";
    private static final String USER_MONEY_INFO = "투입 금액: %s원";

    static String createErrorMessage(String message) {
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

    static String createResultInfo(List<CoinDto> coinDtos) {
        StringBuilder result = new StringBuilder();
        for (CoinDto coinDto : coinDtos) {
            if (coinDto.getCnt() == 0) {
                continue;
            }
            result.append(String.format(COIN_INFO, coinDto.getName(), coinDto.getCnt()));
            result.append(LINE_SEPARATOR);
        }
        return result.toString();
    }

    static String createUserMoneyInfo(int userMoney) {
        return String.format(USER_MONEY_INFO, userMoney);
    }

}
