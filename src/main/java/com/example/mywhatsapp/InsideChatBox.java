package com.example.mywhatsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;


    public class InsideChatBox extends AppCompatActivity {

        private TextView chatUserName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat_box);

            chatUserName = findViewById(R.id.user_name);

            String userName = getIntent().getStringExtra("userName");
            chatUserName.setText(userName);
        }

}
