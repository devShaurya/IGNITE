package com.example.ignite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new HomeFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new LabTourFragment();
            case 3:
                return new ScheduleFragment();
            case 4:
                return new ContactFragment();
            case 5:
                return new SponsorsFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 6;
    }

    //    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        switch (position){
            case 0:
                title="Home";
                break;
            case 1:
                title="Events";
                break;
            case 2:
                title="Lab TOurs";
                break;
            case 3:
                title="Schedule";
                break;
            case 4:
                title="Contact Us";
                break;
            case 5:
                title="Sponsor";
                break;
        }
        return title;
    }
}
