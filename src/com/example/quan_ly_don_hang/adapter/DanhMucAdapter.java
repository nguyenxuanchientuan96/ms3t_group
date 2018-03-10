package com.example.quan_ly_don_hang.adapter;

import java.util.List;

import com.example.quan_ly_don_hang.model.DanhMuc;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DanhMucAdapter extends ArrayAdapter<DanhMuc> {
	private Context context;
	private int resource;
	private List<DanhMuc> listDM;

	public DanhMucAdapter(Context context, int resource, List<DanhMuc> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.resource = resource;
		this.listDM = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewholder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					com.example.quan_ly_don_hang.R.layout.item_list_danhmuc,
					parent, false);
			viewholder = new ViewHolder();
			viewholder.tvID = (TextView) convertView
					.findViewById(com.example.quan_ly_don_hang.R.id.tv_Id);
			viewholder.tvName = (TextView) convertView
					.findViewById(com.example.quan_ly_don_hang.R.id.tv_tendm);
			convertView.setTag(viewholder);
		} else {
			viewholder = (ViewHolder) convertView.getTag();
		}
		DanhMuc dm = listDM.get(position);
		viewholder.tvID.setText(String.valueOf(dm.getmMaDM()));
		viewholder.tvName.setText(dm.getmTenDM());
		
		return convertView;
	}

	public class ViewHolder {
		private TextView tvID;
		private TextView tvName;

	}

}
