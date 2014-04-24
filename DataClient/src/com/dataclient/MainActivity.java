package com.dataclient;

import java.util.HashMap;
import java.util.Map;
import com.constant.Constant;
import com.example.dataclient.R;
import com.google.gson.Gson;
import com.stracture.ClassRoom;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private EditText username_et,password_et;
	private RadioGroup radioGroup;
	private String tag = "0";
	private String name;
	private String password;
	private MainApplication app;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		this.username_et = (EditText)this.findViewById(R.id.username_et);
		this.password_et = (EditText)this.findViewById(R.id.password_et);
		this.radioGroup = (RadioGroup)this.findViewById(R.id.radiogroup_main);
		radioGroup.setOnCheckedChangeListener(listener);
		RadioButton rb = (RadioButton)this.findViewById(R.id.radiobutton_main_student);
		rb.setChecked(true);
		app = (MainApplication)this.getApplication();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void login(View v){
		name = username_et.getText().toString();
		password = password_et.getText().toString();
		if (name.length()==0||password.length()==0)
		{
			Toast.makeText(context, "用户名、密码不能为空！", Toast.LENGTH_LONG).show();
			return;
		}
		pd = ProgressDialog.show(this, "登录中", "请稍后。。。。。。");
		/* 开启一个新线程，在新线程里执行耗时的方法 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				String localhost = Constant.addr+":"+Constant.port;
				// spandTimeMethod();// 耗时的方法
				String url = "http://"+localhost+"/DataServer/login.action";
				String url2 = "http://"+localhost+"/DataServer/listClassRooms.action";
				Map<String, String> pars = new HashMap<String, String>();
				
				pars.put("tag", tag);
				pars.put("name", name);
				pars.put("password", password);	
				String ret = Constant.getData(url, pars);
				Message mes = Message.obtain();
				Bundle b = new Bundle();
				b.putString("data", ret);
				mes.setData(b);
				
				
				String retClassRooms = Constant.getData(url2, null);
				try{
					ClassRoom[] list = new Gson().fromJson(retClassRooms, ClassRoom[].class); 
					app.setClassRooms(list);
				}catch(Exception e){
					
				}
				handler.sendMessage(mes);// 执行耗时的方法之后发送消给handler
			}
		}).start();
		
	}
	
	
	public void register(View v){
		Intent it = new Intent(this,RegisterActivity.class);
		startActivity(it);
	}
	
	private ProgressDialog pd;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message mes){
			String ret = mes.getData().getString("data");
			if(ret==null){
				Toast.makeText(context, "网络错误！", Toast.LENGTH_LONG).show();
			}
			else{
				if(ret.equals("-1")){
					Toast.makeText(context, "用户名、密码错误！", Toast.LENGTH_LONG).show();
				}else{
					app.setTag(Integer.valueOf(tag));
					app.setUserId(ret);
					Intent it = new Intent(context,TabHostActivity.class);
					startActivity(it);
				}
					
			}
			pd.dismiss();
		}
	};
	
	
	private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if (checkedId==R.id.radiobutton_main_student){
				tag = "0";
			}
			else {
				tag = "1";
			}
				
		}
		
	};
	
	/**
	 * 监听touch事件，关闭软键盘
	 */
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
