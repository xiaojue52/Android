package com.jiyuan.pmis.reports;

import java.util.Calendar;

import com.jiyuan.pmis.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddReportsActivity extends Activity {
	private Context context;
	private Spinner spinner_add_page_project;
	static final int DATE_PICKER_ID = 1111;
	private EditText date;
	private int year;
	private int month;
	private int day;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.activity_add_reports);
		this.context = this;
		
		final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);
		
		
		this.spinner_add_page_project = (Spinner) this
				.findViewById(R.id.spinner_add_page_project);

		String[] v1 = { "--", "项目1", "项目2", "项目3" };
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, v1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_add_page_project.setAdapter(adapter1);
		spinner_add_page_project.setVisibility(View.VISIBLE);

	}

	public void cancel(View v) {
		this.finish();
	}

	public void done(View v) {
		this.finish();
	}

	public void selectDate(View v) {
		// Toast.makeText(context, "this is a test", Toast.LENGTH_SHORT).show();
		this.date = (EditText) v;
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
}
