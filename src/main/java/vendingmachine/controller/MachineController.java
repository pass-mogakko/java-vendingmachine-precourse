package vendingmachine.controller;

import vendingmachine.view.InputView;

public class MachineController {
    public void run() {
        createCoins();
    }

    private void createCoins() {
        String machineMoney = InputView.readMachineMoney();
    }
}
