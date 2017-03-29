package com.sdacademy.gieysztor.michal.listofapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main)
    CoordinatorLayout mainLayout;

    @BindView(R.id.mainActivityRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.mainActivityProgressBar)
    ProgressBar progressBar;

    public static final String TAG = MainActivity.class.getSimpleName();
    private PackageManager packageManager;
    private FragmentActivity fragmentActivity;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentActivity = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        inflateRecyclerView();
    }

    private void inflateRecyclerView() {
        InstalledAppsAsynkTask installedAppsAsynkTask = new InstalledAppsAsynkTask();
        installedAppsAsynkTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_settings:
                openSettingsDialogFragment();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openSettingsDialogFragment() {
        SettingsDialogFragment settingsDialogFragment = SettingsDialogFragment.newInstance();
        settingsDialogFragment.show(getSupportFragmentManager(), "");
    }

    private void showAllApps(){
        Log.d(TAG, "Show all apps");

    }

    private void showUserApps(){
        Log.d(TAG, "Show user apps");
    }

    private void showSnackbar() {
        Snackbar snackbar = Snackbar.make(mainLayout, "Data loaded", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }


    private class InstalledAppsAsynkTask extends AsyncTask<Void, Void, InstalledAppsAdapter> {


        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected InstalledAppsAdapter doInBackground(Void... params) {
            ArrayList<AppInfo> appInfos = getAppInfos();
            fragmentManager = fragmentActivity.getSupportFragmentManager();
            InstalledAppsAdapter adapter = new InstalledAppsAdapter(appInfos, fragmentManager);
            return adapter;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(InstalledAppsAdapter adapter) {
            super.onPostExecute(adapter);
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);
            showSnackbar();
        }

        private ArrayList<AppInfo> getAppInfos() {
            packageManager = getPackageManager();
            List<ApplicationInfo> applicationInfos = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
            Log.i(TAG, applicationInfos.toString());
            ArrayList<AppInfo> appInfos = formatToAppInfo(applicationInfos);
            return appInfos;
        }

        private ArrayList<AppInfo> formatToAppInfo(List<ApplicationInfo> applicationInfos) {
            ArrayList<AppInfo> formattedAppInfos = new ArrayList<>();
            for (ApplicationInfo applicationInfo : applicationInfos) {
                formattedAppInfos.add(new AppInfo(applicationInfo.uid,
                        applicationInfo.loadLabel(packageManager).toString(),
                        applicationInfo.loadIcon(packageManager)));
            }
            ;


            return formattedAppInfos;
        }

    }
}
