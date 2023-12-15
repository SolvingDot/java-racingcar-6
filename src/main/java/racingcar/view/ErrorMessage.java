package racingcar.view;

public enum ErrorMessage {
    EMPTY_INPUT("아무 입력이 없습니다."),
    COMMA_PLACE("쉼표는 이름을 구분할 때만 사용해주세요."),
    SPACE("이름은 띄어쓰지 말고 입력해주세요."),
    NAME_LENGTH("자동차 이름은 최대 5글자만 가능합니다."),
    ONLY_NUMERIC("숫자만 입력 가능합니다."),
    ONE_OR_MORE("1 이상의 숫자만 입력 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
