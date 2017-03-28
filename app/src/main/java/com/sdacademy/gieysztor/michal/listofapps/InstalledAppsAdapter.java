package com.sdacademy.gieysztor.michal.listofapps;

import android.support.v7.widget.RecyclerView;
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

    private ArrayList<AppInfo> appInfos;

    InstalledAppsAdapter(ArrayList<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    @Override
    public InstallAppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.installed_apps_row,parent,false);

        return new InstallAppsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstallAppsViewHolder holder, int position) {
        AppInfo appInfo = appInfos.get(position);
        holder.name.setText(appInfo.getName());

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
