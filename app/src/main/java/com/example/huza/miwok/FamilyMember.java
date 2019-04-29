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

public class FamilyMember extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);

        ListView listView=(ListView)findViewById(R.id.list_family);

        final ArrayList<word> item=new ArrayList<word>();
        item.add(new word(R.string.family_father, R.string.miwok_family_father,
                R.drawable.family_father, R.raw.family_father));
        item.add(new word(R.string.family_mother, R.string.miwok_family_mother,
                R.drawable.family_mother, R.raw.family_mother));
        item.add(new word(R.string.family_son, R.string.miwok_family_son,
                R.drawable.family_son, R.raw.family_son));
        item.add(new word(R.string.family_daughter, R.string.miwok_family_daughter,
                R.drawable.family_daughter, R.raw.family_daughter));
        item.add(new word(R.string.family_older_brother, R.string.miwok_family_older_brother,
                R.drawable.family_older_brother, R.raw.family_older_brother));
        item.add(new word(R.string.family_younger_brother, R.string.miwok_family_younger_brother,
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        item.add(new word(R.string.family_older_sister, R.string.miwok_family_older_sister,
                R.drawable.family_older_sister, R.raw.family_older_sister));
        item.add(new word(R.string.family_younger_sister, R.string.miwok_family_younger_sister,
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        item.add(new word(R.string.family_grandmother, R.string.miwok_family_grandmother,
                R.drawable.family_grandmother, R.raw.family_grandmother));
        item.add(new word(R.string.family_grandfather, R.string.miwok_family_grandfather,
                R.drawable.family_grandfather, R.raw.family_grandfather));

        adapter adapter=new adapter(this,item,R.color.category_family);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word wor=item.get(position);

                mediaPlayer= MediaPlayer.create(FamilyMember.this,wor.getAudio_Resource());

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
                NavUtils.navigateUpFromSameTask(FamilyMember.this);
                return true;
        }
        return true;
    }

}
