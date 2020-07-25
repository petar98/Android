package com.example.toread.requestor;

import android.os.AsyncTask;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.ref.WeakReference;

public class FetchBookByIsbn extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> titleText;

    public FetchBookByIsbn(TextView titleText) {
        this.titleText = new WeakReference<>(titleText);
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
            String title = jsonObject.getString("title");

            if (title != null) {
                titleText.get().setText(title);
            } else {
                titleText.get().setText("");
            }
        } catch (JSONException e) {
            titleText.get().setText("Error");
            e.printStackTrace();
        }
    }
}
