package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.MainActivity;
import es.system.daniel.zoo.view.species.CreateSpeciesActivity;
import es.system.daniel.zoo.view.species.DeleteSpeciesActivity;
import es.system.daniel.zoo.view.species.ReadSpeciesActivity;
import es.system.daniel.zoo.view.species.SpeciesActivity;
import es.system.daniel.zoo.view.species.UpdateSpeciesActivity;

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
    }
    public void changeMainView(View view) {
        Intent previousView = new Intent(AnimalsActivity.this,
                MainActivity.class);
        startActivity(previousView);
    }
    public void changeCreateView(View view) {
        Intent nextView = new Intent(AnimalsActivity.this,
                CreateAnimalActivity.class);
        startActivity(nextView);
    }
    public void changeReadView(View view) {
        Intent nextView = new Intent(AnimalsActivity.this,
                ReadAnimalActivity.class);
        startActivity(nextView);
    }
    public void changeUpdateView(View view) {
        Intent nextView = new Intent(AnimalsActivity.this,
                UpdateAnimalActivity.class);
        startActivity(nextView);
    }
    public void changeDeleteView(View view) {
        Intent nextView = new Intent(AnimalsActivity.this,
                DeleteAnimalActivity.class);
        startActivity(nextView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_animal, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent nextView = null;
        switch (item.getItemId()) {

            case R.id.deleteAnimal:
                nextView = new Intent(AnimalsActivity.this,
                        DeleteAnimalActivity.class);
                startActivity(nextView);
                return true;
            case R.id.updateAnimal:

                nextView = new Intent(AnimalsActivity.this,
                        UpdateAnimalActivity.class);
                startActivity(nextView);
                return true;
            case R.id.createAnimal:
                nextView = new Intent(AnimalsActivity.this,
                        CreateAnimalActivity.class);
                startActivity(nextView);
                return true;
            case R.id.readAnimal:
                nextView = new Intent(AnimalsActivity.this,
                        ReadAnimalActivity.class);
                startActivity(nextView);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }
}