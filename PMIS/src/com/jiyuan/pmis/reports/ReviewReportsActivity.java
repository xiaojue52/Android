package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.MySimpleArrayAdapter;
import com.jiyuan.pmis.adapter.SeparatedListAdapter;
import com.jiyuan.pmis.constant.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ReviewReportsActivity extends Activity {
	private ListView review_reports_listView;
	private Context context;
	private Spinner spinner_review_reports_bigger;
	private Spinner spinner_review_reports_smaller;
	private Spinner spinner_review_reports_status;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.activity_review_reports);
		this.context = this;
		this.review_reports_listView = (ListView) this
				.findViewById(R.id.review_reports_listView);
		this.spinner_review_reports_bigger = (Spinner) this
				.findViewById(R.id.spinner_review_reports_bigger);
		this.spinner_review_reports_smaller = (Spinner) this
				.findViewById(R.id.spinner_review_reports_smaller);
		this.spinner_review_reports_status = (Spinner) this
				.findViewById(R.id.spinner_review_reports_status);

		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				context, R.array.reports_status,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_reports_status.setAdapter(adapter1);
		this.spinner_review_reports_status.setSelection(Constant.WEIT_STATUS);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				context, R.array.working_times,
				android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_reports_bigger.setAdapter(adapter2);

		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
				context, R.array.working_times,
				android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_review_reports_smaller.setAdapter(adapter3);
		listReports();

	}

	OnItemClickListener item_listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			// Toast.makeText(context, String.valueOf(arg2),
			// Toast.LENGTH_SHORT).show();
			Intent it = new Intent(context, ReviewReportDetailsActivity.class);
			startActivity(it);
		}

	};

	public void search(View v) {
		
	}

	public void back(View v) {
		finish();
	}

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
	
	private void listReports(){
		String[] values = new String[] { "2014-2-10张三8小时", "2014-2-11李四5小时" };
		//String[] content = new String[] {"编写需求","画界面原型"};
		
		String[] sections = new String[] {"项目1","项目2"};

		// Create the ListView Adapter
		SeparatedListAdapter adapter = new SeparatedListAdapter(this,true,"编写需求");
		ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this,
				R.layout.list_item,R.id.firstLine, values);

		// Add Sections
		for (int i = 0; i < sections.length; i++) {
			adapter.addSection(sections[i], listadapter);
		}

		// Listen for Click events
		this.review_reports_listView.setAdapter(adapter);
		this.review_reports_listView.setOnItemClickListener(item_listener);
	}
}
