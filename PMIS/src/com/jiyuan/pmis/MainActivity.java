package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.jiyuan.pmis.reports.ReportsManagerActivity;
import com.jiyuan.pmis.soap.Soap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	//private final String NAMESPACE = "http://login.user.pmis.com";
	//private final String URL = "http://192.168.1.101:8000/PMIS/services/Login";
	private static final String NAMESPACE = "http://com.soap";
	private static final String URL = "http://192.168.1.17:8080/Soap/services/TestObject";
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
	}

	public void login(View v){
		EditText username_et = (EditText)this.findViewById(R.id.username_et);
		EditText password_et = (EditText)this.findViewById(R.id.password_et);
		String username = username_et.getText().toString();
		String password = password_et.getText().toString();
		if (username.length()==0||password.length()==0){
			Toast.makeText(context, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
			return;
		}
		Soap soap = new Soap(NAMESPACE, "login");
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("username");
		arg0.setValue(username);
		arg0.setType(String.class);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("password");
		arg1.setValue(password);
		arg1.setType(String.class);
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = soap.getResponse(URL, URL+"/login");
		if (ret!=null){
			Log.v("login", ret);
			Intent it1 = new Intent(context,ReportsManagerActivity.class);
			startActivity(it1);
		}else
			Toast.makeText(context, "用户名或密码错误，请重新输入！", Toast.LENGTH_LONG).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
