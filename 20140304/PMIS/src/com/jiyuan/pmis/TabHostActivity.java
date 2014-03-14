package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.constant.MLocation;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.fragment.FragmentPage1;
import com.jiyuan.pmis.fragment.FragmentPage2;
import com.jiyuan.pmis.fragment.FragmentPage3;
import com.jiyuan.pmis.fragment.FragmentPage4;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;


public class TabHostActivity extends FragmentActivity{	

	private FragmentTabHost mTabHost;
	private MainApplication app;
	private User user;
	private Context context;
	private LayoutInflater layoutInflater;	
	@SuppressWarnings("rawtypes")
	private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class};
	
	private int mImageViewArray[] = {R.drawable.tab_item1,R.drawable.tab_item2,R.drawable.tab_item3,R.drawable.tab_item4};	
	private String mTextviewArray[] = {"新建报工", "我的报工", "报工审核", "更多"};
	private String mCount[] = {"","","",""};
	private int mShowCount[] = {View.GONE,View.VISIBLE,View.VISIBLE,View.GONE};
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout);
        this.app = (MainApplication) this.getApplication();
		this.user = app.getUser();	
		this.context = this;
        initView();
        try {
			initDate();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				new MyThread().start();
			}
		});
        
    }
	 
	@Override
	protected void onResume(){
		super.onResume();
		//this.setCount();
		new MyThread().start();
	}
	private void initView(){

		layoutInflater = LayoutInflater.from(this);
				
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);	
		
		int count = fragmentArray.length;	
				
		for(int i = 0; i < count; i++){	
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
		if (!app.getUser().shqx.equals("1")){
			mTabHost.getTabWidget().getChildAt(2).setClickable(false);
			mTabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.disable_bg);
			((TextView)mTabHost.getTabWidget().getChildTabViewAt(2).findViewById(R.id.textview)).setTextColor(Color.GRAY);
		}
	}
				
	private View getTabItemView(int index){
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
	
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		
		TextView textView = (TextView) view.findViewById(R.id.textview);		
		textView.setText(mTextviewArray[index]);
		
		TextView count = (TextView)view.findViewById(R.id.count);
		count.setVisibility(mShowCount[index]);
		count.setText(mCount[index]);
		return view;
	}
	
	private void initDate() throws PmisException{
		try{
			this.getReportTypes();
			//this.getDepartments();
		}catch(Exception e){
			throw new PmisException("获取数据失败！"); 
		}
	}
	
	public void setCount(){
		try {
			this.setMyReportCount(this.getReportCount("-1"));
			this.setReviewReportCount(this.getReportCount("0"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	private void setMyReportCount(String count){
		((TextView)mTabHost.getTabWidget().getChildTabViewAt(1).findViewById(R.id.count)).setText(count);
	}
	private void setReviewReportCount(String count){
		((TextView)mTabHost.getTabWidget().getChildTabViewAt(2).findViewById(R.id.count)).setText(count);
	}
	private void getReportTypes() throws Exception {
		final String METHOD_NAME = "getReportTypes";
		Soap soap = new Soap(Constant.report_namespace, METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(Constant.report_url, Constant.report_url + "/" + METHOD_NAME);
		Gson gson = new Gson();
		ReportType[] reportTypes = gson.fromJson(ret, ReportType[].class);
		app.setReportTypes(reportTypes);
	}

	private void getDepartments() throws Exception {
		final String METHOD_NAME = "getDepartments";
		Soap soap = new Soap(Constant.department_namespace, METHOD_NAME);
		String ret = null;
		ret = soap.getResponse(Constant.department_url, Constant.department_url + "/" + METHOD_NAME);
		Gson gson = new Gson();
		Department[] departments = gson.fromJson(ret, Department[].class);
		app.setDepartments(departments);
	}
	/**
	 * 
	 * @param zt
	 * @return
	 * @throws Exception
	 */
	private String getReportCount(String zt) throws Exception {
		
		final String METHOD_NAME = "getReportCount";
		Soap soap = new Soap(Constant.report_namespace, METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("yhid");
		arg0.setValue(user.yhid);
		arg0.setType(String.class);

		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("zt");
		arg1.setValue(zt);
		arg1.setType(String.class);
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = soap
				.getResponse(Constant.report_url, Constant.report_url + "/" + METHOD_NAME);
		return ret;
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private long start = 0;
	class MyThread extends Thread{
		@Override 
		public void run(){
			super.run();
			Message msg = new Message();
			Bundle data = new Bundle();
			try {
				data.putString("-1", getReportCount("-1"));
				data.putString("0", getReportCount("0"));
				long now = new Date().getTime();
				if ((now - start)>60*60*1000){
					MLocation.getCNBylocation(context);
					location = MLocation.cityName;
					start = now;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				data.putString("-1", "0");
				data.putString("0", "0");
				e.printStackTrace();
			}
			msg.setData(data);
			handler.sendMessage(msg);
		}
	}
	public String location = "";
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			Bundle data = msg.getData();
			setMyReportCount(data.getString("-1"));
			setReviewReportCount(data.getString("0"));
		}
	};
	
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

