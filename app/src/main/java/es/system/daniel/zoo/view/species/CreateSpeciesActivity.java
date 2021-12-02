package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.view.animals.AnimalsActivity;
import es.system.daniel.zoo.view.animals.DeleteAnimalActivity;

public class CreateSpeciesActivity extends AppCompatActivity {

    public SpeciesDbHelper speciesDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_species);
        speciesDbHelper = new SpeciesDbHelper(this);
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(CreateSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
    public void insertSpecies(View view) {
        EditText editTextVulgarName = (EditText) this.findViewById(R.id.editTextId);
        EditText editTextScientificName = (EditText) this.findViewById(R.id.editTextSex);
        EditText editTextFamily = (EditText) this.findViewById(R.id.editTextCountry);
        EditText editTextEndangered = (EditText) this.findViewById(R.id.editTextContinent);

        String vulgarName = editTextVulgarName.getText().toString();
        String scientificName = editTextScientificName.getText().toString();
        String family = editTextFamily.getText().toString();
        String endangered = editTextEndangered.getText().toString();

        if (!vulgarName.equals("")  && !scientificName.equals("")
            && !family.equals("") && !endangered.equals("")) {
            Boolean endangeredBool = false;
            try {
                endangeredBool = endangered.equals("si");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Species species = new Species(vulgarName, scientificName, family, endangeredBool);
            speciesDbHelper.save(species);
        }
    }
}