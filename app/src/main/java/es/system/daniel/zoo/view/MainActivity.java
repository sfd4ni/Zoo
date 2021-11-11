package es.system.daniel.zoo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.animals.AnimalsActivity;
import es.system.daniel.zoo.view.zoos.ZoosActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeZoosView(View view) {
        Intent nextView = new Intent(MainActivity.this,
                ZoosActivity.class);
        startActivity(nextView);
    }
    public void changeAnimalsView(View view) {
        Intent nextView = new Intent(MainActivity.this,
                AnimalsActivity.class);
        startActivity(nextView);
    }
}