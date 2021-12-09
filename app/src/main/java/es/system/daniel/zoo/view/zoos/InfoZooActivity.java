package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;
import es.system.daniel.zoo.dao.helpers.SpeciesDbHelper;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Zoo;
import es.system.daniel.zoo.view.animals.InfoAnimalActivity;
import es.system.daniel.zoo.view.animals.ReadAnimalActivity;
import es.system.daniel.zoo.view.animals.UpdateAnimalActivity;

public class InfoZooActivity extends AppCompatActivity {

    Zoo zoo;
    private ListView listview;
    private ArrayList<String> names;
    private AnimalDbHelper animalDbHelper;
    private ZooDbHelper zooDbHelper;
    private SpeciesDbHelper speciesDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_zoo);
        zoo = (Zoo) getIntent().getSerializableExtra("Zoo");
        listview = findViewById(R.id.animalsZooListView);
        names = new ArrayList<>();
        speciesDbHelper = new SpeciesDbHelper(this);
        animalDbHelper = new AnimalDbHelper(this);
        zooDbHelper = new ZooDbHelper(this);

        TextView txtViewName = (TextView) this.findViewById(R.id.textViewName);
        TextView txtViewCity = (TextView) this.findViewById(R.id.textViewCity);
        TextView txtViewCountry = (TextView) this.findViewById(R.id.textViewCountry);
        TextView txtViewSize = (TextView) this.findViewById(R.id.textViewSize);
        TextView txtViewYearlyIncome = (TextView) this.findViewById(R.id.textViewYearlyInc);

        txtViewName.setText(zoo.getName());
        txtViewCity.setText(zoo.getCity());
        txtViewCountry.setText(zoo.getCountry());
        txtViewSize.setText(zoo.getSize()+"");
        txtViewYearlyIncome.setText(zoo.getYearlyIncome()+"");


        List<Animal> animals = animalDbHelper.getByZooId(zooDbHelper.getId(zoo.getName()));
        //List<Animal> animals = animalDbHelper.getAll();
        System.out.println(animals.size());
        for (Animal animal : animals) {
            names.add(animal.getId() + ", " + speciesDbHelper.getByNumericId(animal.getSpeciesId()).getVulgarName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent myIntent = new Intent(InfoZooActivity.this, InfoAnimalActivity.class);
                myIntent.putExtra("Animal", animals.get(position));
                startActivity(myIntent);
            }
        });
    }
    public void changeShowView(View view) {
        Intent nextView = new Intent(InfoZooActivity.this,
                ReadZooActivity.class);
        startActivity(nextView);
    }
    public void deleteAnimal(View view) {
        zooDbHelper.delete(zoo.getName());
        Intent nextView = new Intent(InfoZooActivity.this,
                ReadZooActivity.class);
        startActivity(nextView);
    }

    public void updateAnimal(View view) {
        Intent myIntent = new Intent(InfoZooActivity.this, UpdateZooActivity.class);
        myIntent.putExtra("Zoo", zoo);
        startActivity(myIntent);
    }
}