package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.SpinnerItem;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SelectProjectsSearchFragment extends Fragment {
	private Context context;
	private ListView select_projects_search_listView;
	private Spinner spinner_select_projects_department;
	private EditText edittext_select_projects_search_project_name;
	private Button btn_select_projects_search;
	private MainApplication app;
	private Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		this.activity = this.getActivity();
		app = (MainApplication) this.getActivity().getApplication();
		View v = inflater.inflate(R.layout.select_projects_search_fragment,
				container, false);
		this.select_projects_search_listView = (ListView) v
				.findViewById(R.id.select_projects_search_listView);
		this.spinner_select_projects_department = (Spinner)v.findViewById(R.id.spinner_select_projects_department);
		this.edittext_select_projects_search_project_name = (EditText)v.findViewById(R.id.edittext_select_projects_search_project_name);
		this.btn_select_projects_search = (Button)v.findViewById(R.id.btn_select_projects_search);
		this.btn_select_projects_search.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				listProjects();
			}
			
		});
		
		Department[] ments = app.getDepartments();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		SpinnerItem first = new SpinnerItem();
		first.key = "-1";
		first.value = "全部";
		values.add(first);
		for(int i=0;i<ments.length;i++){
			SpinnerItem item = new SpinnerItem();
			item.key = ments[i].bmid;
			item.value = ments[i].bmmc;
			values.add(item);
		}
		SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(this.context,
				R.layout.spinner_item, values);
		this.spinner_select_projects_department.setAdapter(adapter);
		return v;
	}

	private void listProjects() {
		SpinnerItem spinnerItem = (SpinnerItem) this.spinner_select_projects_department.getSelectedItem();
		String bmid = spinnerItem.key;
		String xmjc = this.edittext_select_projects_search_project_name.getText().toString();
		String[] sections = new String[] { "项目列表" };
		List<Item> items = new ArrayList<Item>();
		Project[] projects = null;
		try {
			projects = this.getProjects(bmid, xmjc);
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
		this.select_projects_search_listView.setAdapter(adapter);
		this.select_projects_search_listView.setOnItemClickListener(item_listener);
	}
	
	private Project[] getProjects(String bmid,String xmjc) throws PmisException{
		final String METHOD_NAME = "getProjects";
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bmid");
		arg0.setValue(bmid);
		arg0.setType(String.class);
		args.add(arg0);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("xmjc");
		arg1.setValue(xmjc);
		arg1.setType(String.class);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("获取项目列表是失败！");
		}
		Gson gson = new Gson();
		try	{
			return gson.fromJson(ret, Project[].class);
		}catch(Exception e){
			throw new PmisException("当前没有项目！");
		}
	}
	
	private OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			//Log.v("pmis", item.toString());
			Intent it = new Intent();
			//it.putExtra("ret", "2");
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
