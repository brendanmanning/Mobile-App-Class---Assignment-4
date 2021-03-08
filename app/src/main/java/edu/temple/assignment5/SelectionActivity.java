package edu.temple.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        setTitle("Item Selection");

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, Themes.themes));

        gridView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Ignore when the user selects the prompt item
                if (position == 0) return;

                // Select the item at position 0 so that when we return
                // from the DisplayActivity, we get a fresh view
                gridView.setSelection(0);

                // Launch the displayer view
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                launchIntent.putExtra("theme", position - 1);
                startActivity(launchIntent);

            }
        });

    }
}