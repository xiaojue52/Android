package com.jiyuan.pmis.setting;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity{
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_about);
	}
	public void back(View v){
		this.finish();
	}
}
