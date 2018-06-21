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
import android.widget.TextView;

public class Fragment1 extends Fragment {
    public static final String BROADCAST = "myservice";

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;

    BroadcastReceiver mBroadcastReceiver;
    IntentFilter mIntentFilter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView1 = view.findViewById(R.id.f1_textview1);
        mTextView2 = view.findViewById(R.id.f1_textview2);
        mTextView3 = view.findViewById(R.id.f1_textview3);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = MyService.newIntent(getActivity());
        getActivity().startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mTextView1.setBackgroundColor(intent.getIntExtra("color1",0));
                mTextView2.setBackgroundColor(intent.getIntExtra("color2",0));
                mTextView3.setBackgroundColor(intent.getIntExtra("color3",0));
            }
        };
        mIntentFilter = new IntentFilter(BROADCAST);
        getActivity().registerReceiver(mBroadcastReceiver,mIntentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mBroadcastReceiver);
        getActivity().stopService(MyService.newIntent(getActivity()));
    }
}
