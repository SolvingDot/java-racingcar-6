package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int FIRST_INDEX = 0;
    private static final String FORMAT_RACING = "%s : %s";
    private static final String DASH = "-";

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }
    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(Message.OUTPUT_GAME_START.message);
        System.out.println(); // 출력하고 한줄 띄우기 (선택)
    }

    public void printRacingResult(int numberOfTrials, Map<String, List<Integer>> racingResultTable) {
        System.out.println(Message.OUTPUT_RACING_RESULT.message);
        for (int index = FIRST_INDEX; index < numberOfTrials; index++) {
            for (String carName : racingResultTable.keySet()) {
                int count = racingResultTable.get(carName).get(index);
                System.out.println(String.format(FORMAT_RACING, carName, DASH.repeat(count)));
            }
            System.out.println();
        }
    }

    public void printWinner(String winner) {
        System.out.println(String.format(Message.OUTPUT_WINNER.message, winner));
    }

    private enum Message {
        OUTPUT_GAME_START("자동차 경주 게임을 시작합니다."),
        OUTPUT_RACING_RESULT("실행 결과"),
        OUTPUT_WINNER("최종 우승자 : %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
