package com.ladyishenlong.ioc;

import android.support.v4.app.Fragment;
import android.view.View;

public interface BaseFragmentLayoutInjector<T extends Fragment> {

    void inject(T fragment, View baseFragmentLayout);

}
