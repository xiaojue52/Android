package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.structure.Item;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectProjectsRecentFragment extends Fragment {
	private ListView select_projects_recent_listView;
	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		View v = inflater.inflate(R.layout.select_projects_recent_fragment,
				container, false);
		this.select_projects_recent_listView = (ListView) v
				.findViewById(R.id.select_projects_recent_listView);
		this.listProjects();
		return v;
	}
	private void listProjects() {
		String[] values = new String[] { "项目1", "项目2" };
		String[] sections = new String[] { "最近项目" };
		List<Item> items = new ArrayList<Item>();
		// Create the ListView Adapter
		//for 
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context);
		/*ArrayAdapter<String> listadapter = new ArrayAdapter<String>(
				this.context, R.layout.list_item, R.id.firstLine, values);*/
		SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listAdapter);
		}

		// Listen for Click events
		this.select_projects_recent_listView.setAdapter(adapter);
		// this.select_projects_listView.setOnItemClickListener(item_listener);
	}
}
