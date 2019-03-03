package com.example.ignite;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsPagerAdapter tabsPagerAdapter;
    private TextView txt, txtdate;
    private FirebaseFirestore db;
    private Typeface typeface;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeface=Typeface.createFromAsset(this.getAssets(),"fonts/DeathStar.otf");
        toolbar = findViewById(R.id.toolbar);
        txt=findViewById(R.id.textname);
        txtdate=findViewById(R.id.textdate);
        drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
//        txt.setText("IGNITE 5.0");
//        txt.setTextSize(16);
//        txturl.setText("4-5 March");
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_url:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://students.iitgn.ac.in/ignite/"));
                        startActivity(intent);
                        break;
                    case R.id.nav_logo:
                        intent = new Intent(MainActivity.this, logo.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.nav_brochure:
                        intent = new Intent(MainActivity.this,Brochure.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.nav_reg:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://students.iitgn.ac.in/ignite/"));
                        startActivity(intent);
                        break;
                    case R.id.nav_bus:
                        intent = new Intent(MainActivity.this,Bus.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_dev:
                        intent = new Intent(MainActivity.this, DeveloperActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    default:
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opnDrawer, R.string.clsDrawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//        if(savedInstanceState==null){
//            getSupportFragmentManager().beginTransaction().replace(
//                    R.id.fragment_container,new MessageFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_message);
//        }
//

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_outline_event_24px);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_time);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_outline_call_24px);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_sponsor);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tabSelected);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.tabunSelected);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.CYAN);
        drawable.setSize(2, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
//        tabLayout.getTabAt()
        toolbar.setElevation(0);

//        AnimationDrawable animationDrawable = (AnimationDrawable) tabLayout.getBackground();
//
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        AnimationDrawable animationDrawable2 = (AnimationDrawable) toolbar.getBackground();
//
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//
//        animationDrawable.start();
//        animationDrawable2.start();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
