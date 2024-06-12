package random;

public class Factory {
	
	public static void main(String[] args) {
		foodFactory myFoods = new foodFactory();
		Food food1 = myFoods.getFood("Fastfood");
		Food food2 = myFoods.getFood("Fruits");
		System.out.println("My name is:" + food1.getClass().getName());
		System.out.println("My name is:" + food2.getClass().getName());
		System.out.println("Our superclass is:" + food1.getClass().getSuperclass().getName());
		food1.servesFood();
		food2.servesFood();
	}

}
