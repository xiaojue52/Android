package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MyReportsActivity extends Activity{
	private ListView my_reports_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ListView)this.findViewById(R.id.my_reports_listView);
		String[] values = new String[]{"2014-2-10宣城出差演示系统","2014-2-11修改程序增加新功能"};
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,values,false);
		this.my_reports_listView.setAdapter(adapter);
		this.my_reports_listView.setOnItemClickListener(item_listener);
	}
	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			Intent it = new Intent(context,MyReportDetailsActivity.class);
			startActivity(it);
		}
		
	};
	
	public void back(View v){
		finish();
	}
	public void createReports(View v){
		//Toast.makeText(context, "新建报工", Toast.LENGTH_SHORT).show();
		Intent it =  new Intent(this,AddReportsActivity.class);
		startActivity(it);
	}
}
