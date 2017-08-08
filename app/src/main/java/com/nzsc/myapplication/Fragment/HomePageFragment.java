package com.nzsc.myapplication.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.nzsc.myapplication.Adapter.MyViewPagerAdapter;
import com.nzsc.myapplication.Base.MyBaseFragment;
import com.nzsc.myapplication.ChildFragment.ZTUseFragment;
import com.nzsc.myapplication.R;
import com.nzsc.myapplication.View.MyTitleView;
import com.nzsc.myapplication.View.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by WangChang on 2016/5/15.
 */
public class HomePageFragment extends MyBaseFragment {

    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    public static MyViewPagerAdapter adapter;
    HomePageFragment fragment;
    @BindView(R.id.myTitleView)
    MyTitleView titleView;
    @Override
    protected int getLayoutRes() {
        return R.layout.frag_home_page;
    }

    @Override
    protected void initData() {
        //   TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        //   tv.setText(getArguments().getString("ARGS"));
        titleList.add("总体用电");
       // titleList.add("变压器");
      //  titleList.add("监测点");
     //   titleList.add("电能质量");
     //   titleList.add("电力总量");
        //初始化Fragment
        ZTUseFragment fragment1 = new ZTUseFragment();
        args.putInt("position", 0);
        fragment1.setArguments(args);
        fragmentList.add(fragment1);
//
//        ZTUseFragment fragment2 = new ZTUseFragment();
//        args.putInt("position", 1);
//        fragment2.setArguments(args);
//        fragmentList.add(fragment2);
//
//        ZTUseFragment fragment3 = new ZTUseFragment();
//        args.putInt("position", 2);
//        fragment3.setArguments(args);
//        fragmentList.add(fragment3);
//
//        ZTUseFragment fragment4 = new ZTUseFragment();
//        args.putInt("position", 3);
//        fragment4.setArguments(args);
//        fragmentList.add(fragment4);
//
//        ZTUseFragment fragment5 = new ZTUseFragment();
//        args.putInt("position", 4);
//        fragment5.setArguments(args);
//        fragmentList.add(fragment5);


        adapter = new MyViewPagerAdapter(getChildFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        initMagicIndicator();
        titleView.setTitle("配用电检测体验");
        titleView.setRightImageRes(R.mipmap.xl_btn_hd_kf);
        titleView.setLeftImageRes(R.mipmap.xl_logo_hd);
    }

    @Override
    protected void initListener() {

    }


    public static HomePageFragment newInstance(String content) {

        args.putString("ARGS", content);

        HomePageFragment fragment = new HomePageFragment();
        // HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }



    private void initMagicIndicator() {
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(titleList.get(index));

                simplePagerTitleView.setTextSize(20);
                simplePagerTitleView.setNormalColor(Color.parseColor("#FF4081"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#3F51B5"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
                //  indicator.setYOffset(UIUtil.dip2px(context, 39));//设置使下划线显示在上面
                indicator.setLineHeight(UIUtil.dip2px(context, 1));
                indicator.setColors(Color.parseColor("#f57c00"));
                return indicator;
            }

        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);

    }

    @Override
    public void onPause() {
        fragment=null;
        super.onPause();
    }
}
