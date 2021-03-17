package edu.temple.assignment6;

import android.content.res.Resources;

public class Themes {

    private static Theme[] themes = new Theme[0];

    static void setThemes(Resources resources) {
        String[] park_names = resources.getStringArray(R.array.selection_activity_item_names);
        themes = new Theme[] {
                new Theme(park_names[0], R.drawable.acadia),
                new Theme(park_names[1], R.drawable.congaree),
                new Theme(park_names[2], R.drawable.smokies),
                new Theme(park_names[3], R.drawable.shenandoah),
                new Theme(park_names[4], R.drawable.everglades),
                new Theme(park_names[5], R.drawable.arches),
                new Theme(park_names[6], R.drawable.badlands)
        };

    }


    static Theme[] getThemes() {
        return themes;
    };
}
