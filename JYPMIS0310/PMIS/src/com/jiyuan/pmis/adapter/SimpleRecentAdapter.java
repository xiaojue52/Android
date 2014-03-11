package com.jiyuan.pmis.adapter;

import java.util.ArrayList;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.sqlite.RecentProjectInfo;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleRecentAdapter extends BaseAdapter {

	private ArrayList<RecentProjectInfo> mData = new ArrayList<RecentProjectInfo>();
	private LayoutInflater mInflater;

	public SimpleRecentAdapter(Activity activity) {
		mInflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addItem(RecentProjectInfo item) {
		mData.add(item);
		notifyDataSetChanged();
	}

	public int getCount() {
		return mData.size();
	}

	public RecentProjectInfo getItem(int position) {
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
