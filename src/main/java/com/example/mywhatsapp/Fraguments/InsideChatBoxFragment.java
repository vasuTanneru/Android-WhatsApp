package com.example.mywhatsapp.Fraguments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywhatsapp.Adapter.InsideChatBoxAdapter;
import com.example.mywhatsapp.Models.UserChatItem;

import com.example.mywhatsapp.R;

import java.util.ArrayList;
import java.util.List;

    public class InsideChatBoxFragment extends Fragment {

        public RecyclerView recyclerView;
        public InsideChatBoxAdapter InsideChatBoxAdapter;
        public List<UserChatItem> chatList;

        public InsideChatBoxFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_inside_chat_box, container, false);

            recyclerView = view.findViewById(R.id.insideechatBoxRCV);


            chatList = new ArrayList<>();
            chatList.add(new UserChatItem("Vasu Tanneru", "Hey, how are you?", "10:30 AM"));
            chatList.add(new UserChatItem("Mani Kanta.N", "Let's catch up later.", "Yesterday"));
            chatList.add(new UserChatItem("Gautham Kiran", "Check this out!", "2 days ago"));
            chatList.add(new UserChatItem("AbhiLash .B", "Good morning!", "8:00 AM"));

            InsideChatBoxAdapter = new InsideChatBoxAdapter(getContext(), chatList);
            recyclerView.setAdapter(InsideChatBoxAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            return view;
        }
}
