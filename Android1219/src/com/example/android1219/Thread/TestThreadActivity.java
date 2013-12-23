package com.example.android1219.thread;

import com.example.android1219.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestThreadActivity extends Activity {
	private Context context;
	private Button test_updateUI,test_handler,test_newClass;
	private TextView test_updateUI_text;
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg){
			if (msg.what==3){
				Toast.makeText(context, "i sleeped 3 s", Toast.LENGTH_LONG).show();
			}
		}
	};
	public TestThreadActivity() {
		// TODO Auto-generated constructor stub
		context = this;
	}
	@Override
	protected void onCreate(Bundle saveBundle){
		super.onCreate(saveBundle);
		this.setContentView(R.layout.thread_activity);

		this.test_updateUI = (Button)this.findViewById(R.id.test_updateUI);
		this.test_updateUI_text = (TextView)this.findViewById(R.id.test_updateUI_text);
		this.test_updateUI.setOnClickListener(Test_UpdateUI);
		this.test_handler = (Button)this.findViewById(R.id.test_handler);
		this.test_handler.setOnClickListener(Test_Handler);
		this.test_newClass = (Button)this.findViewById(R.id.test_newClass);
		this.test_newClass.setOnClickListener(Test_NewClass);
	}
	private OnClickListener Test_NewClass = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Test test = new Test(){
				@Override
				public void run(){
					Toast.makeText(context, "this is override method", Toast.LENGTH_LONG).show();
				}
			};
			test.run2();
		}
		
	};
	private OnClickListener Test_Handler = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Runnable run = new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					handler.sendEmptyMessage(3);
				}
				
			};
			Thread thread = new Thread(run);
			thread.start();
		}
		
	};
	private OnClickListener Test_UpdateUI = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Thread thread = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					TestThreadActivity.this.runOnUiThread(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(context, "i am from a new thread", Toast.LENGTH_LONG).show();
						}
						
					});
					try {
						Thread.sleep(3000);
						test_updateUI_text.post(new Runnable(){

							@Override
							public void run() {
								// TODO Auto-generated method stub
								test_updateUI_text.setText("i am from another thread too");
							}
							
						});
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			});
			thread.start();
		}
		
	};

	@Override
	protected void onResume(){
		super.onResume();
	}
	@Override
	protected void onStart(){
		super.onStart();
	}
	@Override
	protected void onPause(){
		super.onPause();
	}
	@Override
	protected void onStop(){
		super.onStop();
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
	}
	class Test{
		public Test(){
			this.run();
		}
		public void run(){
			Log.v("Test","parent");
		}
		public void run2(){
			Toast.makeText(context, "parent method", Toast.LENGTH_LONG).show();
		}
	}
}
