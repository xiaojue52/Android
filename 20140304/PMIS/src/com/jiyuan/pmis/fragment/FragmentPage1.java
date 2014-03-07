package com.jiyuan.pmis.fragment;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.TabHostActivity;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.constant.MLocation;
import com.jiyuan.pmis.project.SelectProjectsActivity;
import com.jiyuan.pmis.search.Search;
import com.jiyuan.pmis.search.SimpleSearchAdapter;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.RecentProjectInfo;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.SpinnerItem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentPage1 extends Fragment {
	private Context context;
	private TabHostActivity activity;
	private Spinner spinner_add_reports_reports_option,
			spinner_add_report_date;
	private MainApplication app;
	private TextView textview_add_report_project;
	private EditText edittext_add_report_content,
			edittext_add_report_working_time, edittext_add_report_position;
	private Button button_add_report_submit;

	private Report report;
	private boolean inProject = false;

	private Search search;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_1, null);
		this.context = this.getActivity();
		this.activity = (TabHostActivity) this.getActivity();
		report = new Report();
		app = (MainApplication) this.activity.getApplication();
		this.initData(v);
		return v;
	}

	public void selectDate(final TextView v) {
		Constant.selectDate(context, v);
	}

	private void initData(View v) {
		MLocation.getCNBylocation(this.context);
		String location = MLocation.cityName;
		report.zswz = location;
		this.spinner_add_report_date = (Spinner) v
				.findViewById(R.id.spinner_add_report_date);
		this.spinner_add_reports_reports_option = (Spinner) v
				.findViewById(R.id.spinner_add_reports_reports_option);
		this.textview_add_report_project = (TextView) v
				.findViewById(R.id.textview_add_page_project);
		this.edittext_add_report_content = (EditText) v
				.findViewById(R.id.edittext_add_report_content);
		this.edittext_add_report_position = (EditText) v
				.findViewById(R.id.edittext_add_report_position);
		this.edittext_add_report_working_time = (EditText) v
				.findViewById(R.id.edittext_add_report_working_time);
		this.button_add_report_submit = (Button) v
				.findViewById(R.id.button_add_report_submit);

		this.textview_add_report_project
				.setOnClickListener(project_select_Listener);

		this.edittext_add_report_content.setOnTouchListener(edittext_listener);

		ReportType[] types = app.getReportTypes();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = types[i].bgxid;
			item.value = types[i].bgxmc;
			item.zt = types[i].zt;
			values.add(item);
		}
		SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(this.context,
				R.layout.spinner_item, values);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_add_reports_reports_option.setAdapter(adapter);

		List<SpinnerItem> dates = new ArrayList<SpinnerItem>();
		SpinnerItem date1 = new SpinnerItem();
		date1.value = Constant.getCurrentDataString("yyyy-MM-dd");
		SpinnerItem date2 = new SpinnerItem();
		date2.value = Constant.getBeforeCurrentDataString("yyyy-MM-dd", 1);
		dates.add(date1);
		dates.add(date2);
		SimpleSpinnerAdapter dateAdapter = new SimpleSpinnerAdapter(
				this.context, R.layout.spinner_item, dates);
		this.spinner_add_report_date.setAdapter(dateAdapter);

		DatabaseHandler db = new DatabaseHandler(this.context);
		RecentProjectInfo info = db.getLastRecentProjectInfo(app.getUser().yhid);
		if (info != null) {
			report.xmid = info.getXmid();
			this.textview_add_report_project.setText(info.getXmjc());
		}

		this.button_add_report_submit.setOnClickListener(submit_listener);
		this.spinner_add_reports_reports_option
				.setOnItemSelectedListener(onItemSelectedListener);
		this.edittext_add_report_position.setText(location);
	}

	/**
	 * 提交
	 * 
	 * @param v
	 */
	public void done() {
		Float f = null;
		try {
			f = Float.valueOf(this.edittext_add_report_working_time.getText()
					.toString());

		} catch (Exception e) {
			Toast.makeText(this.context, "工作小时为小于24的数字！", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		if (f <= 0 || f > 24) {
			Toast.makeText(this.context, "工作小时为小于24的数字！", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		if (!inProject)
			report.xmid = "-1";
		else {
			if(report.xmid ==null || report.xmid.equals("-1")){
				Toast.makeText(this.context, "请选择项目！", Toast.LENGTH_SHORT).show();
				return;
			}
		}
			
		report.bgxid = ((SpinnerItem) this.spinner_add_reports_reports_option
				.getSelectedItem()).key;
		report.gznr = this.edittext_add_report_content.getText().toString();
		report.gzxs = this.edittext_add_report_working_time.getText()
				.toString();
		report.gzdd = this.edittext_add_report_position.getText().toString();
		report.gzrq = ((SpinnerItem) this.spinner_add_report_date
				.getSelectedItem()).value;
		report.zt = "-1";

		Gson gson = new Gson();

		final String METHOD_NAME = "saveReport";
		Soap soap = new Soap(Constant.report_namespace, METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("yhid");
		arg0.setValue(app.getUser().yhid);
		arg0.setType(String.class);

		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("reportStr");
		arg1.setValue(gson.toJson(report));
		arg1.setType(String.class);

		Log.v("pmis", gson.toJson(report));
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.report_url, Constant.report_url
					+ "/" + METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(this.context, "提交失败！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (ret.equals(Constant.SUCCESS)) {
			Toast.makeText(this.context, "提交成功！", Toast.LENGTH_SHORT).show();
			this.edittext_add_report_content.setText("");
			this.edittext_add_report_working_time.setText("");
		} else {
			Toast.makeText(this.context, "提交失败！", Toast.LENGTH_SHORT).show();
			return;
		}

		if (!report.xmid.equals("-1")) {
			DatabaseHandler db = new DatabaseHandler(this.context);

			
			
			RecentProjectInfo info = db.getRecentProjectInfoByXmid(report.xmid,app.getUser().yhid);
			
			if (info==null) {
				info = new RecentProjectInfo();
				info.setIdentifier("1");
				info.setXmid(report.xmid);
				info.setXmjc(this.textview_add_report_project.getText().toString());
				info.setYhid(app.getUser().yhid);
				info.setSj(Constant.getCurrentDataString("yyyy-MM-dd HH:mm:ss"));
				db.addRecentProjectInfo(info);
			} else{
				info.setYhid(app.getUser().yhid);
				info.setIdentifier("1");
				info.setXmid(report.xmid);
				info.setXmjc(this.textview_add_report_project.getText().toString());
				info.setSj(Constant.getCurrentDataString("yyyy-MM-dd HH:mm:ss"));
				db.updateRecentProjectInfo(info);
			}
		}
		this.activity.setCount();
	}

	private Spinner.OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0
					.getAdapter();
			SpinnerItem item = adapter.getItem(arg2);
			if (arg0.getChildAt(0) == null) {
				inProject = false;
				textview_add_report_project.setTextColor(Color.GRAY);
				textview_add_report_project.setClickable(inProject);
				return;
			}
			((TextView) arg0.getChildAt(0).findViewById(
					R.id.spinner_item_textview)).setTextColor(Color
					.parseColor("#2867a0"));
			if (item.zt.equals("0")) {
				inProject = false;
				textview_add_report_project.setTextColor(Color.GRAY);
			} else {
				inProject = true;
				textview_add_report_project.setTextColor(Color
						.parseColor("#2867a0"));
			}
			textview_add_report_project.setClickable(inProject);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			// Toast.makeText(context, "wu", Toast.LENGTH_SHORT).show();
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0
					.getAdapter();
			SpinnerItem item = adapter.getItem(0);
			((TextView) arg0.getChildAt(0).findViewById(
					R.id.spinner_item_textview)).setTextColor(Color
					.parseColor("#2867a0"));
			if (item.zt.equals("0")) {
				inProject = false;
				textview_add_report_project.setTextColor(Color.GRAY);

			} else {
				inProject = true;
				textview_add_report_project.setTextColor(Color.BLACK);
			}
			textview_add_report_project.setClickable(inProject);
		}

	};

	private OnClickListener submit_listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			done();
		}

	};

	private OnClickListener project_select_Listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// search = new
			// Search(context,v,onItemClickListener,app.getAllProjectInfos(),0);
			Intent it = new Intent(context, SelectProjectsActivity.class);
			it.putExtra("search", "0");
			startActivityForResult(it, Constant.REQUEST_CODE);
		}

	};

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//getActivity();
		if (requestCode == Constant.REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				report.xmid = data.getStringExtra("xmid");
				this.textview_add_report_project.setText(data.getStringExtra("xmjc"));
			}
			if (resultCode == Activity.RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}

	private OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			SimpleSearchAdapter mAdapter = (SimpleSearchAdapter) arg0
					.getAdapter();
			ProjectInfo projectInfo = mAdapter.getItem(position);
			report.xmid = projectInfo.getXmid();
			textview_add_report_project.setText(projectInfo.getXmjc());
			search.dismiss();
		}
	};

	private OnTouchListener edittext_listener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			v.getParent().requestDisallowInterceptTouchEvent(true);
			return false;
		}

	};

}
