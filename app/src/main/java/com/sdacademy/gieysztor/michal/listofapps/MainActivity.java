package com.sdacademy.gieysztor.michal.listofapps;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main)
    CoordinatorLayout mainLayout;

    @BindView(R.id.mainActivityRecyclerView)
    RecyclerView recyclerView;

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showSnackbar();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new InstalledAppsAdapter(getFakeAppList()));
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLayoutInflater().inflate(R.layout.fragment_app_details_dialog,null);
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

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

    private void openSettingsDialogFragment(){
        SettingsDialogFragment settingsDialogFragment = SettingsDialogFragment.newInstance();
        settingsDialogFragment.show(getSupportFragmentManager(), "");
    }

    private void showSnackbar(){
        Snackbar snackbar = Snackbar.make(mainLayout, "Data loaded", Snackbar.LENGTH_SHORT);

        snackbar.show();
    }

    private ArrayList<AppInfo> getFakeAppList (){
        ArrayList<AppInfo> appInfos = new ArrayList<>();
        appInfos.add(new AppInfo(0, "Aplikacja 1", null));
        appInfos.add(new AppInfo(0, "Aplikacja 2", null));
        appInfos.add(new AppInfo(0, "Aplikacja 3", null));
        appInfos.add(new AppInfo(0, "Aplikacja 4", null));
        appInfos.add(new AppInfo(0, "Aplikacja 5", null));
        appInfos.add(new AppInfo(0, "Aplikacja 1", null));
        appInfos.add(new AppInfo(0, "Aplikacja 2", null));
        appInfos.add(new AppInfo(0, "Aplikacja 3", null));
        appInfos.add(new AppInfo(0, "Aplikacja 4", null));
        appInfos.add(new AppInfo(0, "Aplikacja 5", null));
        appInfos.add(new AppInfo(0, "Aplikacja 1", null));
        appInfos.add(new AppInfo(0, "Aplikacja 2", null));
        appInfos.add(new AppInfo(0, "Aplikacja 3", null));
        appInfos.add(new AppInfo(0, "Aplikacja 4", null));
        appInfos.add(new AppInfo(0, "Aplikacja 5", null));
        return appInfos;
    }
}
