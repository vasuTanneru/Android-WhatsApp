package com.example.mywhatsapp.Models;

public class CallsListItems {

        private String userName;
        private String callTime;
        private boolean isIncoming;

        public CallsListItems(String userName, String callTime, boolean isIncoming) {
            this.userName = userName;
            this.callTime = callTime;
            this.isIncoming = isIncoming;
        }

        public String getUserName() {
            return userName;
        }

        public String getCallTime() {
            return callTime;
        }

        public boolean isIncoming() {
            return isIncoming;
        }


}
