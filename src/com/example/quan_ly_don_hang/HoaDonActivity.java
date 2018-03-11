package com.example.quan_ly_don_hang;

import java.util.ArrayList;

import com.example.quan_ly_don_hang.adapter.HoaDonAdapter;
import com.example.quan_ly_don_hang.adapter.SanPhamAdapter;
import com.example.quan_ly_don_hang.data.DBManager;
import com.example.quan_ly_don_hang.model.HoaDon;
import com.example.quan_ly_don_hang.model.SanPham;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class HoaDonActivity extends Activity {
	ArrayList<HoaDon> arrayHoadon = new ArrayList<HoaDon>();
	HoaDonAdapter adapter;
	Cursor cursor;
	DBManager db;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hoa_don);
		lv = (ListView)findViewById(R.id.lv_hd);
		db = new DBManager(this);
		display();
	}
public void display(){
	
	cursor = db.getAllHoaDon();
	if (adapter==null){
	while (cursor.moveToNext()){
		arrayHoadon.add(new HoaDon(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
	}
adapter = new HoaDonAdapter(this, R.layout.item_list_hoadon, arrayHoadon);
lv.setAdapter(adapter);
	}else {
adapter.notifyDataSetChanged();
	}
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hoa_don, menu);
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
