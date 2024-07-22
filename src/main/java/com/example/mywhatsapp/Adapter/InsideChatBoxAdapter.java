package com.example.mywhatsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywhatsapp.InsideChatBox;
import com.example.mywhatsapp.Models.UserChatItem;

import com.example.mywhatsapp.R;

import java.util.List;
public class InsideChatBoxAdapter  extends RecyclerView.Adapter<InsideChatBoxAdapter.ViewHolder> {


//    @NonNull
//    @Override
//    public InsideChatBoxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull InsideChatBoxAdapter.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }



        private List<UserChatItem> chatList;
        private Context context;

        public InsideChatBoxAdapter(Context context, List<UserChatItem> chatList) {
            this.context = context;
            this.chatList = chatList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chat_box, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            UserChatItem chatMsg = chatList.get(position);
            holder.userName.setText(chatMsg.getuserName());
            holder.lastMessage.setText(chatMsg.getlastMessage());
            holder.timestamp.setText(chatMsg.gettimestamp());

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, InsideChatBox.class);
                intent.putExtra("userName", chatMsg.getuserName());
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return chatList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView userName;
            public TextView lastMessage;
            public TextView timestamp;
            public ImageView userImage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                userName = itemView.findViewById(R.id.user_name);
                lastMessage = itemView.findViewById(R.id.last_message);
                timestamp = itemView.findViewById(R.id.timestamp);
                userImage = itemView.findViewById(R.id.groups_image_id);
            }
        }
}
