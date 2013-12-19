package com.example.android1219;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	private Context context;

	public SecondActivity() {
		// TODO Auto-generated constructor stub
		context = this;
	}
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.second_activity);
		Button btn = (Button)this.findViewById(R.id.button2);
		
		btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "this is a test", Toast.LENGTH_LONG).show();
				Intent it = new Intent();
				it.putExtra("ret", "2");
				setResult(RESULT_OK,it);
				finish();
			}
			
		});
	}

}
