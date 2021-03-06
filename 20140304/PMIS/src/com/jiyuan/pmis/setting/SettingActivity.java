package com.jiyuan.pmis.setting;

import com.jiyuan.pmis.MainActivity;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.UserInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends Activity{
	private TextView textview_version;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_setting);
		this.textview_version = (TextView)this.findViewById(R.id.textview_version);
		this.textview_version.setText(Constant.getCurVersion(this));
	}
	public void back(View v){
		this.finish();
	}
	public void logout(View v){
		this.clearData();
		Intent it = new Intent(this,MainActivity.class);
		it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(it);
	}
	private void clearData(){
		DatabaseHandler db = new DatabaseHandler(this);
		UserInfo info = new UserInfo();
		info.setId(1);
		db.deleteUserInfo(info);
	}
	
}
