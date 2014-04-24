package com.adapter;

import java.io.Serializable;
import java.util.List;

import com.example.dataclient.R;
import com.stracture.ExpandListItem;
import com.stracture.Item;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class SimpleBaseExpandableListAdapter extends BaseExpandableListAdapter {
	private class GroupViewHolder implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7937314772687132245L;
		public TextView textview_group_view_title;
		public ImageView imageview_group_view_icon;
		public TextView textview_group_view_count;
		public CheckBox checkbox_group_view_select;
		public RelativeLayout group_view_main;
	}
	private class ChildViewHolder {
		public TextView firstLine;  
        public TextView secondLine;  
        public ImageView icon;  
        //public TextView count;  
        public CheckBox checkBox;
        public TextView tail;
	}
	private List<ExpandListItem> list;
	
	private Context context;
	private LayoutInflater inflater;
	//private OnCheckedChangeListener GroupCheckBoxCheckedChangeListener;
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
		convertView = null;//防止checkbox状态由于重用带来的问题，对性能有点点影响
		final Item item = list.get(groupPosition).items.get(childPosition);
		if (convertView == null){
			convertView = inflater.inflate(R.layout.list_item, parent,false);
			holder = new ChildViewHolder();
			holder.firstLine = (TextView)convertView.findViewById(R.id.firstLine);
			holder.secondLine = (TextView)convertView.findViewById(R.id.secondLine);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);
			holder.checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);
			//holder.count = (TextView)convertView.findViewById(R.id.count);
			holder.tail = (TextView)convertView.findViewById(R.id.tail);
			convertView.setTag(holder);
			
		}else{
			holder = (ChildViewHolder) convertView.getTag();
		}
		holder.icon.setVisibility(View.GONE);
		holder.firstLine.setText(item.firstLineText);
		if (item.showRed){
			holder.firstLine.setTextColor(Color.RED);
		}
		else {
			holder.firstLine.setTextColor(Color.BLACK);
		}
		holder.secondLine.setText(item.secondLineText);
		if (item.showCheckbox)
			holder.checkBox.setVisibility(View.VISIBLE);
		else
			holder.checkBox.setVisibility(View.INVISIBLE);
		holder.checkBox.setChecked(item.isChecked);
		if (item.showTail){
        	holder.tail.setVisibility(View.VISIBLE);
        	holder.tail.setText(item.tailText);
        }else
        	holder.tail.setVisibility(View.GONE);
        holder.tail.setTextColor(item.taiColor);
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
		
		final ExpandListItem item = list.get(groupPosition);
		//item.isExpanded = isExpanded;
		final GroupViewHolder holder;
		convertView = null;//防止checkbox状态由于重用带来的问题，对性能有点点影响
		if (convertView == null){
			holder = new GroupViewHolder();
			convertView = inflater.inflate(R.layout.group_view, parent,false);
			holder.textview_group_view_title = (TextView)convertView.findViewById(R.id.textview_group_view_title);
			
			holder.imageview_group_view_icon = (ImageView)convertView.findViewById(R.id.imageview_group_view_icon);
			holder.textview_group_view_count = (TextView)convertView.findViewById(R.id.textview_group_view_count);
			//CheckBox checkbox = new CheckBox(this.context);
			//convertView.a
			holder.checkbox_group_view_select = (CheckBox)convertView.findViewById(R.id.checkbox_group_view_select);
			holder.group_view_main = (RelativeLayout)convertView.findViewById(R.id.group_view_main);
			convertView.setTag(holder);	
		}
		else
		{
			holder = (GroupViewHolder) convertView.getTag();
		}
		holder.group_view_main.setBackgroundColor(item.bgColor);
		if (item.bgImageId!=null)
			holder.group_view_main.setBackgroundResource(item.bgImageId);
		holder.textview_group_view_title.setText(item.title);
		holder.textview_group_view_count.setText(String.valueOf(item.count));
		if (item.showCheckBox){
			holder.checkbox_group_view_select.setVisibility(View.VISIBLE);
			//holder.checkbox_group_view_select.setChecked(item.isChecked);
		}
		
		else
			holder.checkbox_group_view_select.setVisibility(View.GONE);
		if (isExpanded){
			holder.imageview_group_view_icon.setImageResource(R.drawable.arrow_up);
		}else{
			holder.imageview_group_view_icon.setImageResource(R.drawable.arrow_down);
		}
		//holder.checkbox_group_view_select.setTag(0);
		holder.checkbox_group_view_select.setChecked(item.isChecked);
		
		holder.checkbox_group_view_select.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				final ExpandListItem expandListItem = item;
				final List<Item> celllist = expandListItem.items;
				for (int i=0;i<celllist.size();i++){
					celllist.get(i).isChecked = isChecked;
				}
				expandListItem.isChecked = isChecked;
				notifyDataSetChanged();
				//holder.textview_group_view_title.setText("item.title");
			}});
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
	private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener(){
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			final ExpandListItem expandListItem = (ExpandListItem)buttonView.getTag();
			final List<Item> celllist = expandListItem.items;
			for (int i=0;i<celllist.size();i++){
				celllist.get(i).isChecked = isChecked;
			}
			expandListItem.isChecked = isChecked;
			notifyDataSetChanged();
			//holder.textview_group_view_title.setText("item.title");
		}
	};

}
