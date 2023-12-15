package racingcar.model;

import java.util.List;
import racingcar.util.Util;
import racingcar.view.ErrorMessage;

public class Car {
    private static final String COMMA = ",";
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    private static final int MAXIMUM_LENGTH = 5;

    public List<String> readName(String input) {
        validateEmptyInput(input);
        validateEndWithComma(input);
        List<String> carNames = Util.splitByComma(input);
        validateEmptyName(carNames);
        validateNameHasBlank(carNames);
        validateNameLength(carNames);
        return carNames;
    }

    private static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateEndWithComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateEmptyName(List<String> names) {
        if (names.contains(EMPTY)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_PLACE.getMessage());
        }
    }

    private static void validateNameHasBlank(List<String> names) {
        for (String name : names) {
            if (name.contains(BLANK)) {
                throw new IllegalArgumentException(ErrorMessage.SPACE.getMessage());
            }
        }
    }

    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
            }
        }
    }
}
