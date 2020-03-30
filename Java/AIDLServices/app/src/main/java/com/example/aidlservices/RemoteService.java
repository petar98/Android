package com.example.aidlservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {

    private final IRemoteService.Stub binder = new IRemoteService.Stub() {
        @Override
        public int getPid() throws RemoteException {
            Log.i(LOG_TAG, "call to getPid");
            return Process.myPid();
        }

        @Override
        public double sum(double first, double second) throws RemoteException {
            Log.i(LOG_TAG, "call to sum");
            return first + second;
        }
    };

    private static final String LOG_TAG = "RemoteService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOG_TAG, "creating service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LOG_TAG, "binding to service");
        return binder;
    }
}