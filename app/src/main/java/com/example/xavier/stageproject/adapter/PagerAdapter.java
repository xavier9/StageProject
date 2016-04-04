package com.example.xavier.stageproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xavier.stageproject.AbsenceActivity;
import com.example.xavier.stageproject.Links;
import com.example.xavier.stageproject.MessageActivity;
import com.example.xavier.stageproject.Roster.RosterFragment;

/**
 * The type Pager adapter.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
	/**
	 * The M num of tabs.
	 */
	int mNumOfTabs;

	/**
	 * Instantiates a new Pager adapter.
	 *
	 * @param fm        the fm
	 * @param NumOfTabs the num of tabs
	 */
	public PagerAdapter(FragmentManager fm, int NumOfTabs) {
		super(fm);
		this.mNumOfTabs = NumOfTabs;
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
			case 0:
				MessageActivity tab1 = new MessageActivity();
				return tab1;
			case 1:
				AbsenceActivity tab2 = new AbsenceActivity();
				return tab2;
			case 2:
				RosterFragment tab4 = new RosterFragment();
				return tab4;
			case 3:
				Links tab3 = new Links();
				return tab3;


			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return mNumOfTabs;
	}
}