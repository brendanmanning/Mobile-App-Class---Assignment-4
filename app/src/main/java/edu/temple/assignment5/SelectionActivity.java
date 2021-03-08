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
        gridView.setNumColumns(3);
        gridView.setAdapter(new ImageAdapter(this, Themes.themes));

        gridView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                launchIntent.putExtra("theme", position);
                startActivity(launchIntent);
            }
        });

    }
}