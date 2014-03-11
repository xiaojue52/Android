package com.jiyuan.pmis.setting;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.structure.ServerInfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class ServerConfigeActivity extends Activity{
	private EditText edittext_server_addr,edittext_server_port;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_server_config);
		this.edittext_server_addr = (EditText)this.findViewById(R.id.edittext_server_addr);
		this.edittext_server_port = (EditText)this.findViewById(R.id.edittext_server_port);
		ServerInfo info = Constant.getServerInfo(this);
		this.edittext_server_addr.setText(info.server_addr);
		this.edittext_server_port.setText(info.server_port);
		//this.edittext_server_addr.setInputType(EditorInfo.t);
		this.edittext_server_port.setInputType(EditorInfo.TYPE_CLASS_PHONE);
	}
	public void back(View v){
		this.finish();
	}
	public void submit(View v){
		if(this.edittext_server_addr.getText().toString().length()==0||this.edittext_server_port.getText().toString().length()==0){
			Toast.makeText(this, "请填写服务器和端口号！", Toast.LENGTH_LONG).show();
			return;
		}
		//Constant.configServer(this.edittext_server_addr.getText().toString(),this.edittext_server_port.getText().toString());
		ServerInfo info = new ServerInfo();
		info.server_addr = this.edittext_server_addr.getText().toString();
		info.server_port = this.edittext_server_port.getText().toString();
		Constant.saveServerInfo(info, this);
		//Intent it = new Intent(this,MainActivity.class);
		//it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		//startActivity(it);
		this.finish();
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
