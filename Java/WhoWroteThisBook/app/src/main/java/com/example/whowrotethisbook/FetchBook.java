package com.example.whowrotethisbook;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            int i = 0;
            String title = null;
            String authors = null;

            while (i < itemsArray.length() && authors == null && title == null) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                ++i;
            }

            if (title != null && authors != null) {
                titleText.get().setText(title);
                authorText.get().setText(authors);
            } else {
                titleText.get().setText(R.string.no_results);
                authorText.get().setText("");
            }
        } catch (JSONException e) {
            titleText.get().setText(R.string.no_results);
            authorText.get().setText("");
            e.printStackTrace();
        }
    }
}