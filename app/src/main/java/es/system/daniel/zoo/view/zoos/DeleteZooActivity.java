package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Zoo;

public class DeleteZooActivity extends AppCompatActivity {

    private ZooDbHelper zooDbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_zoo);
        zooDbHelper = new ZooDbHelper(this);
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(DeleteZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
    public void deleteZoo(View view) {
        EditText editTextName = (EditText) this.findViewById(R.id.editTextName);

        String name = editTextName.getText().toString();

        if (!name.matches("")) {
            zooDbHelper.delete(name);
        }
    }
}