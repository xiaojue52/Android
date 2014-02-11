package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectProjectsActivity extends Activity{
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_select_projects);
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
}
