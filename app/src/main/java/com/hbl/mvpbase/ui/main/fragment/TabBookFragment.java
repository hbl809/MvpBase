package com.hbl.mvpbase.ui.main.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.hbl.mvpbase.R;
import com.hbl.mvpbase.base.BaseMvpFragment;
import com.hbl.mvpbase.contract.main.MainContract;
import com.hbl.mvpbase.presenter.main.MainPresenter;

import butterknife.BindView;

/**
 *
 */
public class TabBookFragment extends BaseMvpFragment<MainPresenter> implements MainContract.View  {
    @BindView(R.id.tv_msg)
    TextView mTvMessage;

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    public TabBookFragment() {

    }

    public static TabBookFragment newInstance(String param1) {
        TabBookFragment fragment = new TabBookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab;
    }

    @Override
    protected void initEventAndData() {
        mTvMessage.setText(mParam1);
    }
}
