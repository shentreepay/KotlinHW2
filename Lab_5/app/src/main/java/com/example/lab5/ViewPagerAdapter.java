package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, @NonNull Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    // Return the number of fragments
    @Override
    public int getItemCount() {
        return 3;
    }

    // Return the appropriate fragment based on the position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FirstFragment();  // First page fragment
            case 1:
                return new SecondFragment(); // Second page fragment
            default:
                return new ThirdFragment();  // Third page fragment
        }
    }
}

