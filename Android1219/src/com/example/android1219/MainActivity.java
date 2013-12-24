package com.example.android1219;


import com.example.android1219.provider.TestProviderActivity;
import com.example.android1219.service.SecondActivity;
import com.example.android1219.service.ThirdActivity;
import com.example.android1219.thread.TestThreadActivity;
import com.example.android1219.listView.TestListView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.activity_main);
		Button btn = (Button)this.findViewById(R.id.third);
		Button four = (Button)this.findViewById(R.id.four);
		Button five = (Button)this.findViewById(R.id.five);
		Button six = (Button)this.findViewById(R.id.six);
		Button seven = (Button)this.findViewById(R.id.seven);
		Button eight = (Button)this.findViewById(R.id.eight);
		four.setOnClickListener(TestContentProvider);
		five.setOnClickListener(TestSql);
		six.setOnClickListener(TestListView);
		seven.setOnClickListener(TestThread);
		eight.setOnClickListener(TestSocket);

		btn.setOnClickListener(BtnOnclick);
	}

	private OnClickListener TestContentProvider = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,TestProviderActivity.class);
			startActivity(it);
		}
		
	};
	private OnClickListener TestSql = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private OnClickListener TestListView = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,TestListView.class);
			startActivity(it);
		}
		
	};
	private OnClickListener TestThread = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,TestThreadActivity.class);
			startActivity(it);
		}
		
	};
	private OnClickListener TestSocket = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private Button.OnClickListener BtnOnclick = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,ThirdActivity.class);
			startActivityForResult(it, 1);
		}
		
	};
	@Override
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
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	public void onClick(View view) {
		Intent it = new Intent(this,SecondActivity.class);
		startActivityForResult(it,2);
	}
	
}
