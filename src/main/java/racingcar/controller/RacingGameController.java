package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.WinnerCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        // 1️⃣ 사용자 입력 받기
        String carNamesInput = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        // 2️⃣ 자동차 객체 생성
        Cars cars = new Cars(carNamesInput);

        // 3️⃣ 결과 안내 메시지 출력
        OutputView.printResultMessage();

        // 4️⃣ 시도 횟수만큼 반복하면서 각 라운드 실행
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            OutputView.printCars(cars);
        }

        // 5️⃣ 우승자 계산 및 출력
        OutputView.printWinners(WinnerCalculator.findWinners(cars));
    }
}
