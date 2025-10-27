package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.WinnerCalculator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCalculatorTest {

    static class TestCar extends Car {
        private final int fixedPosition;

        public TestCar(String name, int fixedPosition) {
            super(name);
            this.fixedPosition = fixedPosition;
        }

        @Override
        public int getPosition() {
            return fixedPosition;
        }

        @Override
        protected int generateRandomValue() {
            return 9;
        }

        @Override
        public void move() {
        }
    }

    private void injectCars(Cars carsObj, List<Car> newCars) throws Exception {
        Field field = Cars.class.getDeclaredField("cars");
        field.setAccessible(true);
        field.set(carsObj, newCars);
    }

    @DisplayName("단일 우승자를 올바르게 판별한다")
    @Test
    void findSingleWinner() throws Exception {
        Cars cars = new Cars("pobi,woni,jun");
        injectCars(cars, Arrays.asList(
                new TestCar("pobi", 3),
                new TestCar("woni", 5),
                new TestCar("jun", 2)
        ));

        List<String> winners = WinnerCalculator.findWinners(cars);

        assertThat(winners).containsExactly("woni");
    }

    @DisplayName("공동 우승자를 올바르게 판별한다")
    @Test
    void findMultipleWinners() throws Exception {
        Cars cars = new Cars("pobi,woni,jun");
        injectCars(cars, Arrays.asList(
                new TestCar("pobi", 5),
                new TestCar("woni", 5),
                new TestCar("jun", 3)
        ));

        List<String> winners = WinnerCalculator.findWinners(cars);

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @DisplayName("모든 자동차가 같은 위치일 때 전부 공동 우승 처리된다")
    @Test
    void allCarsSamePosition() throws Exception {
        Cars cars = new Cars("pobi,woni,jun");
        injectCars(cars, Arrays.asList(
                new TestCar("pobi", 4),
                new TestCar("woni", 4),
                new TestCar("jun", 4)
        ));

        List<String> winners = WinnerCalculator.findWinners(cars);

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
