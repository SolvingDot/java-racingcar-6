package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Movement {
    private static final int MOVE_CONDITION = 4;
    private static final int STOP = 0;
    private static final int GO = 1;

    public int readGoOrStop(int randomNumber) {
        if (randomNumber < MOVE_CONDITION) {
            return STOP;
        }
        return GO;
    }
}
