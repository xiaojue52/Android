package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.structure.Item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyReportsActivity extends Activity{
	private ListView my_reports_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ListView)this.findViewById(R.id.my_reports_listView);
		
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
	
	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.REQUEST_CODE);
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
		List<Item> items = new ArrayList<Item>();
		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context);
		/*ArrayAdapter<String> listadapter = new ArrayAdapter<String>(
				this.context, R.layout.list_item, R.id.firstLine, values);*/
		SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listAdapter);
		}

		// Listen for Click events
		this.my_reports_listView.setAdapter(adapter);
		this.my_reports_listView.setOnItemClickListener(item_listener);
	}
}
