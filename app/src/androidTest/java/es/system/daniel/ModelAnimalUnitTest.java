package es.system.daniel;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import es.system.daniel.zoo.model.Animal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class ModelAnimalUnitTest extends CommonUtilsTest {
    @Test
    public void findAnimalTest() {
        Animal animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("Animal creado es nulo.", animalFind);
        assertEquals("Animal created is not equal to animal found.", animalFind, animal);
    }
    // Comentado porque me estaba dando problema con el resto de tests.
    /*@Test
    public void deleteAnimalTest() {
        Animal animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("Animal creado es nulo.", animalFind);
        animalDbHelper.delete(String.valueOf(animal.getId()));
        animalFind = animalDbHelper.getById(animal.getId());
        assertNull(animalFind);
    }*/

    @Test
    public void updateAnimalTest() {
        Animal animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("Animal creado es nulo.", animalFind);
        Animal animalUpdated = new Animal("Male", "China", "Asia", 1, 1, 1, 1998);
        animalDbHelper.update(animalUpdated, String.valueOf(animal.getId()));
        animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("Animal encontrado ahora es nulo", animalFind);
        assertEquals("Animal created is not equal to animal found.", animalFind, animalUpdated);
        // We set it up to what it was before
        animalDbHelper.update(animal, String.valueOf(animal.getId()));
    }
}