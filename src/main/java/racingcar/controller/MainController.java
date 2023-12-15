package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarPlaceRecorder;
import racingcar.model.RacingJudge;
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
        final Car car = new Car();
        List<String> carNames = car.readName(inputView.readCarName());

        // 시도할 횟수 입력 (String number -> Int numberOfTrials)
        int numberOfTrials = 0;

        // 자동차 전진 기록, 출력 (names, numberOfTrials)
        Map<String, List<Integer>> racingResultTable = playCarRacing(carNames, numberOfTrials);
        outputView.printRacingResult(numberOfTrials, racingResultTable);

        // 최종 우승자 결정, 출력
        RacingJudge judge = new RacingJudge();
        String winner = judge.readWinners(racingResultTable);
        outputView.printWinner(winner);
    }

    private static Map<String, List<Integer>> playCarRacing(List<String> carNames, int numberOfTrials) {
        final CarPlaceRecorder recorder = new CarPlaceRecorder();
        Map<String, List<Integer>> racingResultTable = new LinkedHashMap<>();
        for (String name : carNames) {
            racingResultTable.put(name, recorder.record(numberOfTrials));
        }
        return racingResultTable;
    }
}
