package com.example.mobile_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewPagerAdapter extends FragmentStateAdapter {

    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){


            case 0:

                return new AddContactFragment();

            case 1:

                return new ListContactsFragment();

            case 2:

                return new CreditFragment();

            default:

                return new AddContactFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
