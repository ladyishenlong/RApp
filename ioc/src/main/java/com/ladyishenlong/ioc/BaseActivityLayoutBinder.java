package com.ladyishenlong.ioc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 在baseactivity中初始化，子类的布局添加入baseLayout之中
 */
public class BaseActivityLayoutBinder {

    //生成的后缀，也是接口的名称
    private final String SUFFIX = "BaseActivityLayoutInjector";

    private BaseActivityLayoutBinder() {

    }

    private static class Holder {
        private static final BaseActivityLayoutBinder INSTANCE = new BaseActivityLayoutBinder();
    }

    public static BaseActivityLayoutBinder getInstance() {
        return Holder.INSTANCE;
    }


    public void bind(AppCompatActivity activity, View baseLayout) {
        init(activity, baseLayout);
    }

    private void init(AppCompatActivity activity, View baseLayout) {

        if (activity == null || baseLayout == null) return;

        Class<?> clazz = activity.getClass();

        //生成类的全名
        String proxyClassFullName = clazz.getName() + "$$" + SUFFIX;

        try {
            //反射获取代理类
            Class<?> proxyClass = Class.forName(proxyClassFullName);

            //通过接口传入数据
            BaseActivityLayoutInjector injector = (BaseActivityLayoutInjector) proxyClass.newInstance();

            if (injector != null) {
                injector.inject(activity, baseLayout);
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
