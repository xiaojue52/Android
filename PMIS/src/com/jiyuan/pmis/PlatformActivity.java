package com.jiyuan.pmis;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;
import com.jiyuan.pmis.reports.ReportsManagerActivity;
import com.jiyuan.pmis.workbench.WorkbenchActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class PlatformActivity extends Activity {

	private ListView platform_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_platform);		
		context = this;
		this.platform_listView = (ListView)this.findViewById(R.id.platform_listView);
		String[] values = new String[] { "工作台", "报工管理", "其他。。。"};
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,
				values,false);
		platform_listView.setAdapter(adapter);
		platform_listView.setOnItemClickListener(item_listener);
		
	}
	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			switch(arg2){
			case 0:
				Intent it0 = new Intent(context,WorkbenchActivity.class);
				startActivity(it0);
				break;
			case 1:
				Intent it1 = new Intent(context,ReportsManagerActivity.class);
				startActivity(it1);
				break;
			default:
				Toast.makeText(context, "待开发", Toast.LENGTH_LONG).show();
				break;
			}
		}
		
	};
	
	public void back(View v){
		this.finish();
	}
}
