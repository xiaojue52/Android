package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;

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

		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context,
				false, "描述");
		ArrayAdapter<String> listadapter = new ArrayAdapter<String>(
				this.context, R.layout.list_item, R.id.firstLine, values);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listadapter);
		}

		// Listen for Click events
		this.select_projects_recent_listView.setAdapter(adapter);
		// this.select_projects_listView.setOnItemClickListener(item_listener);
	}
}
