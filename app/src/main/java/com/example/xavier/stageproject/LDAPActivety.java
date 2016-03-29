package com.example.xavier.stageproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.xavier.stageproject.Classes.Global;
import com.example.xavier.stageproject.Classes.Message;
import com.example.xavier.stageproject.Classes.Student;
import com.example.xavier.stageproject.Mysql.ServiceHandler;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.examples.LDAPSearch;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttribute;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPAttributeSet;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPEntry;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPSearchResults;
import com.unboundid.ldap.sdk.persist.LDAPField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;


public class LDAPActivety extends AppCompatActivity implements View.OnClickListener{

    EditText user, pass;
    TextView err;
    ArrayList<String> userinfo= new ArrayList<String>();

    private ProgressDialog pDialog;
    ArrayList<Student> productsList;
    // URL to get contacts JSON
    private static String url = Global.URL + Global.Student;

    // JSON Node names
    private static final String TAG_Table = "student";
    private static final String TAG_ID = "ID";
    private static final String TAG_NAME = "Class";
    //private static final String TAG_Visible = "visibility";


    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<Student> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //LDAPConnection con = new LDAPConnection();
        //LDAPConnection con1 = new LDAPConnection();
        user = (EditText) findViewById(R.id.Username);
        pass = (EditText) findViewById(R.id.Password);
        err = (TextView) findViewById(R.id.Error);
        Button login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(this);

        /*Button message = (Button) findViewById(R.id.Message);
        message.setOnClickListener(this);
        Button afwezig = (Button) findViewById(R.id.Afwezigen);
        afwezig.setOnClickListener(this);*/

       /* try {
            con1.connect(Global.LDAPURL, Global.LDAPPOORT);

        } catch (LDAPException e) {
            e.printStackTrace();
        }*/
        //Log.e("Bind", );

        //setup input fields

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Login:
                err.setText("");
                //Play voicefile
                //MediaPlayer.create(getBaseContext(), R.raw.voicefile).start();
                //Log.e("Login", "Login");
                final String[] error = new String[1];

                if(!user.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {
                    final LDAPConnection con = new LDAPConnection();
                    this.runOnUiThread(new Runnable() {
                        public void run() {


                    try {

                        con.connect(Global.LDAPURL, Global.LDAPPOORT);
                        Log.e("Connected", String.valueOf(con.isConnected()));

                    } catch (LDAPException e) {

                        try {
                            con.connect(Global.LDAPURLLocal, Global.LDAPLocalPoort);
                            Log.e("Connected", String.valueOf(con.isConnected()));
                        } catch (LDAPException e1) {
                            e1.printStackTrace();
                        }

                    }

                    Log.e("Connected", String.valueOf(con.isConnected()));

                    try {

                        String format = "uid=%s,ou=Users,dc=eeb2,dc=be";
                        String ldapuser = String.format(format, user.getText().toString());
                        String searchDn = "(objectclass=*)";
                        String[] myAttrs = {"cn", "employeenumber", "gidnumber", "postalcode"};

                        con.bind(ldapuser, pass.getText().toString());

                        SearchResultEntry st = con.getEntry(ldapuser);
                       // Log.e("Entry", st.toString());
                        SearchResult myResults = null;


                        SearchResult searchResults;
                        searchResults = con.search(ldapuser, SearchScope.SUB,
                                searchDn, myAttrs);

                        //Log.e("Search", searchResults.toString());
                        List<SearchResultEntry> sre = searchResults.getSearchEntries();
                        //Log.e("Search lengt", String.valueOf(sre.size()));
                        for (SearchResultEntry s : sre) {
                           // Log.e("Search", s.toString());
                           // Log.e("Search", String.valueOf(myAttrs.length));
                            for (int i = 0; i < myAttrs.length; i++) {
                                String sts = s.getAttributeValue(myAttrs[i]);
                                userinfo.add(sts);
                               // Log.e("Search", sts);
                            }
                        }
                        contactList = new ArrayList<Student>();

                        new GetContacts().execute();


                    } catch (LDAPException e) {
                        //err.setVisibility(View.VISIBLE);

                        err.setVisibility(View.VISIBLE);
                        err.setText(e.getMessage());
                        Log.e("Error", e.getMessage());

                    }
                        }
                    });

                }else{
                    err.setVisibility(View.VISIBLE);
                   err.setText(R.string.user_pass);
                }

                break;

           /* case R.id.Message:
                //Stop MediaPlayer
                ///MediaPlayer.create(getBaseContext(), R.raw.voicefile).stop();
                intent = new Intent(this, MessageActivity.class);
                this.startActivity(intent);
                break;
            case R.id.Afwezigen:
                //Stop MediaPlayer
                ///MediaPlayer.create(getBaseContext(), R.raw.voicefile).stop();
                intent = new Intent(this, AbsenceActivity.class);
                this.startActivity(intent);
                break;*/
        }
    }
    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
           pDialog = new ProgressDialog(LDAPActivety.this);
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




                        // tmp hashmap for single contact
                        Student contact = new Student();

                        // adding each child node to HashMap key => value
                        contact.setID(id);
                        contact.setKlass(name);



                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                //Log.e("ServiceHandler", "Couldn't get any data from the url");
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
            Student stud = new Student();
            //Log.e("Student", userinfo.get(1));
            stud.setID(Integer.parseInt(userinfo.get(1)));
            for(Student student : contactList){
                if(student.getID() == stud.getID()) {
                    char[] ch = student.getKlass().toCharArray();
                    //Log.e("Char:", ch[0]+"/n"+ch[1]);
                    switch (String.valueOf(ch[1])) {
                        case "1":
                            Intent intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("screen", 1);
                            intent.putExtra("studentid", student.getID());
                            startActivity(intent);
                            break;
                        case "2":
                            intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("studentid", student.getID());
                            intent.putExtra("screen", 1);
                            startActivity(intent);
                            break;
                        case "3":
                            intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("studentid", student.getID());

                            intent.putExtra("screen", 2);
                            startActivity(intent);
                            break;
                        case "4":
                            intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("studentid", student.getID());
                            intent.putExtra("screen", 2);
                            startActivity(intent);
                            break;
                        case "5":
                            intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("studentid", student.getID());
                            intent.putExtra("screen", 3);
                            startActivity(intent);
                            break;
                        case "6":
                            intent = new Intent(getApplication(),MainActivity.class);
                            intent.putExtra("studentid", student.getID());
                            intent.putExtra("screen", 3);
                            startActivity(intent);

                        case "7":
                            intent = new Intent(getApplication(), MainActivity.class);
                            intent.putExtra("studentid", student.getID());
                            intent.putExtra("screen",3);
                            startActivity(intent);
                            break;
                        default:
                            /*intent = new Intent(getApplication(), MessageActivity.class);
                            intent.putExtra("screen", 0);
                            startActivity(intent);*/

                    }
                }
            }


            //Log.e("Size", String.valueOf(contact.length));

        }

    }
}


