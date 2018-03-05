package com.example.quan_ly_don_hang.model;



public class SanPham {
private int mMaSP;
private String mTenSP;
private int mDanhMuc;
private int mSoLuong;
private int mGiaban;
private String mAnh;

public SanPham(String mTenSP, int mDanhMuc, int mSoLuong, int mGiaban,
		String mAnh) {
	super();
	this.mTenSP = mTenSP;
	this.mDanhMuc = mDanhMuc;
	this.mSoLuong = mSoLuong;
	this.mGiaban = mGiaban;
	this.mAnh = mAnh;
}

public SanPham(int mMaSP, String mTenSP, int mDanhMuc, int mSoLuong,
		int mGiaban, String mAnh) {
	super();
	this.mMaSP = mMaSP;
	this.mTenSP = mTenSP;
	this.mDanhMuc = mDanhMuc;
	this.mSoLuong = mSoLuong;
	this.mGiaban = mGiaban;
	this.mAnh = mAnh;
}

public int getmMaSP() {
	return mMaSP;
}
public void setmMaSP(int mMaSP) {
	this.mMaSP = mMaSP;
}
public String getmTenSP() {
	return mTenSP;
}
public void setmTenSP(String mTenSP) {
	this.mTenSP = mTenSP;
}
public int getmDanhMuc() {
	return mDanhMuc;
}
public void setmDanhMuc(int mDanhMuc) {
	this.mDanhMuc = mDanhMuc;
}
public int getmSoLuong() {
	return mSoLuong;
}
public void setmSoLuong(int mSoLuong) {
	this.mSoLuong = mSoLuong;
}
public int getmGiaban() {
	return mGiaban;
}
public void setmGiaban(int mGiaban) {
	this.mGiaban = mGiaban;
}
public String getmAnh() {
	return mAnh;
}
public void setmAnh(String mAnh) {
	this.mAnh = mAnh;
}


}
