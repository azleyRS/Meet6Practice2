package com.fortests.meet6practice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyService2 extends IntentService {
    public MyService2() {
        super("myService2");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Random rand = new Random();
        int color1;
        int color2;
        int color3;
        int color4;
        int color5;
        int color6;
        int color7;
        int color8;
        String randomNum1;
        String randomNum2;
        String randomNum3;
        String randomNum4;
        String randomNum5;
        String randomNum6;
        String randomNum7;
        String randomNum8;
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent broadcastIntent = new Intent(MainActivity.BROADCAST2);
            color1 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color2 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color3 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color4 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color5 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color6 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color7 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color8 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            randomNum1 = String.valueOf(rand.nextInt(100));
            randomNum2 = String.valueOf(rand.nextInt(100));
            randomNum3 = String.valueOf(rand.nextInt(100));
            randomNum4 = String.valueOf(rand.nextInt(100));
            randomNum5 = String.valueOf(rand.nextInt(100));
            randomNum6 = String.valueOf(rand.nextInt(100));
            randomNum7 = String.valueOf(rand.nextInt(100));
            randomNum8 = String.valueOf(rand.nextInt(100));
            broadcastIntent.putExtra("buttonNum1",randomNum1);
            broadcastIntent.putExtra("buttonNum2",randomNum2);
            broadcastIntent.putExtra("buttonNum3",randomNum3);
            broadcastIntent.putExtra("buttonNum4",randomNum4);
            broadcastIntent.putExtra("buttonNum5",randomNum5);
            broadcastIntent.putExtra("buttonNum6",randomNum6);
            broadcastIntent.putExtra("buttonNum7",randomNum7);
            broadcastIntent.putExtra("buttonNum8",randomNum8);
            broadcastIntent.putExtra("color1",color1);
            broadcastIntent.putExtra("color2",color2);
            broadcastIntent.putExtra("color3",color3);
            broadcastIntent.putExtra("color4",color4);
            broadcastIntent.putExtra("color5",color5);
            broadcastIntent.putExtra("color6",color6);
            broadcastIntent.putExtra("color7",color7);
            broadcastIntent.putExtra("color8",color8);
            sendBroadcast(broadcastIntent);
        }
    }


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyService2.class);
        return intent;
    }
}
