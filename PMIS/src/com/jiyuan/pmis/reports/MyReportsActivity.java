package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyReportsActivity extends Activity{
	private ListView my_reports_listView;
	private Context context;
	private Project project;
	private MainApplication app;
	private TextView textview_my_reports_projects,textview_my_reports_startTime,textview_my_reports_endTime;
	private CheckBox checkbox_my_reports_refuse,checkbox_my_reports_waiting,checkbox_my_reports_pass;
	
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ListView)this.findViewById(R.id.my_reports_listView);
		this.initData();
		
	}
	OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			Intent it = new Intent(context,MyReportDetailsActivity.class);
			it.putExtra("bgid", item.key);
			startActivity(it);
		}
		
	};
	public void search(View v){
		ReportSearchField r = this.getReportSearchField();
		listReports(r);
	}
	
	private ReportSearchField getReportSearchField(){
		ReportSearchField r = new ReportSearchField();
		r.xmid = project.xmid;
		r.kssj = this.textview_my_reports_startTime.getText().toString();
		r.jssj = this.textview_my_reports_endTime.getText().toString();
		if (this.checkbox_my_reports_refuse.isChecked()){
			r.xzwtg = "1";
		}else
			r.xzwtg = "0";
		if (this.checkbox_my_reports_waiting.isChecked()){
			r.xzdsh = "1";
		}else
			r.xzdsh = "0";
		if (this.checkbox_my_reports_pass.isChecked()){
			r.xzysh = "1";
		}else
			r.xzysh = "0";
		r.type = "0";
		r.yhid = app.getUser().yhid;
		return r;
	}
	
	public void back(View v){
		finish();
	}	
	
	public void delete(View v){
		//this.my_reports_listView.
		boolean hadChecked = false;
		SeparatedListAdapter adapter = (SeparatedListAdapter) this.my_reports_listView.getAdapter();
		for(int i=0;i<adapter.getCount();i++){
			Class<? extends Object> c = adapter.getItem(i).getClass(); 
			Class<Item> cl = Item.class;
			if(c.isAssignableFrom(cl)){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = (Item)adapter.getItem(i);
				if(item.isChecked){
					hadChecked = true;
					//Toast.makeText(this, "删除！"+item.key+"......"+item.firstLineText, Toast.LENGTH_SHORT).show();
					try {
						this.deleteReport(item.key);	
					} catch (PmisException e) {
						// TODO Auto-generated catch block
						Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked){
			Toast.makeText(this, "请选择报工！", Toast.LENGTH_SHORT).show();
		}
		else
			this.search(v);
	}
	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				project.xmid = data.getStringExtra("xmid");
				project.xmjc = data.getStringExtra("xmjc");
				this.textview_my_reports_projects.setText(project.xmjc);
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	
	private void listReports(ReportSearchField r){
		SeparatedListAdapter adapter = new SeparatedListAdapter(this.context);
		ReportSort[] sorts = new ReportSort[]{};
		try {
			sorts = this.getReports(r);
		} catch (PmisException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}
		
		for (int i=0;i<sorts.length;i++){
			List<Report> reports = sorts[i].list;
			List<Item> items = new ArrayList<Item>();
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				item.firstLineText = reports.get(j).gznr;
				item.secondLineText = reports.get(j).shxx;
				if (reports.get(j).zt.equals("-1")||reports.get(j).zt.equals("0"))
					item.showCheckbox = true;
				else 
					item.showCheckbox = false;
				items.add(item);
			}
			SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);
			adapter.addSection(sorts[i].xmjc, listAdapter);
		}

		// Listen for Click events
		this.my_reports_listView.setAdapter(adapter);
		this.my_reports_listView.setOnItemClickListener(item_listener);
	}
	
	private ReportSort[] getReports(ReportSearchField r) throws PmisException{
		final String METHOD_NAME = "getReports";
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("reportSearchFieldStr");
		arg0.setValue(new Gson().toJson(r));
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("获取报工列表失败！");
		}
		try{
			return new Gson().fromJson(ret, ReportSort[].class);	
		}catch(Exception e){
			throw new PmisException("当前没有报工！");
		}
	}
	
	
	private void deleteReport(String bgid) throws PmisException{
		final String METHOD_NAME = "getReports";
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bgid");
		arg0.setValue(bgid);
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("删除报工失败！");
		}
		if(ret.equals(1)){
			Toast.makeText(this, "删除报工成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("删除报工失败！");
	}
	private void initData(){
		app = (MainApplication) this.getApplication();
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		this.textview_my_reports_projects = (TextView)this.findViewById(R.id.textview_my_reports_projects);
		this.textview_my_reports_startTime = (TextView)this.findViewById(R.id.textview_my_reports_startTime);
		this.textview_my_reports_endTime = (TextView)this.findViewById(R.id.textview_my_reports_endTime);
		this.checkbox_my_reports_refuse = (CheckBox)this.findViewById(R.id.checkbox_my_reports_refuse);
		this.checkbox_my_reports_waiting = (CheckBox)this.findViewById(R.id.checkbox_my_reports_waiting);
		this.checkbox_my_reports_pass = (CheckBox)this.findViewById(R.id.checkbox_my_reports_pass);
		
		this.textview_my_reports_projects.setText(project.xmjc);
		this.textview_my_reports_startTime.setText("--");
		this.textview_my_reports_endTime.setText(Constant.getCurrentDataString("yyyy-MM-dd"));
		this.checkbox_my_reports_refuse.setChecked(true);
		
		ReportSearchField r = this.getReportSearchField();
		listReports(r);
	}
	
	
	private int year,month,day;
	static final int DATE_PICKER_ID = 1111;
	private TextView date = null;
	@SuppressWarnings("deprecation")
	public void selectDate(View v) {
		// Toast.makeText(context, "this is a test", Toast.LENGTH_SHORT).show();
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		date = (TextView)v;
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
			date.setText(Constant.toDateString(c.getTime(), "yyyy-MM-dd"));
		}
	};
}
