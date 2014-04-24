package com.dataclient.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adapter.SimpleSpinnerAdapter;
import com.constant.Constant;
import com.dataclient.MainApplication;
import com.example.dataclient.R;
import com.google.gson.Gson;
import com.stracture.Course;
import com.stracture.SpinnerItem;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentPage2 extends Fragment {
	private Context context;
	private MainApplication app;
	// private SimpleSpinnerAdapter spinnerApdapter;
	private Button button_collect_submit;
	private Spinner spinner_collect_course;
	private TextView textview_collect_week, textview_collect_lesson,
			 textview_collect_teacher;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.collect, null);
		this.context = this.getActivity();
		this.app = (MainApplication) this.getActivity().getApplication();
		this.spinner_collect_course = (Spinner) v
				.findViewById(R.id.spinner_collect_course);
		this.spinner_collect_course.setOnItemSelectedListener(item_listener);
		this.textview_collect_week = (TextView) v
				.findViewById(R.id.textview_collect_week);
		this.textview_collect_lesson = (TextView) v
				.findViewById(R.id.textview_collect_lesson);
		this.textview_collect_teacher = (TextView) v
				.findViewById(R.id.textview_collect_teacher);
		this.button_collect_submit = (Button) v
				.findViewById(R.id.button_collect_submit);
		this.button_collect_submit.setOnClickListener(listener);
		this.initData();
		return v;
	}

	private void initData() {
		pd = ProgressDialog.show(context, "初始化数据", "请稍后。。。。。。");
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String localhost = Constant.addr + ":" + Constant.port;
				// spandTimeMethod();// 耗时的方法
				String url = "http://" + localhost
						+ "/DataServer/listCourses.action";
				String ret = Constant.getData(url, null);
				Message mes = Message.obtain();
				Bundle b = new Bundle();
				b.putInt("identify", 1);
				b.putString("data", ret);
				mes.setData(b);
				handler.sendMessage(mes);
			}

		}).start();
	}

	private Course[] list;
	private ProgressDialog pd;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message mes) {
			if (mes.getData().getInt("identify") == 1) {
				String ret = mes.getData().getString("data");
				list = new Gson().fromJson(ret, Course[].class);
				if (list.length != 0) {
					List<SpinnerItem> items = new ArrayList<SpinnerItem>();
					for (int i = 0; i < list.length; i++) {
						SpinnerItem item = new SpinnerItem();
						item.key = String.valueOf(list[i].getId());
						item.value = list[i].getContent();
						items.add(item);
					}
					SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(
							context, R.layout.spinner_item, items);
					spinner_collect_course.setAdapter(adapter);
					setView(list[0]);
				}
			} else if (mes.getData().getInt("identify") == 2) {
				if(mes.getData().getString("data")!=null){
					Toast.makeText(context, "提交成功！", Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(context, "提交失败！", Toast.LENGTH_LONG).show();
			}
			pd.dismiss();
		}
	};
	
	private void setView(Course course){
		switch (Integer.valueOf(course.getWeek())) {
		case 1:
			textview_collect_week.setText("星期一");
			break;
		case 2:
			textview_collect_week.setText("星期二");
			break;
		case 3:
			textview_collect_week.setText("星期三");
			break;
		case 4:
			textview_collect_week.setText("星期四");
			break;
		case 5:
			textview_collect_week.setText("星期五");
			break;

		}
		switch (Integer.valueOf(course.getLesson())) {
		case 1:
			textview_collect_lesson.setText("第一节课");
			break;
		case 2:
			textview_collect_lesson.setText("第二节课");
			break;
		case 3:
			textview_collect_lesson.setText("第三节课");
			break;
		case 4:
			textview_collect_lesson.setText("第四节课");
			break;
		case 5:
			textview_collect_lesson.setText("第五节课");
			break;
		case 6:
			textview_collect_lesson.setText("第六节课");
			break;
		case 7:
			textview_collect_lesson.setText("第七节课");
			break;
		case 8:
			textview_collect_lesson.setText("第八节课");
			break;

		}

		textview_collect_teacher.setText(course.getTeacher()
				.getName());
	}
	private OnItemSelectedListener item_listener = new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			setView(list[arg2]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pd = ProgressDialog.show(context, "正在提交", "请稍后。。。。。。");
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String localhost = Constant.addr + ":" + Constant.port;
					// spandTimeMethod();// 耗时的方法
					String url = "http://" + localhost
							+ "/DataServer/addCollectCourse.action";
					Map<String, String> pars = new HashMap<String, String>();
					pars.put("collectCourse.student.id", app.getUserId());
					pars.put("collectCourse.course.id", ((SpinnerItem) spinner_collect_course
							.getSelectedItem()).key);
					String ret = Constant.getData(url, pars);
					Message mes = Message.obtain();
					Bundle b = new Bundle();
					b.putInt("identify", 2);
					b.putString("data", ret);
					mes.setData(b);
					handler.sendMessage(mes);
				}

			}).start();
		}

	};
}