package com.suhun.photoaccessuserpermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private ListView imagePath;
    private SimpleAdapter simpleAdapter;
    private String[] from = {"imagePathKey"};
    private int[] to = {R.id.lid_path_list};
    private MyAppData myAppData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppData = (MyAppData)getApplication();
        initListView();
        if(checkUserAgreeReadExternalStorage()){
            initContentResolver();
        }else{
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
        }
    }

    private void initListView(){
        imagePath = findViewById(R.id.lid_imagePath);
        simpleAdapter = new SimpleAdapter(this, myAppData.data, R.layout.item, from, to);
        imagePath.setAdapter(simpleAdapter);
        //test list View
        /*HashMap<String, String> listViewData = new HashMap<>();
        listViewData.put(from[0], "Happy");
        data.add(listViewData);
        simpleAdapter.notifyDataSetChanged();*/
    }

    private void initContentResolver(){
        myAppData.contentResolver = getContentResolver();
    }

    private boolean checkUserAgreeReadExternalStorage(){
        boolean result = false;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            result = true;
        }
        return result;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 123){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                initContentResolver();
            }else{
                finish();
            }
        }
    }

    public void getFilePathFun(View view){
        if(myAppData.contentResolver!=null){
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Cursor cursor = myAppData.contentResolver.query(uri, null, null, null, null);
            while(cursor.moveToNext()){
                HashMap<String, String>imagePath = new HashMap<>();
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                imagePath.put(from[0], path);
                myAppData.data.add(imagePath);
                simpleAdapter.notifyDataSetChanged();
            }
            cursor.close();
        }
    }

    public void goToShowImageFun(View view){

    }
}