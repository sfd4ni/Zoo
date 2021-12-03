package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(CreateSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
    public void insertSpecies(View view) {

        EditText editTextVulgarName = (EditText) this.findViewById(R.id.editTextVulgarName);
        EditText editTextScientificName = (EditText) this.findViewById(R.id.editTextScientificName);
        EditText editTextFamily = (EditText) this.findViewById(R.id.editTextFamily);
        Spinner spinnerEndangered = (Spinner) this.findViewById(R.id.spinner);

        String vulgarName = editTextVulgarName.getText().toString();
        String scientificName = editTextScientificName.getText().toString();
        String family = editTextFamily.getText().toString();
        String endangered = spinnerEndangered.getSelectedItem().toString();

        if (!vulgarName.equals("")  && !scientificName.equals("")
            && !family.equals("") && !endangered.equals("")) {
            Boolean endangeredBool = false;
            try {
                endangeredBool = endangered.equals("Yes");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Species species = new Species(vulgarName, scientificName, family, endangeredBool);
            speciesDbHelper.save(species);
        }
    }
}