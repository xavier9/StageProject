package com.example.xavier.stageproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.xavier.stageproject.Classes.Absence;
import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Listadaptor.AbenceArrayAdaptor;
import com.example.xavier.stageproject.Mysql.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Absence activity.
 */
public class AbsenceActivity extends ListFragment {

    private ProgressDialog pDialog;
    /**
     * The Products list.
     */
    ArrayList<HashMap<String, String>> productsList;
    // URL to get contacts JSON
    private static String url = Global.URL + Global.Absece;

    // JSON Node names
    private static final String TAG_Table = "absence";
    private static final String TAG_ID = "absence_ID";
    private static final String TAG_NAME = "title";
    private static final String TAG_Visible = "name";
    private static final String TAG_houwers = "hours";
    private static final String TAG_dag = "date";


    /**
     * The Contacts.
     */
// contacts JSONArray
    JSONArray contacts = null;

    /**
     * The Contact list.
     */
// Hashmap for ListView
    ArrayList<Absence> contactList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.absence, container, false);
        contactList = new ArrayList<Absence>();
        new GetAbsences().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return rootView;
    }


    private class GetAbsences extends AsyncTask<Void, Void, Void> {

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

                    // Getting JSON Array nod

                        contacts = jsonObj.getJSONArray(TAG_Table);

                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);

                            int id = c.getInt(TAG_ID);
                            String name = c.getString(TAG_NAME);
                            // Log.e("Boolean", c.getString(TAG_Visible));
                            String vis = c.getString(TAG_Visible);
                            String hour = c.getString(TAG_houwers);
                            String dag = c.getString(TAG_dag);


                            // tmp hashmap for single contact
                            Absence contact = new Absence();

                            // adding each child node to HashMap key => value
                            contact.setID(id);
                            contact.setTitle(name);
                            contact.setName(vis);
                            contact.setHours(hour);
                            contact.setDate(dag);


                            // adding contact to contact list
                            contactList.add(contact);
                        }

                    }catch(JSONException e){
                    Absence contact = new Absence();
                    contactList.add(contact);
                        //e.printStackTrace();
                    }
                }else{
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

            ListAdapter adapter = new AbenceArrayAdaptor(getActivity(),contactList);
            // updating listview
           setListAdapter(adapter);

           // Log.e("Size", String.valueOf(contact.length));

        }

    }
}
