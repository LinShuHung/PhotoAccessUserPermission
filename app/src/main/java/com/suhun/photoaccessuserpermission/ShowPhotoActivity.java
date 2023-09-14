package com.suhun.photoaccessuserpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPhotoActivity extends AppCompatActivity {
    private String tag = ShowPhotoActivity.class.getSimpleName();
    private TextView path;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        initView();
    }

    private void initView(){
        path = findViewById(R.id.lid_show_path);
        img = findViewById(R.id.lid_show_image);
    }

    public void previousFun(View view){

    }

    public void nextFun(View view){

    }

    public void finishFun(View view){
        finish();
    }
}