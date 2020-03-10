package com.example.whowrotethisbook;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class FetchBook extends AsyncTask<String, Void, String> {

    private WeakReference<TextView> titleText;
    private WeakReference<TextView> authorText;

    FetchBook(TextView titleText, TextView authorText) {
        this.titleText = new WeakReference<>(titleText);
        this.authorText = new WeakReference<>(authorText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}