package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;
import es.system.daniel.zoo.model.Animal;

public class UpdateAnimalActivity extends AppCompatActivity {

    private AnimalDbHelper animalDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_animal);
        this.animalDbHelper = new AnimalDbHelper(this);
        Animal animal = (Animal) getIntent().getSerializableExtra("Animal");
        if (animal!=null) {
            EditText editTextId = (EditText) this.findViewById(R.id.editTextId);
            EditText editTextSex = (EditText) this.findViewById(R.id.editTextSex);
            EditText editTextCountry = (EditText) this.findViewById(R.id.editTextCountry);
            EditText editTextContinent = (EditText) this.findViewById(R.id.editTextContinent);
            EditText editTextSpeciesId = (EditText) this.findViewById(R.id.editTextSpecies);
            EditText editTextZooId = (EditText) this.findViewById(R.id.editTextZoo);
            EditText editTextBirthYear = (EditText) this.findViewById(R.id.editTextBirth);

            editTextBirthYear.setText(animal.getBirthYear()+"");
            editTextZooId.setText(animal.getZooId()+"");
            editTextContinent.setText(animal.getContinent());
            editTextCountry.setText(animal.getCountry());
            editTextId.setText(animal.getId()+"");
            editTextSex.setText(animal.getSex());
            editTextSpeciesId.setText(animal.getSpeciesId()+"");
        }
    }
    public void changeAnimalsView(View view) {
        Intent previousView = new Intent(UpdateAnimalActivity.this,
                AnimalsActivity.class);
        startActivity(previousView);
    }
    public void updateAnimal(View view) {
        EditText editTextId = (EditText) this.findViewById(R.id.editTextId);
        EditText editTextSex = (EditText) this.findViewById(R.id.editTextSex);
        EditText editTextCountry = (EditText) this.findViewById(R.id.editTextCountry);
        EditText editTextContinent = (EditText) this.findViewById(R.id.editTextContinent);
        EditText editTextSpeciesId = (EditText) this.findViewById(R.id.editTextSpecies);
        EditText editTextZooId = (EditText) this.findViewById(R.id.editTextZoo);
        EditText editTextBirthYear = (EditText) this.findViewById(R.id.editTextBirth);

        String id = editTextId.getText().toString();
        String sex = editTextSex.getText().toString();
        String country = editTextCountry.getText().toString();
        String continent = editTextContinent.getText().toString();
        String speciesId = editTextSpeciesId.getText().toString();
        String zooId = editTextZooId.getText().toString();
        String birthYear = editTextBirthYear.getText().toString();

        if (!id.equals("") && !sex.equals("") && !country.equals("") && !continent.equals("") &&
                !speciesId.equals("") && !zooId.equals("") && !birthYear.equals("")) {
            Integer idFin = null;
            Integer speciesIdFin = null;
            Integer zooIdFin = null;
            Integer birthYearFin = null;
            try {
                idFin = Integer.parseInt(id);
                speciesIdFin = Integer.parseInt(speciesId);
                zooIdFin = Integer.parseInt(zooId);
                birthYearFin = Integer.parseInt(birthYear);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Animal animal = new Animal(sex, country, continent,
                    idFin, speciesIdFin, zooIdFin, birthYearFin);
            animalDbHelper.update(animal, animal.getId()+"");
        }
    }
}