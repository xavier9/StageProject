package com.example.xavier.stageproject.Listadaptor;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.xavier.stageproject.Classes.Message;
import com.example.xavier.stageproject.R;

import java.util.ArrayList;

/**
 * Created by xavier on 19/02/2016.
 */
public class MessageArrayAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> values;

    /**
     * Instantiates a new Message array adapter.
     *
     * @param context the context
     * @param values  the values
     */
    public MessageArrayAdapter(Context context, ArrayList<Message> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
       // WebView textView = (WebView) rowView.findViewById(R.id.webView);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
       // Log.e("Lengte", String.valueOf(values.size()));
        Message summary = values.get(position);
        //Log.e("web", summary.toString());


        //textView.setWebChromeClient(new WebChromeClient());
        Spanned marked_up = Html.fromHtml(summary.getMessage());
        /*textView.loadData(summary.getMessage(), "text/html", "utf-8");
        textView.getSettings().setJavaScriptEnabled(true);
        textView.getSettings().setBuiltInZoomControls(false);
        textView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        textView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);*/
        ((TextView) rowView.findViewById(R.id.textView)).setText(marked_up);
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
