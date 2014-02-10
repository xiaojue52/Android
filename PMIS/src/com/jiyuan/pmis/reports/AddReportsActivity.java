package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddReportsActivity extends Activity{
	private Context context;
	private Spinner spinner_add_page_project;
	private Spinner spinner_add_page_review_man;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_add_reports);
		this.context = this;
		this.spinner_add_page_project = (Spinner)this.findViewById(R.id.spinner_add_page_project);
		this.spinner_add_page_review_man = (Spinner)this.findViewById(R.id.spinner_add_page_review_man);
		String[] v1 = {"项目1","项目2","项目3"};
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,v1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_add_page_project.setAdapter(adapter1);
		spinner_add_page_project.setVisibility(View.VISIBLE);
		
		
		String[] v2 = {"张三","李四","王五"};
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,v2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_add_page_review_man.setAdapter(adapter2);
		spinner_add_page_review_man.setVisibility(View.VISIBLE);
	}
	public void cancel(View v){
		this.finish();
	}
	public void done(View v){
		this.finish();
	}
}
