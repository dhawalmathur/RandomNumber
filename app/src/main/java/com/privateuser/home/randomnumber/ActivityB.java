package com.privateuser.home.randomnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class ActivityB extends AppCompatActivity {

    private TextView textB = null;
    private Button buttonB = null;
    private Intent intentB = null;
    private int randomNumberToReceive = 0;
    private int randomNumberToSend = 0;
    private int minNumber = 0;
    private int maxNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // typecasting
        textB = (TextView) findViewById(R.id.textB);
        buttonB = (Button) findViewById(R.id.buttonB);
        intentB = new Intent(ActivityB.this, ActivityA.class);

        // getting values through intent
        if(getIntent() != null) {
            minNumber = getIntent().getIntExtra("minNumber", 0);
            maxNumber = getIntent().getIntExtra("maxNumber", 0);
            randomNumberToReceive = getIntent().getIntExtra("fromA", 0);
            textB.setText(String.valueOf(randomNumberToReceive));
        }

        // click listener
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // generating random number
                randomNumberToSend = ThreadLocalRandom.current().nextInt(minNumber, maxNumber);
                // starting Activity B
                intentB.putExtra("fromB", randomNumberToSend);
                intentB.putExtra("minNumber", minNumber);
                intentB.putExtra("maxNumber", maxNumber);
                startActivity(intentB);
                finish();
            }
        });

    }
}
