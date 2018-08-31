package com.ladyishenlong.ioc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public interface BaseActivityLayoutInjector<T extends AppCompatActivity> {

    void inject(T activity, View baseLayout);

}
