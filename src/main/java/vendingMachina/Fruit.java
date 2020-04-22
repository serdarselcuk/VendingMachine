package vendingMachina;

public class Fruit {

    public String name;
    public String color;
    private int price;

    public Fruit(String color, int price) {
        this.name = "fruit";
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format( "I'm an %s and I am the color %s and I cost $%s dollars.", this.name, this.color, this.price);
    }
}

class Orange extends Fruit {

    public Orange(String name) {
        super("orange", 3);
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Apple extends Fruit {

    private String color;


    public Apple(String name) {

        super("red", 3);
        super.color = this.color;


    }
    public void setName(String name) {
        this.name = name;
    }
}

class HoneyCrispApple extends Apple {

    private boolean isMultiColored = true;

    public HoneyCrispApple(String name) {

        super(name);

    }

    public void setName(String name) {
        this.name = name;
    }

}

class FruitStand {
    public static void main(String[] args) {
        Fruit banana = new Fruit("yellow", 1);
        banana.name = "Banana";
        System.out.println(banana);
        System.out.println(new Orange("Orange"));
        System.out.println(new Orange("Navel Orange"));
        System.out.println(new Apple("Red Delicious"));
        System.out.println(new HoneyCrispApple("Honey Crisp Apple"));
        Apple apple = new HoneyCrispApple("");
        apple.setName("Honey Crisp Apple");
        System.out.println(apple);
    }
}