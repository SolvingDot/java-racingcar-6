package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Movement;

public class CarPlaceRecorder {
    private static final int NOT_START = 0;
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    private static final Movement movement = new Movement();

    public List<Integer> record(int numberOfTrials) {
        List<Integer> placeOfCar = new ArrayList<>();
        return recordPlaceOfCar(numberOfTrials, placeOfCar);
    }

    private List<Integer> recordPlaceOfCar(int numberOfTrials, List<Integer> placeOfCar) {
        int place = NOT_START;
        for (int trial = NOT_START; trial < numberOfTrials; trial++) {
            int randomNumber = makeRandomNumber();
            place += movement.readGoOrStop(randomNumber);
            placeOfCar.add(place);
        }
        return placeOfCar;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER,MAXIMUM_NUMBER);
    }
}
