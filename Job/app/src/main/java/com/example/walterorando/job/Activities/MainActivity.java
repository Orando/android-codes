package com.example.walterorando.job.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.walterorando.job.Fragments.Location_fragment;
import com.example.walterorando.job.Fragments.Stories_fragment;
import com.example.walterorando.job.Fragments.newsFeed_fragment;
import com.example.walterorando.job.R;
import com.example.walterorando.job.models.HomeItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    String username, avatarPic, email;
    int count;
    FragmentManager homeFragmentManager;
   // LoginDataBaseAdapter mydb;
    HomeItems images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

       // mydb = new LoginDataBaseAdapter(getApplicationContext());

       // HashMap<String,String> user = mydb.getUserDetails();

      //  username = user.get("USERNAME");
        //email = user.get("EMAIL");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View drawerHeader = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView name = (TextView) drawerHeader.findViewById(R.id.name);
        name.setText(username);
        TextView emailTxt = (TextView) drawerHeader.findViewById(R.id.email);
        emailTxt.setText(email);
        final ImageView avatar = (ImageView)drawerHeader.findViewById(R.id.avatar);
        Glide.with(getApplicationContext())
                .load(avatarPic)
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.avatar)
                .error(R.drawable.avatar)
                .into(new BitmapImageViewTarget(avatar) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        avatar.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main_drawer, menu);
        return true;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new newsFeed_fragment(), "newsFeed");
        adapter.addFragment(new Location_fragment(), "location");
        adapter.addFragment(new Stories_fragment(), "Stories");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(android.support.v4.app.FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
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
        Intent intent;
        if (id == R.id.nav_profile) {
            intent = new Intent(MainActivity.this, Profile_Activity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_usertype) {
            intent = new Intent(MainActivity.this, Usertype_Activity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_points) {
            intent = new Intent(MainActivity.this, Points_Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_invite) {
            intent = new Intent(MainActivity.this, Invite_Friends_Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(MainActivity.this, Settings_Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_log_out) {
         //   PreferenceHelper.logOut(getApplicationContext());
           // intent = new Intent(MainActivity.this, AccountActivity.class);
           // startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

