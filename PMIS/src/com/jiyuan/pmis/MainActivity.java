package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.reports.ReportsManagerActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;
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

	// private final String NAMESPACE = "http://login.func.jypmis.com";
	// private final String URL =
	// "http://192.168.1.101:8000/JYPMIS/services/Login";
	MainApplication app;
	private User user = new User();
	private Context context;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		app = (MainApplication) this.getApplication();
	}

	public void login(View v) {

		try {
			this.initData();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		
		Intent it = new Intent(context, ReportsManagerActivity.class);
		startActivity(it);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void saveUser(String userStr) throws PmisException{
		try{
			Gson gson = new Gson();
			user = gson.fromJson(userStr, User.class);
			app.setUser(user);
		}catch(Exception e){
			throw new PmisException("用户名密码错误");
		}
	}

	private void volidate(String username, String password) throws Exception,PmisException {
		Soap soap = new Soap(Constant.NAMESPACE, "login");
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
		String ret = soap.getResponse(Constant.URL, Constant.URL + "/login");
		this.saveUser(ret);
	}

	private void initData() throws PmisException {
		EditText username_et = (EditText) this.findViewById(R.id.username_et);
		EditText password_et = (EditText) this.findViewById(R.id.password_et);
		String username = username_et.getText().toString();
		String password = password_et.getText().toString();
		if (username.length() == 0 || password.length() == 0) {
			throw new PmisException("用户名或密码不能为空！"); 
		}
		try{
			this.volidate(username,password);
		}catch(PmisException e){
			throw e; 
		}catch(Exception e){
			throw new PmisException("网络连接错误！"); 
		}
	}
}
