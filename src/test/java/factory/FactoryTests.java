package factory;

import cy.markelova.factory.entity.Cat;
import cy.markelova.factory.entity.Color;
import cy.markelova.factory.entity.Factory;
import cy.markelova.factory.util.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        System.out.println(cat);
        Assert.assertTrue(0.5 <= cat.getWeight() && cat.getWeight() < 20.5, "Wrong generated weight");
        Assert.assertTrue(0 <= cat.getAge() && cat.getAge() < 18, "Wrong generated age");
        Assert.assertNotNull(cat.getColor(), "Wrong generated color");
    }
}