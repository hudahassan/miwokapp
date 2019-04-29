package com.example.huza.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by huza on 3/15/2019.
 */

public class adapter extends ArrayAdapter<word> {
    private static final String LOG_TAG=adapter.class.getSimpleName();

    private int color;
    // ArrayList<word> item=new ArrayList<word>();

    public adapter(@NonNull Activity context, ArrayList<word> item,int mcolor) {
        super(context,0,item);
        color=mcolor;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        word item=getItem(position);
        View view=convertView;
        if (view==null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }
        TextView textView1=(TextView)view.findViewById(R.id.text1);
        textView1.setText(item.getMessage());

        TextView textView2=(TextView)view.findViewById(R.id.text2);
        textView2.setText(item.getDefault_message());


        ImageView imageView=(ImageView)view.findViewById(R.id.image);

        //  Button button=(Button)view.findViewById(R.id.button);


        if(item.hasimage()) {
            imageView.setImageResource(item.getImage());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);

        }

        LinearLayout container=(LinearLayout)view.findViewById(R.id.linear);
        int Color= ContextCompat.getColor(getContext(),color);
        container.setBackgroundColor(Color);

        return view;
    }
}
