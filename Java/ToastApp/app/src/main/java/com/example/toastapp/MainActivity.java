package com.example.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countPresses = 0;
    private TextView showCounts;
    public static final String COUNT_MESSAGE = "com.example.android.toastapp.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCounts = (TextView) findViewById(R.id.showCountTxt);
    }

    public void countDown(View view) {
        countPresses--;

        if (countPresses <= 0) {
            Toast toast = Toast.makeText(this, R.string.show_count_less_than_zero,
                    Toast.LENGTH_SHORT);
            toast.show();
            countPresses = 0;
        }

        if (showCounts != null) {
            showCounts.setText(Integer.toString(countPresses));
        }
    }

    public void countUp(View view) {
        countPresses++;
        if (showCounts != null) {
            showCounts.setText(Integer.toString(countPresses));
        }
    }

    public void startHelloActivity(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        String count = showCounts.getText().toString();
        intent.putExtra(COUNT_MESSAGE, count);
        startActivity(intent);
    }
}
