package com.example.mywhatsapp.Fraguments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywhatsapp.Models.CallsListItems;
import com.example.mywhatsapp.Adapter.CallsListItemsAdapter;
import com.example.mywhatsapp.R;

import java.util.ArrayList;
import java.util.List;

    public class CallsListItemsFragment extends Fragment {

        public RecyclerView recyclerView;
        public CallsListItemsAdapter CallsListItemsAdapter;
        public List<CallsListItems> callList = new ArrayList<>();

        public CallsListItemsFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_calls, container, false);

            recyclerView = view.findViewById(R.id.calls_recyclerView_id);

            callList.add(new CallsListItems("Vasu Tanneru", "10:30 AM", true));
            callList.add(new CallsListItems("Mani Kanta.N", "Yesterday", false));
            callList.add(new CallsListItems("Gautham Kiran", "2 days ago", true));
            callList.add(new CallsListItems("Abhilash .B", "8:00 AM", false));

            setCallsListItemsAdapter(new CallsListItemsAdapter(callList));
            recyclerView.setAdapter(getCallsListItemsAdapter());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


            return view;
        }

        public CallsListItemsAdapter getCallsListItemsAdapter() {
            return CallsListItemsAdapter;
        }

        public void setCallsListItemsAdapter(CallsListItemsAdapter callsListItemsAdapter) {
            CallsListItemsAdapter = callsListItemsAdapter;
        }
    }
