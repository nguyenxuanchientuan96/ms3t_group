package com.example.quan_ly_don_hang;

import com.example.quan_ly_don_hang.model.SanPham;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class EditSPActivity extends Activity {
SanPham sanpham;
EditText edtten, edtsoluong, edtgia;
ImageView imgAvatar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_sp);
		edtten = (EditText)findViewById(R.id.txtTenSP_EditSP);
		edtsoluong = (EditText)findViewById(R.id.txtSoluong_ThemSP_EditSP);
		edtgia = (EditText)findViewById(R.id.txtGiaca_ThemSP_EditSP);
		imgAvatar = (ImageView)findViewById(R.id.imgHinh_EditSP);
		getData();
		
	}
	
	public void getData(){
		if (getIntent().getExtras()!=null){
			sanpham = (SanPham) getIntent().getSerializableExtra("Edit");
			int a = sanpham.getmMaSP();
			byte[] hinhanh = sanpham.getmAnh();
			Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
			imgAvatar.setImageBitmap(bitmap);
			edtten.setText(sanpham.getmTenSP().toString());
			edtsoluong.setText(String.valueOf(sanpham.getmSoLuong()));
			edtgia.setText(String.valueOf(sanpham.getmGiaban()));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_s, menu);
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
