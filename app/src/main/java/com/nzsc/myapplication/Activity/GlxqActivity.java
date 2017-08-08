package com.nzsc.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nzsc.myapplication.MainActivity;
import com.nzsc.myapplication.R;
import com.nzsc.myapplication.View.TopBar;

public class GlxqActivity extends AppCompatActivity {
TopBar topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_glxq);
       topBar= (TopBar) findViewById(R.id.topbar);
        topBar.setOnLeftAndRightClickListener(new TopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                finish();
            }

            @Override
            public void OnRightButtonClick() {
                Intent intent=new Intent(GlxqActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
