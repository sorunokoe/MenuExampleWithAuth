package com.kitestart.menuexample.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.kitestart.menuexample.Constants.Constants;
import com.kitestart.menuexample.Controller.Repos.ListReposController;
import com.kitestart.menuexample.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);

        TextView login = view.findViewById(R.id.firstNameTextView);
        TextView email = view.findViewById(R.id.emailTextView);

        if(Constants.shared.getLogin() != null){
            login.setText( Constants.shared.getLogin() );
        }
        if(Constants.shared.getEmail() != null){
            email.setText( Constants.shared.getEmail() );
        }

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent intent = new Intent(this, ListReposController.class);
            startActivity(intent);

        } else if(id == R.id.nav_user_list){

            Intent intent = new Intent(this, UserListController.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_my_location) {

            startActivity(new Intent(this, MyLocationController.class));

        } else if (id == R.id.nav_sign_out){
            if( Constants.shared.removeCredentials() ){
                signOut();
            } else{
                Toast.makeText(this, "Cannot sign out", Toast.LENGTH_SHORT).show();
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void signOut(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
