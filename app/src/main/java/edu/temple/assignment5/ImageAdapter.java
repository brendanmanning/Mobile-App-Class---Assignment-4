package edu.temple.assignment5;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create all the elements
        LinearLayout ll = new LinearLayout(context);
        TextView textView = new TextView(context);
        ImageView imageView = new ImageView(context);

        // Setup the layout
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.LEFT);
        ll.setPadding(8, 8, 8, 8);

        // Add the text view (including an adjustment for position for the prompt item)
        textView.setText(getItem(position).getName());
        textView.setTextSize(22);
        textView.setPadding(32, 92, 16, 15);

        // Add the image
        imageView.setLayoutParams(new LinearLayout.LayoutParams(350,275));
        imageView.setImageResource(getItem(position).getResource());
        imageView.setPadding(24, 0, 0, 0);

        // Add the items
        ll.addView(imageView);
        ll.addView(textView);

        return ll;

    }

}
