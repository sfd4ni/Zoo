package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;
import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Animal;

public class InfoAnimalActivity extends AppCompatActivity {

    Animal animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_animal);
        animal = (Animal) getIntent().getSerializableExtra("Animal");
        SpeciesDbHelper speciesDbHelper = new SpeciesDbHelper(this);
        ZooDbHelper zooDbHelper = new ZooDbHelper(this);
        TextView txtViewId = (TextView) this.findViewById(R.id.textViewId);
        TextView txtViewSex = (TextView) this.findViewById(R.id.textViewSex);
        TextView txtViewCountry = (TextView) this.findViewById(R.id.textViewCountry);
        TextView txtViewContinent = (TextView) this.findViewById(R.id.textViewContinent);
        TextView txtViewSpecies = (TextView) this.findViewById(R.id.textViewSpecies);
        TextView txtViewZoo = (TextView) this.findViewById(R.id.textViewZoo);
        TextView txtViewBirth = (TextView) this.findViewById(R.id.textViewBirth);
        txtViewId.setText(animal.getId()+"");
        txtViewBirth.setText(animal.getBirthYear()+"");
        txtViewContinent.setText(animal.getContinent());
        txtViewCountry.setText(animal.getCountry());
        txtViewSpecies.setText(speciesDbHelper.getByNumericId(animal.getSpeciesId()).getVulgarName());
        txtViewZoo.setText(zooDbHelper.getByNumericId(animal.getZooId()).getName());
        txtViewSex.setText(animal.getSex());
    }
    public void changeShowView(View view) {
        Intent nextView = new Intent(InfoAnimalActivity.this,
                ReadAnimalActivity.class);
        startActivity(nextView);
    }
    public void deleteAnimal(View view) {
        AnimalDbHelper animalDbHelper = new AnimalDbHelper(this);
        animalDbHelper.delete(animal.getId()+"");
        Intent nextView = new Intent(InfoAnimalActivity.this,
                ReadAnimalActivity.class);
        startActivity(nextView);
    }

    public void updateAnimal(View view) {
        Intent myIntent = new Intent(InfoAnimalActivity.this, UpdateAnimalActivity.class);
        myIntent.putExtra("Animal", animal);
        startActivity(myIntent);
    }
}