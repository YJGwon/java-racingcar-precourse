package racingcar.view;

import racingcar.model.Car;

/**
 * 사용자에게 보여지는 출력을 담당하는 view class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class Display {
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PLAY_TIME_QUESTION = "시도할 회수는 몇회인가요?";

	private static final String ERROR_FORMAT = "[ERROR] %s%n";
	private static final String WINNER_FORMAT = "최종 우승자 : %s%n";

	public void askCarName() {
		System.out.println(CAR_NAME_QUESTION);
	}

	public void askPlayTime() {
		System.out.println(PLAY_TIME_QUESTION);
	}

	public void printCar(Car car) {
		System.out.println(car.toString());
	}

	public void printWinner(String winner) {
		System.out.printf(WINNER_FORMAT, winner);
	}

	public void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
