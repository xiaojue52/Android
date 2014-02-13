package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;
import com.jiyuan.pmis.setting.SettingActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ReportsManagerActivity extends Activity {
	private ListView reports_manager_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_reports_manager);
		this.context = this;
		this.reports_manager_listView = (ListView)this.findViewById(R.id.reports_manager_listView);
		String[] values = new String[] { "新建报工","我的报工", "审核报工"};
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,
				values,false);
		this.reports_manager_listView.setAdapter(adapter);
		this.reports_manager_listView.setOnItemClickListener(item_listener);
	}

	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_LONG).show();
			switch(arg2){
			case 0:
				Intent it0 = new Intent(context,AddReportsActivity.class);
				startActivity(it0);
				break;
			case 1:
				Intent it1 = new Intent(context,MyReportsActivity.class);
				startActivity(it1);
				break;
			case 2:
				Intent it2 = new Intent(context,ReviewReportsActivity.class);
				startActivity(it2);
				break;
			default:
				break;
			}
		}
		
	};
	public void back(View v){
		this.finish();
	}
	public void setting(View v){
		//Toast.makeText(this, "设置界面", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(this,SettingActivity.class);
		startActivity(it);
	}
}
