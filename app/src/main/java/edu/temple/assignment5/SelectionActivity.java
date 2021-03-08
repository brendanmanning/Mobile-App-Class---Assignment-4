package edu.temple.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        setTitle("Item Selection");

        Spinner spinner = findViewById(R.id.spinnerView);
        spinner.setAdapter(new ImageAdapter(this, Themes.themes));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Ignore when the user selects the prompt item
                if(position == 0) return;

                // Select the item at position 0 so that when we return
                // from the DisplayActivity, we get a fresh view
                spinner.setSelection(0);

                // Launch the displayer view
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                launchIntent.putExtra("theme", position-1);
                startActivity(launchIntent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}