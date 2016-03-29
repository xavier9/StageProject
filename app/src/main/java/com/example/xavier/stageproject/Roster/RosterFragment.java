package com.example.xavier.stageproject.Roster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;

import com.example.xavier.stageproject.R;
import com.example.xavier.stageproject.adapter.PagerAdapter;
import com.example.xavier.stageproject.adapter.PagerAdapter1;

public class RosterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_roster, container, false);
        TabLayout tabLayout1 = (TabLayout) rootView.findViewById(R.id.tab_layout1);
        tabLayout1.addTab(tabLayout1.newTab().setText("Mon"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Tue"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Wens"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Thu"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Fri"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);



        final ViewPager viewPager1 = (ViewPager) rootView.findViewById(R.id.pager1);
        final PagerAdapter1 adapter = new PagerAdapter1
                ( getChildFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab1) {
                Log.e("Tab2", String.valueOf(tab1.getPosition()));
                viewPager1.setCurrentItem(tab1.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        return  rootView;
    }
}





