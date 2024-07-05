package factory;

import cy.markelova.factory.entity.Factory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactoryTests {

    @Test
    public void testCreationTheOnlyFactory() {
        Factory factory = Factory.getInstance();
        Factory factoryNew = Factory.getInstance();
        Assert.assertEquals(factory, factoryNew, "There are more than one instances");
    }
}
