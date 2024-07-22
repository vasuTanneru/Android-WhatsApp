package com.example.mywhatsapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mywhatsapp.Fraguments.CallsFragment;
import com.example.mywhatsapp.Fraguments.CallsListItemsFragment;
import com.example.mywhatsapp.Fraguments.ChatFragment;
import com.example.mywhatsapp.Fraguments.StatusFragment;
import com.example.mywhatsapp.Fraguments.UserChatItemFragment;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UserChatItemFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsListItemsFragment();
            default:
                return new UserChatItemFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
