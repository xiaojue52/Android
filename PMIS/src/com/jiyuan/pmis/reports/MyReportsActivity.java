package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.constant.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MyReportsActivity extends Activity{
	private ListView my_reports_listView;
	private Spinner spinner_my_reports_status;
	//private Spinner spinner_my_reports_project;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ListView)this.findViewById(R.id.my_reports_listView);
		this.spinner_my_reports_status = (Spinner)this.findViewById(R.id.spinner_my_reports_status);
		//this.spinner_my_reports_project = (Spinner)this.findViewById(R.id.spinner_my_reports_project);
		
		
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(context, R.array.reports_status, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_my_reports_status.setAdapter(adapter1);
		this.spinner_my_reports_status.setSelection(Constant.REFUSE_STATUS);
		
		listReports();
		

	}
	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			Intent it = new Intent(context,MyReportDetailsActivity.class);
			startActivity(it);
		}
		
	};
	public void search(View v){
		/*String[] values = new String[]{"2014-2-10宣城出差演示系统","2014-2-11修改程序增加新功能"};
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,values,false);
		this.my_reports_listView.setAdapter(adapter);
		this.my_reports_listView.setOnItemClickListener(item_listener);*/
	}
	
	public void back(View v){
		finish();
	}
	public void createReports(View v){
		//Toast.makeText(context, "新建报工", Toast.LENGTH_SHORT).show();
		Intent it =  new Intent(this,AddReportsActivity.class);
		startActivity(it);
	}
	
	
	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.ADD_PROJECTS_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				String result = data.getStringExtra("ret");
				Toast.makeText(context, result, Toast.LENGTH_LONG).show();
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	
	private void listReports(){
		String[] values = new String[]{"2014-2-10宣城出差演示系统","2014-2-11修改程序增加新功能"};
		String[] sections = new String[] {"未通过"};

		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this,false,"拒绝原因（批注信息）");
		ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this,
				R.layout.list_item,R.id.firstLine, values);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listadapter);
		}

		// Listen for Click events
		this.my_reports_listView.setAdapter(adapter);
		this.my_reports_listView.setOnItemClickListener(item_listener);
	}
}
