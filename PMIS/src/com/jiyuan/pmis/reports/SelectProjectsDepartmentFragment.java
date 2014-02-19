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
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
		Project[] projects = null;
		try {
			projects = this.getDepartmentProjects();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		for (int i=0;i<projects.length;i++){
			Item item = new Item();
			item.firstLineText = projects[i].xmmc;
			item.secondLineText = projects[i].xmjc;
			item.key = projects[i].xmid;
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
		this.select_projects_department_listView.setAdapter(adapter);
		this.select_projects_department_listView.setOnItemClickListener(item_listener);
	}
	
	private Project[] getDepartmentProjects() throws PmisException{
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
			throw new PmisException("获取部门项目失败！");
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
			Intent it = new Intent();
			it.putExtra("xmid", item.key);
			it.putExtra("xmjc", item.secondLineText);
			
			DatabaseHandler db = new DatabaseHandler(context);
			//ProjectInfo info = db.getProjectInfo();
			if(!db.projectInfoExist(item.key)){
				ProjectInfo info = new ProjectInfo();
				info.setXmid(item.key);
				info.setXmjc(item.secondLineText);
				info.setXmmc(item.firstLineText);
				db.addProjectInfo(info);
			}
			
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};
}
