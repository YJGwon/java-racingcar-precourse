package racingcar;

/**
 * 입력값 가공과 검증을 담당하는 service class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class InputValidator {
	private static final String CAR_NAME_SEPARATOR = ",";
	private static final int MAX_NAME_LENGTH = 5;

	private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5자를 넘을 수 없다.";
	public String[] validateCarNames(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			carName = carName.trim();
			checkNameLength(carName);
		}
		return carNames;
	}

	private void checkNameLength(String carName) {
		if(carName.length() <= MAX_NAME_LENGTH) {
			return;
		}
		throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
	}
}
