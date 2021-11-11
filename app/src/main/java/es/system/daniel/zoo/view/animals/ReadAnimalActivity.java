package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class ReadAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_zoo);
    }
    public void changeAnimalsView(View view) {
        Intent previousView = new Intent(ReadAnimalActivity.this,
                AnimalsActivity.class);
        startActivity(previousView);
    }
}