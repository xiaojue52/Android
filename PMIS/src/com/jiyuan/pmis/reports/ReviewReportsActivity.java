package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;

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

public class ReviewReportsActivity extends Activity{
	private ListView review_reports_listView;
	private Context context;
	private Spinner spinner_review_reports_project;
	private Spinner spinner_review_reports_status;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_review_reports);
		this.context = this;
		this.review_reports_listView = (ListView)this.findViewById(R.id.review_reports_listView);
		this.spinner_review_reports_project = (Spinner)this.findViewById(R.id.spinner_review_reports_project);
		this.spinner_review_reports_status = (Spinner)this.findViewById(R.id.spinner_review_reports_status);
		
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(context, R.array.reports_status, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_reports_status.setAdapter(adapter1);
		
		
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context, R.array.projects, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_reports_project.setAdapter(adapter2);
		
	}
	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			Intent it = new Intent(context,ReviewReportDetailsActivity.class);
			startActivity(it);
		}
		
	};
	public void search(View v){
		String[] values = new String[]{"2014-2-10编写需求","2014-2-11画界面原型"};
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,values,true);
		this.review_reports_listView.setAdapter(adapter);
		this.review_reports_listView.setOnItemClickListener(item_listener);
	}
	
	public void back(View v){
		finish();
	}
}
