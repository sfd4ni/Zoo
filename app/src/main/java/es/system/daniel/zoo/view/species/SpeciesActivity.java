package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.MainActivity;
import es.system.daniel.zoo.view.zoos.CreateZooActivity;
import es.system.daniel.zoo.view.zoos.DeleteZooActivity;
import es.system.daniel.zoo.view.zoos.ReadZooActivity;
import es.system.daniel.zoo.view.zoos.UpdateZooActivity;
import es.system.daniel.zoo.view.zoos.ZoosActivity;

public class SpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);
    }
    public void changeMainView(View view) {
        Intent previousView = new Intent(SpeciesActivity.this,
                MainActivity.class);
        startActivity(previousView);
    }

    public void changeUpdateSpeciesView(View view) {
        Intent nextView = new Intent(SpeciesActivity.this,
                UpdateSpeciesActivity.class);
        startActivity(nextView);
    }
    public void changeCreateSpeciesView(View view) {
        Intent nextView = new Intent(SpeciesActivity.this,
                CreateSpeciesActivity.class);
        startActivity(nextView);
    }
    public void changeReadSpeciesView(View view) {
        Intent nextView = new Intent(SpeciesActivity.this,
                ReadSpeciesActivity.class);
        startActivity(nextView);
    }
    public void changeDeleteSpeciesView(View view) {
        Intent nextView = new Intent(SpeciesActivity.this,
                DeleteSpeciesActivity.class);
        startActivity(nextView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_species, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent nextView = null;
        switch (item.getItemId()) {

            case R.id.deleteSpecies:
                nextView = new Intent(SpeciesActivity.this,
                        DeleteSpeciesActivity.class);
                startActivity(nextView);
                return true;
            case R.id.updateSpecies:

                nextView = new Intent(SpeciesActivity.this,
                        UpdateSpeciesActivity.class);
                startActivity(nextView);
                return true;
            case R.id.createSpecies:
                nextView = new Intent(SpeciesActivity.this,
                        CreateSpeciesActivity.class);
                startActivity(nextView);
                return true;
            case R.id.readSpecies:
                nextView = new Intent(SpeciesActivity.this,
                        ReadSpeciesActivity.class);
                startActivity(nextView);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }
}