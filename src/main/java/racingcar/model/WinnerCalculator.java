package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCalculator {

    public static List<String> findWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
