package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarPlaceRecorder;
import racingcar.model.RacingJudge;
import racingcar.model.RacingTrials;
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
        List<String> carNames = readCarNames();
        int numberOfTrials = readRacingTrials();

        Map<String, List<Integer>> racingResultTable = playCarRacing(carNames, numberOfTrials);
        String winner = readWinner(racingResultTable);
        printRacingResults(numberOfTrials, racingResultTable, winner);
    }

    private List<String> readCarNames() {
        final Car car = new Car();
        return car.readName(inputView.readCarName());
    }

    private int readRacingTrials() {
        final RacingTrials racingTrials = new RacingTrials();
        return racingTrials.read(inputView.readNumber());
    }

    private static Map<String, List<Integer>> playCarRacing(List<String> carNames, int numberOfTrials) {
        final CarPlaceRecorder recorder = new CarPlaceRecorder();
        Map<String, List<Integer>> racingResultTable = new LinkedHashMap<>();
        for (String name : carNames) {
            racingResultTable.put(name, recorder.record(numberOfTrials));
        }
        return racingResultTable;
    }

    private static String readWinner(Map<String, List<Integer>> racingResultTable) {
        final RacingJudge judge = new RacingJudge();
        return judge.readWinners(racingResultTable);
    }

    private void printRacingResults(int numberOfTrials, Map<String, List<Integer>> racingResultTable, String winner) {
        outputView.printRacingResult(numberOfTrials, racingResultTable);
        outputView.printWinner(winner);
    }
}
