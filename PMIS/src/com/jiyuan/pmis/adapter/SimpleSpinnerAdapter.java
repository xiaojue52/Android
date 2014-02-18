package com.jiyuan.pmis.adapter;

import java.util.List;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SimpleSpinnerAdapter extends ArrayAdapter<SpinnerItem> {
	private Context context;
	private List<SpinnerItem> values;

	public SimpleSpinnerAdapter(Context context, int textViewResourceId, List<SpinnerItem> values) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
	}

	public int getCount() {
		return values.size();
	}

	public SpinnerItem getItem(int position) {
		return values.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(context);
		label.setTextColor(Color.BLACK);
		label.setText(values.get(position).value);
		return label;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(context);
		label.setTextColor(Color.BLACK);
		label.setText(values.get(position).value);
		return label;
	}
}