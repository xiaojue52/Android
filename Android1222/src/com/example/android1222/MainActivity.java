package com.example.android1222;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context context;
	private Button call_service,call_provider;
	private ContentResolver contentResolver;
	private final String AUTHORITY = "jason.wei.apps.notes.providers.NotesContentProvider";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		contentResolver = this.getContentResolver();
		call_service = (Button)this.findViewById(R.id.call_service);
		this.call_service.setOnClickListener(Call_Service);
		this.call_provider = (Button)this.findViewById(R.id.call_provider);
		this.call_provider.setOnClickListener(Call_Provider);
	}

	private OnClickListener Call_Provider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor cursor = contentResolver.query(Uri.parse("content://"+AUTHORITY+"/notes"), null, null, null, null);
			if(cursor.moveToNext()){
				 //String name = cursor.getColumnName(0);
				 Toast.makeText(context, "the column is "+cursor.getString(2), Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(context, "provider error!", Toast.LENGTH_LONG).show();
		}
		
	};
	private OnClickListener Call_Service = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent it = new Intent("com.example.android1219.Service.MyLocalService");
			startService(it);
		}
		
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
