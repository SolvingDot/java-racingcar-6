package racingcar.view;

public class OutputView {
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

    private enum Message {
        OUTPUT_GAME_START("자동차 경주 게임을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
