package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.Calendar;
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
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewReportDetailsActivity extends Activity{
	private Context context;
	//private Spinner spinner_review_report_details_reports_option;
	private TextView textview_review_report_details_reports_option;
	private TextView textview_review_report_details_project,textview_review_report_details_date,
					textview_review_report_details_status,textview_review_report_details_report_date;
	private EditText edittext_review_report_details_content,edittext_review_report_details_working_time,
					edittext_review_report_details_position;
	private EditText edittext_review_report_details_note;
	private MainApplication app;
	private Report report;
	//private boolean inProject = false;
	
	static final int DATE_PICKER_ID = 1111;
	private int year;
	private int month;
	private int day;
	
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_review_report_details);
		this.context = this;
		app = (MainApplication) this.getApplication();
		report = new Report();
		Intent it = this.getIntent();
		report.bgid = it.getStringExtra("bgid");
		this.initData();
	}
	public void back(View v){
		this.finish();
	}
	
	public void pass(View v){
		this.update(0);
	}
	public void refuse(View v){
		this.update(1);
	}
	private void update(int tag){
		if (tag==0)
			report.zt = "-1";
		else
			report.zt = "1";
		/*if (inProject){
			report.xmid = "-1";
		}*/
		//report.bgxid = ((SpinnerItem)this.spinner_review_report_details_reports_option.getSelectedItem()).key;
		report.gzdd = this.edittext_review_report_details_position.getText().toString();
		report.gznr = this.edittext_review_report_details_content.getText().toString();
		report.gzrq = this.textview_review_report_details_date.getText().toString();
		report.gzxs = this.edittext_review_report_details_working_time.getText().toString();
		report.shxx = this.edittext_review_report_details_note.getText().toString();
		try {
			this.updateReport(app.getUser().yhid, report);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		this.finish();
	}
	
	
	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == Constant.REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				report.xmid = data.getStringExtra("xmid");
				this.textview_review_report_details_project.setText(data.getStringExtra("xmjc"));
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	
	private void initData(){
		this.textview_review_report_details_project = (TextView)this.findViewById(R.id.textview_review_report_details_project);
		this.textview_review_report_details_date = (TextView)this.findViewById(R.id.textview_review_report_details_date);
		this.textview_review_report_details_report_date = (TextView)this.findViewById(R.id.textview_review_report_details_report_date);
		this.textview_review_report_details_status = (TextView)this.findViewById(R.id.textview_review_report_details_status);
		
		this.edittext_review_report_details_content = (EditText)this.findViewById(R.id.edittext_review_report_details_content);
		this.edittext_review_report_details_note = (EditText)this.findViewById(R.id.edittext_review_report_details_note);
		this.edittext_review_report_details_position = (EditText)this.findViewById(R.id.edittext_review_report_details_position);
		this.edittext_review_report_details_working_time = (EditText)this.findViewById(R.id.edittext_review_report_details_working_time);
		
		this.textview_review_report_details_reports_option = (TextView)this.findViewById(R.id.textview_review_report_details_report_option);
		//this.spinner_review_report_details_reports_option = (Spinner)this.findViewById(R.id.spinner_review_report_details_reports_option);
		//this.spinner_review_report_details_reports_option.setOnItemSelectedListener(onItemSelectedListener);
		
		//this.spinner_review_report_details_reports_option.setClickable(false);
		
		//this.textview_review_report_details_project.setClickable(false);
		//this.textview_review_report_details_project.setTextColor(Color.GRAY);
		
		/*ReportType[] types = app.getReportTypes();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = types[i].bgxid;
			item.value = types[i].bgxmc;
			item.zt = types[i].zt;
			values.add(item);
		}*/
		//SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(this,
		//		R.layout.spinner_item, values);
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//this.spinner_review_report_details_reports_option.setAdapter(adapter);
		
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
		}else
			temp = "已审核";
		this.textview_review_report_details_status.setText(temp);
		this.edittext_review_report_details_content.setText(report.gznr);
		this.edittext_review_report_details_position.setText(report.gzdd);
		this.edittext_review_report_details_working_time.setText(report.gzxs);
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
			throw new PmisException("更新失败！");
		}
		if(ret.equals("1")){
			Toast.makeText(this, "更新成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("更新失败！");
	}
	
	/*private Spinner.OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0.getAdapter();
			SpinnerItem item = adapter.getItem(arg2);
			if (item.zt.equals("0")){
				inProject = false;
				textview_review_report_details_project.setTextColor(Color.GRAY);
			}else {
				inProject = true;
				textview_review_report_details_project.setTextColor(Color.BLACK);
			}
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			textview_review_report_details_project.setClickable(inProject);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, "wu", Toast.LENGTH_SHORT).show();
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0.getAdapter();
			SpinnerItem item = adapter.getItem(0);
			if (item.zt.equals("0")){
				inProject = false;
				textview_review_report_details_project.setTextColor(Color.GRAY);
			}else{
				inProject = true;
				textview_review_report_details_project.setTextColor(Color.BLACK);
			}
			textview_review_report_details_project.setClickable(inProject);
		}
		
	};*/
	

	@SuppressWarnings("deprecation")
	public void selectDate(View v) {
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		// Toast.makeText(context, "this is a test", Toast.LENGTH_SHORT).show();
		showDialog(DATE_PICKER_ID);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_PICKER_ID:
			return new DatePickerDialog(this, pickerListener, year, month, day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, selectedYear);
			c.set(Calendar.MONTH, selectedMonth);
			c.set(Calendar.DAY_OF_MONTH, selectedDay);
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
			// Show selected date
			textview_review_report_details_date.setText(Constant.toDateString(c.getTime(),"yyyy-MM-dd"));
		}
	};
}