package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.navidrawer.Fragments.HistoryFragment;
import com.example.navidrawer.Fragments.HomeFragment;
import com.example.navidrawer.Fragments.NotificationFragment;
import com.example.navidrawer.Fragments.ProfileFragment;
import com.example.navidrawer.Fragments.SchoolFragment;
import com.example.navidrawer.Fragments.SettingsFragment;
import com.example.navidrawer.Fragments.WorkFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout=findViewById(R.id.drawerLayout);
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(new HomeFragment());
        showFragment(new WorkFragment());
        showFragment(new SchoolFragment());
        showFragment(new SettingsFragment());
        showFragment(new HistoryFragment());
        showFragment(new NotificationFragment());
        showFragment(new ProfileFragment());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.home){
            showFragment(new HomeFragment());
        }
        if (id==R.id.work){
            showFragment(new WorkFragment());
        }
        if (id==R.id.school){
            showFragment(new SchoolFragment());
        }
        if (id==R.id.settings){
            showFragment(new SettingsFragment());
        }
        if (id==R.id.history){
            showFragment(new HistoryFragment());
        }
        if (id==R.id.notification){
            showFragment(new NotificationFragment());
        }
        if (id==R.id.profile){
            showFragment(new ProfileFragment());
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_laypout,fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}