package cy.markelova.factory.util;

public class DataGenerator {

    public double generateWeight() {
        return Math.random() * 20 + 0.5;
    }

    public int generateAge() {
        return (int) (Math.random() * 18);
    }
}