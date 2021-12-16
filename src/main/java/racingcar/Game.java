package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @since 1.0
 * @version 1.0
 */
public class Game {
	private final Display display;
	private final InputValidator inputValidator;

	private CarManager carManager;

	public Game() {
		this.display = new Display();
		this.inputValidator = new InputValidator();
	}

	public void play() {
		display.askCarName();
		try {
			this.carManager = new CarManager(inputValidator.validateCarNames(Console.readLine()));
		} catch (IllegalArgumentException e) {
			display.printError(e);
		}
	}
}
