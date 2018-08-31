package com.ladyishenlong.rapp.pages.page_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ladyishenlong.ioc_annotation.BaseFragmentLayout;
import com.ladyishenlong.rapp.R;
import com.ladyishenlong.rapp.pages.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@BaseFragmentLayout(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {


    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected void finishBind() {


    }
}
