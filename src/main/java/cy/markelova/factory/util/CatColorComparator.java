package cy.markelova.factory.util;

import cy.markelova.factory.entity.Cat;

import java.util.Comparator;

public class CatColorComparator implements Comparator<Cat> {

    public int compare(Cat cat1, Cat cat2) {
        return cat1.getColor().name().compareTo(cat2.getColor().name());
    }
}