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
			contentResolver.delete(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/"+Note.table_name+"/1"), "", null);
		}
		
	};
	private OnClickListener Test_InsertProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentValues values = new ContentValues();
			//values.put(Note.Notes.CONTENT_TYPE, "type");
			values.put(Note.TEXT, "Text");
			values.put(Note.TITLE, "title");
			contentResolver.insert(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/"+Note.table_name), values);
		}
		
	};
	private OnClickListener Test_UpdateProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentValues values = new ContentValues();
			values.put(Note.TEXT, "update text");
			values.put(Note.TITLE, "update title");
			contentResolver.update(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/"+Note.table_name), values, null, null);
		}
		
	};
	private OnClickListener Test_Provider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor cursor = contentResolver.query(Uri.parse("content://"+NotesContentProvider.AUTHORITY+"/"+Note.table_name), new String[]{Note.TITLE,Note.TEXT}, null, null, null);
			String content = "";
			if(cursor.moveToFirst()){
				do{
					content += cursor.getString(0)+"--"+cursor.getString(1)+";";
				}while(cursor.moveToNext());
			}
			if (content.length()==0){
				Toast.makeText(context, "there is no record!", Toast.LENGTH_LONG).show();
			}else
				Toast.makeText(context, content, Toast.LENGTH_LONG).show();
			cursor.close();
		}
		
	};
}
