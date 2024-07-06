package cy.markelova.factory._main;

import cy.markelova.factory.entity.Cat;
import cy.markelova.factory.entity.Factory;
import cy.markelova.factory.service.CatSorter;

import java.util.ArrayList;
import java.util.List;

public class _Main {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cats.add(Factory.getInstance().createCat());
        }

        System.out.println("Unsorted:");
        cats.forEach(System.out::println);

        System.out.println("\nSorted by color, age, weight:");
        CatSorter.sortCatsColorAgeWeight(cats);
        cats.forEach(System.out::println);
    }
}