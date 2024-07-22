package com.example.mywhatsapp.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mywhatsapp.Fraguments.CallsFragment;
import com.example.mywhatsapp.Fraguments.ChatFragment;
import com.example.mywhatsapp.Fraguments.StatusFragment;

public class FragumentAdapter extends FragmentPagerAdapter {

    public FragumentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ChatFragment();
            case 1: return new StatusFragment();
            case 2: return new CallsFragment();
            default: return new ChatFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if (position==0)
            title="Chats";
        if (position==1)
            title="Status";

        if (position==2)
            title="Calls";

        return title;
    }
}
