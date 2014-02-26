package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleBaseExpandableListAdapter;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.ExpandListItem;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MyReportsActivity extends Activity{
	private ExpandableListView my_reports_listView;
	private Spinner spinner_my_reports_projects;
	private Context context;
	private Project project;
	private MainApplication app;
	private TextView textview_my_reports_startTime,textview_my_reports_endTime;
	private CheckBox checkbox_my_reports_refuse,checkbox_my_reports_waiting,checkbox_my_reports_pass;
	
	private boolean firstCreate = true;
	//private SeparatedListAdapter adapter;
	
	private List<SpinnerItem> spinnerItems;
	private SimpleSpinnerAdapter adapter;
	
	private SimpleBaseExpandableListAdapter expandableadapter;
	
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ExpandableListView)this.findViewById(R.id.my_reports_listView);
		this.my_reports_listView.setGroupIndicator(null);
		this.initData();
		
	}
	
	@Override
	protected void onResume(){
		
		super.onResume();
		if(!firstCreate){
			this.search(null);
		}
		firstCreate = false;
			
	}

	public void search(View v){
		ReportSearchField r = this.getReportSearchField();
		List<ExpandListItem> values = listReports(r);
		this.expandableadapter.setValues(values);
		this.expandableadapter.notifyDataSetChanged();
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
		int count = expandableadapter.getGroupCount();
		for(int i=0;i<count;i++){
			List<Item> items = expandableadapter.getGroup(i).items;
			for(int j=0;j<items.size();j++){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = items.get(j);
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
	private void selectProjects() {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				spinnerItems = this.getSpinnerItems();
				adapter.notifyDataSetChanged();
				project.xmid = data.getStringExtra("xmid");
				project.xmjc = data.getStringExtra("xmjc");
				for(int i =0;i<spinnerItems.size();i++){
					if(project.xmid.equals(spinnerItems.get(i).key))
							this.spinner_my_reports_projects.setSelection(i);
				}
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	
	private List<ExpandListItem> listReports(ReportSearchField r){
		List<ReportSort> sorts = new ArrayList<ReportSort>();
		List<ExpandListItem> values = new ArrayList<ExpandListItem>();
		try {
			sorts = this.getReports(r);
		} catch (PmisException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return values;
		}
		
		for (int i=0;i<sorts.size();i++){
			ExpandListItem expandListItem = new ExpandListItem();
			List<Report> reports = sorts.get(i).list;
			List<Item> items = new ArrayList<Item>();
			expandListItem.title = sorts.get(i).title;
		
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				item.firstLineText = reports.get(j).gzrq+"  "+reports.get(j).gznr;
				item.secondLineText = reports.get(j).shxx;
				if (reports.get(j).zt.equals("-1")||reports.get(j).zt.equals("0"))
					item.showCheckbox = true;
				else 
					item.showCheckbox = false;
				items.add(item);
			}
			expandListItem.items = items;
			values.add(expandListItem);
		}
		return values;
	}
	
	private List<ReportSort> getReports(ReportSearchField r) throws PmisException{
		Report[] reports = new Report[]{};
		final String METHOD_NAME = "getReports";
		Soap soap = new Soap(Constant.report_namespace,METHOD_NAME);
		
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("reportSearchFieldStr");
		arg0.setValue(new Gson().toJson(r));
		args.add(arg0);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("获取报工列表失败！");
		}
		try{
			reports = new Gson().fromJson(ret, Report[].class);	
		}catch(Exception e){
			throw new PmisException("当前没有报工！");
		}
		List<Report> listReports = new ArrayList<Report>();
		for (int i=0;i<reports.length;i++){
			listReports.add(reports[i]);
		}
		List<ReportSort> sorts = new ArrayList<ReportSort>();
		while(listReports.size()>0){
			List<Report> list = new ArrayList<Report>();
			Report b = listReports.get(0);
			list.add(b);
			
			listReports.remove(0);
			int i = 0;
			while(listReports.size()!=i){
				if (b.xmjc.equals((listReports).get(i).xmjc)){
					list.add((listReports).get(i));
					listReports.remove(i);
					i--;
				}
				i++;
			}
			ReportSort sort = new ReportSort();
			sort.title = b.xmjc;
			sort.list = list;
			sorts.add(sort);
		}
		Log.e("pmis.....",new Gson().toJson(sorts));
		return sorts;
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
			//Toast.makeText(this, "删除报工成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("删除报工失败！");
	}
	private void initData(){
		app = (MainApplication) this.getApplication();
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		this.spinner_my_reports_projects = (Spinner)this.findViewById(R.id.spinner_my_reports_projects);
		this.textview_my_reports_startTime = (TextView)this.findViewById(R.id.textview_my_reports_startTime);
		this.textview_my_reports_endTime = (TextView)this.findViewById(R.id.textview_my_reports_endTime);
		this.checkbox_my_reports_refuse = (CheckBox)this.findViewById(R.id.checkbox_my_reports_refuse);
		this.checkbox_my_reports_waiting = (CheckBox)this.findViewById(R.id.checkbox_my_reports_waiting);
		this.checkbox_my_reports_pass = (CheckBox)this.findViewById(R.id.checkbox_my_reports_pass);
		
		//this.textview_my_reports_projects.setText(project.xmjc);
		this.textview_my_reports_startTime.setText("--");
		this.textview_my_reports_endTime.setText(Constant.getCurrentDataString("yyyy-MM-dd"));
		this.checkbox_my_reports_refuse.setChecked(true);
		
		spinnerItems = this.getSpinnerItems();
		
		adapter = new SimpleSpinnerAdapter(this,R.layout.spinner_item,spinnerItems);
		this.spinner_my_reports_projects.setAdapter(adapter);
		this.spinner_my_reports_projects.setOnItemSelectedListener(listener);
		
		List<ExpandListItem> values = this.listReports(this.getReportSearchField());
		expandableadapter = new SimpleBaseExpandableListAdapter(this,values);
		this.my_reports_listView.setAdapter(expandableadapter);
		//this.review_reports_listView.setOnItemClickListener(item_listener);
		this.my_reports_listView.setOnGroupCollapseListener(onGroupCollapseListener);
		this.my_reports_listView.setOnGroupExpandListener(onGroupExpandListener);
		this.my_reports_listView.setOnChildClickListener(onChildClickListener);

	}
	
	private List<SpinnerItem> getSpinnerItems(){
		List<SpinnerItem> items = new ArrayList<SpinnerItem>();
		SpinnerItem firstItem = new SpinnerItem();
		firstItem.key = "-1";
		firstItem.value = "全部";
		SpinnerItem lastItem = new SpinnerItem();
		lastItem.key = "0";
		lastItem.value = "其它";
		items.add(firstItem);
		DatabaseHandler db = new DatabaseHandler(this);
		List<ProjectInfo> list = db.getAllProjectInfos();
		for(int i=0;list!=null&&i<list.size();i++){
			SpinnerItem item = new SpinnerItem();
			item.key = list.get(i).getXmid();
			item.value = list.get(i).getXmjc();
			items.add(item);
		}
		items.add(lastItem);
		return items;
	}
	
	private Spinner.OnItemSelectedListener listener = new Spinner.OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter)arg0.getAdapter();
			SpinnerItem item = adapter.getItem(arg2);
			if (item.key.equals("0")&&item.value.equals("其它")){
				selectProjects();
			}else{
				project.xmid = item.key;
				project.xmjc = item.value;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
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
	
	private ExpandableListView.OnGroupExpandListener onGroupExpandListener = new ExpandableListView.OnGroupExpandListener(){

		@Override
		public void onGroupExpand(int groupPosition) {
			// TODO Auto-generated method stub
			expandableadapter.notifyDataSetChanged();
		}
		
	};
	
	private ExpandableListView.OnGroupCollapseListener onGroupCollapseListener = new ExpandableListView.OnGroupCollapseListener(){

		@Override
		public void onGroupCollapse(int groupPosition) {
			// TODO Auto-generated method stub
			expandableadapter.notifyDataSetChanged();
		}
		
	};
	
	private ExpandableListView.OnChildClickListener onChildClickListener = new ExpandableListView.OnChildClickListener(){

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,ReviewReportDetailsActivity.class);
			it.putExtra("bgid", ((Item)expandableadapter.getChild(groupPosition, childPosition)).key);
			startActivity(it);
			return false;
		}
		
	};
}
