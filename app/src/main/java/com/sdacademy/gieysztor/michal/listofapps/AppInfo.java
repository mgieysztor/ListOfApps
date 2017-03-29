package com.sdacademy.gieysztor.michal.listofapps;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RENT on 2017-03-28.
 */

public class AppInfo implements Parcelable {

    private int UID;
    private String name;
    private Drawable icon;

    public AppInfo(int UID, String name, Drawable icon) {
        this.UID = UID;
        this.name = name;
        this.icon = icon;
    }

    protected AppInfo(Parcel in) {
        UID = in.readInt();
        name = in.readString();
    }

    public static final Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        @Override
        public AppInfo createFromParcel(Parcel in) {
            return new AppInfo(in);
        }

        @Override
        public AppInfo[] newArray(int size) {
            return new AppInfo[size];
        }
    };

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

    @Override
    public String toString() {
        return "AppInfo{" +
                "UID=" + UID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(UID);
        dest.writeString(name);
    }
}
