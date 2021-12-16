package racingcar;

import java.util.ArrayList;

/**
 * 게임에 참가한 자동차들을 관리하는 service class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class CarManager {
	private static final String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 있습니다.";

	private final ArrayList<Car> cars = new ArrayList<>();

	public CarManager(String[] carNames) {
		lineUpCars(carNames);
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
