package racingcar;

public class Car {
	private static final String TO_STRING_CONJUNCTION = " : ";
	private static final char POSITION_CHAR = '-';

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public boolean isName(String name) {
		return this.name.equals(name);
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
