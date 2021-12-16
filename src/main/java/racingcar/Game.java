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

	private GameManager gameManager;

	public Game() {
		this.display = new Display();
		this.inputValidator = new InputValidator();
	}

	public void run() {
		lineUpCars();
		preparePlayTime();
		gameManager.play();
		gameManager.getWinner();
	}

	private void lineUpCars() {
		display.askCarName();
		try {
			this.gameManager = new GameManager(inputValidator.validateCarNames(Console.readLine()), display);
		} catch (IllegalArgumentException e) {
			display.printError(e);
			lineUpCars();
		}
	}

	private void preparePlayTime() {
		display.askPlayTime();
		try {
			gameManager.setPlayTime(inputValidator.validatePlayTime(Console.readLine()));
		} catch (Exception e) {
			display.printError(e);
			preparePlayTime();
		}
	}
}
