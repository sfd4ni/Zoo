package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class UpdateAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_animal);
    }
    public void changeAnimalsView(View view) {
        Intent previousView = new Intent(UpdateAnimalActivity.this,
                AnimalsActivity.class);
        startActivity(previousView);
    }
}