package com.nzsc.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nzsc.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Sinooo on 2017/8/7.
 */
 public class MyAdspter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public MyAdspter(Context context, List<Map<String, Object>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class Zujian{
        public ImageView image;
        public TextView didian;
        public TextView Uu;
        public TextView Uv;
        public TextView Uw;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.item_listview, null);
            zujian.image=(ImageView)convertView.findViewById(R.id.iv_star);
            zujian.didian=(TextView)convertView.findViewById(R.id.didian);
            zujian.Uu=(TextView) convertView.findViewById(R.id.Uu);
            zujian.Uv=(TextView)convertView.findViewById(R.id.Uv);
            zujian.Uw=(TextView)convertView.findViewById(R.id.Uw);
            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }
        //绑定数据
        zujian.image.setBackgroundResource((Integer)data.get(position).get("image"));
        zujian.didian.setText((String)data.get(position).get("didian"));
        zujian.Uu.setText((String)data.get(position).get("Uu"));
        zujian.Uv.setText((String)data.get(position).get("Uv"));
        zujian.Uw.setText((String)data.get(position).get("Uw"));
        return convertView;
    }

}
