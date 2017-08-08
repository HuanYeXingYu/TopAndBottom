package com.nzsc.myapplication.Base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 夜墨 on 2017/8/3.
 *
 */
public class ViewHolder {
    private int position;
    private SparseArray<View> array;
    private View convertView;
    private Context context;

    private ViewHolder(ViewGroup parent, int position, int layout) {
        this.position = position;
        this.context = parent.getContext();
        convertView = LayoutInflater.from(parent.getContext()).inflate(layout, null);
        convertView.setTag(this);
        array = new SparseArray<>();
    }

    public static ViewHolder getHolder(View convertView, ViewGroup parent, int position, int layout) {
        if (convertView == null) {
            return new ViewHolder(parent, position, layout);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.position = position;
            return holder;
        }
    }

    public <T extends View> T getView(int viewId) {
        View view = array.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            array.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return convertView;
    }

    public ViewHolder setText(int viewId, String data) {
        TextView tv = getView(viewId);
        tv.setText(data);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView img = getView(viewId);
        img.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView img = getView(viewId);
        img.setImageBitmap(bm);
        return this;
    }
}
