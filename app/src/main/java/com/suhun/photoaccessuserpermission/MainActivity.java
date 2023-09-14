package com.suhun.photoaccessuserpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private ListView imagePath;
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String, String>> data = new ArrayList<>();
    private String[] from = {"imagePathKey"};
    private int[] to = {R.id.lid_path_list};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListView();
    }

    private void initListView(){
        imagePath = findViewById(R.id.lid_imagePath);
        simpleAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        imagePath.setAdapter(simpleAdapter);
        //test list View
        /*HashMap<String, String> listViewData = new HashMap<>();
        listViewData.put(from[0], "Happy");
        data.add(listViewData);
        simpleAdapter.notifyDataSetChanged();*/
    }

    public void getFilePathFun(View view){

    }

    public void goToShowImageFun(View view){

    }
}