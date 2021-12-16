package racingcar;

/**
 * 사용자에게 보여지는 출력을 담당하는 view class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class Display {
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public void askCarName() {
		System.out.println(CAR_NAME_QUESTION);
	}
}
