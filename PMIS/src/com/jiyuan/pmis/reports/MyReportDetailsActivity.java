package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MyReportDetailsActivity extends Activity{
	private Context context;
	private Spinner spinner_my_report_details_project;

	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_report_details);
		this.context = this;
		this.spinner_my_report_details_project = (Spinner)this.findViewById(R.id.spinner_my_report_details_project);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.projects, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_my_report_details_project.setAdapter(adapter);
	}
	public void back(View v){
		this.finish();
	}
	public void update(View v){
		this.finish();
	}
}
