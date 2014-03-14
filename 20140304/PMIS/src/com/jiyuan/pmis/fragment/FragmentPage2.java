package com.jiyuan.pmis.fragment;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.TabHostActivity;
import com.jiyuan.pmis.adapter.SimpleBaseExpandableListAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.reports.MyReportDetailsActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.ExpandListItem;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class FragmentPage2 extends Fragment{
	private ExpandableListView my_reports_listView;
	private Button button_my_reports_delete,button_my_reports_more;
	private Context context;
	private Project project;
	private MainApplication app;
	private SimpleBaseExpandableListAdapter expandableadapter;
	private TabHostActivity activity;
	private int day = 7;
	
	private boolean isFirst = false;

	private View v = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		if (v!=null){
			((ViewGroup)v.getParent()).removeView(v);
			return v;
		}
		v = inflater.inflate(R.layout.fragment_2, null);	
		this.context = this.getActivity();
		this.activity = (TabHostActivity) this.getActivity();
		this.my_reports_listView = (ExpandableListView)v.findViewById(R.id.my_reports_listView);
		this.button_my_reports_delete = (Button)v.findViewById(R.id.button_my_reports_delete);
		this.button_my_reports_more = (Button)v.findViewById(R.id.button_my_reports_more);
		
		
		this.button_my_reports_delete.setOnClickListener(onClickListener);
		this.my_reports_listView.setGroupIndicator(null);
		this.button_my_reports_more.setOnClickListener(moreOnClickListener);
		isFirst = true;
		this.initData(v);
		return v;		
	}	
	@Override
	public void onResume(){
		super.onResume();
		if(!isFirst){
			this.search(day);
		}
		this.isFirst = false;
	}
	public void search(int day){
		ReportSearchField r = this.getReportSearchField(day);
		List<ExpandListItem> values = listReports(r);
		this.expandableadapter.setValues(values);
		this.expandableadapter.notifyDataSetChanged();
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == Constant.REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				this.isFirst = true;
			}
			if (resultCode == Activity.RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
	private ReportSearchField getReportSearchField(int day){
		ReportSearchField r = new ReportSearchField();
		r.xmid = project.xmid;
		r.kssj = Constant.getBeforeCurrentDataString("yyyy-MM-dd",day);
		r.jssj = Constant.getCurrentDataString("yyyy-MM-dd");
		r.xzwtg = "1";
		r.xzdsh = "1";
		r.xzysh = "1";
		r.type = "0";
		r.yhid = app.getUser().yhid;
		r.bgxid = "-1";
		return r;
	}	
	
	public void delete(){
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
						Toast.makeText(this.context, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked){
			Toast.makeText(this.context, "请选择报工！", Toast.LENGTH_SHORT).show();
		}
		else
			this.search(day);
		this.activity.setCount();
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
			if (sorts.get(i).title.equals("未通过")){
				expandListItem.bgColor = Color.parseColor("#ff8974");
				//expandListItem.bgImageId = R.drawable.wtg;
			}else if (sorts.get(i).title.equals("待审核")){
				expandListItem.bgColor = Color.parseColor("#009bd9");
				//expandListItem.bgImageId = R.drawable.dsh;
			}else{
				expandListItem.bgColor = Color.parseColor("#8ec156");
				//expandListItem.bgImageId = R.drawable.ytg;
			}
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				if (!reports.get(j).xmjc.equals("--"))
					item.firstLineText = reports.get(j).gzrq.substring(5)+"   "+reports.get(j).gzxs+"小时"+"   "+reports.get(j).xmjc;
				else
					item.firstLineText = reports.get(j).gzrq.substring(5)+"   "+reports.get(j).gzxs+"小时"+"   "+app.getReportType(reports.get(j).bgxid);
				item.secondLineText = reports.get(j).gznr;

				if (reports.get(j).zt.equals("0"))
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
		ReportSort sort1 = new ReportSort();
		sort1.title = "未通过";
		ReportSort sort2 = new ReportSort();
		sort2.title = "待审核";
		ReportSort sort3 = new ReportSort();
		sort3.title = "已审核";
		while(listReports.size()>0){
			List<Report> list = new ArrayList<Report>();
			Report b = listReports.get(0);
			list.add(b);
			
			listReports.remove(0);
			int i = 0;
			while(listReports.size()!=i){
				if (b.zt.equals((listReports).get(i).zt)){
					list.add((listReports).get(i));
					listReports.remove(i);
					i--;
				}
				i++;
			}
			if (b.zt.equals("-1")){
				sort1.list = list;
				sort1.count = list.size();
			}else if(b.zt.equals("1")){
				sort3.list = list;
				sort3.count = list.size();
			}else{
				sort2.list = list;
				sort2.count = list.size();
			}
			
		}
		sorts.add(sort1);
		sorts.add(sort2);
		sorts.add(sort3);
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
	private void initData(View v){
		app = (MainApplication) this.activity.getApplication();
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		
		List<ExpandListItem> values = this.listReports(this.getReportSearchField(day));
		expandableadapter = new SimpleBaseExpandableListAdapter(this.context,values);
		this.my_reports_listView.setAdapter(expandableadapter);
		this.my_reports_listView.setOnChildClickListener(onChildClickListener);

	}
	
	private ExpandableListView.OnChildClickListener onChildClickListener = new ExpandableListView.OnChildClickListener(){

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,MyReportDetailsActivity.class);
			it.putExtra("bgid", ((Item)expandableadapter.getChild(groupPosition, childPosition)).key);
			startActivityForResult(it,Constant.REQUEST_CODE);
			return false;
		}
		
	};
	
	private Button.OnClickListener onClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			delete();
		}
		
	};
	
	private Button.OnClickListener moreOnClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			day = day+7;
			search(day);
		}
		
	};
}