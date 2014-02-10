package com.jiyuan.pmis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		Button login_btn = (Button)this.findViewById(R.id.login_btn);
		login_btn.setOnClickListener(login_btn_Listener);
	}

	OnClickListener login_btn_Listener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, "login button is clicked!", Toast.LENGTH_LONG).show();
			Intent it = new Intent(context,PlatformActivity.class);
			startActivity(it);
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
