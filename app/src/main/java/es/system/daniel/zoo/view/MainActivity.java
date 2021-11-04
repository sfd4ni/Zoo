package es.system.daniel.zoo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

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
}