package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MyReportDetailsActivity extends Activity{

	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_report_details);
	}
	public void back(View v){
		this.finish();
	}
	public void update(View v){
		this.finish();
	}
}
