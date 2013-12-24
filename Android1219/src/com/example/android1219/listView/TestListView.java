package com.example.android1219.listView;

import com.example.android1219.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TestListView extends Activity {

	private ListView test_listView;
	private Context context;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.listview_activity);
		context = this;
		this.test_listView = (ListView)this.findViewById(R.id.test_listView);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
		        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
		        "Android", "iPhone", "WindowsMobile" };
		final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,
				values);
		test_listView.setAdapter(adapter);
		test_listView.setOnItemClickListener(new ListView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "Click arg2 item", Toast.LENGTH_LONG).show();
			}
			
		});
	}
}
