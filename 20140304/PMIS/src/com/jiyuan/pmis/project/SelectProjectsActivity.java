package com.jiyuan.pmis.project;

import com.jiyuan.pmis.R;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectProjectsActivity extends FragmentActivity{
	private RadioGroup radioGroup;
	private Fragment selectProjectsDepartmentFragment;
	private Fragment selectProjectsRecentFragment;
	private Fragment selectProjectsSearchFragment;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_select_projects);
		this.selectProjectsDepartmentFragment = new SelectProjectsDepartmentFragment();
		//this.selectProjectsDepartmentFragment.setRetainInstance(false);
		this.selectProjectsRecentFragment = new SelectProjectsRecentFragment();
		//this.selectProjectsRecentFragment.setRetainInstance(false);
		this.selectProjectsSearchFragment = new SelectProjectsSearchFragment();
		//this.selectProjectsSearchFragment.setRetainInstance(false);
		radioGroup = (RadioGroup)this.findViewById(R.id.radiogroup_select_projects);
		radioGroup.setOnCheckedChangeListener(listener);
		RadioButton rb = (RadioButton)this.findViewById(R.id.radiobutton_recent_projects);
		rb.setChecked(true);
	}
	public void back(View v){
		//Intent it = new Intent();
		//this.setResult(Activity.RESULT_OK,it);
		this.finish();
	}
	
	private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			Fragment fr;
			if (checkedId==R.id.radiobutton_department_projects){
				 fr = selectProjectsDepartmentFragment;
			}
			else if (checkedId==R.id.radiobutton_recent_projects){
				fr = selectProjectsRecentFragment;
			}
			else 
				fr = selectProjectsSearchFragment;
			selectFrag(fr);
		}
		
	};
	
	public void selectFrag(Fragment fr) {
		 FragmentManager fm = getSupportFragmentManager();
	     FragmentTransaction fragmentTransaction = fm.beginTransaction();
	     fragmentTransaction.replace(R.id.fragment_place, fr);
	     fragmentTransaction.commit();
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
