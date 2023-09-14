package com.suhun.photoaccessuserpermission;

import android.app.Application;
import android.content.ContentResolver;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAppData extends Application {
    public ArrayList<HashMap<String, String>> data = new ArrayList<>();
    public ContentResolver contentResolver;
}
