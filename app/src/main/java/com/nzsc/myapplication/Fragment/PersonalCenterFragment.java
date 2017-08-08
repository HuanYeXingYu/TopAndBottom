package com.nzsc.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nzsc.myapplication.Base.MyBaseFragment;
import com.nzsc.myapplication.R;

/**
 * Created by WangChang on 2016/5/15.
 */
public class PersonalCenterFragment extends MyBaseFragment {


    @Override
    protected int getLayoutRes() {
        return R.layout.frag_personal_center;
    }

    @Override
    protected void initData() {
        //    TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        //   tv.setText(getArguments().getString("ARGS"));
    }

    @Override
    protected void initListener() {

    }


    public static PersonalCenterFragment newInstance(String content) {
        args.putString("ARGS", content);
        PersonalCenterFragment fragment = new PersonalCenterFragment();


        fragment.setArguments(args);
        return fragment;
    }
}
