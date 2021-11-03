package es.system.daniel;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;

import static es.system.daniel.CommonUtilsTest.animalDbHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ModelAnimalUnitTest extends CommonUtilsTest {
    @Test
    public void findSpeciesTest() {
        Animal animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("" + animal.getZooId(), animalFind);
        assertEquals("Animal created is not equal to animal found.", animalFind, animal);
    }
}
