package es.system.daniel.zoo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class ZoosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoos);
    }
    public void changeMainView(View view) {
        Intent previousView = new Intent(ZoosActivity.this,
                MainActivity.class);
        startActivity(previousView);
    }
    public void changeUpdateZooView(View view) {
        Intent previousView = new Intent(ZoosActivity.this,
                UpdateZooActivity.class);
        startActivity(previousView);
    }
    public void changeCreateZooView(View view) {
        Intent previousView = new Intent(ZoosActivity.this,
                CreateZooActivity.class);
        startActivity(previousView);
    }
    public void changeReadZooView(View view) {
        Intent previousView = new Intent(ZoosActivity.this,
                ReadZooActivity.class);
        startActivity(previousView);
    }
    public void changeDeleteZooView(View view) {
        Intent previousView = new Intent(ZoosActivity.this,
                DeleteZooActivity.class);
        startActivity(previousView);
    }
}