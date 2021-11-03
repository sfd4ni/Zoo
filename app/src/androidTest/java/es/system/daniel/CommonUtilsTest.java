package es.system.daniel;

import static org.junit.Assert.fail;

import android.content.Context;


import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;

import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;
import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;


public class CommonUtilsTest {

    public static Context appContext = null;
    public static Species species = null;
    public static Zoo zoo = null;
    public static Animal animal = null;
    public static SpeciesDbHelper speciesDbHelper;
    public static ZooDbHelper zooDbHelper;
    public static AnimalDbHelper animalDbHelper;
    @BeforeClass
    public static void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            speciesDbHelper = new SpeciesDbHelper(appContext);
            zooDbHelper = new ZooDbHelper(appContext);
            animalDbHelper = new AnimalDbHelper(appContext);
            species = new Species ("Cheetah", "Acinonyx jubatus", "Felines", false);
            zoo = new Zoo("Central Park Zoo", "New York", "USA", 200000, 200000000);
            animal = new Animal("Female", "España", "Europa", 1, 1, 1, 1994);
            zooDbHelper.save(zoo);
            speciesDbHelper.save(species);
            animalDbHelper.save(animal);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:" + ex.getMessage());
        }
    }

}