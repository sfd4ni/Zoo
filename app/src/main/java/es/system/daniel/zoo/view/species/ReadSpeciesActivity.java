package es.system.daniel.zoo.view.species;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class ReadSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_species);
    }
    public void changeSpeciesView(View view) {
        Intent previousView = new Intent(ReadSpeciesActivity.this,
                SpeciesActivity.class);
        startActivity(previousView);
    }
}