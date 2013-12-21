package com.example.android1219.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class BackIntentService extends IntentService {


	public BackIntentService() {
		super("1");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		String dataString = arg0.getDataString();
		int i=0;
		while(i<=10){
			i++;
			try {
				
				Thread.sleep(1000);
				//System.out("2",dataString);
				Log.v("test",dataString);
				Toast.makeText(this, "this", Toast.LENGTH_LONG).show();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
