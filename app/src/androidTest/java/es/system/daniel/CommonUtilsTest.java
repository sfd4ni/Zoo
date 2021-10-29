package es.system.daniel;

import static org.junit.Assert.fail;

import android.content.Context;


import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;

import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.model.Species;


public class CommonUtilsTest {

    public static Context appContext = null;
    public static Species species = null;
    public static SpeciesDbHelper speciesDbHelper;

    @BeforeClass
    public static void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            speciesDbHelper = new SpeciesDbHelper(appContext);
            species = new Species ("Cheetah", "Acinonyx jubatus", "Felines", false);
            speciesDbHelper.save(species);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:" + ex.getMessage());
        }
    }

}