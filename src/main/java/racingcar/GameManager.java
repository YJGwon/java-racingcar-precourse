package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 게임 진행을 담당하는 service class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class GameManager {
	private static final String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 있습니다.";
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int CRITERION = 4;

	private final ArrayList<Car> cars = new ArrayList<>();
	private int playTime;

	public GameManager(String[] carNames) {
		lineUpCars(carNames);
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public void tryToMove() {
		for (Car car : cars) {
			if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= CRITERION) {
				car.move();
			}
		}
	}

	private void lineUpCars(String[] carNames) {
		for (String carName : carNames) {
			checkNameDuplicate(carName);
			cars.add(new Car(carName));
		}
	}

	private void checkNameDuplicate(String carName) {
		if (cars.stream().noneMatch(car -> car.isName(carName))) {
			return;
		}
		throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
	}
}
