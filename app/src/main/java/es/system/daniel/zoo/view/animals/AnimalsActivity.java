package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.MainActivity;

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoos);
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
}