package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.validator.InputValidator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력값 검증 테스트")
class InputValidationTest {

    @Test
    @DisplayName("자동차 이름이 6자 이상이면 예외 발생")
    void shouldThrowExceptionWhenNameIsTooLong() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 비어있으면 예외 발생")
    void shouldThrowExceptionWhenNameIsBlank() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백으로 설정할 수 없습니다!");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재하면 예외 발생")
    void shouldThrowExceptionWhenDuplicateNameExists() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,pobi,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하이면 예외 발생")
    void shouldThrowExceptionWhenRoundIsInvalid() {
        assertThatThrownBy(() -> InputValidator.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이여야 합니다.");
    }

    @Test
    @DisplayName("유효한 입력은 예외 없이 통과한다")
    void shouldPassWhenInputIsValid() {
        assertThatCode(() -> InputValidator.validateCarNames("pobi,woni"))
                .doesNotThrowAnyException();
        assertThatCode(() -> InputValidator.validateTryCount("3"))
                .doesNotThrowAnyException();
    }
}
