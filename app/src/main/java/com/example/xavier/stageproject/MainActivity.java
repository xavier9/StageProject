package com.example.xavier.stageproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.xavier.stageproject.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tab);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        // Initilization

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Messages"));
        tabLayout.addTab(tabLayout.newTab().setText("Absences"));
        tabLayout.addTab(tabLayout.newTab().setText("Roster"));
        tabLayout.addTab(tabLayout.newTab().setText("Links"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e("Tab1", String.valueOf(tab.getPosition()));
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
           Intent intent = new Intent(getApplication(), MainActivity.class);
            Bundle extra = getIntent().getExtras();
            int test = extra.getInt("screen");
            int student = extra.getInt("studentid");
            intent.putExtra("studentid", student);
            intent.putExtra("screen", test);
            startActivity(intent);
        }
        if (id == R.id.LogOut) {
            Intent intent = new Intent(getApplication(), LDAPActivety.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
