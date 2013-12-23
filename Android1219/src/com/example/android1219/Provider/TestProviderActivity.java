package com.example.android1219.provider;

import com.example.android1219.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TestProviderActivity extends Activity {
	private Context context;
	private Button test_provider,test_updateProvider,test_deleteProvider,test_insertProvider;
	private ContentResolver contentResolver;
	
	public TestProviderActivity() {
		// TODO Auto-generated constructor stub
		context = this;
	}
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.provider_activity);
		this.test_provider = (Button)this.findViewById(R.id.test_provider);
		this.test_provider.setOnClickListener(Test_Provider);
		this.contentResolver = this.getContentResolver();
		
		this.test_deleteProvider = (Button)this.findViewById(R.id.test_deleteProvider);
		this.test_insertProvider = (Button)this.findViewById(R.id.test_insertProvider);
		this.test_updateProvider = (Button)this.findViewById(R.id.test_updateProvider);
		this.test_deleteProvider.setOnClickListener(this.Test_DeleteProvider);
		this.test_insertProvider.setOnClickListener(this.Test_InsertProvider);
		this.test_updateProvider.setOnClickListener(this.Test_UpdateProvider);
	}
	private OnClickListener Test_DeleteProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private OnClickListener Test_InsertProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentValues values = new ContentValues();
			//values.put(Note.Notes.CONTENT_TYPE, "type");
			values.put(Note.Notes.TEXT, "Text");
			values.put(Note.Notes.TITLE, "title");
			contentResolver.insert(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/notes"), values);
		}
		
	};
	private OnClickListener Test_UpdateProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private OnClickListener Test_Provider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor cursor = contentResolver.query(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/notes"), null, null, null, null);
			if(cursor.moveToNext()){
				Toast.makeText(context, "it has "+cursor.getCount(), Toast.LENGTH_LONG).show();
				
			}
		}
		
	};
}
