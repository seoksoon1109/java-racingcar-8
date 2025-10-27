package racingcar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체 테스트")
class CarTest {

    static class FixedCar extends Car {
        private final int fixedValue;

        FixedCar(String name, int fixedValue) {
            super(name);
            this.fixedValue = fixedValue;
        }

        @Override
        protected int generateRandomValue() {
            return fixedValue;
        }
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 move()가 position을 증가시킨다")
    void shouldMoveWhenRandomValueIsGreaterOrEqualToFour() {
        Car car = new FixedCar("pobi", 5);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 move()가 position을 증가시키지 않는다")
    void shouldNotMoveWhenRandomValueIsLessThanFour() {
        Car car = new FixedCar("woni", 3);
        car.move();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("getPositionBar()는 위치에 맞는 '-'를 반환한다")
    void shouldReturnCorrectPositionBar() {
        Car car = new FixedCar("pobi", 5);
        car.move();
        car.move();
        assertThat(car.getPositionBar()).isEqualTo("--");
    }
}
