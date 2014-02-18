package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.User;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SelectProjectsDepartmentFragment extends Fragment {
	private Context context;
	private Activity activity;
	private ListView select_projects_department_listView;
	private MainApplication app;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		this.activity = this.getActivity();
		app = (MainApplication) this.getActivity().getApplication();
		View v = inflater.inflate(R.layout.select_projects_department_fragment,
				container, false);
		this.select_projects_department_listView = (ListView)v.findViewById(R.id.select_projects_department_listView);
		this.listProjects();
		return v;
	}

	private void listProjects() {
		
		String[] sections = new String[] { "部门项目" };
		List<Item> items = new ArrayList<Item>();
		Project[] projects = this.getDepartmentProjects();
		for (int i=0;i<projects.length;i++){
			Item item = new Item();
			item.firstLineText = projects[i].xmmc;
			item.secondLineText = projects[i].xmjc;
			item.key = projects[i].xmid;
			item.showCheckbox = false;
			items.add(item);
			Log.v("pmis", item.toString());
		}
		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context);

		SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listAdapter);
		}

		// Listen for Click events
		this.select_projects_department_listView.setAdapter(adapter);
		this.select_projects_department_listView.setOnItemClickListener(item_listener);
	}
	
	private Project[] getDepartmentProjects(){
		final String METHOD_NAME = "getDepartmentProjects";
		User user = this.app.getUser();
		String bmid = user.bmid;
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bmid");
		arg0.setValue(bmid);
		arg0.setType(String.class);
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Project[] projects = gson.fromJson(ret, Project[].class);
		return projects;
	}
	
	private OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			//Log.v("pmis", item.toString());
			Toast.makeText(context, item.key+item.firstLineText, Toast.LENGTH_SHORT).show();
			Intent it = new Intent();
			//it.putExtra("ret", "2");
			it.putExtra("xmid", item.key);
			it.putExtra("xmjc", item.firstLineText);
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};
}
