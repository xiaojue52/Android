package com.example.android1219.Thread;

import com.example.android1219.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestThreadActivity extends Activity {
	private Context context;
	private Button test_updateUI;
	private TextView test_updateUI_text;
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
	}
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
}
