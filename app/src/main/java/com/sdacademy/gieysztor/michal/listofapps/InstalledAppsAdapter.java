package com.sdacademy.gieysztor.michal.listofapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RENT on 2017-03-28.
 */

public class InstalledAppsAdapter extends RecyclerView.Adapter<InstalledAppsAdapter.InstallAppsViewHolder> {

    public static final String TAG = InstalledAppsAdapter.class.getSimpleName();
    private ArrayList<AppInfo> appInfos;
    private FragmentManager fragmentManager;


    InstalledAppsAdapter(ArrayList<AppInfo> appInfos, FragmentManager fragmentManager) {
        this.appInfos = appInfos;
        this.fragmentManager = fragmentManager;
    }


    @Override
    public InstallAppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.installed_apps_row, parent, false);

        return new InstallAppsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstallAppsViewHolder holder, final int position) {
        final AppInfo appInfo = appInfos.get(position);
        holder.name.setText(appInfo.getName());
        holder.icon.setImageDrawable(appInfo.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Position: " + position + " content: " + appInfos.get(position));
                AppDetailsDialogFragment appDetailsDialogFragment = AppDetailsDialogFragment.newInstance(appInfo);
                appDetailsDialogFragment.show(fragmentManager, "");
            }
        });

    }

    @Override
    public int getItemCount() {
        if (appInfos == null || appInfos.isEmpty()) {
            return 0;
        } else {
            return appInfos.size();
        }


    }

    static class InstallAppsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.installedAppRowIcon)
        ImageView icon;

        @BindView(R.id.installedAppRowName)
        TextView name;

        public InstallAppsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
