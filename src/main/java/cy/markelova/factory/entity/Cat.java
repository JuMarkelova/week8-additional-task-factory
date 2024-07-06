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
        return String.format("Cat id %-3d | color: %-7s | age: %2d full year(s) | weight: %5.2f kg ",
                ID, color, age, weight);
    }
}