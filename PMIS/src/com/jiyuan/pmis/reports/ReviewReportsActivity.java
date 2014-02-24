package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleAdapter;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class ReviewReportsActivity extends Activity {
	private ListView review_reports_listView;
	private Context context;
	private MainApplication app;
	private Project project;
	private Spinner spinner_review_reports_projects;
	private CheckBox checkbox_review_reports_bigger,checkbox_review_reports_smaller,checkbox_review_reports_equal;
	private RadioButton radiobutton_review_reports_one_day,radiobutton_review_reports_two_day;
	private boolean selectedAll = false;

	private boolean firstCreate = true;
	
	private List<SpinnerItem> spinnerItems;
	private SimpleSpinnerAdapter adapter;
	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.activity_review_reports);
		this.context = this;
		this.app = (MainApplication) this.getApplication();
		this.review_reports_listView = (ListView) this
				.findViewById(R.id.review_reports_listView);

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
	OnItemClickListener item_listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			Intent it = new Intent(context,ReviewReportDetailsActivity.class);
			it.putExtra("bgid", item.key);
			startActivity(it);
		}

	};

	public void search(View v) {
		ReportSearchField r = this.getReportSearchField();
		listReports(r);
	}

	public void back(View v) {
		finish();
	}
	
	public void pass(View v){
		boolean hadChecked = false;
		SeparatedListAdapter adapter = (SeparatedListAdapter) this.review_reports_listView.getAdapter();
		for(int i=0;i<adapter.getCount();i++){
			Class<? extends Object> c = adapter.getItem(i).getClass(); 
			Class<Item> cl = Item.class;
			if(c.isAssignableFrom(cl)){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = (Item)adapter.getItem(i);
				if(item.isChecked){
					hadChecked = true;
					try {
						Report report = this.showReport(item.key);
						report.shxx = "无";
						report.zt = "1";
						this.updateReport(app.getUser().yhid, report,item.firstLineText);
						//this.search(v);
					} catch (PmisException e) {
						// TODO Auto-generated catch block
						Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked)
			Toast.makeText(this, "请选择报工！", Toast.LENGTH_SHORT).show();
		else
			this.search(v);
	}
	
	public void refuse(View v){
		boolean hadChecked = false;
		SeparatedListAdapter adapter = (SeparatedListAdapter) this.review_reports_listView.getAdapter();
		for(int i=0;i<adapter.getCount();i++){
			Class<? extends Object> c = adapter.getItem(i).getClass(); 
			Class<Item> cl = Item.class;
			if(c.isAssignableFrom(cl)){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = (Item)adapter.getItem(i);
				if(item.isChecked){
					hadChecked = true;
					try {
						Report report = this.showReport(item.key);
						report.shxx = "无";
						report.zt = "-1";
						this.updateReport(app.getUser().yhid, report,item.firstLineText);
						//this.search(v);
					} catch (PmisException e) {
						// TODO Auto-generated catch block
						Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked)
			Toast.makeText(this, "请选择报工！", Toast.LENGTH_SHORT).show();
		else
			this.search(v);
	}

	public void selectAll(View v){
		SeparatedListAdapter adapter = (SeparatedListAdapter) this.review_reports_listView.getAdapter();
		for(int i=0;i<adapter.getCount();i++){
			Class<? extends Object> c = adapter.getItem(i).getClass(); 
			Class<Item> cl = Item.class;
			if(c.isAssignableFrom(cl)){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = (Item)adapter.getItem(i);
				if(selectedAll){
					item.isChecked = false;
					((Button)v).setText("全选");
				}
				else{
					item.isChecked = true;
					((Button)v).setText("取消全选");
				}
			}
		}
		adapter.notifyDataSetChanged();
		selectedAll = !selectedAll;
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
							this.spinner_review_reports_projects.setSelection(i);
				}
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
			//((SeparatedListAdapter)this.review_reports_listView.getAdapter()).clear();
			//((SeparatedListAdapter)this.review_reports_listView.getAdapter()).notifyDataSetChanged();
			List<Item> items = new ArrayList<Item>();
			SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);
			adapter.addSection(" ", listAdapter);
			this.review_reports_listView.setAdapter(adapter);
			this.review_reports_listView.setOnItemClickListener(item_listener);
			return;
		}
		
		for (int i=0;i<sorts.length;i++){
			List<Report> reports = sorts[i].list;
			List<Item> items = new ArrayList<Item>();
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				item.firstLineText = reports.get(j).gzrq+"  "+reports.get(j).bgr+"  "+reports.get(j).gzxs+"小时";
				item.secondLineText = reports.get(j).gznr;
				item.showCheckbox = true;
				items.add(item);
			}
			SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);
			adapter.addSection(sorts[i].xmjc, listAdapter);
		}

		this.review_reports_listView.setAdapter(adapter);
		this.review_reports_listView.setOnItemClickListener(item_listener);
	}
	
	private ReportSort[] getReports(ReportSearchField r) throws PmisException{
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
		try {
			return new Gson().fromJson(ret, ReportSort[].class);	
		} catch (Exception e){
			throw new PmisException("当前没有报工！");
		}
	}
	
	private void initData(){
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		
		this.spinner_review_reports_projects = (Spinner)this.findViewById(R.id.spinner_review_reports_project);
		this.checkbox_review_reports_bigger = (CheckBox)this.findViewById(R.id.checkbox_review_reports_bigger);
		this.checkbox_review_reports_smaller = (CheckBox)this.findViewById(R.id.checkbox_review_reports_smaller);
		this.checkbox_review_reports_equal = (CheckBox)this.findViewById(R.id.checkbox_review_reports_equal);
		this.radiobutton_review_reports_one_day = (RadioButton)this.findViewById(R.id.radiobutton_review_reports_one_day);
		this.radiobutton_review_reports_two_day = (RadioButton)this.findViewById(R.id.radiobutton_review_reports_two_day);
		
		//this.textview_review_reports_projects.setText(project.xmjc);
		this.checkbox_review_reports_bigger.setChecked(true);
		this.checkbox_review_reports_equal.setChecked(true);
		this.checkbox_review_reports_smaller.setChecked(true);
		
		this.radiobutton_review_reports_two_day.setChecked(true);
		
		spinnerItems = this.getSpinnerItems();
		
		adapter = new SimpleSpinnerAdapter(this,R.layout.spinner_item,spinnerItems);
		this.spinner_review_reports_projects.setAdapter(adapter);
		this.spinner_review_reports_projects.setOnItemSelectedListener(listener);
		ReportSearchField r = this.getReportSearchField();
		
		listReports(r);
	}
	private ReportSearchField getReportSearchField(){
		ReportSearchField r = new ReportSearchField();
		r.xmid = project.xmid;
		if (this.checkbox_review_reports_bigger.isChecked()){
			r.xzdy = "1";
		}else
			r.xzdy = "0";
		if (this.checkbox_review_reports_equal.isChecked()){
			r.xzeq = "1";
		}else
			r.xzeq = "0";
		if (this.checkbox_review_reports_smaller.isChecked()){
			r.xzxy = "1";
		}else
			r.xzxy = "0";
		if (this.radiobutton_review_reports_one_day.isChecked()){
			Calendar c = Calendar.getInstance();
			int day = c.get(Calendar.DAY_OF_MONTH);	
			c.set(Calendar.DAY_OF_MONTH, day-1);
			//day = c.get(Calendar.DAY_OF_MONTH);
			r.kssj = Constant.toDateString(c.getTime(), "yyyy-MM-dd");
		}else{
			Calendar c = Calendar.getInstance();
			int day = c.get(Calendar.DAY_OF_MONTH);	
			c.set(Calendar.DAY_OF_MONTH, day-2);
			//day = c.get(Calendar.DAY_OF_MONTH);
			r.kssj = Constant.toDateString(c.getTime(), "yyyy-MM-dd");
		}
		
		r.jssj = Constant.getCurrentDataString("yyyy-MM-dd");
		r.type = "1";
		
		r.yhid = app.getUser().yhid;
		return r;
	}
	
	private void updateReport(String yhid,Report report,String firstLine) throws PmisException{
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
			throw new PmisException("更新"+firstLine+"失败！");
		}
		if(ret.equals("1")){
			//Toast.makeText(this, "更新"+firstLine+"成功！", Toast.LENGTH_SHORT).show();
		}else
			throw new PmisException("更新"+firstLine+"失败！");
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
}
