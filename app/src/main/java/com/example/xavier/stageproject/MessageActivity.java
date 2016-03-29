package com.example.xavier.stageproject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Classes.Message;
import com.example.xavier.stageproject.Listadaptor.MessageArrayAdapter;
import com.example.xavier.stageproject.Mysql.ServiceHandler;
import com.example.xavier.stageproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

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
        new GetMessages().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return rootView;
    }

    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetMessages extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            //Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    contacts = jsonObj.getJSONArray(TAG_Table);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        int id = c.getInt(TAG_ID);
                        //Log.e("ID", String.valueOf(id));
                        String name = c.getString(TAG_NAME);
                       // Log.e("Boolean", c.getString(TAG_Visible));
                        boolean vis = false;
                        switch (c.getString(TAG_Visible)){
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
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

            //Log.e("Size", String.valueOf(contact.length));
            ListAdapter adapter = new MessageArrayAdapter(getActivity(),contacts);
            // updating listview
            setListAdapter(adapter);
        }

    }

}
