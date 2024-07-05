package cy.markelova.factory.util;

public class DataGenerator {

    public double weightGenerator() {
        return Math.random() * 20 + 0.5;
    }

    public int ageGenerator() {
        return (int) (Math.random() * 18);
    }

    public int colorNumberGenerator() {
        return (int) (Math.random() * 100);
    }
}