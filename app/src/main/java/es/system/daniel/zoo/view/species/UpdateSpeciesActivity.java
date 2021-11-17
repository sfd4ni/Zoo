package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class UpdateSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_species);
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(UpdateSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
}