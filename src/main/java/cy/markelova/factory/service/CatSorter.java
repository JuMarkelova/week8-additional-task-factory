package cy.markelova.factory.service;

import cy.markelova.factory.entity.Cat;
import cy.markelova.factory.util.CatAgeComparator;
import cy.markelova.factory.util.CatColorComparator;
import cy.markelova.factory.util.CatWeightComparator;

import java.util.List;

public class CatSorter {

    public static void sortCatsColorAgeWeight(List<Cat> cats) {
        cats.sort(new CatColorComparator().
                thenComparing(new CatAgeComparator()).
                thenComparing(new CatWeightComparator()));
    }
}