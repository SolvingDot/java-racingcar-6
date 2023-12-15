package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingJudge {
    private static final int ONE = 1;
    private static final int FIRST_INDEX = 0;
    private static final String COMMA = ", ";

    public String readWinners(Map<String, List<Integer>> racingResultTable) {
        List<String> winnerNames = decideWinners(racingResultTable);
        if (winnerNames.size() > ONE) {
            return winnerNames.stream().collect(Collectors.joining(COMMA));
        }
        return winnerNames.get(FIRST_INDEX);
    }

    private static List<String> decideWinners(Map<String, List<Integer>> racingResultTable) {
        Map<String, Integer> carPositionTable = readLastPositionOfCars(racingResultTable);
        List<String> winnerNames = readTheFurthestCar(carPositionTable);
        return winnerNames;
    }

    private static List<String> readTheFurthestCar(Map<String, Integer> carPositionTable) {
        int maxPosition = Collections.max(carPositionTable.values());
        List<String> winnerNames = carPositionTable.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxPosition))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return winnerNames;
    }

    private static Map<String, Integer> readLastPositionOfCars(Map<String, List<Integer>> racingResultTable) {
        Map<String, Integer> carPositionTable = new LinkedHashMap<>();
        for (String carName : racingResultTable.keySet()) {
            int lastPosition = Collections.max(racingResultTable.get(carName));
            carPositionTable.put(carName, lastPosition);
        }
        return carPositionTable;
    }
}
