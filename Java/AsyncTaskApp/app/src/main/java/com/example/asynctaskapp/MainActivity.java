package com.example.asynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView heading;
    private static final String TEXT_STATE = "currentText";
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heading = findViewById(R.id.heading);
        progressBar = findViewById(R.id.progress);

        if (savedInstanceState != null) {
            heading.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXT_STATE, heading.getText().toString());
    }

    public void startTask(View view) {
        heading.setText(R.string.napping);
        new SimpleAsyncTask(heading, this).execute();
    }
}
