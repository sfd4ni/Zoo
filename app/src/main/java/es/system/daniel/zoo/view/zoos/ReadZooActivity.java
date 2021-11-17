package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class ReadZooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_zoo);
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(ReadZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
}