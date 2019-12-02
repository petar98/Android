package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG_SECOND = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.example.twoactivities.extra.REPLY";
    private EditText replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG_SECOND, "onCreate");

        replyText = (EditText) findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG_SECOND, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG_SECOND, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG_SECOND, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG_SECOND, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG_SECOND, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG_SECOND, "onRestart");
    }

    public void returnReply(View view) {
        String reply = replyText.getText().toString();

        Log.d(LOG_TAG_SECOND, "Reply Button was clicked!");
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG_SECOND, "End of SecondActivity");
        finish();
    }
}
