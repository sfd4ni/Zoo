package es.system.daniel.zoo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.system.daniel.R;

public class ReadZooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_zoo);
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(ReadZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
}