package com.fortests.meet6practice;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment3.OnTextView2ChanchedListener {

    public static final String BROADCAST = "myservice";
    public static final String BROADCAST3 = "myservice3";
    public static final String BROADCAST2 = "myservice2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setFragment2ButtonText(String text) {
        Fragment fragment3 = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        Button button = fragment3.getView().findViewById(R.id.fragment2_the_chosen_one);
        button.setText(text);
    }
}
