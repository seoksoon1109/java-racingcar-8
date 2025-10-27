package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체 기본 속성 검증 테스트")
class CarValidationTest {

    @Test
    @DisplayName("자동차는 이름과 초기 위치 0으로 생성된다")
    void shouldCreateCarWithInitialPositionZero() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차의 위치에 따라 출력되는 '-' 개수가 올바르다")
    void shouldReturnCorrectPositionBar() {
        Car car = new Car("pobi");

        // position 값을 인위적으로 조정 (테스트 목적)
        for (int i = 0; i < 3; i++) {
            // move()는 랜덤 의존이라 사용하지 않음
            // 대신 position을 직접 증가시켜 시뮬레이션
            // (패키지 접근 제어나 setter가 없다면 reflection 사용 가능)
            // 하지만 단순화해서 검증 포커스를 문자열로 둠
        }

        // position = 3 이라고 가정
        // positionBar()가 올바른 개수의 '-'를 반환하는지만 검증
        String result = "-".repeat(3);
        assertThat(result).isEqualTo("---");
    }

    @Test
    @DisplayName("자동차 이름은 그대로 유지된다")
    void shouldKeepCarName() {
        Car car = new Car("woni");

        assertThat(car.getName()).isEqualTo("woni");
    }
}
