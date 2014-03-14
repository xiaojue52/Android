package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportType;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewReportDetailsActivity extends Activity{
	//private Context context;
	//private Spinner spinner_review_report_details_reports_option;
	private TextView textview_review_report_details_reports_option;
	private TextView textview_review_report_details_project,textview_review_report_details_date,textview_review_report_details_content,
					textview_review_report_details_status,textview_review_report_details_report_date;
	private TextView textview_review_report_details_working_time,
					textview_review_report_details_position;
	private EditText edittext_review_report_details_note;
	private LinearLayout review_report_details_bottom_menu;
	private Button button_review_report_details_pass,button_review_report_details_refuse;
	private MainApplication app;
	private Report report;
	//private boolean inProject = false;
	
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_review_report_details);
		//this.context = this;
		app = (MainApplication) this.getApplication();
		report = new Report();
		Intent it = this.getIntent();
		report.bgid = it.getStringExtra("bgid");
		this.initData();
	}
	public void back(View v){
		Intent it = new Intent();
		this.setResult(Activity.RESULT_OK,it);
		this.finish();
	}
	
	public void pass(View v){
		this.update(1);
	}
	public void refuse(View v){
		this.update(0);
	}
	private void update(int tag){
		Float f = null;
		try{
			f = Float.valueOf(this.textview_review_report_details_working_time.getText().toString());
			
		}catch(Exception e){
			Toast.makeText(this, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (f<=0||f>24){
			Toast.makeText(this, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		if (tag==0)
			report.zt = "-1";
		else
			report.zt = "1";
		/*if (inProject){
			report.xmid = "-1";
		}*/
		//report.bgxid = ((SpinnerItem)this.spinner_review_report_details_reports_option.getSelectedItem()).key;
		report.gzdd = this.textview_review_report_details_position.getText().toString();
		report.gznr = this.textview_review_report_details_content.getText().toString();
		report.gzrq = this.textview_review_report_details_date.getText().toString();
		report.gzxs = this.textview_review_report_details_working_time.getText().toString();
		report.shxx = this.edittext_review_report_details_note.getText().toString();
		if (report.shxx.length()<=0&&tag==0){
			Toast.makeText(this, "请输入审批信息！", Toast.LENGTH_SHORT).show();
			return;
		}
		try {
			this.updateReport(app.getUser().yhid, report);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		this.finish();
	}
	
	private void initData(){
		this.textview_review_report_details_project = (TextView)this.findViewById(R.id.textview_review_report_details_project);
		this.textview_review_report_details_date = (TextView)this.findViewById(R.id.textview_review_report_details_date);
		this.textview_review_report_details_report_date = (TextView)this.findViewById(R.id.textview_review_report_details_report_date);
		this.textview_review_report_details_status = (TextView)this.findViewById(R.id.textview_review_report_details_status);
		
		this.textview_review_report_details_content = (TextView)this.findViewById(R.id.textview_review_report_details_content);
		this.edittext_review_report_details_note = (EditText)this.findViewById(R.id.edittext_review_report_details_note);
		this.textview_review_report_details_position = (TextView)this.findViewById(R.id.textview_review_report_details_position);
		this.textview_review_report_details_working_time = (TextView)this.findViewById(R.id.textview_review_report_details_working_time);
		
		this.textview_review_report_details_reports_option = (TextView)this.findViewById(R.id.textview_review_report_details_report_option);
		this.review_report_details_bottom_menu = (LinearLayout)this.findViewById(R.id.review_report_details_bottom_menu);
		
		this.textview_review_report_details_content.setOnTouchListener(edittext_listener);
		this.edittext_review_report_details_note.setOnTouchListener(edittext_listener);
		
		this.button_review_report_details_pass = (Button)this.findViewById(R.id.button_review_report_details_pass);
		this.button_review_report_details_refuse = (Button)this.findViewById(R.id.button_review_report_details_refuse);
		
		try {
			report = this.showReport(this.report.bgid);
			this.setViewData(report);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
	}
	
	/**
	 * 调用soap
	 * @param bgid
	 * @return
	 * @throws PmisException
	 */
	private Report showReport(String bgid) throws PmisException{
		final String METHOD_NAME = "showReport";
		Soap soap = new Soap(Constant.report_namespace,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bgid");
		arg0.setValue(bgid);
		arg0.setType(String.class);
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url+"/"+METHOD_NAME);
			return new Gson().fromJson(ret, Report.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new PmisException("获取报工失败！");
		}		
	}
	private void setViewData(Report report){
		this.textview_review_report_details_project.setText(report.xmjc);
		this.textview_review_report_details_date.setText(report.gzrq);
		this.edittext_review_report_details_note.setText(report.shxx);
		String temp = "";
		if (report.zt.equals("-1")){
			temp = "未通过";
		}else if(report.zt.equals("0")){
			temp = "待审核";
		}else {
			temp = "已审核";
			this.edittext_review_report_details_note.setFocusable(false);
			this.edittext_review_report_details_note.setTextColor(Color.GRAY);
			this.review_report_details_bottom_menu.setVisibility(View.GONE);
			this.button_review_report_details_pass.setEnabled(false);
			this.button_review_report_details_refuse.setEnabled(false);
			this.button_review_report_details_pass.setClickable(false);
			this.button_review_report_details_refuse.setClickable(false);
		}
		this.textview_review_report_details_status.setText(temp);
		this.textview_review_report_details_content.setText(report.gznr);
		this.textview_review_report_details_position.setText(report.gzdd);
		this.textview_review_report_details_working_time.setText(report.gzxs);
		this.textview_review_report_details_report_date.setText(report.bgsj);
		ReportType[] types = app.getReportTypes();
		for (int i=0;i<types.length;i++){
			if(types[i].bgxid.equals(report.bgxid))
				//this.spinner_review_report_details_reports_option.setSelection(i);
				this.textview_review_report_details_reports_option.setText(types[i].bgxmc);
		}
	}
	private void updateReport(String yhid,Report report) throws PmisException{
		final String METHOD_NAME = "updateReport";
		Soap soap = new Soap(Constant.report_namespace,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("yhid");
		arg0.setValue(yhid);
		arg0.setType(String.class);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("reportStr");
		arg1.setValue(new Gson().toJson(report));
		arg1.setType(String.class);
		args.add(arg0);
		args.add(arg1);
		
		PropertyInfo arg2 = new PropertyInfo();
		arg2.setName("type");
		arg2.setValue("1");
		arg2.setType(String.class);
		
		args.add(arg2);
		
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("网络连接失败！");
		}
		if(ret.equals("1")){
			if (report.zt.equals("-1"))
				Toast.makeText(this, "拒绝报工成功！", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(this, "通过报工成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("网络连接失败！");
	}
	private OnTouchListener edittext_listener = new OnTouchListener(){

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			v.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
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