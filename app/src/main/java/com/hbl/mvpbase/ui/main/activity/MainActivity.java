package com.hbl.mvpbase.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hbl.mvpbase.R;
import com.hbl.mvpbase.base.BaseMvpActivity;
import com.hbl.mvpbase.contract.main.MainContract;
import com.hbl.mvpbase.presenter.main.MainPresenter;
import com.hbl.mvpbase.ui.main.fragment.TabContactFragment;
import com.hbl.mvpbase.ui.main.fragment.TabDiscoverFragment;
import com.hbl.mvpbase.ui.main.fragment.TabMeFragment;
import com.hbl.mvpbase.ui.main.fragment.TabMessageFragment;
import com.hbl.mvpbase.ui.main.fragment.TabNewsFragment;
import com.jaeger.library.StatusBarUtil;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    public static final String FRAGMENT_SEARCH = "fragment_search";
    public static final String FRAGMENT_BOOK_LIST = "fragment_book_list";
    public static final String FRAGMENT_QUESTION = "fragment_question";
    public static final String FRAGMENT_COLLECTION = "fragment_collection";
    public static final String FRAGMENT_ME = "fragment_me";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = TabNewsFragment.newInstance("111");
            fragmentManager.beginTransaction()
                    .replace(R.id.contentContainer, fragment, FRAGMENT_SEARCH).commit();
        }

        int mColor = getResources().getColor(R.color.colorPrimary);
        // mToolBar.setBackgroundColor(mColor);
        StatusBarUtil.setColor(this, mColor, 0);
        mToolBar.setVisibility(View.GONE);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                //tabSelectMsg(tabId, false);
                tabSelectMsg(tabId);
            }
        });
        //setToolBar(mToolBar,"测试");
    }

    //Tab切换
    public void tabSelectMsg(int menuItemId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment search_fragment = fm.findFragmentByTag(FRAGMENT_SEARCH);
        Fragment book_list_fragment = fm.findFragmentByTag(FRAGMENT_BOOK_LIST);
        Fragment question_fragment = fm.findFragmentByTag(FRAGMENT_QUESTION);
        Fragment collection_fragment = fm.findFragmentByTag(FRAGMENT_COLLECTION);
        Fragment me_fragment = fm.findFragmentByTag(FRAGMENT_ME);
        if (search_fragment != null) {
            ft.hide(search_fragment);
        }
        if (book_list_fragment != null) {
            ft.hide(book_list_fragment);
        }
        if (question_fragment != null) {
            ft.hide(question_fragment);
        }
        if (collection_fragment != null) {
            ft.hide(collection_fragment);
        }
        if (me_fragment != null) {
            ft.hide(me_fragment);
        }
        switch (menuItemId) {
            case R.id.main_tab_news:
                if (search_fragment == null) {
                    search_fragment = TabNewsFragment.newInstance("111");
                    ft.add(R.id.contentContainer, search_fragment, FRAGMENT_SEARCH);
                } else {
                    ft.show(search_fragment);
                }
                break;
            case R.id.main_tab_message:
                if (book_list_fragment == null) {
                    book_list_fragment = TabMessageFragment.newInstance("2222");
                    ft.add(R.id.contentContainer, book_list_fragment, FRAGMENT_BOOK_LIST);
                } else {
                    ft.show(book_list_fragment);
                }
                break;
            case R.id.main_tab_contact:
                if (question_fragment == null) {
                    question_fragment = TabContactFragment.newInstance("33333");
                    ft.add(R.id.contentContainer, question_fragment,
                            FRAGMENT_QUESTION);
                } else {
                    ft.show(question_fragment);
                }
                break;
            case R.id.main_tab_discover:
                if (collection_fragment == null) {
                    collection_fragment = TabDiscoverFragment.newInstance("444444");
                    ft.add(R.id.contentContainer, collection_fragment,
                            FRAGMENT_COLLECTION);
                } else {
                    ft.show(collection_fragment);
                }
                break;
            case R.id.tab_me:
                if (me_fragment == null) {
                    me_fragment = TabMeFragment.newInstance("5555555");
                    ft.add(R.id.contentContainer, me_fragment,
                            FRAGMENT_ME);
                } else {
                    ft.show(me_fragment);
                }
                break;
        }
        ft.commit();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment search_fragment = fm.findFragmentByTag(FRAGMENT_SEARCH);
        Fragment book_list_fragment = fm.findFragmentByTag(FRAGMENT_BOOK_LIST);
        Fragment question_fragment = fm.findFragmentByTag(FRAGMENT_QUESTION);
        Fragment collection_fragment = fm.findFragmentByTag(FRAGMENT_COLLECTION);
        Fragment me_fragment = fm.findFragmentByTag(FRAGMENT_ME);
        if (search_fragment != null && !mBottomBar.getTabAtPosition(0).isActivated()) {
            ft.hide(search_fragment);
        }
        if (book_list_fragment != null && !mBottomBar.getTabAtPosition(1).isActivated()) {
            ft.hide(book_list_fragment);
        }
        if (question_fragment != null && !mBottomBar.getTabAtPosition(2).isActivated()) {
            ft.hide(question_fragment);
        }
        if (collection_fragment != null && !mBottomBar.getTabAtPosition(3).isActivated()) {
            ft.hide(collection_fragment);
        }
        if (me_fragment != null && !mBottomBar.getTabAtPosition(4).isActivated()) {
            ft.hide(me_fragment);
        }

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
