package com.jiyuan.pmis.adapter;

import com.jiyuan.pmis.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	private boolean showCheckBox = false;

	public MySimpleArrayAdapter(Context context, String[] values, boolean showCheckBox) {
		super(context, R.layout.list_item, values);
		this.context = context;
		this.values = values;
		this.showCheckBox = showCheckBox;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = null;
		rowView = inflater.inflate(R.layout.list_item, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		CheckBox checkBox = (CheckBox)rowView.findViewById(R.id.checkbox);
		if (showCheckBox){
			checkBox.setVisibility(View.VISIBLE);
		}
		imageView.setOnClickListener(IconListener);
		textView.setText(values[position]);
		if (values[position].equals("我的报工")||values[position].equals("审核报工")){
			TextView count = (TextView)rowView.findViewById(R.id.count);
			count.setText("2");
		}
		// Change the icon for Windows and iPhone
		String s = values[position];
		imageView.setImageResource(R.drawable.ic_launcher);
		return rowView;
	}

	private OnClickListener IconListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(context, "icon was clicked!", Toast.LENGTH_LONG)
					.show();
		}

	};
}