package com.jiyuan.pmis.fragment;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleBaseExpandableListAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.exception.PmisException;
import com.jiyuan.pmis.reports.ReviewReportDetailsActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.ExpandListItem;
import com.jiyuan.pmis.structure.Item;
import com.jiyuan.pmis.structure.Project;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportSearchField;
import com.jiyuan.pmis.structure.ReportSort;
import com.jiyuan.pmis.structure.ReportType;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class FragmentPage3 extends Fragment implements OnClickListener{
	private ExpandableListView review_reports_listView;
	//private Button button_review_reports_select_all,button_review_reports_pass,button_review_reports_refuse;
	private Context context;
	private Activity activity;
	private MainApplication app;
	private Project project;
	private boolean selectedAll = false;
	private SimpleBaseExpandableListAdapter expandableadapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		View v = inflater.inflate(R.layout.fragment_3, null);
		this.context = this.getActivity();
		this.activity = this.getActivity();
		this.app = (MainApplication) this.activity.getApplication();
		this.review_reports_listView = (ExpandableListView) v
				.findViewById(R.id.review_reports_listView);
		this.review_reports_listView.setGroupIndicator(null);
		this.initData(v);
		return v;		
	}
	

	public void search() {
		ReportSearchField r = this.getReportSearchField();
		List<ExpandListItem> values = listReports(r);
		this.expandableadapter.setValues(values);
		this.expandableadapter.notifyDataSetChanged();
	}

	public void pass(View v){
		boolean hadChecked = false;
		//SeparatedListAdapter adapter = (SeparatedListAdapter) this.review_reports_listView.getAdapter();
		int count = expandableadapter.getGroupCount();
		for(int i=0;i<count;i++){
			List<Item> items = expandableadapter.getGroup(i).items;
			for(int j=0;j<items.size();j++){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = items.get(j);
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
						Toast.makeText(this.context, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked)
			Toast.makeText(this.context, "请选择报工！", Toast.LENGTH_SHORT).show();
		else
			this.search();
	}
	
	public void refuse(View v){
		boolean hadChecked = false;
		int count = expandableadapter.getGroupCount();
		for(int i=0;i<count;i++){
			List<Item> items = expandableadapter.getGroup(i).items;
			for(int j=0;j<items.size();j++){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = items.get(j);
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
						Toast.makeText(this.context, e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
		if (!hadChecked)
			Toast.makeText(this.context, "请选择报工！", Toast.LENGTH_SHORT).show();
		else
			this.search();
	}

	private void selectAll(View v){
		
		int count = expandableadapter.getGroupCount();
		for(int i=0;i<count;i++){
			List<Item> items = expandableadapter.getGroup(i).items;
			for(int j=0;j<items.size();j++){
				//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
				Item item = items.get(j);
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
		expandableadapter.notifyDataSetChanged();
		selectedAll = !selectedAll;
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
			for(int j=0;j<reports.size();j++){
				Item item = new Item();
				item.key = reports.get(j).bgid;
				item.firstLineText = reports.get(j).gzrq+"  "+reports.get(j).bgr+"  "+reports.get(j).gzxs+"小时";
				item.secondLineText = reports.get(j).gznr;
				item.showCheckbox = true;
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
			if (b.xmid.equals("-1")){
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
				}
			}else
				sorts.add(sort);
		}
		Log.e("pmis.....",new Gson().toJson(sorts));
		return sorts;
	}
	
	private void initData(View v){
		project = new Project();
		project.xmid = "-1";
		project.xmjc = "全部";
		
		List<ExpandListItem> values = this.listReports(this.getReportSearchField());
		expandableadapter = new SimpleBaseExpandableListAdapter(this.context,values);
		this.review_reports_listView.setAdapter(expandableadapter);
		//this.review_reports_listView.setOnItemClickListener(item_listener);
		this.review_reports_listView.setOnGroupCollapseListener(onGroupCollapseListener);
		this.review_reports_listView.setOnGroupExpandListener(onGroupExpandListener);
		this.review_reports_listView.setOnChildClickListener(onChildClickListener);
		//expandableadapter.notifyDataSetChanged();
	}
	private ReportSearchField getReportSearchField(){
		ReportSearchField r = new ReportSearchField();
		r.xmid = project.xmid;
		r.xzdy = "1";
		r.xzeq = "1";
		r.xzxy = "1";
		r.kssj = Constant.getBeforeCurrentDataString("yyyy-MM-dd", 2);
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
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId()==R.id.button_review_reports_select_all){
			this.selectAll(v);
			
		}else if(v.getId()==R.id.button_review_reports_pass){
			this.pass(v);
			
		}else if(v.getId()==R.id.button_review_reports_refuse){
			this.refuse(v);
		}
	}
}