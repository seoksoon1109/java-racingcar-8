package racingcar.model.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateCarNames(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] names = input.split(",");
        Set<String> uniqueNames = new HashSet<>();

        for (String rawName : names) {
            String name = rawName.trim();

            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백으로 설정할 수 없습니다!");
            }

            if (name.length() < 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (!uniqueNames.add(name)){
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public static void validateTryCount(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
