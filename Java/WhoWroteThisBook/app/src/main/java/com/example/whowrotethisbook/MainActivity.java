package com.example.whowrotethisbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_INPUT = "savedInput";
    private static final String SAVED_TITLE = "savedTitle";
    private static final String SAVED_AUTHOR = "savedAuthor";

    private EditText bookInput;
    private TextView titleText;
    private TextView authorText;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(SAVED_INPUT, bookInput.getText().toString());
        outState.putString(SAVED_TITLE, titleText.getText().toString());
        outState.putString(SAVED_AUTHOR, authorText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookInput = findViewById(R.id.bookInput);
        titleText = findViewById(R.id.titleText);
        authorText = findViewById(R.id.authorText);

        if (savedInstanceState != null) {
            this.bookInput.setText(savedInstanceState.getString(SAVED_INPUT));
            this.titleText.setText(savedInstanceState.getString(SAVED_TITLE));
            this.authorText.setText(savedInstanceState.getString(SAVED_AUTHOR));
        }
    }

    public void searchBooks(View view) {
        String queryString = bookInput.getText().toString();

        // hide the keyboard after pressing Search
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // handle the case with no internet connection
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {
            new FetchBook(titleText, authorText).execute(queryString);
            titleText.setText(R.string.loading);
            authorText.setText("");
        } else if (queryString.length() == 0) {
            authorText.setText("");
            titleText.setText(R.string.no_search_items);
        } else {
            authorText.setText("");
            titleText.setText(R.string.no_connection);
        }
    }
}