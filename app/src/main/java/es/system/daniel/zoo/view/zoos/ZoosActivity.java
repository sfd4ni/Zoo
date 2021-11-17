package es.system.daniel.zoo.view.zoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import es.system.daniel.R;
import es.system.daniel.zoo.view.MainActivity;

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
        Intent nextView = new Intent(ZoosActivity.this,
                UpdateZooActivity.class);
        startActivity(nextView);
    }
    public void changeCreateZooView(View view) {
        Intent nextView = new Intent(ZoosActivity.this,
                CreateZooActivity.class);
        startActivity(nextView);
    }
    public void changeReadZooView(View view) {
        Intent nextView = new Intent(ZoosActivity.this,
                ReadZooActivity.class);
        startActivity(nextView);
    }
    public void changeDeleteZooView(View view) {
        Intent nextView = new Intent(ZoosActivity.this,
                DeleteZooActivity.class);
        startActivity(nextView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_zoo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent nextView = null;
        switch (item.getItemId()) {

            case R.id.deleteZoo:
                nextView = new Intent(ZoosActivity.this,
                        DeleteZooActivity.class);
                startActivity(nextView);
                return true;
            case R.id.updateZoo:

                nextView = new Intent(ZoosActivity.this,
                        UpdateZooActivity.class);
                startActivity(nextView);
                return true;
            case R.id.createZoo:
                nextView = new Intent(ZoosActivity.this,
                        CreateZooActivity.class);
                startActivity(nextView);
                return true;
            case R.id.readZoo:
                nextView = new Intent(ZoosActivity.this,
                        ReadZooActivity.class);
                startActivity(nextView);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }
}