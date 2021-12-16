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
	private ArrayList<Car> cars;

	public CarManager(String[] carNames) {
		lineUpCars(carNames);
	}

	private void lineUpCars(String[] carNames) {
		ArrayList<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		this.cars = cars;
	}
}
