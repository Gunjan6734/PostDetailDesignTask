package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.PlaceholderFragment;

import java.util.ArrayList;

public class PostDetailImagePagerAdapter extends FragmentStateAdapter {

    ArrayList<String> list;

    public PostDetailImagePagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<String> list) {
        super(fragmentActivity);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PlaceholderFragment.newInstance(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
