package com.example.whowrotethisbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText bookInput;
    private TextView titleText;
    private TextView authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookInput = findViewById(R.id.bookInput);
        titleText = findViewById(R.id.titleText);
        authorText = findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString = bookInput.getText().toString();
    }
}
