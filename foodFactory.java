package random;

public class foodFactory extends Food {

	public Food getFood(String string) {
		if (string.equals("Fruit")) {
			return new Fruit("Fruit");
		} else {
			return new FastFood("FastFood");
		}
	}

}
