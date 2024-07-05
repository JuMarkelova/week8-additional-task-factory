package cy.markelova.factory.entity;

import cy.markelova.factory.util.DataGenerator;

public class Factory {
    private static Factory instance;
    private final DataGenerator generator = new DataGenerator();

    private Factory() {
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Cat createCat() {
        return new Cat(generator.weightGenerator(),
                generator.ageGenerator(),
                Color.getRandomColor(generator.colorNumberGenerator()));
    }
}