package com.example.huza.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChange=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);

            }else if(focusChange==AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                ReleaseResource();
            }


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ListView listView=(ListView)findViewById(R.id.list_number);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);







        //  final MediaPlayer.OnCompletionListener mcompletionListener=new MediaPlayer.OnCompletionListener(){

        //      public void onCompletion(MediaPlayer mp) {
        //                  ReleaseResource();
        //      }
        // };

        final ArrayList<word> item=new ArrayList<word>();
        item.add(new word(R.string.number_one, R.string.miwok_number_one,
                R.drawable.number_one, R.raw.number_one));
        item.add(new word(R.string.number_two, R.string.miwok_number_two,
                R.drawable.number_two, R.raw.number_two));
        item.add(new word(R.string.number_three, R.string.miwok_number_three,
                R.drawable.number_three, R.raw.number_three));
        item.add(new word(R.string.number_four, R.string.miwok_number_four,
                R.drawable.number_four, R.raw.number_four));
        item.add(new word(R.string.number_five, R.string.miwok_number_five,
                R.drawable.number_five, R.raw.number_five));
        item.add(new word(R.string.number_six, R.string.miwok_number_six,
                R.drawable.number_six, R.raw.number_six));
        item.add(new word(R.string.number_seven, R.string.miwok_number_seven,
                R.drawable.number_seven, R.raw.number_seven));
        item.add(new word(R.string.number_eight, R.string.miwok_number_eight,
                R.drawable.number_eight, R.raw.number_eight));
        item.add(new word(R.string.number_nine, R.string.miwok_number_nine,
                R.drawable.number_nine, R.raw.number_nine));
        item.add(new word(R.string.number_ten, R.string.miwok_number_ten,
                R.drawable.number_ten, R.raw.number_ten));


        final adapter adapter=new adapter(this,item,R.color.category_numbers);
        listView.setAdapter(adapter);

        int result = audioManager.requestAudioFocus(onAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    word wor = item.get(position);

                    ReleaseResource();




                    mediaPlayer = MediaPlayer.create(Numbers.this, wor.getAudio_Resource());

                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            ReleaseResource();
                        }
                    });
                }
            });
        }}




    private void ReleaseResource(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
            audioManager.abandonAudioFocus(onAudioFocusChange);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        ReleaseResource();

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(Numbers.this);
                return true;
        }
        return true;
    }
}
