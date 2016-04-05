package com.example.xavier.stageproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Classes.Message;
import com.example.xavier.stageproject.Listadaptor.MessageArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MessageActivity extends ListFragment {

    private ProgressDialog pDialog;
    ArrayList<Message> productsList;
    // URL to get contacts JSON
    private static String url = Global.URL + Global.Message;

    // JSON Node names
    private static final String TAG_Table = "message";
    private static final String TAG_ID = "message_ID";
    private static final String TAG_NAME = "message";
    private static final String TAG_Visible = "visibility";


    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<Message> contactList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.message, container, false);
        contactList = new ArrayList<Message>();
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        final JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Bundle extra = getActivity().getIntent().getExtras();

                        /*int test = extra.getInt("studentid");
                        url = url +"?Student_id="+test+"";
                        Log.e("URL", url);*/
                        try {
                            contacts = response.getJSONArray("message");
                            for (int i = 0; i < contacts.length(); i++) {


                                    JSONObject c = contacts.getJSONObject(i);

                                    int id = c.getInt(TAG_ID);
                                    //Log.e("ID", String.valueOf(id));
                                    String name = c.getString(TAG_NAME);
                                    // Log.e("Boolean", c.getString(TAG_Visible));
                                    boolean vis = false;
                                    switch (c.getString(TAG_Visible)) {
                                        case "0":
                                            vis = false;
                                            break;
                                        case "1":
                                            vis = true;
                                            break;
                                    }
                                    int screen = c.getInt("screen_ID");


                                    // tmp hashmap for single contact
                                    Message contact = new Message();

                                    // adding each child node to HashMap key => value
                                    contact.setID(id);
                                    contact.setMessage(name);
                                    contact.setVisible(vis);
                                    contact.setScreen(screen);


                                    // adding contact to contact list
                                    contactList.add(contact);
                                }
                            ArrayList<Message> contacts =new ArrayList<Message>();
                            for(int i  = 0; i < contactList.size(); i++){
                                //Log.i("Test", contactList.get(i).get(TAG_NAME));
                                //Log.i("Test", contactList.get(i).toString());
                                //Log.e("Visible", contactList.get(i).get(TAG_Visible));
                                Bundle extra = getActivity().getIntent().getExtras();
                                int test = extra.getInt("screen");
                                // Log.e("screen", String.valueOf(test));
                                if(contactList.get(i).getVisible() && contactList.get(i).getScreen() == test){
                                    contacts.add(contactList.get(i));
                                    //Log.e("visible", "visible");

                                }



                            }
                            Log.e("Size", String.valueOf(contactList.size()));
                            ListAdapter adapter = new MessageArrayAdapter(getActivity(),contacts);
                            // updating listview
                            setListAdapter(adapter);


                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    },
                 new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                }
                }

                    );
                    getRequest.setRetryPolicy(new

                    DefaultRetryPolicy(500000,
                                       DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

                    );
                    //Log.e("Request", getRequest.toString());
        queue.add(getRequest);

        //new GetMessages().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return rootView;
    }

}
