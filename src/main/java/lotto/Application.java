package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView,outputView);
        lottoController.start();

    }

}
