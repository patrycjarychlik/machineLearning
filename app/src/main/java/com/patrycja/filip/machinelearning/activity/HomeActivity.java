package com.patrycja.filip.machinelearning.activity;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.fragment.BadgesFragment;
import com.patrycja.filip.machinelearning.fragment.HomeFragment;
import com.patrycja.filip.machinelearning.fragment.SettingsFragment;
import com.patrycja.filip.machinelearning.persistence.db.entity.ChapterEntity;
import com.patrycja.filip.machinelearning.persistence.db.exception.DbExportException;
import com.patrycja.filip.machinelearning.persistence.db.helper.AppDatabaseBackupHelper;
import com.patrycja.filip.machinelearning.persistence.viewmodel.ChapterViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ChapterViewModel chapterViewModel = ViewModelProviders.of(this).get(ChapterViewModel.class);
        chapterViewModel.getObservableChapters().observe(this, new Observer<List<ChapterEntity>>() {
            @Override
            public void onChanged(@Nullable List<ChapterEntity> chapterEntities) {
                Log.println(Log.INFO, "TEST_VIEW_MODEL", "List of chapters: " + chapterEntities.toString());
            }
        });
    }

    private void exportDatabaseToDownloadsDir() {
        if (isReadWritePermissionsGranted() && needRequestForPermissions()) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        try {
            AppDatabaseBackupHelper.exportDB();
            Toast.makeText(this, "DB Backup successfully created!", Toast.LENGTH_SHORT).show();
        } catch (DbExportException e) {
            Log.println(Log.ERROR, "DbExportError", e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean needRequestForPermissions() {
        return Build.VERSION.SDK_INT > 22;
    }

    private boolean isReadWritePermissionsGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_badges:
                fragment = new BadgesFragment();
                break;
            case R.id.nav_rate:
                showNotImplementedToastMsg();
                break;
            case R.id.nav_settings:
                fragment = new SettingsFragment();
                break;
            case R.id.nav_share:
                showNotImplementedToastMsg();
                break;
            case R.id.nav_invite_friends:
                showNotImplementedToastMsg();
                break;
            case R.id.nav_export_db:
                exportDatabaseToDownloadsDir();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        changeCurrentView(fragment);

        return true;
    }

    private void changeCurrentView(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_home, fragment).addToBackStack(null)
                    .commit();
        }
    }

    private void showNotImplementedToastMsg() {
        Toast.makeText(this, "This action is not implemented yet!", Toast.LENGTH_LONG).show();
    }

}
