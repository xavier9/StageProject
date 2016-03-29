package com.example.xavier.stageproject.Roster;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.xavier.stageproject.Classes.Courses;
import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Mysql.ServiceHandler;
import com.example.xavier.stageproject.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class DinsDagFragment extends Fragment {

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

    // contacts JSONArray
    JSONArray contacts = null;    TextView één, twee, drie, vier, vijf, zes, zeven, acht, negen;
    // JSON Node names

    ArrayList<Courses> contactList;
    ArrayList<Courses> courses = new ArrayList<Courses>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.roster, container, false);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
        contactList = new ArrayList<Courses>();
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        final JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            contacts = response.getJSONArray("courses");

                            // looping through All Contacts



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

                            Bundle extra = getActivity().getIntent().getExtras();

                            int test = extra.getInt("studentid");
                            //Log.e("screen", String.valueOf(test));


                            for (Courses ct : contactList) {
                                if (ct.getStudent_id() == test) {
                                    courses.add(ct);
                                }
                            }

                            /*for(Courses cr : courses){
                                Log.e("Cources:", cr.toString());
                            }*/
                            if (pDialog.isShowing())
                                pDialog.dismiss();
                            //new GetCourses().executeOnExecutor(Executors.newSingleThreadExecutor());
                            één = (TextView) getActivity().findViewById(R.id.Eerstelesuur);
                            twee = (TextView) getActivity().findViewById(R.id.Tweedelesuur);
                            drie = (TextView) getActivity().findViewById(R.id.Derdelesuur);
                            vier = (TextView) getActivity().findViewById(R.id.Vierdelesuur);
                            vijf = (TextView) getActivity().findViewById(R.id.Vijfdelesuur);
                            zes = (TextView) getActivity().findViewById(R.id.Zesdelesuur);
                            zeven = (TextView) getActivity().findViewById(R.id.Zevendelesuur);
                            acht = (TextView) getActivity().findViewById(R.id.Achtsetlesuur);
                            negen = (TextView) getActivity().findViewById(R.id.Neegendelesuur);
                            for (Courses c : courses) {
                                switch (c.getDag()) {

                                    case 2:
                                        switch (c.getPeriod()) {
                                            case 1:

                                                één.setText(c.toString());
                                                break;
                                            case 2:
                                                twee.setText(c.toString());
                                                break;
                                            case 3:
                                                drie.setText(c.toString());
                                                break;
                                            case 4:
                                                vier.setText(c.toString());
                                                break;
                                            case 5:
                                                vijf.setText(c.toString());
                                                break;
                                            case 6:
                                                zes.setText(c.toString());
                                                break;
                                            case 7:
                                                acht.setText(c.toString());
                                                break;
                                            case 8:
                                                acht.setText(c.toString());
                                                break;
                                            case 9:
                                                negen.setText(c.toString());
                                                break;
                                        }
                                        break;

                                }
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
        );
        getRequest.setRetryPolicy(new DefaultRetryPolicy(100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(getRequest);
        return rootView;
    }


}
