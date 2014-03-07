package com.jiyuan.pmis.project;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectProjectsActivity extends FragmentActivity{
	private RadioGroup radioGroup;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_select_projects);
		radioGroup = (RadioGroup)this.findViewById(R.id.radiogroup_select_projects);
		radioGroup.setOnCheckedChangeListener(listener);
		RadioButton rb = (RadioButton)this.findViewById(R.id.radiobutton_recent_projects);
		rb.setChecked(true);
	}
	public void back(View v){
		//Intent it = new Intent();
		//this.setResult(Activity.RESULT_OK,it);
		this.finish();
	}
	
	private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			Fragment fr;
			if (checkedId==R.id.radiobutton_department_projects){
				 fr = new SelectProjectsDepartmentFragment();
			}
			else if (checkedId==R.id.radiobutton_recent_projects){
				fr = new SelectProjectsRecentFragment();
			}
			else 
				fr = new SelectProjectsSearchFragment();
			selectFrag(fr);
		}
		
	};
	
	public void selectFrag(Fragment fr) {
		 FragmentManager fm = getSupportFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
	}
}
