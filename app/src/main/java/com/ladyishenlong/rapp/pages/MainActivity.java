package com.ladyishenlong.rapp.pages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ladyishenlong.ioc_annotation.BaseActivityLayout;
import com.ladyishenlong.rapp.R;
import com.ladyishenlong.rapp.adapter.ViewPagerAdapter;
import com.ladyishenlong.rapp.pages.base.BaseActivity;
import com.ladyishenlong.rapp.pages.page_home.HomeFragment;
import com.ladyishenlong.rapp.pages.page_news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import devlight.io.library.ntb.NavigationTabBar;

@BaseActivityLayout(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager_main)
    ViewPager viewPagerMain;
    @BindView(R.id.navigationTabBar)
    NavigationTabBar navigationTabBar;

    private ArrayList<NavigationTabBar.Model> models;

    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){

        fragmentList=new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new NewsFragment());

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPagerMain.setAdapter(viewPagerAdapter);




        models=new ArrayList<>();

        models.add(new NavigationTabBar.Model.Builder(
                getDrawable(R.mipmap.label_home),
                getColor(R.color.red)).
                        title("主页")
                .badgeTitle("主页")
                .build());

        models.add(new NavigationTabBar.Model.Builder(
                getDrawable(R.mipmap.label_news),
                getColor(R.color.green)).
                title("新闻")
                .badgeTitle("新闻")
                .build());

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPagerMain, 0);
        navigationTabBar.setBgColor(Color.WHITE);

    }


}
