package com.ladyishenlong.rapp.pages.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ladyishenlong.ioc.BaseFragmentLayoutBinder;
import com.ladyishenlong.rapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {


    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, null);
        RelativeLayout baseFragmentLayout = view.findViewById(R.id.baseFragmentLayout);

        BaseFragmentLayoutBinder.getInstance().bind(this, baseFragmentLayout);
        unbinder = ButterKnife.bind(this, view);

        finishBind();
        return view;
    }


    /**
     * 在用butterKnife绑定之后，在这里面继续可以做一些操作
     * */
    protected abstract void finishBind();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
