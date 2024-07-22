package com.example.mywhatsapp.Models;

public class UserChatItem {

        public String userName;
        public String lastMessage;
        public String timestamp;

    public UserChatItem( String userName, String lastMessage, String timestamp) {
        this.userName = userName;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
    }

    public UserChatItem() {

    }


    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getlastMessage() {
        return lastMessage;
    }

    public void setlastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String gettimestamp() {
        return timestamp;
    }

    public void settimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
