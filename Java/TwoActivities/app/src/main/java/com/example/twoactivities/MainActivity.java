package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView replyHeaderTextView;
    private TextView replyMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "onCreate");

        mMessageEditText = findViewById(R.id.editText_main);
        replyHeaderTextView = findViewById(R.id.text_header_reply);
        replyMessageTextView = findViewById(R.id.text_message_reply);

        if (savedInstanceState != null) {
            // The app is started with saved instance state -> Restore it
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                replyHeaderTextView.setVisibility(View.VISIBLE);
                replyMessageTextView.setText(savedInstanceState.getString("reply_text"));
                replyMessageTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // If header is visible then state of the reply needs to be saved
        // Otherwise it will use the default layout after start
        if (replyHeaderTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", replyMessageTextView.getText().toString());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Send clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMessageEditText.setText("");

        if (resultCode == RESULT_OK) {
            mMessageEditText.setText("Result OK");
        }
        else {
            String code = String.valueOf(resultCode);
            mMessageEditText.setText(code);
        }

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                mMessageEditText.setText("");
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyHeaderTextView.setVisibility(View.VISIBLE);
                replyMessageTextView.setText(reply);
                replyMessageTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
