package com.jiyuan.pmis;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.fragment.FragmentPage1;
import com.jiyuan.pmis.fragment.FragmentPage2;
import com.jiyuan.pmis.fragment.FragmentPage3;
import com.jiyuan.pmis.fragment.FragmentPage4;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Department;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.User;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;


public class TabHostActivity extends FragmentActivity{	

	private FragmentTabHost mTabHost;
	private MainApplication app;
	private User user;
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
				try{
					setMyReportCount(getReportCount("-1"));
					setReviewReportCount(getReportCount("0"));
				}catch(Exception e){
					
				}
			}
		});
        
    }
	 
	@Override
	protected void onResume(){
		super.onResume();
		this.setCount();
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
			this.getDepartments();
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
}

