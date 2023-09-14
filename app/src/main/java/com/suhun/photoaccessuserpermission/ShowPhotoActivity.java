package com.suhun.photoaccessuserpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPhotoActivity extends AppCompatActivity {
    private String tag = ShowPhotoActivity.class.getSimpleName();
    private TextView path;
    private ImageView img;
    private MyAppData myAppData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        initView();
        myAppData = (MyAppData) getApplication();
        path.setText(myAppData.data.get(myAppData.currentIndex).get("imagePathKey"));
        img.setImageBitmap(BitmapFactory.decodeFile(myAppData.data.get(myAppData.currentIndex).get("imagePathKey")));
    }

    private void initView(){
        path = findViewById(R.id.lid_show_path);
        img = findViewById(R.id.lid_show_image);
    }

    public void previousFun(View view){
        myAppData.currentIndex--;
        if(myAppData.currentIndex < 0){
            myAppData.currentIndex = 0;
        }
        path.setText(myAppData.data.get(myAppData.currentIndex).get("imagePathKey"));
        img.setImageBitmap(BitmapFactory.decodeFile(myAppData.data.get(myAppData.currentIndex).get("imagePathKey")));
    }

    public void nextFun(View view){
        myAppData.currentIndex++;
        path.setText(myAppData.data.get(myAppData.currentIndex).get("imagePathKey"));
        img.setImageBitmap(BitmapFactory.decodeFile(myAppData.data.get(myAppData.currentIndex).get("imagePathKey")));
    }

    public void finishFun(View view){
        finish();
    }
}