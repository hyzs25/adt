package com.example.android_ch13_listview;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView l;
    private ArrayAdapter<String> adapter;
    private String[] data = {"北京","上海","南京"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	l = (ListView) findViewById(R.id.lv);
	adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
	l.setAdapter(adapter);
    }
}
