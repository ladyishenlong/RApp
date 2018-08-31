package com.ladyishenlong.ioc;

import android.support.v4.app.Fragment;
import android.view.View;

public class BaseFragmentLayoutBinder {

    private final String SUFFIX = "BaseFragmentLayoutInjector";

    private BaseFragmentLayoutBinder() {

    }

    private static class Holder {
        private static BaseFragmentLayoutBinder INSTANCE = new BaseFragmentLayoutBinder();
    }

    public static BaseFragmentLayoutBinder getInstance() {
        return Holder.INSTANCE;
    }


    public void bind(Fragment fragment, View baseFragmentLayout) {

        if (fragment == null || baseFragmentLayout == null) return;

        Class<?> clazz = fragment.getClass();
        String proxyClassFullName = clazz.getName() + "$$" + SUFFIX;

        try {

            Class<?> proxyClass = Class.forName(proxyClassFullName);
            //通过接口传入数据
            BaseFragmentLayoutInjector injector = (BaseFragmentLayoutInjector) proxyClass.newInstance();

            if (injector != null) {
                injector.inject(fragment, baseFragmentLayout);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
