package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }
    private InputView() {
    }

    public String readCarName() {
        System.out.println(Message.INPUT_CAR_NAME.message);
        String input = Console.readLine();
        System.out.println(); // 입력 받고 한줄 띄우기
        return input;
    }

    public String readNumber() {
        System.out.println(Message.INPUT_NUMBER_OF_TRIALS.message);
        String input = Console.readLine();
        System.out.println(); // 입력 받고 한줄 띄우기
        return input;
    }

    private enum Message {
        INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_NUMBER_OF_TRIALS("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
