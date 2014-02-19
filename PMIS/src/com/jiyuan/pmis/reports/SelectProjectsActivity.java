package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class SelectProjectsActivity extends FragmentActivity{
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
