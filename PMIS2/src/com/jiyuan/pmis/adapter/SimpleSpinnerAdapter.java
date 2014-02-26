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
	private LayoutInflater inflater;
	class Holder{
		public TextView textview;
	}

	public SimpleSpinnerAdapter(Context context, int textViewResourceId, List<SpinnerItem> values) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.inflater = (LayoutInflater) this.context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		Holder holder;
        if (convertView == null) {
        	holder = new Holder();
        	convertView = inflater.inflate(R.layout.spinner_item, parent,
                false);
        	holder.textview = (TextView) convertView
                .findViewById(R.id.spinner_item_textview);
        	convertView.setTag(holder);
        }else
        	holder = (Holder) convertView.getTag();
        holder.textview.setText(values.get(position).value);
        holder.textview.setTextColor(values.get(position).color);
        //values.get(position).textview = main_text;
        return convertView;
    }

}