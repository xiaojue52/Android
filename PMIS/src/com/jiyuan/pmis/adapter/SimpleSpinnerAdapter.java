package com.jiyuan.pmis.adapter;

import java.util.List;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.content.Context;
import android.view.LayoutInflater;
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
		return this.getCustomView(position, convertView, parent);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return this.getCustomView(position, convertView, parent);
	}
	public View getCustomView(int position, View convertView,
            ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mySpinner_item = inflater.inflate(R.layout.spinner_item, parent,
                false);
        TextView main_text = (TextView) mySpinner_item
                .findViewById(R.id.spinner_item_textview);
        main_text.setText(values.get(position).value);
        main_text.setTextColor(values.get(position).color);
        //values.get(position).textview = main_text;
        return mySpinner_item;
    }

}