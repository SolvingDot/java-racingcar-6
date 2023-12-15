package racingcar.view;

public enum ErrorMessage {
    ONLY_NUMERIC("자연수만 입력 가능합니다."),
    NAME_LENGTH("자동차 이름은 최대 5글자만 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
