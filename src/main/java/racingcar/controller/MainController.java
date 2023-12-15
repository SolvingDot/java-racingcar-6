package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printGameStart();
        // 자동차 이름 입력 (String name -> List<String> names)

        // 시도할 횟수 입력 (String number -> Int numberOfTrials)

        // 자동차 전진 기록, 출력 (names, numberOfTrials)

        // 최종 우승자 결정, 출력
    }
}
