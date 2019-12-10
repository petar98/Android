package com.example.tablayout;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int CARD_ITEM_SIZE = 10;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return CARD_ITEM_SIZE;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return CardFragment.newInstance(position);
    }
}
