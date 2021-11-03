package es.system.daniel;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;


import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ModelSpeciesUnitTest extends CommonUtilsTest {

    @Test
    public void findSpeciesTest() {
        Species speciesFind = speciesDbHelper.getById(species.getVulgarName());
        assertNotNull("Species found is null", speciesFind);
        assertEquals("Species created is not equal to species found.", speciesFind, species);
    }

    @Test
    public void updateSpeciesTest() {
        Species speciesFind = speciesDbHelper.getById(species.getVulgarName());
        assertNotNull("Species found is null", speciesFind);
        Species speciesUpdated = new Species ("Cheetah", "Acinonyx jubatus2", "Felines2", true);
        speciesDbHelper.update(speciesUpdated, species.getVulgarName());
        speciesFind = speciesDbHelper.getById(species.getVulgarName());
        assertNotNull("Species encontrado ahora es nulo", speciesFind);
        assertEquals("Species created is not equal to animal found.", speciesFind, speciesUpdated);
        // We set it up to what it was before
        speciesDbHelper.update(species, speciesUpdated.getVulgarName());
    }
}