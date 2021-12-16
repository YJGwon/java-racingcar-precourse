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

	public String[] validateCarNames(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for(String carName : carNames) {
			carName.trim();
		}
		return carNames;
	}
}
