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

        // Return 1 more theme than we actually have because
        // of the "Select a theme" label
        return themes.length + 1;
    }

    @Override
    public Theme getItem(int position) {

        // Create a Theme "item" to show a label without an image
        if(position == 0) {
            return new Theme("Select a theme", 0);
        }

        // Otherwise, return the image (with an off-by-one adjustment)
        else {
            return themes[position-1];
        }
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
        textView.setPadding(position == 0 ? 280 : 32, position == 0 ? 24 : 92, 16, 15);

        // Add the image
        imageView.setLayoutParams(new LinearLayout.LayoutParams(350,275));
        imageView.setImageResource(getItem(position).getResource());
        imageView.setPadding(24, 0, 0, 0);

        // Add the items
        if(position > 0) ll.addView(imageView);
        ll.addView(textView);

        return ll;

    }

}
