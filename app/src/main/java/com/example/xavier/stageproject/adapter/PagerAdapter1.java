package com.example.xavier.stageproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xavier.stageproject.Roster.DagFragment;

/**
 * The type Pager adapter 1.
 */
public class PagerAdapter1 extends FragmentStatePagerAdapter {
    /**
     * The M num of tabs.
     */
    int mNumOfTabs;

    /**
     * Instantiates a new Pager adapter 1.
     *
     * @param fm        the fm
     * @param NumOfTabs the num of tabs
     */
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