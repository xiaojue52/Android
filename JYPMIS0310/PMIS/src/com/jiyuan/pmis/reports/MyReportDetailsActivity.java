package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.constant.MLocation;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Report;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyReportDetailsActivity extends Activity{
	private Context context;
	private TextView textview_my_report_details_reports_option;
	private MainApplication app;
	private Report report;
	//private boolean inProject = false;
	
	private TextView textview_my_report_details_date,textview_my_report_details_status,textview_my_report_details_project,
			textview_my_report_details_note,textview_my_report_details_review_man;
	private EditText edittext_my_report_details_content,edittext_my_report_details_working_time,edittext_my_report_details_position;
	private Button btn_my_report_details_update,btn_my_report_details_delete;
	
	private LinearLayout my_report_details_note_box,my_report_details_review_man_box,my_report_details_status;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_report_details);
		this.context = this;	
		app = (MainApplication) this.getApplication();
		report = new Report();
		Intent it = this.getIntent();
		report.bgid = it.getStringExtra("bgid");
		this.initDate();
	}
	
	
	public void back(View v){
		//Intent it = new Intent();
		//this.setResult(Activity.RESULT_OK,it);
		this.finish();
	}
	
	public void delete(View v){
		try {
			this.deleteReport(report.bgid);	
			this.finish();
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this.context, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	private void deleteReport(String bgid) throws PmisException{
		final String METHOD_NAME = "deleteReport";
		Soap soap = new Soap(Constant.report_namespace,METHOD_NAME);
		
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bgid");
		arg0.setValue(bgid);
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("删除报工失败！");
		}
		if(ret.equals("1")){
			Toast.makeText(this, "删除报工成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("删除报工失败！");
	}
	public void update(View v){
		MLocation.getCNBylocation(this.context);
		String location = MLocation.cityName;
		report.zswz = location;
		Float f = null;
		try{
			f = Float.valueOf(this.edittext_my_report_details_working_time.getText().toString());
			
		}catch(Exception e){
			Toast.makeText(this, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (f<=0||f>24){
			Toast.makeText(this, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (this.edittext_my_report_details_position.getText().toString().length()==0||this.edittext_my_report_details_content.getText().length()==0){
			Toast.makeText(this.context, "表单内容不能为空！", Toast.LENGTH_SHORT)
			.show();
			return;
		}
		/*if (!inProject){
			report.xmid = "-1";
		}*/
		//report.bgxid = ((SpinnerItem)this.spinner_my_report_details_reports_option.getSelectedItem()).key;
		report.gzdd = this.edittext_my_report_details_position.getText().toString();
		report.gznr = this.edittext_my_report_details_content.getText().toString();
		report.gzrq = this.textview_my_report_details_date.getText().toString();
		report.gzxs = this.edittext_my_report_details_working_time.getText().toString();
		try {
			this.updateReport(app.getUser().yhid, report);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		this.finish();
	}
	
	public void selectDate(View v) {
		Constant.selectDate(context, (TextView)v);
	}
	private void initDate(){
		this.textview_my_report_details_project = (TextView)this.findViewById(R.id.textview_my_report_details_project);
		this.edittext_my_report_details_content = (EditText)this.findViewById(R.id.edittext_my_report_details_content);
		this.textview_my_report_details_date = (TextView)this.findViewById(R.id.textview_my_report_details_date);
		this.textview_my_report_details_note = (TextView)this.findViewById(R.id.textview_my_report_details_note);
		this.textview_my_report_details_status = (TextView)this.findViewById(R.id.textview_my_report_details_status);
		this.edittext_my_report_details_position = (EditText)this.findViewById(R.id.edittext_my_report_details_position);
		this.edittext_my_report_details_working_time = (EditText)this.findViewById(R.id.edittext_my_report_details_working_time);
		this.btn_my_report_details_update = (Button)this.findViewById(R.id.btn_my_report_details_update);
		this.btn_my_report_details_delete = (Button)this.findViewById(R.id.btn_my_report_details_delete);
		this.textview_my_report_details_review_man = (TextView)this.findViewById(R.id.textview_my_report_details_review_man);
		
		this.my_report_details_note_box = (LinearLayout)this.findViewById(R.id.my_report_details_note_box);
		this.my_report_details_review_man_box = (LinearLayout)this.findViewById(R.id.my_report_details_review_man_box);
		this.my_report_details_status = (LinearLayout)this.findViewById(R.id.my_report_review_status_box);
		
		
		this.textview_my_report_details_reports_option = (TextView)this.findViewById(R.id.textview_my_report_details_reports_option);
		
		
		this.edittext_my_report_details_content.setOnTouchListener(edittext_listener);
		this.textview_my_report_details_note.setOnTouchListener(edittext_listener);
		this.edittext_my_report_details_working_time.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
		
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
		this.textview_my_report_details_project.setText(report.xmjc);
		this.textview_my_report_details_date.setText(report.gzrq);
		this.textview_my_report_details_note.setText(report.shxx);
		this.textview_my_report_details_review_man.setText(report.shr);
		
		textview_my_report_details_reports_option.setText(app.getReportType(report.bgxid));
		String temp = "";
		if (report.zt.equals("-1")){
			temp = "未通过";
		}else if(report.zt.equals("0")){
			temp = "待审核";
		}else
			temp = "已审核";
		this.textview_my_report_details_status.setText(temp);
		this.edittext_my_report_details_content.setText(report.gznr);
		this.edittext_my_report_details_position.setText(report.gzdd);
		this.edittext_my_report_details_working_time.setText(report.gzxs);
		{
			this.textview_my_report_details_project.setClickable(false);
			this.textview_my_report_details_project.setTextColor(Color.GRAY);
			this.textview_my_report_details_date.setClickable(false);
			this.textview_my_report_details_date.setTextColor(Color.GRAY);
			this.textview_my_report_details_note.setClickable(false);
			this.textview_my_report_details_note.setTextColor(Color.GRAY);
			this.textview_my_report_details_status.setClickable(false);
			this.textview_my_report_details_status.setTextColor(Color.GRAY);
			this.textview_my_report_details_review_man.setTextColor(Color.GRAY);
			this.textview_my_report_details_reports_option.setTextColor(Color.GRAY);
		}
		if(report.zt.equals("1")){
			
			this.edittext_my_report_details_content.setClickable(false);
			this.edittext_my_report_details_content.setTextColor(Color.GRAY);
			this.edittext_my_report_details_content.setFocusable(false);
			
			this.edittext_my_report_details_position.setClickable(false);
			this.edittext_my_report_details_position.setFocusable(false);
			this.edittext_my_report_details_position.setTextColor(Color.GRAY);
			
			this.edittext_my_report_details_working_time.setClickable(false);
			this.edittext_my_report_details_working_time.setFocusable(false);
			this.edittext_my_report_details_working_time.setTextColor(Color.GRAY);
			
			
			//((SpinnerItem)this.spinner_my_report_details_reports_option.getSelectedItem()).textview.setTextColor(Color.GRAY);
			
			this.btn_my_report_details_update.setEnabled(false);
			this.btn_my_report_details_delete.setEnabled(false);
			this.btn_my_report_details_delete.setTextColor(Color.GRAY);
			this.btn_my_report_details_update.setTextColor(Color.GRAY);
			
		}else if (report.zt.equals("-1")){
			this.btn_my_report_details_delete.setEnabled(false);
			this.btn_my_report_details_delete.setTextColor(Color.GRAY);
		}else if (report.zt.equals("0")&&(report.shsj==null||report.shsj.length()==0)){
			//this.textview_my_report_details_status.setVisibility(View.GONE);
			//this.textview_my_report_details_note.setVisibility(View.GONE);
			//this.textview_my_report_details_review_man.setVisibility(View.GONE);
			this.my_report_details_note_box.setVisibility(View.GONE);
			this.my_report_details_review_man_box.setVisibility(View.GONE);
			this.my_report_details_status.setVisibility(View.GONE);
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
		arg2.setValue("0");
		arg2.setType(String.class);
		
		args.add(arg2);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("修改失败！");
		}
		if(ret.equals("1")){
			Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("修改失败！");
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
