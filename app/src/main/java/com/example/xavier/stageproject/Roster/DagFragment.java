package com.example.xavier.stageproject.Roster;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xavier.stageproject.Classes.Courses;
import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Mysql.ServiceHandler;
import com.example.xavier.stageproject.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressLint("ValidFragment")
public class DagFragment extends Fragment {

    private ProgressDialog pDialog;
    private static String url = Global.URL + Global.Cources;
    private static final String TAG_Table = "courses";
    private static final String TAG_ID = "Student_id";
    private static final String TAG_Day = "Day";
    private static final String TAG_Description = "Code";
    private static final String TAG_First_Name = "First_name";
    private static final String TAG_Last_Name = "Last_name";
    private static final String TAG_Period = "Period";
    private static final String TAG_Room = "Room";
    int load = 0;

    // contacts JSONArray
    JSONArray contacts = null;
    TextView één, twee, drie, vier, vijf, zes, zeven, acht, negen;
    // JSON Node names

    ArrayList<Courses> contactList;
    ArrayList<Courses> courses = new ArrayList<Courses>();
    int tabs;

    @SuppressLint("ValidFragment")
    public DagFragment(int tab){
        tabs = tab;
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.roster, container, false);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        contactList = new ArrayList<Courses>();

        Bundle extra = getActivity().getIntent().getExtras();
        if(load == 0) {
            int test = extra.getInt("studentid");
            url = url + "?Student_id=" + test + "";
            Log.e("URL", url);
            load = 1;
        }
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        final JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Bundle extra = getActivity().getIntent().getExtras();

                        /*int test = extra.getInt("studentid");
                        url = url +"?Student_id="+test+"";
                        Log.e("URL", url);*/
                        try {
                            contacts = response.getJSONArray("courses");
                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject cs = contacts.getJSONObject(i);
                                int id = cs.getInt(TAG_ID);
                                //Log.e("ID", String.valueOf(id));
                                int name = cs.getInt(TAG_Day);
                                // Log.e("Boolean", c.getString(TAG_Visible));
                                String vis = cs.getString(TAG_Description);
                                int screen = cs.getInt(TAG_Period);
                                String screen1 = cs.getString(TAG_Room);
                                String f = cs.getString(TAG_First_Name);
                                String l = cs.getString(TAG_Last_Name);


                                // tmp hashmap for single contact


                                Courses contact = new Courses();

                                // adding each child node to HashMap key => value
                                contact.setStudent_id(id);
                                contact.setDag(name);
                                contact.setDescription(vis);
                                contact.setPeriod(screen);
                                contact.setRoom(screen1);
                                contact.setFirst_name(f);
                                contact.setLaste_name(l);


                                // adding contact to contact list
                                contactList.add(contact);


                            }


                            /*for(Courses cr : courses){
                                Log.e("Cources:", cr.toString());
                            }*/
                            if (pDialog.isShowing())
                                pDialog.dismiss();
                            //new GetCourses().executeOnExecutor(Executors.newSingleThreadExecutor());
                            één = (TextView) rootView.findViewById(R.id.Eerstelesuur);
                            twee = (TextView) rootView.findViewById(R.id.Tweedelesuur);
                            drie = (TextView) rootView.findViewById(R.id.Derdelesuur);
                            vier = (TextView) rootView.findViewById(R.id.Vierdelesuur);
                            vijf = (TextView) rootView.findViewById(R.id.Vijfdelesuur);
                            zes = (TextView) rootView.findViewById(R.id.Zesdelesuur);
                            zeven = (TextView) rootView.findViewById(R.id.Zevendelesuur);
                            acht = (TextView) rootView.findViewById(R.id.Achtsetlesuur);
                            negen = (TextView) rootView.findViewById(R.id.Neegendelesuur);
                            //Log.e("Tab3", tabs + "");



