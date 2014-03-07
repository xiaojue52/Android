package com.jiyuan.pmis.search;

import java.util.ArrayList;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.sqlite.ProjectInfo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleSearchAdapter extends BaseAdapter {

	private ArrayList<ProjectInfo> mData = new ArrayList<ProjectInfo>();
	private LayoutInflater mInflater;

	public SimpleSearchAdapter(Activity activity) {
		mInflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addItem(ProjectInfo item) {
		mData.add(item);
		notifyDataSetChanged();
	}

	public int getCount() {
		return mData.size();
	}

	public ProjectInfo getItem(int position) {
		return mData.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.search_item, null);
			holder.textView = (TextView) convertView.findViewById(R.id.search_item_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		String str = mData.get(position).getXmjc();
		holder.textView.setText(str);
		return convertView;
	}

	public class ViewHolder {
		public TextView textView;
	}

}
