package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.daniel.R;

public class DeleteZooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_zoo);
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(DeleteZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
}