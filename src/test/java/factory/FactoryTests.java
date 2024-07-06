package factory;

import cy.markelova.factory.entity.Cat;
import cy.markelova.factory.entity.Color;
import cy.markelova.factory.entity.Factory;
import cy.markelova.factory.service.CatSorter;
import cy.markelova.factory.util.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FactoryTests {

    @Test
    public void testCreationTheOnlyFactory() {
        Factory factory = Factory.getInstance();
        Factory factoryNew = Factory.getInstance();
        Assert.assertEquals(factory, factoryNew, "There are more than one instances");
    }

    @Test
    public void testCreationCat() {
        Cat cat = new Cat(12, 3, Color.WHITE);
        Assert.assertEquals(cat.getID(), 1, "Wrong id");
        Assert.assertEquals(cat.getWeight(), 12.00, "Wrong weight");
        Assert.assertEquals(cat.getAge(), 3, "Wrong age");
        Assert.assertEquals(cat.getColor().name(), "WHITE", "Wrong color");
    }

    @Test
    public void testGenerationCatId() {
        Cat cat1 = new Cat(12, 3, Color.BROWN);
        Cat cat2 = new Cat(11, 4, Color.GREY);
        Cat cat3 = new Cat(11, 4, Color.BLACK);
        Assert.assertEquals(cat3.getID(), 3, "Wrong id");
    }

    @Test
    public void testRandomCatParameters() {
        DataGenerator generator = new DataGenerator();
        Cat cat = new Cat(generator.weightGenerator(),
                generator.ageGenerator(),
                Color.getRandomColor(generator.colorNumberGenerator()));
        Assert.assertTrue(0.5 <= cat.getWeight() && cat.getWeight() < 20.5, "Wrong generated weight");
        Assert.assertTrue(0 <= cat.getAge() && cat.getAge() < 18, "Wrong generated age");
        Assert.assertNotNull(cat.getColor(), "Wrong generated color");
    }

    @Test
    public void generateCatThroughFactory() {
        Factory factory = Factory.getInstance();
        Cat cat = null;
        cat = factory.createCat();
        Assert.assertNotNull(cat, "Error cat generation through factory");
    }

    @Test
    public void testSortingColor() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(10, 5, Color.WHITE));
        cats.add(new Cat(10, 5, Color.BROWN));
        cats.add(new Cat(10, 5, Color.BLACK));

        CatSorter.sortCatsColorAgeWeight(cats);
        Assert.assertEquals(cats.get(0).getID(), 3, "wrong sorting by color 1");
        Assert.assertEquals(cats.get(1).getID(), 2, "wrong sorting by color 2");
        Assert.assertEquals(cats.get(2).getID(), 1, "wrong sorting by color 3");
    }

    @Test
    public void testSortingAge() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(10, 5, Color.WHITE));
        cats.add(new Cat(10, 6, Color.BROWN));
        cats.add(new Cat(1, 8, Color.BROWN));

        CatSorter.sortCatsColorAgeWeight(cats);
        Assert.assertEquals(cats.get(0).getID(), 2, "wrong sorting by age 1");
        Assert.assertEquals(cats.get(1).getID(), 3, "wrong sorting by age 2");
        Assert.assertEquals(cats.get(2).getID(), 1, "wrong sorting by age 3");
    }

    @Test
    public void testSortingWeight() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(10, 5, Color.GREY));
        cats.add(new Cat(10, 6, Color.BROWN));
        cats.add(new Cat(1, 6, Color.BROWN));

        CatSorter.sortCatsColorAgeWeight(cats);
        Assert.assertEquals(cats.get(0).getID(), 3, "wrong sorting by weight 1");
        Assert.assertEquals(cats.get(1).getID(), 2, "wrong sorting by weight 2");
        Assert.assertEquals(cats.get(2).getID(), 1, "wrong sorting by weight 3");
    }


    @Test
    public void testSortingSameOrder() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(10, 6, Color.BROWN));
        cats.add(new Cat(10, 6, Color.BROWN));
        cats.add(new Cat(10, 6, Color.BROWN));

        CatSorter.sortCatsColorAgeWeight(cats);
        Assert.assertEquals(cats.get(0).getID(), 1, "wrong sorting 1");
        Assert.assertEquals(cats.get(1).getID(), 2, "wrong sorting 2");
        Assert.assertEquals(cats.get(2).getID(), 3, "wrong sorting 3");
    }
}