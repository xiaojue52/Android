package com.jiyuan.pmis.adapter;

import java.util.List;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.structure.ExpandListItem;
import com.jiyuan.pmis.structure.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class SimpleBaseExpandableListAdapter extends BaseExpandableListAdapter {
	private class GroupViewHolder {
		public TextView textview_group_view_title;
		public ImageView imageview_group_view_icon;
		public TextView textview_group_view_count;
	}
	private class ChildViewHolder {
		public TextView firstLine;  
        public TextView secondLine;  
        public ImageView icon;  
        public TextView count;  
        public CheckBox checkBox;
	}
	private List<ExpandListItem> list;
	
	private Context context;
	private LayoutInflater inflater;
	public SimpleBaseExpandableListAdapter(Context context,List<ExpandListItem> expandListItem){
		this.context = context;
		this.list = expandListItem;
		inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public List<ExpandListItem> getValues(){
		return this.list;
	}
	public void setValues(List<ExpandListItem> values){
		this.list = values;
	}
	@Override
	public Item getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition).items.get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ChildViewHolder holder;
		final Item item = list.get(groupPosition).items.get(childPosition);
		if (convertView == null){
			convertView = inflater.inflate(R.layout.list_item, parent,false);
			holder = new ChildViewHolder();
			holder.firstLine = (TextView)convertView.findViewById(R.id.firstLine);
			holder.secondLine = (TextView)convertView.findViewById(R.id.secondLine);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);
			holder.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
			holder.count = (TextView)convertView.findViewById(R.id.count);
			convertView.setTag(holder);
			
		}else{
			holder = (ChildViewHolder) convertView.getTag();
		}
		holder.icon.setVisibility(View.GONE);
		holder.firstLine.setText(item.firstLineText);
		holder.secondLine.setText(item.secondLineText);
		if (item.showCheckbox)
			holder.checkBox.setVisibility(View.VISIBLE);
		else
			holder.checkBox.setVisibility(View.INVISIBLE);
		holder.checkBox.setChecked(item.isChecked);
		holder.count.setVisibility(View.GONE);
		holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

    		@Override
    		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
    			// TODO Auto-generated method stub
    			item.isChecked = arg1;
    		}
    		
    	});
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition).items.size();
	}

	@Override
	public ExpandListItem getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return list.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ExpandListItem item = list.get(groupPosition);
		//item.isExpanded = isExpanded;
		GroupViewHolder holder;
		if (convertView == null){
			holder = new GroupViewHolder();
			convertView = inflater.inflate(R.layout.group_view, parent,false);
			holder.textview_group_view_title = (TextView)convertView.findViewById(R.id.textview_group_view_title);
			
			holder.imageview_group_view_icon = (ImageView)convertView.findViewById(R.id.imageview_group_view_icon);
			holder.textview_group_view_count = (TextView)convertView.findViewById(R.id.textview_group_view_count);
			convertView.setTag(holder);
			
			
		}
		else
		{
			holder = (GroupViewHolder) convertView.getTag();
		}
		holder.textview_group_view_title.setText(item.title);
		holder.textview_group_view_count.setText(String.valueOf(item.count));
		if (isExpanded){
			holder.imageview_group_view_icon.setImageResource(R.drawable.arrow_up);
		}else{
			holder.imageview_group_view_icon.setImageResource(R.drawable.arrow_down);
		}
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
