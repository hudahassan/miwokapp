package com.example.huza.miwok;

import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ListView listView=(ListView)findViewById(R.id.list_color);



        final ArrayList<word> item=new ArrayList<word>();
        item.add(new word(R.string.color_red, R.string.miwok_color_red,
                R.drawable.color_red, R.raw.color_red));
        item.add(new word(R.string.color_mustard_yellow, R.string.miwok_color_mustard_yellow,
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        item.add(new word(R.string.color_dusty_yellow, R.string.miwok_color_dusty_yellow,
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        item.add(new word(R.string.color_green, R.string.miwok_color_green,
                R.drawable.color_green, R.raw.color_green));
        item.add(new word(R.string.color_brown, R.string.miwok_color_brown,
                R.drawable.color_brown, R.raw.color_brown));
        item.add(new word(R.string.color_gray, R.string.miwok_color_gray,
                R.drawable.color_gray, R.raw.color_gray));
        item.add(new word(R.string.color_black, R.string.miwok_color_black,
                R.drawable.color_black, R.raw.color_black));
        item.add(new word(R.string.color_white, R.string.miwok_color_white,
                R.drawable.color_white, R.raw.color_white));

        adapter adapter=new adapter(this,item,R.color.category_colors);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wor=item.get(position);

                mediaPlayer= MediaPlayer.create(Colors.this,wor.getAudio_Resource());

                mediaPlayer.start();
                Toast.makeText(Colors.this,"hiiii",Toast.LENGTH_LONG).show();
            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(Colors.this);
                return true;
        }
        return true;
    }
}
