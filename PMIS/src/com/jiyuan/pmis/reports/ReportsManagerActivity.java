package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.setting.SettingActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.ReportType;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ReportsManagerActivity extends Activity {
	private ListView reports_manager_listView;
	private Context context;
	
	private final String NAMESPACE = "http://com.soap";
	private final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_reports_manager);
		this.context = this;
		
		this.initListView();
		
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
	
	public void initListView(){
		List<Item> items = new ArrayList<Item>();
		Bundle extras = this.getIntent().getExtras();
		int wait_count = extras.getInt("wait_count");
		int refuse_count = extras.getInt("refuse_count");
		this.reports_manager_listView = (ListView)this.findViewById(R.id.reports_manager_listView);
		String[] values = new String[] { "新建报工","我的报工", "审核报工"};
		String[] description = new String[] {"创建新的报工","查看我的报工","查看我要审核的报工"};
		Item item0 = new Item();
		item0.firstLineText = values[0];
		item0.secondLineText = description[0];
		item0.count = "";
		item0.imageRid = R.drawable.ic_launcher;
		item0.showCheckbox = false;
		Item item1 = new Item();
		item1.firstLineText = values[1];
		item1.secondLineText = description[1];
		item1.count = String.valueOf(refuse_count);
		item1.imageRid = R.drawable.ic_launcher;
		item1.showCheckbox = false;
		Item item2 = new Item();
		item2.firstLineText = values[2];
		item2.secondLineText = description[2];
		item2.count = String.valueOf(wait_count);
		item2.imageRid = R.drawable.ic_launcher;
		item2.showCheckbox = false;
		
		items.add(item0);
		items.add(item1);
		items.add(item2);
		
		final SimpleAdapter adapter = new SimpleAdapter(this,
				items);
		this.reports_manager_listView.setAdapter(adapter);
		this.reports_manager_listView.setOnItemClickListener(item_listener);
	}
	
}
