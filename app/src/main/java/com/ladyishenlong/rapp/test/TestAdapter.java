package com.ladyishenlong.rapp.test;

import android.content.Context;
import android.widget.TextView;

import com.ladyishenlong.rapp.R;
import com.ladyishenlong.rapp.adapter.BaseRecyAdapter;

import java.util.List;

import butterknife.BindView;

public class TestAdapter extends BaseRecyAdapter<String> {


    @BindView(R.id.tv_text)
    TextView tvText;

    public TestAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int setLayout() {
        return R.layout.recy_test;
    }

    @Override
    protected void bindData(String data, int position) {
        //直接进行数据的加载
        tvText.setText(data);
    }


}
