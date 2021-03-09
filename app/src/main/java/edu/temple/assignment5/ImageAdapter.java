package edu.temple.assignment5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter implements ListAdapter {

    private final Context context;
    private final Theme[] themes;

    public ImageAdapter(Context context, Theme[] themes) {
        this.context = context;
        this.themes = themes;
    }

    @Override
    public int getCount() {
        return themes.length;
    }

    @Override
    public Theme getItem(int position) {
        return themes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create all the elements
        FrameLayout fl = new FrameLayout(context);
        TextView textView = new TextView(context);
        ImageView imageView = new ImageView(context);

        // Add the text view (including an adjustment for position for the prompt item)
        textView.setText(getItem(position).getName());
        textView.setTextSize(18);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setGravity(Gravity.CENTER);
        textView.setHeight(275);
        textView.setTextColor(Color.WHITE);


        // Add the image
        imageView.setLayoutParams(new LinearLayout.LayoutParams(350,275));
        imageView.setImageResource(getItem(position).getResource());
        imageView.setPadding(0, 0, 0, 0);

        // Add the items
        fl.addView(imageView);
        fl.addView(textView);

        return fl;

    }

}
