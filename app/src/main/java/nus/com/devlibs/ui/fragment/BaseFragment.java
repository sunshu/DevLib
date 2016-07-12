package nus.com.devlibs.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nus.com.devlibs.R;

/**
 * Created by sun on 2016/7/6.
 */

public abstract class BaseFragment extends Fragment {
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null == mRootView){
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
        mRootView.setFocusable(true);
        mRootView.setFocusable(true);
        mRootView.setFocusableInTouchMode(true);
        mRootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    //不一定是要触发返回栈，可以做一些其他的事情，我只是举个栗子。
                    getActivity().onBackPressed();
                    return true;
                }
                return false;
            }
        });
        return mRootView;






    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        afterCreate(savedInstanceState);
    }



    protected abstract int getLayoutId();

    protected abstract void afterCreate(Bundle savedInstanceState);
}
