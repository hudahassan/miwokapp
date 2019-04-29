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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ListView listView=(ListView)findViewById(R.id.list_phrase);

        final ArrayList<word> item=new ArrayList<word>();
        item.add(new word(R.string.phrase_where_are_you_going,
                R.string.miwok_phrase_where_are_you_going, R.raw.phrase_where_are_you_going));
        item.add(new word(R.string.phrase_what_is_your_name,
                R.string.miwok_phrase_what_is_your_name, R.raw.phrase_what_is_your_name));
        item.add(new word(R.string.phrase_my_name_is,
                R.string.miwok_phrase_my_name_is, R.raw.phrase_my_name_is));
        item.add(new word(R.string.phrase_how_are_you_feeling,
                R.string.miwok_phrase_how_are_you_feeling, R.raw.phrase_how_are_you_feeling));
        item.add(new word(R.string.phrase_im_feeling_good,
                R.string.miwok_phrase_im_feeling_good, R.raw.phrase_im_feeling_good));
        item.add(new word(R.string.phrase_are_you_coming,
                R.string.miwok_phrase_are_you_coming, R.raw.phrase_are_you_coming));
        item.add(new word(R.string.phrase_yes_im_coming,
                R.string.miwok_phrase_yes_im_coming, R.raw.phrase_yes_im_coming));
        item.add(new word(R.string.phrase_im_coming,
                R.string.miwok_phrase_im_coming, R.raw.phrase_im_coming));
        item.add(new word(R.string.phrase_lets_go,
                R.string.miwok_phrase_lets_go, R.raw.phrase_lets_go));
        item.add(new word(R.string.phrase_come_here,
                R.string.miwok_phrase_come_here, R.raw.phrase_come_here));

        adapter adapter=new adapter(this,item,R.color.category_phrases);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wor=item.get(position);

                mediaPlayer= MediaPlayer.create(Phrases.this,wor.getAudio_Resource());

                mediaPlayer.start();

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
                NavUtils.navigateUpFromSameTask(Phrases.this);
                return true;
        }
        return true;
    }
}
