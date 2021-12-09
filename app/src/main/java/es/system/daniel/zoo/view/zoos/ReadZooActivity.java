package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.platform.app.InstrumentationRegistry;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Zoo;
import es.system.daniel.zoo.view.animals.InfoAnimalActivity;

public class ReadZooActivity extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> names;
    private ZooDbHelper zooDbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_zoo);
        listview = findViewById(R.id.zoosListView);
        names = new ArrayList<>();

        zooDbHelper = new ZooDbHelper(this);
        List<Zoo> zoos = zooDbHelper.getAll();
        for (Zoo zoo : zoos) {
            names.add(zoo.getName());
            /*names.add(zoo.getCity());
            names.add(zoo.getCountry());
            names.add(zoo.getSize() + "");
            names.add(zoo.getYearlyIncome() + "");
            names.add("-------------------------");*/
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent myIntent = new Intent(ReadZooActivity.this, InfoZooActivity.class);
                myIntent.putExtra("Zoo", zoos.get(position));
                startActivity(myIntent);
            }
        });
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(ReadZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
}