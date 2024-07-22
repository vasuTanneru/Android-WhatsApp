package com.example.mywhatsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class UserChatItemAdapter extends RecyclerView.Adapter <UserChatItemAdapter.ViewHolder> {

ImageView view;
        public List<UserChatItem> chatList;

       public Context context;
        String url="https://media.licdn.com/dms/image/D4E03AQGf3n4Hpwqt5g/profile-displayphoto-shrink_100_100/0/1684335839018?e=1724889600&amp;v=beta&amp;" +
                "t=T-C3TTdiCHyvUu1ZF-CTvxMIF7ls2RlGgFPF076ineM\" loading=\"lazy\" alt=\"Manikanta Nissankara\" id=\"ember224\" " +
                "class=\"presence-entity__image  ivm-view-attr__img--centered EntityPhoto-circle-6   EntityPhoto-circle-6 evi-image lazy-image ember-view";

        public UserChatItemAdapter(List<UserChatItem> chatListOrder) {
            this.chatList = chatListOrder;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_chat_items, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            UserChatItem chatMsg = chatList.get(position);
            holder.userName.setText(chatMsg.getuserName());
            holder.lastMessage.setText(chatMsg.getlastMessage());
            holder.timestamp.setText(chatMsg.gettimestamp());

//            Glide.with(this)
//                    .load("https://media.licdn.com/dms/image/D4E03AQGf3n4Hpwqt5g/profile-displayphoto-shrink_100_100/0/1684335839018?e=1724889600&amp;v=beta&amp;" +
//                    "t=T-C3TTdiCHyvUu1ZF-CTvxMIF7ls2RlGgFPF076ineM\" loading=\"lazy\" alt=\"Manikanta Nissankara\" id=\"ember224\" " +
//                    "class=\"presence-entity__image  ivm-view-attr__img--centered EntityPhoto-circle-6   EntityPhoto-circle-6 evi-image lazy-image ember-view")
//
//                    .into();

            Log.d("Adpter", "onBindViewHolder: "+chatMsg.getuserName());

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
