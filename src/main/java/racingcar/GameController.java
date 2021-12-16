package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class GameController {
	private final Display display;

	public GameController() {
		this.display = new Display();
	}

	public void play() {
		display.askCarName();
		Console.readLine();
	}
}
