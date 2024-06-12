package random;

public class Food {
    public String name = null;
    public void Food() {

    }
    public void Food(String string) {
        this.name = string;
    }
    public void servesFood() {
        System.out.println("I'm serving " + this.name);
    }
}
