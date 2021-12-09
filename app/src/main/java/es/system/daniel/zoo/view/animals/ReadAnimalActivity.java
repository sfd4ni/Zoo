package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;
import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Animal;

public class ReadAnimalActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> names;
    private AnimalDbHelper animalDbHelper;
    private ZooDbHelper zooDbHelper;
    private SpeciesDbHelper speciesDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_animal);

        listview = findViewById(R.id.animalsListView);
        names = new ArrayList<>();
        speciesDbHelper = new SpeciesDbHelper(this);
        animalDbHelper = new AnimalDbHelper(this);
        zooDbHelper = new ZooDbHelper(this);
        List<Animal> animals = animalDbHelper.getAll();
        for (Animal animal : animals) {
            if (speciesDbHelper.getByNumericId(animal.getSpeciesId()) != null) {
                names.add(animal.getId() + ", " + speciesDbHelper.getByNumericId(animal.getSpeciesId()).getVulgarName());
            }
            /*names.add(animal.getCountry());
            names.add(animal.getBirthYear()+"");
            names.add(speciesDbHelper.getByNumericId(animal.getSpeciesId()).getVulgarName());
            names.add(animal.getContinent());
            names.add(animal.getSex());
            names.add(zooDbHelper.getByNumericId(animal.getZooId()).getName());
            names.add("-------------------------");*/
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent myIntent = new Intent(ReadAnimalActivity.this, InfoAnimalActivity.class);
                myIntent.putExtra("Animal", animals.get(position));
                startActivity(myIntent);
            }
        });
    }
    public void changeAnimalsView(View view) {
        Intent previousView = new Intent(ReadAnimalActivity.this,
                AnimalsActivity.class);
        startActivity(previousView);

    }
}