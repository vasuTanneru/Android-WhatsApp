package com.example.mywhatsapp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywhatsapp.Models.CallsListItems;
import com.example.mywhatsapp.R;

import java.util.List;

    public class CallsListItemsAdapter extends RecyclerView.Adapter<CallsListItemsAdapter.ViewHolder> {

        public List<CallsListItems> callList;

        public CallsListItemsAdapter(List<CallsListItems> callList) {
            this.callList = callList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calls_list_items_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            CallsListItems CallsListItems = callList.get(position);
            holder.userName.setText(CallsListItems.getUserName());
            holder.callTime.setText(CallsListItems.getCallTime());
            if (CallsListItems.isIncoming()) {
                holder.callType.setImageResource(R.drawable.outgoing);
            } else {
                holder.callType.setImageResource(R.drawable.downright);
            }

            Log.d("Adpter", "onBindViewHolder: "+CallsListItems.getUserName());

        }

        @Override
        public int getItemCount() {
            return callList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView userName;
            public TextView callTime;
            public ImageView callType;
            public ImageView userImage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                userName = itemView.findViewById(R.id.user_name);
                callTime = itemView.findViewById(R.id.call_time);
                callType = itemView.findViewById(R.id.call_type);
                //userImage = itemView.findViewById(R.id.user_image);
            }
        }
}
