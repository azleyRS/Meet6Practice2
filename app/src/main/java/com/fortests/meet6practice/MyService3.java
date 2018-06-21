package com.fortests.meet6practice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyService3 extends IntentService {
    public MyService3() {
        super("MyService1");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Random rand = new Random();
        int color1;
        int color2;
        int color3;
        int randomNum;
        //need this to make sure MyService and MyService3 aren't working simultaneously
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent broadcastIntent = new Intent(MainActivity.BROADCAST3);
            color1 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color2 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            color3 = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            randomNum = rand.nextInt(13);
            broadcastIntent.putExtra("color1",color1);
            broadcastIntent.putExtra("color2",color2);
            broadcastIntent.putExtra("color3",color3);
            broadcastIntent.putExtra("textviewtext",String.valueOf(randomNum));
            sendBroadcast(broadcastIntent);

            Log.d("TAG", String.valueOf(color1));
            Log.d("TAG", String.valueOf(color2));
            Log.d("TAG", String.valueOf(color3));

        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MyService3.class);
        return intent;
    }
}
