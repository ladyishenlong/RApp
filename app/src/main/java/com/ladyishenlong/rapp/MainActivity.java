package com.ladyishenlong.rapp;

import android.os.Bundle;
import android.widget.TextView;

import com.ladyishenlong.ioc_annotation.BaseActivityLayout;

import butterknife.BindView;

@BaseActivityLayout(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
