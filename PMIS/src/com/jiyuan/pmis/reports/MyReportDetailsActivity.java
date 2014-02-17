package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MyReportDetailsActivity extends Activity{
	private Context context;
	private Spinner spinner_my_report_details_reports_option;

	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_report_details);
		this.context = this;
		/*this.spinner_my_report_details_project = (Spinner)this.findViewById(R.id.spinner_my_report_details_project);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.projects, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_my_report_details_project.setAdapter(adapter);*/
		
		this.spinner_my_report_details_reports_option = (Spinner)this.findViewById(R.id.spinner_my_report_details_reports_option);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.reports_option, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_my_report_details_reports_option.setAdapter(adapter);
	}
	public void back(View v){
		this.finish();
	}
	public void update(View v){
		this.finish();
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
}
