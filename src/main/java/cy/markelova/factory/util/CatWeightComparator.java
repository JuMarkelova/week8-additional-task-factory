package cy.markelova.factory.util;

import cy.markelova.factory.entity.Cat;

import java.util.Comparator;

public class CatWeightComparator implements Comparator<Cat> {

    public int compare(Cat cat1, Cat cat2) {
        return Double.compare(cat1.getWeight(), cat2.getWeight());
    }
}