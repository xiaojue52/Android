package com.example.android1219;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.IBinder;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private LocalWordService s;
	private Context context;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.activity_main);
		wordList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				wordList);
		setListAdapter(adapter);
		Button btn = (Button)this.findViewById(R.id.third);
		btn.setOnClickListener(BtnOnclick);
	}

	private Button.OnClickListener BtnOnclick = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,ThirdActivity.class);
			startActivityForResult(it, 1);
		}
		
	};
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (requestCode == 1) {
		     if(resultCode == RESULT_OK){      
		         String result=data.getStringExtra("ret");      
		         Toast.makeText(context, result, Toast.LENGTH_LONG).show();
		     }
		     if (resultCode == RESULT_CANCELED) {    
		         //Write your code if there's no result
		     }
		  }
		  if (requestCode == 2){
			  if(resultCode == RESULT_OK){
				  String ret = data.getStringExtra("ret");
				  Toast.makeText(context, ret, Toast.LENGTH_LONG).show();
			  }
		  }
		}
	@Override
	protected void onResume() {
		super.onResume();
		bindService(new Intent(this, LocalWordService.class), mConnection,
				Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unbindService(mConnection);
	}

	private ServiceConnection mConnection = new ServiceConnection() {

		public void onServiceConnected(ComponentName className, IBinder binder) {
			s = ((LocalWordService.MyBinder) binder).getService();
			Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT)
					.show();
		}

		public void onServiceDisconnected(ComponentName className) {
			s = null;
		}
	};
	private ArrayAdapter<String> adapter;
	private List<String> wordList;

	public void onClick(View view) {
		/*if (s != null) {

			Toast.makeText(this, "Number of elements" + s.getWordList().size(),
					Toast.LENGTH_SHORT).show();
			wordList.clear();
			wordList.addAll(s.getWordList());
			adapter.notifyDataSetChanged();
		}*/
		Intent it = new Intent(this,SecondActivity.class);
		startActivityForResult(it,2);
	}
	
}
