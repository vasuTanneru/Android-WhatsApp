package com.example.mywhatsapp.Fraguments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mywhatsapp.Adapter.UserChatItemAdapter;
import com.example.mywhatsapp.Models.UserChatItem;
import com.example.mywhatsapp.MySingleton;
import com.example.mywhatsapp.R;


import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.mikhaellopez.circularimageview.CircularImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatFragment extends Fragment {


    private RecyclerView recyclerView;
    private UserChatItemAdapter UserChatItemAdapter;
    public List<UserChatItem> chatList;
    public List<UserChatItem> chatItemLists;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_chat, container, false);

         //View view;

      //  recyclerView = view.findViewById(R.id.recycler_view);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        chatItemLists = new ArrayList<>();
//        UserChatItemAdapter = new UserChatItemAdapter(chatItemLists);
//        recyclerView.setAdapter(UserChatItemAdapter);

//        return recyclerView;
    }
//
//    public void fetchChatItems () {
//        String url = "https://localhost:44330/get_chat_items";
//
//        RequestQueue queue = MySingleton.getInstance(requireContext()).getRequestQueue();
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        chatItemLists.clear();
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject jsonObject = response.getJSONObject(i);
//                                UserChatItem chatItem = new UserChatItem();
//
//                                chatItem.setuserName(jsonObject.getString("userName"));
//                                chatItem.setlastMessage(jsonObject.getString("lastMessage"));
//                                chatItem.settimestamp(jsonObject.getString("timestamp"));
//                                chatItemLists.add(chatItem);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        UserChatItemAdapter.notifyDataSetChanged();
//                    }
//                },
//                error -> Log.e("Volley", "Error fetching chat items", error));
//
//        queue.add(jsonArrayRequest);
//    }

}