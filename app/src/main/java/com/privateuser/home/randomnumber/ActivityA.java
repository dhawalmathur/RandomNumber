package com.privateuser.home.randomnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class ActivityA extends AppCompatActivity {

    private TextView textA = null;
    private Button buttonA = null;
    private Intent intentA = null;
    private int randomNumberToSend = 0;
    private int randomNumberToReceive = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // typecasting
        textA = (TextView) findViewById(R.id.textA);
        buttonA = (Button) findViewById(R.id.buttonA);
        intentA = new Intent(ActivityA.this, ActivityB.class);

        // getting values through intent
        if(getIntent() != null) {
            randomNumberToReceive = getIntent().getIntExtra("fromB", 0);
            // Setting Random Number to the TextView
            textA.setText(String.valueOf(randomNumberToReceive));
        }

        // click listener
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // generating random number
                randomNumberToSend = ThreadLocalRandom.current().nextInt();
                // starting Activity B
                intentA.putExtra("fromA", randomNumberToSend);
                startActivity(intentA);
                finish();
            }
        });

    }
}
