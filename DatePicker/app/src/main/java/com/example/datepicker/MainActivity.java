package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String yearAsString = Integer.toString(year);
        String monthAsString = Integer.toString(month + 1);
        String dayAsString = Integer.toString(day);

        String fullDate = (dayAsString + "/" + monthAsString + "/" + yearAsString);

        TextView dateText = findViewById(R.id.date_prompt);
        dateText.setText(fullDate);
    }

    public void showTimePicker(View view) {
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String hourAsString = Integer.toString(hourOfDay);
        String minuteAsString = Integer.toString(minute);
        String fullTime = (hourAsString + ":" + minuteAsString);

        TextView timeText = findViewById(R.id.time_prompt);
        timeText.setText(fullTime);
    }
}
