package com.example.asynctaskapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Integer, String> {

    private WeakReference<TextView> mTextView;
    private WeakReference<MainActivity> activityReference;

    SimpleAsyncTask(TextView tv, MainActivity context) {
        mTextView = new WeakReference<>(tv);
        activityReference = new WeakReference<>(context);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random sleepingMilliseconds = new Random();
        int n = sleepingMilliseconds.nextInt(11);

        int result = n * 200;

        for (int i = 1; i <= result; i *= 100) {
            try {
                Thread.sleep(100);    // sleeping 100 ms and updating progress bar
                publishProgress((result / i * 100) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Awake at last after sleeping for " + result + " milliseconds";
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        activityReference.get().progressBar.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
        activityReference.get().progressBar.setProgress(0);
    }
}