package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.content.Intent.ACTION_HEADSET_PLUG;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom broadcast received!";
                    break;
                case ACTION_HEADSET_PLUG:
                    int headsetState = intent.getIntExtra("state", 0);
                    if (headsetState == 0) {
                        toastMessage = "Headset disconnected!";
                    } else {
                        toastMessage = "Headset connected!";
                    }
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
        }
    }
}
