package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Machine;
import vendingmachine.domain.dto.request.ProductDto;
import vendingmachine.domain.dto.response.CoinDto;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

import static vendingmachine.util.ExceptionHandler.*;

public class MachineController {
    private Machine machine;

    public void run() {
        setUp();
        register();
        consume();
        finish();
    }

    private void setUp() {
        int initMoney = handleInputException(InputView::readInitMoney);
        machine = new Machine(initMoney);

        machine.setUpRandomCoins(initMoney);
        List<CoinDto> coinDtos = machine.generateInitCoinDto();
        OutputView.printInitCoins(coinDtos);
    }

    private void register() {
        List<ProductDto> productDto = handleInputException(InputView::readProductInfo);
        productDto.forEach(dto
                -> machine.registerProduct(dto.getName(), dto.getPrice(), dto.getCount()));
    }

    private void consume() {
        int userMoney = handleInputException(InputView::readUserMoney);
        machine.setUserMoney(userMoney);
        repeatSelecting();
    }

    private void repeatSelecting() {
        while (machine.available()) {
            try {
                selectProduct();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    };

    private void selectProduct() {
        int userMoney = machine.getUserMoney();
        OutputView.printUserMoney(userMoney);
        String productName = handleInputException(InputView::readProductName);
        machine.consumeProduct(productName);
    }

    private void finish() {
        int userMoney = machine.getUserMoney();
        Coins resultCoins = new Coins();
        resultCoins.generateResultCoins(userMoney);
        List<CoinDto> resultDtos = machine.generateResultCoinDtos();
        OutputView.printResult(resultDtos);
    }

}
