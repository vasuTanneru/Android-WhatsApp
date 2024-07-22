package com.example.mywhatsapp.Fraguments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywhatsapp.Adapter.UserChatItemAdapter;
import com.example.mywhatsapp.MainActivity;
import com.example.mywhatsapp.Models.UserChatItem;
import com.example.mywhatsapp.MySingleton;
import com.example.mywhatsapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UserChatItemFragment extends Fragment {

        private RecyclerView recyclerView;
        private UserChatItemAdapter UserChatItemAdapter;
        private List<UserChatItem> chatList;
        public List<UserChatItem> chatItemLists;

        public UserChatItemFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_chat, container, false);
            Log.d("Fragment", "onCreateView: "+"Showing Frag");
            recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()
            ));

            chatItemLists = new ArrayList<>();
           UserChatItemAdapter = new UserChatItemAdapter(chatItemLists);
            recyclerView.setAdapter(UserChatItemAdapter);
            fetchChatItems();

            chatList = new ArrayList<>();
            chatList.add(new UserChatItem("Vasu Tanneru", "Hey, how are you?", "10:30 AM"));
            chatList.add(new UserChatItem("Mani Kanta N", "Let's catch up later.", "Yesterday"));
            chatList.add(new UserChatItem("Gautham Kiran", "Check this out!", "2 days ago"));
            chatList.add(new UserChatItem("AbhiLash B", "Good morning!", "8:00 AM"));

            UserChatItemAdapter = new UserChatItemAdapter(chatList);
            recyclerView.setAdapter(UserChatItemAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            return view;
        }

        public void fetchChatItems () {
            String url = "https://localhost:44330/get_chat_items";
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    chatItemLists.clear();
                    JSONArray arrayRes;
                    try {
                        arrayRes = response.getJSONArray("Data");
                    }catch (Exception ex){
                        arrayRes = new JSONArray();
                    }
                    for (int i = 0; i < arrayRes.length(); i++) {
                        try {
                            JSONObject jsonObject = arrayRes.getJSONObject(i);
                            UserChatItem chatItem = new UserChatItem();
                            chatItem.setuserName(jsonObject.getString("userName"));
                            chatItem.setlastMessage(jsonObject.getString("lastMessage"));
                            chatItem.settimestamp(jsonObject.getString("timestamp"));
                            chatItemLists.add(chatItem);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    UserChatItemAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(request);
        }

        private void trustAllCertificates() {
            try {
                TrustManager[] trustAllCerts = new TrustManager[] {
                        new X509TrustManager() {
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }
                            public void checkClientTrusted(
                                    java.security.cert.X509Certificate[] certs, String authType) {
                            }
                            public void checkServerTrusted(
                                    java.security.cert.X509Certificate[] certs, String authType) {
                            }
                        }
                };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                HostnameVerifier allHostsValid = (hostname, session) -> true;
                HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

