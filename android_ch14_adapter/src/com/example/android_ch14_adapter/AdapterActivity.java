package com.example.android_ch14_adapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class AdapterActivity extends Activity implements OnItemClickListener{
	
	private ListView lv;
	private Myadapter adapter;
	
	private String[] data = {"北京","上海","安徽","上海","安徽","上海","安徽","上海","安徽","上海","安徽"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter);
		
		lv = (ListView) findViewById(R.id.listView1);
		adapter = new Myadapter(this, data);
		lv.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
	}

}
