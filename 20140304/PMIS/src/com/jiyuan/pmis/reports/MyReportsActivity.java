package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleBaseExpandableListAdapter;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.project.SelectProjectsActivity;
import com.jiyuan.pmis.search.Search;
import com.jiyuan.pmis.search.SimpleSearchAdapter;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.ExpandListItem;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MyReportsActivity extends Activity{
	private ExpandableListView my_reports_listView;
	private Spinner spinner_my_reports_report_types;
	private Context context;
	private Project project;
	private MainApplication app;
	private TextView textview_my_reports_startTime,textview_my_reports_endTime;
	private CheckBox checkbox_my_reports_refuse,checkbox_my_reports_waiting,checkbox_my_reports_pass;
	private TextView textview_my_reports_project;
	
	//private SeparatedListAdapter adapter;
	
	private SimpleSpinnerAdapter adapter;
	
	private SimpleBaseExpandableListAdapter expandableadapter;
	
	private boolean isFirst = false;
	
	
	public static final int start_from_my_report_to_select_project = 10;
	public static final int start_from_my_report_to_my_report_details = 11;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.activity_my_reports);
		this.context = this;
		this.my_reports_listView = (ExpandableListView)this.findViewById(R.id.my_reports_listView);
		this.my_reports_listView.setGroupIndicator(null);
		this.initData();
		this.isFirst = true;
	}

	@Override
	protected void onResume(){
		super.onResume();
		if (!this.isFirst)
			this.search(null);
		this.isFirst = false;
	}
	public void search(View v){
		ReportSearchField r = this.getReportSearchField();
		List<ExpandListItem> values = listReports(r);
		this.expandableadapter.setValues(values);
		this.expandableadapter.notifyDataSetChanged();
	}
	
	private ReportSearchField getReportSearchField(){
		ReportSearchField r = new ReportSearchField();
		if (this.inProject)
			r.xmid = project.xmid;
		else
			r.xmid = "-1";
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
		r.bgxid = ((SpinnerItem)this.spinner_my_reports_report_types.getSelectedItem()).key;
		return r;
	}
	
	public void back(View v){
		finish();
	}	
	
	public void selectDate(View v) {
		Constant.selectDate(context, (TextView)v);
	}	
	
	private List<ExpandListItem> listReports(ReportSearchField r){
		List<ReportSort> sorts = new ArrayList<ReportSort>();
		List<ExpandListItem> values = new ArrayList<ExpandListItem>();
		try {
			sorts = this.getReports(r);
		} catch (PmisException e) {
			Toast.makeText(this.context, e.getMessage(), Toast.LENGTH_SHORT).show();
			return values;
		}
		
		for (int i=0;i<sorts.size();i++){
			ExpandListItem expandListItem = new ExpandListItem();
			List<Report> reports = sorts.get(i).list;
			List<Item> items = new ArrayList<Item>();
			expandListItem.title = sorts.get(i).title;
			expandListItem.count = sorts.get(i).count;
			expandListItem.showCheckBox = false;
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				item.firstLineText = reports.get(j).gzrq.substring(5)+"   "+reports.get(j).gzxs+"小时";

				item.secondLineText = reports.get(j).gznr;
				item.showCheckbox = false;
				
				if (reports.get(j).zt.equals("0")){
					item.showTail = true;
					item.taiColor = Color.parseColor("#009bd9");
					item.tailText = "待审核";
				}else if(reports.get(j).zt.equals("1")){
					item.showTail = true;
					item.taiColor = Color.parseColor("#8ec156");
					item.tailText = "已审核";
				}else {
					item.showTail = true;
					item.taiColor = Color.parseColor("#ff8974");
					item.tailText = "未通过";
				}
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
			sort.count = list.size();
			if (b.xmjc.equals("--")){
				ReportType[] types = app.getReportTypes();
				for (int j=0;j<types.length;j++){
					ReportSort typeSort = new ReportSort();
					typeSort.title = types[j].bgxmc;
					List<Report> typeList = new ArrayList<Report>();
					for(int k=0;k<list.size();k++){
						if (types[j].bgxid.equals(list.get(k).bgxid)){
							typeList.add(list.get(k));
						}
					}
					typeSort.list = typeList;
					typeSort.count = typeList.size();
					if(typeSort.count>0)
						//sorts.add(typeSort);
						sorts.add(0, typeSort);
				}
			}else
				sorts.add(sort);
		}
		Log.e("pmis.....",new Gson().toJson(sorts));
		return sorts;
	}
	
	
	private void initData(){
		app = (MainApplication) this.getApplication();
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		
		View headerView = View.inflate(this, R.layout.my_report_search_box, null);
		headerView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
		this.textview_my_reports_startTime = (TextView)headerView.findViewById(R.id.textview_my_reports_startTime);
		this.textview_my_reports_endTime = (TextView)headerView.findViewById(R.id.textview_my_reports_endTime);
		this.checkbox_my_reports_refuse = (CheckBox)headerView.findViewById(R.id.checkbox_my_reports_refuse);
		this.checkbox_my_reports_waiting = (CheckBox)headerView.findViewById(R.id.checkbox_my_reports_waiting);
		this.checkbox_my_reports_pass = (CheckBox)headerView.findViewById(R.id.checkbox_my_reports_pass);
		this.spinner_my_reports_report_types = (Spinner)headerView.findViewById(R.id.spinner_my_reports_report_types);
		this.textview_my_reports_project = (TextView)headerView.findViewById(R.id.textview_my_reports_project);
		
		
		//this.textview_my_reports_projects.setText(project.xmjc);
		this.textview_my_reports_startTime.setText(Constant.getBeforeCurrentDataString("yyyy-MM-dd", 7));
		this.textview_my_reports_endTime.setText(Constant.getCurrentDataString("yyyy-MM-dd"));
		this.checkbox_my_reports_refuse.setChecked(true);
		this.checkbox_my_reports_pass.setChecked(true);
		this.checkbox_my_reports_waiting.setChecked(true);
		
		this.textview_my_reports_project.setText(project.xmjc);
		
		ReportType[] types = app.getReportTypes();
		
		
		List<SpinnerItem> typeValues = new ArrayList<SpinnerItem>();
		SpinnerItem first = new SpinnerItem();
		first.key = "-1";
		first.value = "全部";
		first.zt = "1";
		first.size = 12;
		typeValues.add(first);
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = types[i].bgxid;
			item.value = types[i].bgxmc;
			item.zt = types[i].zt;
			item.size = 12;
			typeValues.add(item);
		}
		
		adapter = new SimpleSpinnerAdapter(this,R.layout.spinner_item,typeValues);
		this.spinner_my_reports_report_types.setAdapter(adapter);
		
		List<ExpandListItem> values = new ArrayList<ExpandListItem>();
		expandableadapter = new SimpleBaseExpandableListAdapter(this,values);
		
		
		
		
		this.my_reports_listView.addHeaderView(headerView);
		
		this.my_reports_listView.setAdapter(expandableadapter);
		//this.review_reports_listView.setOnItemClickListener(item_listener);
		this.my_reports_listView.setOnChildClickListener(onChildClickListener);
		this.spinner_my_reports_report_types.setOnItemSelectedListener(onItemSelectedListener);
		this.textview_my_reports_project.setOnClickListener(project_select_Listener);
	}
	
	
	private ExpandableListView.OnChildClickListener onChildClickListener = new ExpandableListView.OnChildClickListener(){

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,MyReportDetailsActivity.class);
			it.putExtra("bgid", ((Item)expandableadapter.getChild(groupPosition, childPosition)).key);
			startActivityForResult(it,start_from_my_report_to_my_report_details);
			return false;
		}
		
	};
	
	private boolean inProject = true;
	private Spinner.OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0.getAdapter();
			SpinnerItem item = adapter.getItem(arg2);
			if (item.zt.equals("0")){
				inProject = false;
				textview_my_reports_project.setTextColor(Color.GRAY);
			}else {
				inProject = true;
				textview_my_reports_project.setTextColor(Color.parseColor("#2867a0"));
			}
			//Toast.makeText(context, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
			textview_my_reports_project.setClickable(inProject);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(context, "wu", Toast.LENGTH_SHORT).show();
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0.getAdapter();
			SpinnerItem item = adapter.getItem(0);
			if (item.zt.equals("0")){
				inProject = false;
				textview_my_reports_project.setTextColor(Color.GRAY);
			}else{
				inProject = true;
				textview_my_reports_project.setTextColor(Color.parseColor("#2867a0"));
			}
			textview_my_reports_project.setClickable(inProject);
		}
		
	};
	
	
	private Search search;
	private OnClickListener project_select_Listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//search = new Search(context,v,onItemClickListener,app.getAllProjectInfos(),1);
			Intent it = new Intent(context, SelectProjectsActivity.class);
			it.putExtra("search", "1");
			startActivityForResult(it,start_from_my_report_to_select_project);
		}

	};
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//getActivity();
		if (requestCode == start_from_my_report_to_select_project) {
			this.isFirst = true;
			if (resultCode == Activity.RESULT_OK) {
				project.xmid = data.getStringExtra("xmid");
				this.textview_my_reports_project.setText(data.getStringExtra("xmjc"));
			}
			if (resultCode == Activity.RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}else if (requestCode == start_from_my_report_to_my_report_details) {
			this.isFirst = false;
			if (resultCode == Activity.RESULT_OK) {
				this.isFirst = true;
			}
			if (resultCode == Activity.RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	private OnItemClickListener onItemClickListener = new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			SimpleSearchAdapter mAdapter = (SimpleSearchAdapter)arg0.getAdapter();
			ProjectInfo projectInfo = mAdapter.getItem(position);
			project.xmid = projectInfo.getXmid();
			textview_my_reports_project.setText(projectInfo.getXmjc());
			search.dismiss();
		}	
	};
	
}
