package com.jiyuan.pmis.reports;

import java.util.Calendar;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.constant.Constant;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddReportsActivity extends Activity {
	private Context context;
	private Spinner spinner_add_reports_reports_option;
	static final int DATE_PICKER_ID = 1111;
	private TextView date;
	private int year;
	private int month;
	private int day;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.activity_add_reports);
		this.context = this;
		this.spinner_add_reports_reports_option = (Spinner)this.findViewById(R.id.spinner_add_reports_reports_option);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.reports_option, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_add_reports_reports_option.setAdapter(adapter);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		/*
		 * this.spinner_add_page_project = (Spinner) this
		 * .findViewById(R.id.spinner_add_page_project);
		 * 
		 * String[] v1 = { "--", "项目1", "项目2", "项目3" }; ArrayAdapter<String>
		 * adapter1 = new ArrayAdapter<String>(this,
		 * android.R.layout.simple_spinner_item, v1);
		 * adapter1.setDropDownViewResource
		 * (android.R.layout.simple_spinner_dropdown_item);
		 * spinner_add_page_project.setAdapter(adapter1);
		 * spinner_add_page_project.setVisibility(View.VISIBLE);
		 */

	}

	public void cancel(View v) {
		this.finish();
	}

	public void done(View v) {
		this.finish();
	}

	public void selectDate(View v) {
		// Toast.makeText(context, "this is a test", Toast.LENGTH_SHORT).show();
		this.date = (TextView) v;
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
			date.setText(new StringBuilder().append(month + 1).append("-")
					.append(day).append("-").append(year).append(" "));

		}
	};

	public void selectProjects(View v) {
		// Toast.makeText(this, "this is a test", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(context, SelectProjectsActivity.class);
		startActivityForResult(it, Constant.ADD_PROJECTS_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				String result = data.getStringExtra("ret");
				Toast.makeText(context, result, Toast.LENGTH_LONG).show();
			}
			if (resultCode == RESULT_CANCELED) {
				// Write your code if there's no result
			}
		}
	}
}
