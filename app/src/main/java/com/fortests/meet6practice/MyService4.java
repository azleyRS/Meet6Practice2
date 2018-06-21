package com.fortests.meet6practice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyService4 extends Service {
    private int i = 0;
    private IBinder mBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyService4.class);
        return intent;
    }

    public class LocalBinder extends Binder {
        MyService4 getService(){
            return MyService4.this;
        }
    }

    public int Angle(){
        i = i+15;
        return i;
    }

}
