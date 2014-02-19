package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Item;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SelectProjectsRecentFragment extends Fragment {
	private ListView select_projects_recent_listView;
	private Context context;
	private Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		this.activity = this.getActivity();
		View v = inflater.inflate(R.layout.select_projects_recent_fragment,
				container, false);
		this.select_projects_recent_listView = (ListView) v
				.findViewById(R.id.select_projects_recent_listView);
		this.listProjects();
		return v;
	}
	
	private void listProjects() {
		DatabaseHandler db = new DatabaseHandler(context);
		String[] sections = new String[] { "最近项目" };
		List<Item> items = new ArrayList<Item>();
		List<ProjectInfo> list = db.getAllProjectInfos();

		for (int i=0;i<list.size();i++){
			Item item = new Item();
			item.firstLineText = list.get(i).getXmmc();
			item.secondLineText = list.get(i).getXmjc();
			item.key = list.get(i).getXmid();
			item.showCheckbox = false;
			items.add(item);
		}
		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context);

		SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listAdapter);
		}

		// Listen for Click events
		this.select_projects_recent_listView.setAdapter(adapter);
		this.select_projects_recent_listView.setOnItemClickListener(item_listener);
	}
	
	private OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			Intent it = new Intent();
			it.putExtra("xmid", item.key);
			it.putExtra("xmjc", item.secondLineText);
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};
}
