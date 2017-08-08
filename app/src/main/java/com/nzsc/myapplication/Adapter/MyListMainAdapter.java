package com.nzsc.myapplication.Adapter;

import com.nzsc.myapplication.Base.MyBaseAdapter;
import com.nzsc.myapplication.Base.ViewHolder;
import com.nzsc.myapplication.Entity.ListMain;
import com.nzsc.myapplication.R;

import java.util.List;

/**
 * Created by 夜墨 on 2017/8/7.
 */

public class MyListMainAdapter extends MyBaseAdapter<ListMain> {
    public MyListMainAdapter(List<ListMain> data) {
        super(data);
    }

    @Override
    public void setData(ViewHolder holder, ListMain listMain) {
        holder.setText(R.id.type, listMain.getType()).setText(R.id.content, listMain.getContent()).setImageResource(R.id.main_image,listMain.getImageID());
    }

    @Override
    public int setRes() {
        return R.layout.item_main_list;
    }
}
