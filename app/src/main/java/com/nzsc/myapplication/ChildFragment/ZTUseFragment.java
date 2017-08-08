package com.nzsc.myapplication.ChildFragment;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nzsc.myapplication.Activity.DlxqActivity;
import com.nzsc.myapplication.Activity.DyActivity;
import com.nzsc.myapplication.Activity.GlxqActivity;
import com.nzsc.myapplication.Activity.ZfhActivity;
import com.nzsc.myapplication.Adapter.MyListMainAdapter;
import com.nzsc.myapplication.Base.MyBaseFragment;
import com.nzsc.myapplication.Entity.ListMain;
import com.nzsc.myapplication.MainActivity;
import com.nzsc.myapplication.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zxy.recovery.core.Recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

import static com.nzsc.myapplication.Application.MyApplication.titles;
import static com.nzsc.myapplication.Application.MyApplication.images;

/**
 * Created by 夜墨 on 2017/8/7.
 */

public class ZTUseFragment extends MyBaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.lv_main_type)
    ListView lvType;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment;
    }

    @Override
    protected void initData() {

        banner.setImages(images)
                .setBannerTitles(titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();
        List<ListMain> listMains = new ArrayList<>();
        listMains.add(new ListMain("用电负荷", "总负荷曲线及总负荷数据统计分析", R.mipmap.icon_201));
        listMains.add(new ListMain("总电量", "企业的总电量及构成分析", R.mipmap.icon_212));
        listMains.add(new ListMain("功率因素", "各总表的月功率因素分析", R.mipmap.icon_230));
        listMains.add(new ListMain("预购电", "剩余电压", R.mipmap.icon_206));
        listMains.add(new ListMain("最大需量", "各总表的最大需量数据分析", R.mipmap.icon_202));
        listMains.add(new ListMain("用电安全", "异常用电报警与记录", R.mipmap.icon_209));

        MyListMainAdapter adapter = new MyListMainAdapter(listMains);
        lvType.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent=new Intent(getActivity(), ZfhActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(getActivity(), DlxqActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(getActivity(), GlxqActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(getActivity(), DyActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .crossFade()
                    .into(imageView);
        }


    }

    @Override
    public void onPause() {
        banner.stopAutoPlay();
        super.onPause();
    }

    @Override
    public void onResume() {
        banner.startAutoPlay();
        super.onResume();
    }
}
