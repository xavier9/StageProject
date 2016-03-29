package com.example.xavier.stageproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.xavier.stageproject.AbsenceActivity;
import com.example.xavier.stageproject.Links;
import com.example.xavier.stageproject.MessageActivity;
import com.example.xavier.stageproject.Roster.DagFragment;
import com.example.xavier.stageproject.Roster.DinsDagFragment;
import com.example.xavier.stageproject.Roster.DondeDagFragment;
import com.example.xavier.stageproject.Roster.MaanDagFragment;
import com.example.xavier.stageproject.Roster.RosterFragment;
import com.example.xavier.stageproject.Roster.VrijDagFragment;
import com.example.xavier.stageproject.Roster.WoensDagFragment;


import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter1(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                //MaanDagFragment tab1 = new MaanDagFragment();
                return new DagFragment(position);

            case 1:
               // DinsDagFragment  tab2 = new DinsDagFragment();
                return new DagFragment(position);
            case 2:
                //WoensDagFragment  tab4 = new WoensDagFragment ();
                return new DagFragment (position);
            case 3:
                //DondeDagFragment tab3 = new DondeDagFragment ();
                return new DagFragment (position);
            case 4:
                //VrijDagFragment tab5 = new VrijDagFragment ();
                return new DagFragment (position);


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}