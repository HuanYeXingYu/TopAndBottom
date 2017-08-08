package com.nzsc.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nzsc.myapplication.R;
import com.nzsc.myapplication.View.TopBar;


public class ZfhActivity extends AppCompatActivity {
TopBar topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfh);
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
    }
}
