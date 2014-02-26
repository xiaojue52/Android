package com.jiyuan.pmis.fragment;

import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.calendar.DateLayout;
import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.constant.MLocation;
import com.jiyuan.pmis.reports.SelectProjectsActivity;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentPage1 extends Fragment {
	private Context context;
	private Activity activity;
	private Spinner spinner_add_reports_reports_option;
	private MainApplication app;
	static final int DATE_PICKER_ID = 1111;
	private TextView textview_add_report_date, textview_add_report_project;
	private EditText edittext_add_report_content,
			edittext_add_report_working_time, edittext_add_report_position;
	private Button button_add_report_submit;

	private Report report;
	private boolean inProject = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_1, null);
		this.context = this.getActivity();
		this.activity = this.getActivity();
		report = new Report();
		app = (MainApplication) this.activity.getApplication();
		this.initData(v);
		return v;
	}

	public void selectDate(TextView v) {
		new DateLayout(this.context,this.getView(),v);
	}

	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.REQUEST_CODE);
	}

	private void initData(View v) {
		MLocation.getCNBylocation(this.context);
		String location = MLocation.cityName;
		this.textview_add_report_date = (TextView) v.findViewById(R.id.textview_add_report_date);
		this.spinner_add_reports_reports_option = (Spinner) v
				.findViewById(R.id.spinner_add_reports_reports_option);
		this.textview_add_report_project = (TextView) v
				.findViewById(R.id.textView_add_page_project);
		this.edittext_add_report_content = (EditText) v
				.findViewById(R.id.edittext_add_report_content);
		this.edittext_add_report_position = (EditText) v
				.findViewById(R.id.edittext_add_report_position);
		this.edittext_add_report_working_time = (EditText) v
				.findViewById(R.id.edittext_add_report_working_time);
		this.button_add_report_submit = (Button)v.findViewById(R.id.button_add_report_submit);
		

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

		textview_add_report_date.setText(Constant.getCurrentDataString("yyyy-MM-dd"));

		DatabaseHandler db = new DatabaseHandler(this.context);
		ProjectInfo info = db.getLastProjectInfo();
		if (info != null) {
			report.xmid = info.getXmid();
			this.textview_add_report_project.setText(info.getXmjc());
		}
		
		
		this.textview_add_report_date.setOnClickListener(selectDate_listener);
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
			Toast.makeText(this.context, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (f <= 0 || f > 24) {
			Toast.makeText(this.context, "工作小时为小于24的数字！", Toast.LENGTH_SHORT).show();
			return;
		}

		if (!inProject)
			report.xmid = "-1";
		report.bgxid = ((SpinnerItem) this.spinner_add_reports_reports_option
				.getSelectedItem()).key;
		report.gznr = this.edittext_add_report_content.getText().toString();
		report.gzxs = this.edittext_add_report_working_time.getText()
				.toString();
		report.gzdd = this.edittext_add_report_position.getText().toString();
		report.gzrq = this.textview_add_report_date.getText().toString();
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
		} else {
			Toast.makeText(this.context, "提交失败！", Toast.LENGTH_SHORT).show();
			return;
		}
		this.activity.finish();

	}

	private Spinner.OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0
					.getAdapter();
			SpinnerItem item = adapter.getItem(arg2);
			if (item.zt.equals("0")) {
				inProject = false;
				textview_add_report_project.setTextColor(Color.GRAY);
			} else {
				inProject = true;
				textview_add_report_project.setTextColor(Color.BLACK);
			}
			textview_add_report_project.setClickable(inProject);
			// Toast.makeText(context, String.valueOf(arg2),
			// Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			// Toast.makeText(context, "wu", Toast.LENGTH_SHORT).show();
			SimpleSpinnerAdapter adapter = (SimpleSpinnerAdapter) arg0
					.getAdapter();
			SpinnerItem item = adapter.getItem(0);
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
	
	private OnClickListener selectDate_listener = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			selectDate((TextView)arg0);
		}
		
	};
	private OnClickListener submit_listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			done();
		}
		
	};
}
