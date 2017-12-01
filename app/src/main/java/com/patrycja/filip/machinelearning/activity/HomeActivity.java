package com.patrycja.filip.machinelearning.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.fragment.BadgesFragment;
import com.patrycja.filip.machinelearning.fragment.HomeFragment;
import com.patrycja.filip.machinelearning.fragment.SettingsFragment;
import com.patrycja.filip.machinelearning.persistence.db.helper.AppDatabaseBackupHelper;

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

        setupInitialFragment();
        setOnBackStackListener();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setProperMenuItem();
    }

    private void setOnBackStackListener() {
        getSupportFragmentManager().addOnBackStackChangedListener(this::setProperMenuItem);
    }

    private void setupInitialFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.content_home, new HomeFragment()).commit();
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

    private void setProperMenuItem() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById((R.id.content_home));
        if (currentFragment instanceof HomeFragment) {
            navigationView.setCheckedItem(R.id.nav_home);
        } else if (currentFragment instanceof BadgesFragment) {
            navigationView.setCheckedItem(R.id.nav_badges);
        } else if (currentFragment instanceof SettingsFragment) {
            navigationView.setCheckedItem(R.id.nav_settings);
        } else {
            showNotImplementedToastMsg();
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
                AppDatabaseBackupHelper.exportDatabaseToDownloadsDir(this);
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
