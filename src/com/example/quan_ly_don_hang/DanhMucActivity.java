package com.example.quan_ly_don_hang;

import java.util.ArrayList;
import java.util.List;

import com.example.quan_ly_don_hang.adapter.DanhMucAdapter;
import com.example.quan_ly_don_hang.data.DBManager;
import com.example.quan_ly_don_hang.model.DanhMuc;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class DanhMucActivity extends Activity {
	
//ImageButton btnThemDM;
ListView lvDM;
DanhMucAdapter DMadapter;
DBManager dbManager;
List<DanhMuc> danhmuc = new ArrayList<DanhMuc>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danh_muc);
		dbManager = new DBManager(this);
		
		danhmuc = dbManager.getAllDanhMuc();
		DMadapter = new DanhMucAdapter(this, R.layout.item_list_danhmuc, danhmuc);
		lvDM.setAdapter(DMadapter);
		
		lvDM = (ListView)findViewById(R.id.lv_danhmuc);
		/*
		btnThemDM = (ImageButton)findViewById(R.id.imgbtnThemDM_DM);
		btnThemDM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i  = new Intent(getApplicationContext(), ThemDanhMucActivity.class);
				startActivity(i);
			}
		});
		*/
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danh_muc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
