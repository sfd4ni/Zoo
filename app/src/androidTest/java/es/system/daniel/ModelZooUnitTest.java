package es.system.daniel;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ModelZooUnitTest extends CommonUtilsTest {
    @Test
    public void findUserTest() {
        Zoo zooFind = zooDbHelper.getById(zoo.getName());
        assertNotNull("Zoo found is null", zooFind);
        assertEquals("Zoo created is not equal to zoo found.", zooFind, zoo);
    }
}
