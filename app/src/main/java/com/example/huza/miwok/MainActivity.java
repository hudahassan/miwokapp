package com.example.huza.miwok;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView number_text;
    TextView family_text;
    TextView color_text;
    TextView phrase_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Miwok");

        number_text = (TextView) findViewById(R.id.numbers);
        family_text = (TextView) findViewById(R.id.family);
        color_text = (TextView) findViewById(R.id.colors);
        phrase_text = (TextView) findViewById(R.id.phrases);







        //  public void number(View view){
        number_text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Numbers.class);
                startActivity(intent);

            }
        });


    }
    public void family(View view){
        Intent intent = new Intent(this, FamilyMember.class);
        startActivity(intent);

    }
    public void color(View view){
        Intent intent = new Intent(this, Colors.class);
        startActivity(intent);

    }
    public void phrase(View view){
        Intent intent = new Intent(this, Phrases.class);
        startActivity(intent);

    }




}

