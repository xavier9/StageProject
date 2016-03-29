package com.example.xavier.stageproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Links extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_links, container, false);

        //Find the +1 button
        view.findViewById(R.id.Zimbra).setOnClickListener(this);
        view.findViewById(R.id.Learning).setOnClickListener(this);
        view.findViewById(R.id.Alumni).setOnClickListener(this);
        view.findViewById(R.id.Pupils).setOnClickListener(this);
        view.findViewById(R.id.Blog).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Zimbra:
                //Intent intent = new Intent();
                Uri uri = Uri.parse("http://zimbra.eeb2.be/"); // missing 'http://' will cause crashed
                Log.e("URL", uri.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                //intent.setAction(Intent.ACTION_VIEW);
                //intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //intent.setData(Uri.parse(String.valueOf(R.string.URL_Zimbra)));
                //startActivity(intent);
                break;
            case R.id.Learning:
                uri = Uri.parse("https://esb.itslearning.com/"); // missing 'http://' will cause crashed
                Log.e("URL", uri.toString());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.Alumni:
                uri = Uri.parse("http://www.alumnieuropae.org/"); // missing 'http://' will cause crashed
                Log.e("URL", uri.toString());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.Pupils:
                uri = Uri.parse("https://www.facebook.com/EuropeanSchoolBrusselsII"); // missing 'http://' will cause crashed
                Log.e("URL", uri.toString());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.Blog:
                uri = Uri.parse("http://woluweindependent.blogspot.be/"); // missing 'http://' will cause crashed
                Log.e("URL", uri.toString());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }

    }
}
