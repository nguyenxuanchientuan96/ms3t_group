package com.example.quan_ly_don_hang;

import java.util.ArrayList;

import com.example.quan_ly_don_hang.adapter.SanPhamAdapter;
import com.example.quan_ly_don_hang.data.DBManager;
import com.example.quan_ly_don_hang.model.SanPham;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class QLSanPhamActivity extends Activity {
	ImageButton ibtAddnewSP;
	ArrayList<SanPham> arraySanpham = new ArrayList<SanPham>();
	SanPhamAdapter adapter;
	Cursor cursor;
	DBManager dbmanager;
	ListView lv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qlsan_pham);
		lv = (ListView)findViewById(R.id.lv_SP);
		ibtAddnewSP = (ImageButton)findViewById(R.id.ibnThemHang);
		dbmanager = new DBManager(this);
		displaySP();
		ibtAddnewSP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ThemHangActivity.class);
				startActivity(i);
			}
		});
		
	}
	public void displaySP(){
		cursor = dbmanager.getAllSanPham();
		while (cursor.moveToNext()){
			arraySanpham.add(new SanPham(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getBlob(5)));
		}
	adapter = new SanPhamAdapter(this, R.layout.item_list_sanpham, arraySanpham);		
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qlsan_pham, menu);
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
