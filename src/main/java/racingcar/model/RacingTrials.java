package racingcar.model;

import java.util.regex.Pattern;
import racingcar.view.ErrorMessage;

public class RacingTrials {
    private static final int ONE = 1;

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public int read(String input) {
        validateEmptyInput(input);
        validateNumeric(input);
        int numberOfTrials = Integer.parseInt(input);
        validateOneOrMore(numberOfTrials);
        return numberOfTrials;
    }

    private static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMERIC.getMessage());
        }
    }

    private static void validateOneOrMore(int numberOfTrials) {
        if (numberOfTrials < ONE) {
            throw new IllegalArgumentException(ErrorMessage.ONE_OR_MORE.getMessage());
        }
    }
}
