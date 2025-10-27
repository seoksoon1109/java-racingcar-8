package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    // 각 시도별 자동차 이동 결과 출력
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getPositionBar());
        }
        System.out.println(); // 한 턴이 끝난 후 줄바꿈
    }

    // 최종 우승자 출력 (공동 우승자 쉼표로 구분)
    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
