package com.privateuser.home.randomnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText et_minimum = null;
    private EditText et_maximum = null;
    private Button btn_done = null;
    private Button btn_skip = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // typecasting
        et_minimum = (EditText) findViewById(R.id.et_minimum);
        et_maximum = (EditText) findViewById(R.id.et_maximum);
        btn_done = (Button) findViewById(R.id.btn_done);
        btn_skip = (Button) findViewById(R.id.btn_skip);
        intent = new Intent(FirstActivity.this, ActivityA.class);

        // setting on-click listener
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting inputs from user
                String min = et_minimum.getText().toString().trim();
                String max = et_maximum.getText().toString().trim();
                try {
                    int minNumber = Integer.parseInt(min);
                    int maxNumber = Integer.parseInt(max);

                    // sending required values to Activity A
                    intent.putExtra("minNumber", minNumber);
                    intent.putExtra("maxNumber", maxNumber);
                    intent.putExtra("flag", FirstActivity.class.getSimpleName());

                    // starting Activity A
                    startActivity(intent);
                    finish();
                } catch (Exception ex) {
                    Toast.makeText(FirstActivity.this, getString(R.string.str_err_range), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting Activity A
                intent.putExtra("skipped", true);
                startActivity(intent);
                finish();
            }
        });

        // TextWatcher
        et_minimum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().startsWith("-") || s.toString().startsWith("+")) {
                    et_minimum.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                } else {
                    et_minimum.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_maximum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().startsWith("-") || s.toString().startsWith("+")) {
                    et_maximum.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                } else {
                    et_maximum.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
