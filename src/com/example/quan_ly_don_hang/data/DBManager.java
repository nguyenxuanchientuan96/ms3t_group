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

	private static final String DATABASE_NAME = "user_manager";
	private static final String TABLE_NAME = "user";
	private static final String ID = "id";
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";
	private static final String PERMISSION = "permission";
	private static int VERSION = 1;
private Context context;
	private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" + ID
			+ " integer primary key, " + USER_NAME + " TEXT, " + PASSWORD
			+ " TEXT, " + PERMISSION + " integer)";

	public DBManager(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
		this.context=context;
	}



	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
 arg0.execSQL(SQLQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void adduser(Users users){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(USER_NAME, users.getmUsername());
		values.put(PASSWORD, users.getmPassword());
		db.insert(TABLE_NAME, null, values);
		db.close();
	}

}
