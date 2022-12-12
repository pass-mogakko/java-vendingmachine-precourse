package vendingmachine.controller;

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
    }

    private void setUp() {
        int initMoney = handleInputException(InputView::readInitMoney);
        machine = new Machine(initMoney);

        List<CoinDto> coinDtos = machine.createCoinDto();
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

        OutputView.printUserMoney(userMoney);
        String productName = handleInputException(InputView::readProductName);
    }

}
