package com.example.android1219;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	private Context context;

	public ThirdActivity() {
		// TODO Auto-generated constructor stub
		context = this;
	}
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.third_activity);
		Button btn = (Button)this.findViewById(R.id.button3);
		btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context,"this is third activity", Toast.LENGTH_LONG).show();
				Intent it = new Intent();
				it.putExtra("ret", "1");
				setResult(RESULT_OK,it);
				finish();
			}
			
		});
	}
	
}
