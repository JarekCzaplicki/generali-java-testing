package tdd;

public class Meal {
    private final int price;
    private final String name;

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }
}
