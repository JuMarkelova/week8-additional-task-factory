package cy.markelova.factory.entity;

public class Cat {

    private static long idCounter = 1;
    private final long ID;
    private double weight;
    private int age;
    private Color color;

    public Cat(double weight, int age, Color color) {
        this.ID = generateId();
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    private long generateId() {
        return idCounter++;

    }

    public long getID() {
        return ID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return String.format("Cat %d. color: %s, weight: %.2f kg, age: %d full year(s)", ID, color, weight, age);
    }
}