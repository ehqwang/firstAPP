package com.example.hqwang.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initDate(){
        mToolbar = findViewById(R.id.toolbar);

        mToolbar.setTitle("首页");
        mToolbar.setSubtitle("subtitle");
        mToolbar.setLogo(R.drawable.ic_launcher_background);
    }
}
