package com.example.quan_ly_don_hang.data;

import com.example.quan_ly_don_hang.model.Users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "QUANLYDONHANG";
	private static final String TABLE_USER = "user";
	private static final String TABLE_SANPHAM = "SanPham";
	private static final String TABLE_DANHMUC = "DanhMuc";
	private static final String TABLE_GIAMGIA = "GiamGia";
	// Các cột chung
	private static final String ID = "id";
	// Các cột bảng user
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";
	private static final String PERMISSION = "permission";
	// Các cột bảng danh mục
	private static final String TEN_DANHMUC = "Tendanhmuc";

	// Các cột bảng Giảm giá
	private static final String MA_GIAM_GIA = "Magiamgia";
	private static final String GIA_TRI = "Giatri";
	// Các cột bảng sản phẩm
	private static final String TEN_SANPHAM = "Tensanpham";
	private static final String DANH_MUC = "Danhmuc";
	private static final String SO_LUONG = "Soluong";
	private static final String GIA_BAN = "Giaban";
	private static final String ANH = "Anh";
//Một số thứ linh tinh
	private static int VERSION = 1;
	private Context context;
	//Các câu lệnh tạo bảng
	private String SQLQuery_CREATE_TBLUSER = "CREATE TABLE " + TABLE_USER
			+ " (" + ID + " integer primary key, " + USER_NAME + " TEXT, "
			+ PASSWORD + " TEXT, " + PERMISSION + " integer)";
	private String SQLQuery_CREATE_TBLSANPHAM = "CREATE TABLE " + TABLE_SANPHAM + " ("
			+ ID + " integer primary key, " + TEN_SANPHAM + " TEXT, "
			+DANH_MUC+ " TEXT, " +SO_LUONG+ " integer, " +GIA_BAN+ " integer, " +ANH+ " TEXT)";
	private String SQLQuery_CREATE_GIAMGIA = "CREATE TABLE " + TABLE_GIAMGIA
			+ " (" + ID + " integer primary key, " + MA_GIAM_GIA + " TEXT, "
			+ GIA_TRI + " integer)";
	private String SQLQuery_CREATE_DANHMUC = "CREATE TABLE " + TABLE_DANHMUC
			+ " (" + ID + " integer primary key, " 
			+ TEN_DANHMUC + " TEXT)";
	

	public DBManager(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	SQLiteDatabase db;

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQLQuery_CREATE_TBLUSER);
		db.execSQL(SQLQuery_CREATE_TBLSANPHAM);
		db.execSQL(SQLQuery_CREATE_GIAMGIA);
		db.execSQL(SQLQuery_CREATE_DANHMUC);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DANHMUC);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIAMGIA);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SANPHAM);
		
		this.onCreate(db);
	}

	public void adduser(Users users) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(USER_NAME, users.getmUsername());
		values.put(PASSWORD, users.getmPassword());
		db.insert(TABLE_USER, null, values);
		db.close();
	}

	public boolean checklogin(String user, String pass) {
		db = this.getReadableDatabase();
		String query = "Select * from " + TABLE_USER + " where username ='"
				+ user + "'and password='" + pass + "'";
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.getCount() >= 1) {
			db.close();
			return true;
		}

		db.close();
		return false;

	}

}
