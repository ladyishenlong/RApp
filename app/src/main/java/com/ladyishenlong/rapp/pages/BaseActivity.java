package com.ladyishenlong.rapp.pages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.ladyishenlong.ioc.BaseActivityLayoutBinder;
import com.ladyishenlong.rapp.R;

public class BaseActivity extends AppCompatActivity {


    private RelativeLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initView();

        BaseActivityLayoutBinder.getInstance().bind(this,baseLayout);
    }

    private void initView(){
        baseLayout=(RelativeLayout)findViewById(R.id.baseLayout);
    }






}
