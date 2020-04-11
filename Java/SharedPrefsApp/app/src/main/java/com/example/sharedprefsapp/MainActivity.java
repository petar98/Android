package com.example.sharedprefsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private int mColor;
    private TextView mShowCountTextView;
    private final String COUNT_KEY = "count";
    private final String COLOR_KEY = "color";
    private SharedPreferences sharedPreferences;
    private String sharedPrefsFile = "com.example.sharedprefsapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);

        sharedPreferences = getSharedPreferences(sharedPrefsFile, MODE_PRIVATE);

        mCount = sharedPreferences.getInt(COUNT_KEY, 0);
        mShowCountTextView.setText(String.format("%s", mCount));
        mColor = sharedPreferences.getInt(COLOR_KEY, mColor);
        mShowCountTextView.setBackgroundColor(mColor);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }

    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    public void countUp(View view) {
        mCount++;
        mShowCountTextView.setText(String.format("%s", mCount));
    }

    public void reset(View view) {
        mCount = 0;
        mShowCountTextView.setText(String.format("%s", mCount));

        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);

        SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();
        sharedPrefsEditor.clear();
        sharedPrefsEditor.apply();
    }
}
