package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.system.daniel.R;
import es.system.daniel.zoo.dao.helpers.ZooDbHelper;
import es.system.daniel.zoo.model.Animal;
import es.system.daniel.zoo.model.Zoo;

public class UpdateZooActivity extends AppCompatActivity {

    private ZooDbHelper zooDbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_zoo);
        zooDbHelper = new ZooDbHelper(this);

        Zoo zoo = (Zoo) getIntent().getSerializableExtra("Zoo");

        EditText editTextName = (EditText) this.findViewById(R.id.editTextName);
        EditText editTextCity = (EditText) this.findViewById(R.id.editTextCity);
        EditText editTextCountry = (EditText) this.findViewById(R.id.editTextCountry);
        EditText editTextSize = (EditText) this.findViewById(R.id.editTextSize);
        EditText editTextYearlyIncome = (EditText) this.findViewById(R.id.editTextYearlyIncome);

        editTextName.setText(zoo.getName());
        editTextCity.setText(zoo.getCity());
        editTextCountry.setText(zoo.getCountry());
        editTextSize.setText(zoo.getSize()+"");
        editTextYearlyIncome.setText(zoo.getYearlyIncome()+"");
    }
    public void changeZoosView(View view) {
        Intent previousView = new Intent(UpdateZooActivity.this,
                ZoosActivity.class);
        startActivity(previousView);
    }
    public void updateZoo(View view) {
        EditText editTextName = (EditText) this.findViewById(R.id.editTextName);
        EditText editTextCity = (EditText) this.findViewById(R.id.editTextCity);
        EditText editTextCountry = (EditText) this.findViewById(R.id.editTextCountry);
        EditText editTextSize = (EditText) this.findViewById(R.id.editTextSize);
        EditText editTextYearlyIncome = (EditText) this.findViewById(R.id.editTextYearlyIncome);

        String name = editTextName.getText().toString();
        String city = editTextCity.getText().toString();
        String country = editTextCountry.getText().toString();
        String size = editTextSize.getText().toString();
        String yearlyIncome = editTextYearlyIncome.getText().toString();

        if (!name.matches("") &&
                !city.matches("") && !country.matches("") &&
                !size.matches("") && !yearlyIncome.matches("")) {
            Zoo zoo = null;
            try {
                zoo = new Zoo(name, city, country, Integer.parseInt(size),
                        Integer.parseInt(yearlyIncome));
            } catch(Exception e) {
                e.printStackTrace();
            }
            if (zoo != null) {
                zooDbHelper.update(zoo, name);
            }
        }
    }
}