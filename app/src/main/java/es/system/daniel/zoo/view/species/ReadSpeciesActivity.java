package es.system.daniel.zoo.view.species;

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
import es.system.daniel.zoo.model.Species;
import es.system.daniel.zoo.model.Zoo;
import es.system.daniel.zoo.view.zoos.ReadZooActivity;

public class ReadSpeciesActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> names;
    private AnimalDbHelper animalDbHelper;
    private SpeciesDbHelper speciesDbHelper;
    private ZooDbHelper zooDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_species);
        listview = findViewById(R.id.speciesListView);
        names = new ArrayList<>();

        speciesDbHelper = new SpeciesDbHelper(this);
        zooDbHelper = new ZooDbHelper(this);
        List<Species> speciesList = speciesDbHelper.getAll();
        for (Species species : speciesList) {
            names.add(species.getVulgarName());
            names.add(species.getScientificName());
            names.add(species.getFamily());
            names.add(species.isEndangered() ? "Si" : "No");
            names.add("-------------------------");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ReadSpeciesActivity.this, "Has pulsado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(ReadSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
}