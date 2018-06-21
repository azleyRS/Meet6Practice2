package com.fortests.meet6practice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment4 extends Fragment {

    private BroadcastReceiver mBroadcastReceiver;
    private IntentFilter mIntentFilter;

    public static final String BROADCAST = "myservice3";

    private Button mButton;

    private MyService4 mBoundService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mBoundService = ((MyService4.LocalBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.fragment4_button);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().bindService(MyService4.newIntent(getActivity()), mServiceConnection, Context.BIND_AUTO_CREATE);

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //change here
                ConstraintLayout layout = (ConstraintLayout)getActivity().findViewById(R.id.fragment4);
                ConstraintSet set = new ConstraintSet();
                set.clone(layout);
                float angle = (float) mBoundService.Angle();
                set.constrainCircle(R.id.fragment4_button, R.id.textView2,100, angle);
                set.applyTo(layout);
            }
        };
        mIntentFilter = new IntentFilter(BROADCAST);
        getActivity().registerReceiver(mBroadcastReceiver,mIntentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mBroadcastReceiver);
        getActivity().unbindService(mServiceConnection);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4,container,false);
        return v;
    }

    public int getAngle(){

        return mBoundService.Angle();
    }


}
