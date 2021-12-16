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
	private static final String BLANK_ERROR_MESSAGE = "이름은 공백일 수 없다.";
	private static final String NOT_A_NUMBER_MESSAGE = "시도 횟수는 숫자로 입력해야 한다.";

	public String[] validateCarNames(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			carName = carName.trim();
			checkNameLength(carName);
			checkBlank(carName);
		}
		return carNames;
	}

	public int validatePlayTime(String input) {
		return stringToInteger(input);
	}

	private void checkNameLength(String carName) {
		if (carName.length() <= MAX_NAME_LENGTH) {
			return;
		}
		throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
	}

	private void checkBlank(String carName) {
		if (carName.length() > 0) {
			return;
		}
		throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
	}

	private int stringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
		}
	}
}
