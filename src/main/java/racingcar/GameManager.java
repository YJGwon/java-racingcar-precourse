package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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
	private static final String WINNER_NAME_DELIMITER = ", ";
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int CRITERION = 4;

	private final Display display;
	private final ArrayList<Car> cars = new ArrayList<>();

	private int playTime;
	private int maxPosition;

	public GameManager(String[] carNames, Display display) {
		lineUpCars(carNames);
		this.display = display;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public void play() {
		for (int i = 0; i < playTime; i++) {
			tryToMove();
		}
	}

	public void announceWinner() {
		setMaxPosition();
		display.printWinner(cars.stream().filter(car -> car.isPosition(maxPosition))
								.map(Car::getName)
								.collect(Collectors.joining(WINNER_NAME_DELIMITER)));
	}

	private void lineUpCars(String[] carNames) {
		for (String carName : carNames) {
			checkNameDuplicate(carName);
			cars.add(new Car(carName));
		}
	}

	private void tryToMove() {
		for (Car car : cars) {
			if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= CRITERION) {
				car.move();
			}
			display.printCar(car);
		}
	}

	private void setMaxPosition() {
		this.maxPosition =  cars.stream()
								.max(Comparator.comparingInt(Car::getPosition))
								.get().getPosition();
	}

	private void checkNameDuplicate(String carName) {
		if (cars.stream().noneMatch(car -> car.isName(carName))) {
			return;
		}
		throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
	}
}