                            switch(tabs) {
                                case 0:
                                    for (Courses cm : contactList) {
                                        switch (cm.getDag()) {
                                            case 1:

                                                switch (cm.getPeriod()) {
                                                    case 1:
                                                        //Log.e("Dag", "uur1");
                                                        één.setText(cm.toString());
                                                        break;
                                                    case 2:
                                                        //Log.e("Dag", "uur2");
                                                        twee.setText(cm.toString());
                                                        break;
                                                    case 3:
                                                        //Log.e("Dag", "uur3");
                                                        drie.setText(cm.toString());
                                                        break;
                                                    case 4:
                                                       // Log.e("Dag", "uur4");
                                                        vier.setText(cm.toString());
                                                        break;
                                                    case 5:
                                                        vijf.setText(cm.toString());
                                                        break;
                                                    case 6:
                                                        zes.setText(cm.toString());
                                                        break;
                                                    case 7:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 8:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 9:
                                                        negen.setText(cm.toString());
                                                        break;
                                                }
                                                break;


                                        }
                                    }
                                    break;
                                case 1:
                                    for (Courses cm : contactList) {
                                        switch (cm.getDag()) {
                                            case 2:
                                                switch (cm.getPeriod()) {
                                                    case 1:
                                                       // Log.e("Dag", "uur1");
                                                        één.setText(cm.toString());
                                                        break;
                                                    case 2:
                                                        twee.setText(cm.toString());
                                                        break;
                                                    case 3:
                                                        drie.setText(cm.toString());
                                                        break;
                                                    case 4:
                                                        vier.setText(cm.toString());
                                                        break;
                                                    case 5:
                                                        vijf.setText(cm.toString());
                                                        break;
                                                    case 6:
                                                        zes.setText(cm.toString());
                                                        break;
                                                    case 7:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 8:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 9:
                                                        negen.setText(cm.toString());
                                                        break;
                                                }
                                                break;


                                        }
                                    }
                                    break;
                                case 2:
                                    for (Courses cm : contactList) {
                                        switch (cm.getDag()) {
                                            case 3:
                                                switch (cm.getPeriod()) {
                                                    case 1:
                                                        //Log.e("Dag", "uur1");
                                                        één.setText(cm.toString());
                                                        break;
                                                    case 2:
                                                        twee.setText(cm.toString());
                                                        break;
                                                    case 3:
                                                        drie.setText(cm.toString());
                                                        break;
                                                    case 4:
                                                        vier.setText(cm.toString());
                                                        break;
                                                    case 5:
                                                        vijf.setText(cm.toString());
                                                        break;
                                                    case 6:
                                                        zes.setText(cm.toString());
                                                        break;
                                                    case 7:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 8:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 9:
                                                        negen.setText(cm.toString());
                                                        break;
                                                }
                                                break;


                                        }
                                    }
                                    break;
                                case 3:
                                    for (Courses cm : contactList) {
                                        switch (cm.getDag()) {
                                            case 4:
                                                switch (cm.getPeriod()) {
                                                    case 1:
                                                        //Log.e("Dag", "uur1");
                                                        één.setText(cm.toString());
                                                        break;
                                                    case 2:
                                                        twee.setText(cm.toString());
                                                        break;
                                                    case 3:
                                                        drie.setText(cm.toString());
                                                        break;
                                                    case 4:
                                                        vier.setText(cm.toString());
                                                        break;
                                                    case 5:
                                                        vijf.setText(cm.toString());
                                                        break;
                                                    case 6:
                                                        zes.setText(cm.toString());
                                                        break;
                                                    case 7:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 8:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 9:
                                                        negen.setText(cm.toString());
                                                        break;
                                                }
                                                break;


                                        }
                                    }
                                    break;
                                case 4:
                                    for (Courses cm : contactList) {
                                        switch (cm.getDag()) {
                                            case 5:
                                                switch (cm.getPeriod()) {
                                                    case 1:
                                                       // Log.e("Dag", "uur1");
                                                        één.setText(cm.toString());
                                                        break;
                                                    case 2:
                                                        twee.setText(cm.toString());
                                                        break;
                                                    case 3:
                                                        drie.setText(cm.toString());
                                                        break;
                                                    case 4:
                                                        vier.setText(cm.toString());
                                                        break;
                                                    case 5:
                                                        vijf.setText(cm.toString());
                                                        break;
                                                    case 6:
                                                        zes.setText(cm.toString());
                                                        break;
                                                    case 7:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 8:
                                                        acht.setText(cm.toString());
                                                        break;
                                                    case 9:
                                                        negen.setText(cm.toString());
                                                        break;
                                                }
                                                break;


                                        }
                                    }
                                    break;
                            }



                        } catch (JSONException e) {
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
        ) ;
        getRequest.setRetryPolicy(new DefaultRetryPolicy(500000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //Log.e("Request", getRequest.toString());
        queue.add(getRequest);
       // queue.add(getRequest);
        return rootView;
    }

}
