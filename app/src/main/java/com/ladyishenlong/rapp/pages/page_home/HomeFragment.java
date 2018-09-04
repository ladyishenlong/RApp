package com.ladyishenlong.rapp.pages.page_home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladyishenlong.ioc_annotation.BaseFragmentLayout;
import com.ladyishenlong.rapp.R;
import com.ladyishenlong.rapp.adapter.BaseRecyAdapter;
import com.ladyishenlong.rapp.pages.base.BaseFragment;
import com.ladyishenlong.rapp.test.TestAdapter;
import com.ladyishenlong.rapp.test.TestData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@BaseFragmentLayout(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;



    @Override
    protected void finishBind() {

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        TestAdapter adapter=new TestAdapter(getContext(), TestData.getTestData());
        recycler.setAdapter(adapter);

    }


}
