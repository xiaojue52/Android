package com.jiyuan.pmis.fragment;

import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.reports.MyReportsActivity;
import com.jiyuan.pmis.reports.ReviewReportsActivity;
import com.jiyuan.pmis.setting.SettingActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentPage4 extends Fragment{

	private Button button_more_look_my_report,button_more_look_review_report,button_more_setting;
	private Context context;
	private View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		if (v!=null){
			((ViewGroup)v.getParent()).removeView(v);
			return v;
		}
		v = inflater.inflate(R.layout.fragment_4, null);	
		this.context = this.getActivity();
		this.button_more_look_my_report = (Button)v.findViewById(R.id.button_more_look_my_report);
		this.button_more_look_review_report = (Button)v.findViewById(R.id.button_more_look_review_report);
		this.button_more_setting = (Button)v.findViewById(R.id.button_more_setting);
		
		this.button_more_look_my_report.setOnClickListener(look_my_report_listener);
		this.button_more_look_review_report.setOnClickListener(look_review_report_listener);
		this.button_more_setting.setOnClickListener(setting_listener);
		if (!((MainApplication)this.getActivity().getApplication()).getUser().shqx.equals("1")){
			this.button_more_look_review_report.setClickable(false);
			this.button_more_look_review_report.setTextColor(Color.GRAY);
		}
		return v;		
	}	
	private OnClickListener look_my_report_listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,MyReportsActivity.class);
			context.startActivity(it);
		}
		
	};
	private OnClickListener look_review_report_listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,ReviewReportsActivity.class);
			context.startActivity(it);
		}
		
	};
	private OnClickListener setting_listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,SettingActivity.class);
			context.startActivity(it);
		}
		
	};
}