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

public class Fragment3 extends Fragment {
    OnTextView2ChanchedListener mCallback;

    public interface OnTextView2ChanchedListener{
        public void setFragment2ButtonText(String text);
    }

    public static final String BROADCAST = "myservice3";

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;

    private BroadcastReceiver mBroadcastReceiver;
    private IntentFilter mIntentFilter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnTextView2ChanchedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnTextView2ChanchedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView1 = view.findViewById(R.id.f3_textview1);
        mTextView2 = view.findViewById(R.id.f3_textview2);
        mTextView3 = view.findViewById(R.id.f3_textview3);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = MyService3.newIntent(getActivity());
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
                mTextView2.setText(intent.getStringExtra("textviewtext"));

                mCallback.setFragment2ButtonText(mTextView2.getText().toString());

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
        getActivity().stopService(MyService3.newIntent(getActivity()));
    }
}
