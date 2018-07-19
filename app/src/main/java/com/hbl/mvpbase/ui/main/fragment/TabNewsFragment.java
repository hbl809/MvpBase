package com.hbl.mvpbase.ui.main.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.hbl.mvpbase.R;
import com.hbl.mvpbase.app.AppConfig;
import com.hbl.mvpbase.base.BaseMvpFragment;
import com.hbl.mvpbase.contract.main.DoDoContract;
import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.presenter.main.DoDoPresenter;

import butterknife.BindView;

/**
 *
 */

public class TabNewsFragment extends BaseMvpFragment<DoDoPresenter> implements DoDoContract
        .View{
    @BindView(R.id.tv_msg)
    TextView mTvMessage;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public TabNewsFragment() {

    }

    public static TabNewsFragment newInstance(String param1) {
        TabNewsFragment fragment = new TabNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
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
        return R.layout.fragment_news;
    }

    @Override
    protected void initEventAndData() {
          mTvMessage.setText(mParam1);
          mPresenter.getToken(AppConfig.APP_ID,AppConfig.APP_KEY,AppConfig.APP_SECRET);
    }

    @Override
    public void showContent(TokenBean tokenBean) {
        if(null!=tokenBean)
        mTvMessage.setText(mTvMessage.getText()+"__"+tokenBean.getAccess_token());
    }
}
