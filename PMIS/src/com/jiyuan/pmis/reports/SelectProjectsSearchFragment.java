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
import android.widget.Spinner;

public class SelectProjectsSearchFragment extends Fragment {
	private Context context;
	private ListView select_projects_search_listView;
	private Spinner spinner_select_projects_department;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		View v = inflater.inflate(R.layout.select_projects_search_fragment,
				container, false);
		this.select_projects_search_listView = (ListView) v
				.findViewById(R.id.select_projects_search_listView);
		this.listProjects();
		this.spinner_select_projects_department = (Spinner)v.findViewById(R.id.spinner_select_projects_department);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.departments, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_select_projects_department.setAdapter(adapter);
		return v;
	}

	private void listProjects() {
		String[] values = new String[] { "项目1", "项目2" };
		String[] sections = new String[] { "项目" };

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
		this.select_projects_search_listView.setAdapter(adapter);
		// this.select_projects_listView.setOnItemClickListener(item_listener);
	}
}
