package com.fortests.meet6practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;

    public static final String BROADCAST2 = "myservice2";

    BroadcastReceiver mBroadcastReceiver;
    IntentFilter mIntentFilter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton1 = view.findViewById(R.id.fragment2_button1);
        mButton2 = view.findViewById(R.id.fragment2_button2);
        mButton3 = view.findViewById(R.id.fragment2_button3);
        mButton4 = view.findViewById(R.id.fragment2_button4);
        mButton5 = view.findViewById(R.id.fragment2_button5);
        mButton6 = view.findViewById(R.id.fragment2_button7);
        mButton7 = view.findViewById(R.id.fragment2_button8);
        mButton8 = view.findViewById(R.id.fragment2_button9);
    }

    @Override
    public void onResume() {
        super.onResume();
        startService();

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mButton1.setTextColor(intent.getIntExtra("color1",0));
                mButton2.setTextColor(intent.getIntExtra("color2",0));
                mButton3.setTextColor(intent.getIntExtra("color3",0));
                mButton4.setTextColor(intent.getIntExtra("color4",0));
                mButton5.setTextColor(intent.getIntExtra("color5",0));
                mButton6.setTextColor(intent.getIntExtra("color6",0));
                mButton7.setTextColor(intent.getIntExtra("color7",0));
                mButton8.setTextColor(intent.getIntExtra("color8",0));
                mButton1.setText(intent.getStringExtra("buttonNum1"));
                mButton2.setText(intent.getStringExtra("buttonNum2"));
                mButton3.setText(intent.getStringExtra("buttonNum3"));
                mButton4.setText(intent.getStringExtra("buttonNum4"));
                mButton5.setText(intent.getStringExtra("buttonNum5"));
                mButton6.setText(intent.getStringExtra("buttonNum6"));
                mButton7.setText(intent.getStringExtra("buttonNum7"));
                mButton8.setText(intent.getStringExtra("buttonNum8"));
            }
        };
        mIntentFilter = new IntentFilter(BROADCAST2);
        getActivity().registerReceiver(mBroadcastReceiver,mIntentFilter);
    }

    private void startService() {
        getActivity().startService(MyService2.newIntent(getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().stopService(MyService2.newIntent(getActivity()));
    }
}
