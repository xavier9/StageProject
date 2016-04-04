package com.example.xavier.stageproject.Listadaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.xavier.stageproject.Classes.Courses;
import com.example.xavier.stageproject.R;

import java.util.ArrayList;

/**
 * Created by xavier on 26/02/2016.
 */
public class CourseArrayAdaptor extends ArrayAdapter<Courses> {
    private final Context context;
    private final ArrayList<Courses> values;

    /**
     * Instantiates a new Course array adaptor.
     *
     * @param context the context
     * @param values  the values
     */
    public CourseArrayAdaptor(Context context,ArrayList<Courses>values){
            super(context, R.layout.list_item_ab,values);
            this.context=context;
            this.values=values;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater=(LayoutInflater)context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView=inflater.inflate(R.layout.list_item_ab,parent,false);
            Courses summary;
            if(values.get(position)!=null){

                summary=values.get(position);
               //Log.e("Absence", summary.toString());
                ((TextView)rowView.findViewById(R.id.textView)).setText(summary.toString());



            }else{((TextView)rowView.findViewById(R.id.textView)).setText("No Absence");
            }
            //change the icon for Windows and iPhone
            //String s = values[position];
            /*if (s.startsWith("iPhone")) {
                imageView.setImageResource(R.drawable.no);
            } else {
                imageView.setImageResource(R.drawable.ok);
            }*/

            return rowView;
    }
}