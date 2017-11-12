package com.example.nisha.lumohacks2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LandingMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // global variables
    private CalendarView calenderObject;
    private FloatingActionButton floatingActionButton;
    private TextView homeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize objects
        calenderObject = (CalendarView) findViewById(R.id.calendar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.add);
        homeText = (TextView) findViewById(R.id.homeText);

        // initialize drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // initialize home screen objects
        calenderObject.setVisibility(View.GONE);
        homeText.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuestions(view);

            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.landing_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            // Clear everything but the home button
            calenderObject.setVisibility(View.GONE);
            floatingActionButton.setVisibility(View.VISIBLE);
            homeText.setVisibility(View.VISIBLE);

        } else if (id == R.id.calendarOption) {

            calenderObject.setVisibility(View.VISIBLE);
            floatingActionButton.setVisibility(View.GONE);
            homeText.setVisibility(View.GONE);

        } else if (id == R.id.myCharts) {

            calenderObject.setVisibility(View.GONE);
            floatingActionButton.setVisibility(View.GONE);
            homeText.setVisibility(View.GONE);

            /* come back to this
            finish();
            startActivity(new Intent(getApplicationContext(), DailyActivity.class));
            */

        } else if (id == R.id.logout) {

//            calenderObject.setVisibility(View.GONE);
//            floatingActionButton.setVisibility(View.GONE);

            // sign out user and open login activity
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void startQuestions(View view) {
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
    }
}
