package com.example.servicesapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent startHelloIntentServiceIntent = new Intent(this,
//                HelloIntentService.class);
//        Intent startHelloServiceIntent = new Intent(this, HelloService.class);
//
//        // starting the two services with the appropriate intents
//        startService(startHelloIntentServiceIntent);
//        startService(startHelloServiceIntent);
    }

    public void startActivity(View view) {
        Intent intent = new Intent(this, BindingActivity.class);
        startActivity(intent);
    }
}