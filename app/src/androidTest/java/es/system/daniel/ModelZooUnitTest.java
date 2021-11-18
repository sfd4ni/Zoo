package es.system.daniel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class ModelZooUnitTest extends CommonUtilsTest {
    @Test
    public void findZooTest() {
        Zoo zooFind = zooDbHelper.getById(zoo.getName());
        assertNotNull("Zoo found is null", zooFind);
        assertEquals("Zoo created is not equal to zoo found.", zooFind, zoo);
    }
    @Test
    public void updateZooTest() {
        Zoo zooFind = zooDbHelper.getById(zoo.getName());
        assertNotNull("Zoo found is null", zooFind);
        Zoo zooUpdated = new Zoo("Central Park Zoo", "Los Angeles", "USA", 300000, 30000000);
        zooDbHelper.update(zooUpdated, zoo.getName());
        zooFind = zooDbHelper.getById(zoo.getName());
        assertNotNull("Species encontrado ahora es nulo", zooFind);
        assertEquals("Species created is not equal to animal found.", zooFind, zooUpdated);
        // We set it up to what it was before
        zooDbHelper.update(zoo, zooUpdated.getName());
    }

    @Test
    public void findAllZoosTest() {
        List<Zoo> zoos = zooDbHelper.getAll();
        assertNotNull("Zoo found is null", zoos);
        Assert.assertTrue("There must be at least one species on the db", zoos.size() > 0);
    }
}
