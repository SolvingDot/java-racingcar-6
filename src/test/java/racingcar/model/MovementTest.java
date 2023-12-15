package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovementTest {
    private static final int STOP = 0;
    private static final int GO = 1;

    @DisplayName("숫자가 4보다 작으면 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void createNumberLessThanFour(int randomNumber) {
        // Given
        Movement movement = new Movement();

        // When
        int move = movement.readGoOrStop(randomNumber);

        // Then
        assertThat(move).isEqualTo(STOP);
    }

    @DisplayName("숫자가 4 이상이면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8,  9})
    @ParameterizedTest
    void createNumberFourOrOver(int randomNumber) {
        // Given
        Movement movement = new Movement();

        // When
        int move = movement.readGoOrStop(randomNumber);

        // Then
        assertThat(move).isEqualTo(GO);
    }
}