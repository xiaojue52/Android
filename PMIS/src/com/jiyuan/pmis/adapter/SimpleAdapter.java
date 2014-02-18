package com.jiyuan.pmis.adapter;

import java.util.List;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.structure.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleAdapter extends BaseAdapter{
	//private final Context context;
	private List<Item> items;
	private LayoutInflater inflater; 
	private Context context;
	private class RecentViewHolder {  
        TextView firstLine;  
        TextView secondLine;  
        ImageView icon;  
        TextView count;  
        CheckBox checkBox;
    }

	public SimpleAdapter(Context context, List<Item> items) {
		this.context = context;
		this.items = items;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RecentViewHolder holder; 
		if (convertView == null) {  
            convertView = inflater.inflate(R.layout.list_item, parent, false); 
            holder = new RecentViewHolder();  
            holder.firstLine = (TextView) convertView.findViewById(R.id.firstLine);  
            holder.icon = (ImageView) convertView  
                    .findViewById(R.id.icon);  
            holder.secondLine = (TextView) convertView.findViewById(R.id.secondLine);  
            holder.count = (TextView)convertView.findViewById(R.id.count);
            holder.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
            
            convertView.setTag(holder);  
        } else {  
            holder = (RecentViewHolder) convertView.getTag();  
        }  
        final Item item = this.items.get(position);   
        if (item != null) {  
            holder.firstLine.setText(item.firstLineText);
            holder.secondLine.setText(item.secondLineText);
            holder.icon.setImageResource(item.imageRid);
            if (item.showCheckbox){
            	holder.checkBox.setVisibility(View.VISIBLE);
            }else
            	holder.checkBox.setVisibility(View.GONE);
            holder.count.setText(item.count);
            holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

        		@Override
        		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
        			// TODO Auto-generated method stub
        			item.isChecked = arg1;
        			if (arg1){
        				Toast.makeText(context, "选中", Toast.LENGTH_SHORT).show();
        			}else{
        				Toast.makeText(context, "未选中", Toast.LENGTH_SHORT).show();
        			}
        		}
        		
        	});
        }  
        return convertView;  
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.items.size();
	}

	@Override
	public Item getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
}