package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.animals.AnimalsActivity;
import es.system.daniel.zoo.view.animals.DeleteAnimalActivity;

public class DeleteSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_species);
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(DeleteSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
}