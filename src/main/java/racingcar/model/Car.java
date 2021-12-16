package racingcar.model;

public class Car {
	private static final String TO_STRING_CONJUNCTION = " : ";
	private static final char POSITION_CHAR = '-';

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

	public boolean isPosition(int position) {
		return this.position >= position;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name);
		stringBuilder.append(TO_STRING_CONJUNCTION);
		for (int i = 0; i < position; i++) {
			stringBuilder.append(POSITION_CHAR);
		}
		return stringBuilder.toString();
	}

	public void move() {
		this.position++;
	}
}
