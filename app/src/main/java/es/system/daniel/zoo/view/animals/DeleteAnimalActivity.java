package es.system.daniel.zoo.view.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.AnimalDbHelper;

public class DeleteAnimalActivity extends AppCompatActivity {

    public AnimalDbHelper animalDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_animal);
    }
    public void changeAnimalsView(View view) {
        Intent previousView = new Intent(DeleteAnimalActivity.this,
                AnimalsActivity.class);
        startActivity(previousView);
    }
    public void deleteAnimal(View view) {
        animalDbHelper = new AnimalDbHelper(this);
        EditText editTextName = (EditText) this.findViewById(R.id.editTextId);

        String idStr = editTextName.getText().toString();

        if (!idStr.matches("")) {
            Integer id = null;
            try {
                id = Integer.parseInt(idStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (id != null) {
                animalDbHelper.delete(idStr);
            }
        }
    }
}