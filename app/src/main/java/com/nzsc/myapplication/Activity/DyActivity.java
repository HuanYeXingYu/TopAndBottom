package com.nzsc.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.nzsc.myapplication.Adapter.MyAdspter;
import com.nzsc.myapplication.R;
import com.nzsc.myapplication.View.TopBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DyActivity extends AppCompatActivity {

    private ListView listView=null;
    TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy);
        topBar= (TopBar) findViewById(R.id.topbar);
        topBar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {

            }
        });
        listView=(ListView)findViewById(R.id.listview);
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new MyAdspter(this, list));
    }
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 30; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", R.drawable.white);
            map.put("didian", "地点"+i);
            map.put("Uu", +220+i+i/3+"");
            map.put("Uv", +260+i+i/4+"");
            map.put("Uw", +240+i+i/5+"");
if(i==3){
    map.put("image", R.drawable.star);
}
            if(i==4){
                map.put("image", R.drawable.star);
            }
            if(i==13){
                map.put("image", R.drawable.star);
            }
            list.add(map);
        }
        return list;
    }
}

