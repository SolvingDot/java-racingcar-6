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
        recordPlaceOfCar(numberOfTrials, placeOfCar);
        return placeOfCar;
    }

    private static void recordPlaceOfCar(int numberOfTrials, List<Integer> placeOfCar) {
        int place = NOT_START;
        for (int trial = NOT_START; trial < numberOfTrials; trial++) {
            int randomNumber = makeRandomNumber();
            recordPlace(placeOfCar, randomNumber, place);
        }
    }

    private static void recordPlace(List<Integer> placeOfCar, int randomNumber, int place) {
        place += movement.readGoOrStop(randomNumber);
        placeOfCar.add(place);
    }

    private static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER,MAXIMUM_NUMBER);
    }
}
