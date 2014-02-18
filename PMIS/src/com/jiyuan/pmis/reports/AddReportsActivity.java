package com.jiyuan.pmis.reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;

import com.google.gson.Gson;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleSpinnerAdapter;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Report;
import com.jiyuan.pmis.structure.ReportType;
import com.jiyuan.pmis.structure.SpinnerItem;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddReportsActivity extends Activity {
	private Context context;
	private Spinner spinner_add_reports_reports_option;
	private MainApplication app;
	static final int DATE_PICKER_ID = 1111;
	private TextView date,textview_add_report_project;
	private EditText edittext_add_report_content,edittext_add_report_working_time,edittext_add_report_position;
	private int year;
	private int month;
	private int day;
	private Report report;
	
	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.activity_add_reports);
		this.context = this;
		report = new Report();
		app = (MainApplication) this.getApplication();
		this.initData();
	}

	public void cancel(View v) {
		this.finish();
	}

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
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
			// Show selected date
			date.setText(new StringBuilder().append(year).append("-")
					.append(month + 1).append("-").append(day).append(" "));
		}
	};

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
				this.textview_add_report_project.setText(data.getStringExtra("xmjc"));
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}

	private void initData() {
		date = (TextView) this.findViewById(R.id.textview_add_report_date);
		this.spinner_add_reports_reports_option = (Spinner) this
				.findViewById(R.id.spinner_add_reports_reports_option);
		this.textview_add_report_project = (TextView)this.findViewById(R.id.textView_add_page_project);
		this.edittext_add_report_content = (EditText)this.findViewById(R.id.edittext_add_report_content);
		this.edittext_add_report_position = (EditText)this.findViewById(R.id.edittext_add_report_position);
		this.edittext_add_report_working_time = (EditText)this.findViewById(R.id.edittext_add_report_working_time);
		
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
		this.spinner_add_reports_reports_option.setAdapter(adapter);

		date.setText(Constant.getCurrentDataString(0));
	}
	
	/**
	 * 提交
	 * @param v
	 */
	public void done(View v) {
		report.bglx = ((SpinnerItem)this.spinner_add_reports_reports_option.getSelectedItem()).key;
		report.gznr = this.edittext_add_report_content.getText().toString();
		report.gzxs = this.edittext_add_report_working_time.getText().toString();
		report.gzdd = this.edittext_add_report_position.getText().toString();
		report.gzrq = this.date.getText().toString();
		Gson gson = new Gson();
		
		final Calendar c = Calendar.getInstance();
		int year0 = c.get(Calendar.YEAR);
		int month0 = c.get(Calendar.MONTH);
		int day0 = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int mi = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);

		report.bgsj = new StringBuilder().append(year0).append("-")
				.append(month0 + 1).append("-").append(day0).append(" ").append(hour).append(":").append(mi).append(":").append(s).toString();
		
		final String METHOD_NAME = "saveReport";
		Soap soap = new Soap(Constant.NAMESPACE,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("yhid");
		arg0.setValue(app.getUser().yhid);
		arg0.setType(String.class);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("reportStr");
		arg1.setValue(gson.toJson(report));
		arg1.setType(String.class);

		Log.v("pmis",gson.toJson(report));
		args.add(arg0);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.URL, Constant.URL+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "提交失败！", Toast.LENGTH_SHORT).show();
			return;
		}
		if (ret.equals(Constant.SUCCESS)){
			Toast.makeText(this, "提交成功！", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "提交失败！", Toast.LENGTH_SHORT).show();
			return;
		}
		this.finish();
	}

}
