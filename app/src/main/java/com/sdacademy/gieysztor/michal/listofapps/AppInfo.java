package com.sdacademy.gieysztor.michal.listofapps;

import android.graphics.drawable.Drawable;

/**
 * Created by RENT on 2017-03-28.
 */

public class AppInfo {

    private int UID;
    private String name;
    private Drawable icon;

    public AppInfo(int UID, String name, Drawable icon) {
        this.UID = UID;
        this.name = name;
        this.icon = icon;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
