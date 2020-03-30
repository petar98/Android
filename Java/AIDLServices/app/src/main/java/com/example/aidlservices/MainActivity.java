package com.example.aidlservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IRemoteService iRemoteService = null;
    private static final String LOG_TAG = "MainActivity";

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iRemoteService = IRemoteService.Stub.asInterface(service);
            Log.i(LOG_TAG, "connected to service");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(LOG_TAG, "service has unexpectedly disconnected");
            iRemoteService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
        iRemoteService = null;
    }

    public void getPidButtonClicked(View view) {
        if (iRemoteService != null) {
            try {
                int pid = iRemoteService.getPid();
                Toast.makeText(this, "pid " + pid, Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "connection not established", Toast.LENGTH_SHORT).
                    show();
        }
    }

    public void sumButtonClicked(View view) {
        if (iRemoteService != null) {
            try {
                double result = iRemoteService.sum(5, 5);
                Toast.makeText(this, "sum is " + result, Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}