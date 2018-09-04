package com.ladyishenlong.rapp.pages.page_home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ladyishenlong.ioc_annotation.BaseFragmentLayout;
import com.ladyishenlong.rapp.R;
import com.ladyishenlong.rapp.pages.base.BaseFragment;
import com.ladyishenlong.rapp.test.TestAdapter;
import com.ladyishenlong.rapp.test.TestData;
import com.ladyishenlong.translation.TranslationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


@BaseFragmentLayout(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.translationView)
    TranslationView translationView;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;


    @Override
    protected void finishBind() {

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        TestAdapter adapter = new TestAdapter(getContext(), TestData.getTestData());
        recycler.setAdapter(adapter);


        translationView.setDatas(TestData.getTestData())
                .setDirection(1)
                .build();
    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        translationView.move(true);
    }


    @OnClick(R.id.btn2)
    public void onViewClicked2() {
        translationView.move(false);
    }
}
