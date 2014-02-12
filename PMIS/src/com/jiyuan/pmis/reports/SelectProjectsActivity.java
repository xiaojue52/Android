package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class SelectProjectsActivity extends FragmentActivity{
	//private Spinner spinner_select_projects_department;
	//private ListView select_projects_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_select_projects);
		this.context = this;
		/*this.spinner_select_projects_department = (Spinner)this.findViewById(R.id.spinner_select_projects_department);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.departments, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_select_projects_department.setAdapter(adapter);
		this.select_projects_listView = (ListView)this.findViewById(R.id.select_projects_listView);
		listProjects();*/
	}
	public void back(View v){
		this.finish();
	}
	public void done(View v){
		Intent it = new Intent();
		it.putExtra("ret", "2");
		setResult(RESULT_OK,it);
		this.finish();
	}
	public void search(View v){
		
	}
	
	/*private void listProjects(){
		String[] values = new String[]{"项目1","项目2"};
		String[] sections = new String[] {"历史项目"};

		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this,false,"描述");
		ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this,
				R.layout.list_item,R.id.firstLine, values);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listadapter);
		}

		// Listen for Click events
		this.select_projects_listView.setAdapter(adapter);
		//this.select_projects_listView.setOnItemClickListener(item_listener);
	}*/
	
	public void selectFrag(View view) {
		 Fragment fr;
		 
		 if(view == findViewById(R.id.btn_recent_projects)) {
			 fr = new SelectProjectsRecentFragment();
		 
		 }else if(view == findViewById(R.id.btn_department_projects)) {
			 fr = new SelectProjectsDepartmentFragment();
		 }else{
			 fr = new SelectProjectsSearchFragment();
		 }
		 
		 FragmentManager fm = getSupportFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
		 
	}
}
