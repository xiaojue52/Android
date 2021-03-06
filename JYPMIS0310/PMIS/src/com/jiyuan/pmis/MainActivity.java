package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.setting.ServerConfigeActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.UserInfo;
import com.jiyuan.pmis.structure.User;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	MainApplication app;
	private User user = new User();
	private Context context;
	// private CheckBox checkbox_main_remenber;
	private EditText username_et, password_et;
	private DatabaseHandler db;

	// private EditText for_test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		app = (MainApplication) this.getApplication();
		db = new DatabaseHandler(this);
		// this.for_test = (EditText)this.findViewById(R.id.for_test);
		this.initData();
	}

	public void serverConfige(View v) {
		Intent it = new Intent(this, ServerConfigeActivity.class);
		startActivity(it);
	}

	private void initData() {
		username_et = (EditText) this.findViewById(R.id.username_et);
		password_et = (EditText) this.findViewById(R.id.password_et);
		// checkbox_main_remenber =
		// (CheckBox)this.findViewById(R.id.checkbox_main_remenber);
		UserInfo info = db.getUserInfo(1);
		if (info != null) {
			username_et.setText(info.getUsername());
			password_et.setText(Constant.deCode(info.getPassword()));
			// checkbox_main_remenber.setChecked(true);
		}
		Constant.configServer(Constant.getServerInfo(this));
	}

	public void login(View v) {
		// Constant.host = this.for_test.getText().toString();
		// System.out.println(Constant.login_url);
		// Toast.makeText(this, Constant.login_url, Toast.LENGTH_SHORT).show();
		try {
			this.doLogin();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		this.saveData();
		Intent it = new Intent(context, TabHostActivity.class);
		startActivity(it);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void saveUser(String userStr) throws PmisException {
		try {
			Gson gson = new Gson();
			user = gson.fromJson(userStr, User.class);
			app.setUser(user);
		} catch (Exception e) {
			throw new PmisException("用户名密码错误");
		}
	}

	private void volidate(String username, String password) throws Exception,
			PmisException {
		Soap soap = new Soap(Constant.login_namespace, "login");
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
		String ret = soap.getResponse(Constant.login_url, Constant.login_url
				+ "/login");
		this.saveUser(ret);
	}

	private void doLogin() throws PmisException {

		String username = username_et.getText().toString();
		String password = password_et.getText().toString();
		if (username.length() == 0 || password.length() == 0) {
			throw new PmisException("用户名或密码不能为空！");
		}
		try {
			this.volidate(username, password);
		} catch (PmisException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PmisException("网络连接错误！");
		}
	}

	private void saveData() {

		UserInfo info = new UserInfo();
		info.setId(1);
		info.setUsername(this.username_et.getText().toString());
		info.setPassword(Constant.doCode(this.password_et.getText().toString()));
		if (db.getUserInfosCount() == 0)
			db.addUserInfo(info);
		else
			db.updateUserInfo(info);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (isShouldHideInput(v, ev)) {
				hideSoftInput(v.getWindowToken());
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
	 * 
	 * @param v
	 * @param event
	 * @return
	 */
	private boolean isShouldHideInput(View v, MotionEvent event) {
		if (v != null && (v instanceof EditText)) {
			int[] l = { 0, 0 };
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (event.getX() > left && event.getX() < right
					&& event.getY() > top && event.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}

	/**
	 * 多种隐藏软件盘方法的其中一种
	 * 
	 * @param token
	 */
	private void hideSoftInput(IBinder token) {
		if (token != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(token,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
}
