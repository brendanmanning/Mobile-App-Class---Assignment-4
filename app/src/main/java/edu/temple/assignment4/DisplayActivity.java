package edu.temple.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        setTitle("Display");

        System.out.println("In DisplayView");

        Intent intent = getIntent();
        int theme_index = intent.getIntExtra("theme", -1);
        System.out.println("Theme index was: " + theme_index);

        if(theme_index >= 0) {
            Theme theme = Themes.themes[theme_index];

            TextView text_view = findViewById(R.id.textView);
            text_view.setText(theme.getName());

            ImageView img_view = findViewById(R.id.imageView);
            img_view.setImageResource(theme.getResource());

        }

    }

}
