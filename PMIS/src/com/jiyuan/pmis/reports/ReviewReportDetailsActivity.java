package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewReportDetailsActivity extends Activity{
	private Context context;
	private Spinner spinner_review_report_details_reports_option;
	private TextView textview_review_report_details_project,textview_review_report_details_date,
					textview_review_report_details_status,textview_review_report_details_report_date;
	private EditText edittext_review_report_details_content,edittext_review_report_details_working_time,
					edittext_review_report_details_position,edittext_review_report_details_note;
	private MainApplication app;
	private Report report;
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
		this.update();
	}
	public void refuse(View v){
		this.update();
	}
	private void update(){
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
		
		
		this.spinner_review_report_details_reports_option = (Spinner)this.findViewById(R.id.spinner_review_report_details_reports_option);
		
		ReportType[] types = app.getReportTypes();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = types[i].bgxid;
			item.value = types[i].bgxmc;
			values.add(item);
		}
		SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(this,
				android.R.layout.simple_spinner_item, values);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_report_details_reports_option.setAdapter(adapter);
		
		try {
			Report report = this.showReport(this.report.bgid);
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
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bgid");
		arg0.setValue(bgid);
		arg0.setType(String.class);
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
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
		this.textview_review_report_details_status.setText(report.zt);
		this.edittext_review_report_details_content.setText(report.gznr);
		this.edittext_review_report_details_position.setText(report.gzdd);
		this.edittext_review_report_details_working_time.setText(report.gzxs);
		this.textview_review_report_details_report_date.setText(report.bgsj);
		ReportType[] types = app.getReportTypes();
		for (int i=0;i<types.length;i++){
			if(types[i].bgxid.equals(report.bglx))
				this.spinner_review_report_details_reports_option.setSelection(i);
		}
	}
	private void updateReport(String yhid,Report report) throws PmisException{
		final String METHOD_NAME = "updateReport";
		Soap soap = new Soap(Constant.URL,METHOD_NAME);
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
		
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("更新失败！");
		}
		if(ret.equals("1")){
			Toast.makeText(this, "更新成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("更新失败！");
	}
}