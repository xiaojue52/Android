package com.dataclient.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adapter.SimpleSpinnerAdapter;
import com.constant.Constant;
import com.dataclient.MainApplication;
import com.example.dataclient.R;
import com.stracture.ClassRoom;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FragmentPage3 extends Fragment{
	private Context context;
	private Spinner spinner_course_classRoon,spinner_course_week,spinner_course_lesson;
	private EditText editText_course_content;
	private Button button_course_submit;
	private MainApplication app;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.course, null);
			this.context = this.getActivity();
			this.spinner_course_classRoon = (Spinner)v.findViewById(R.id.spinner_course_classRoom);
			this.spinner_course_lesson = (Spinner)v.findViewById(R.id.spinner_course_lesson);
			this.spinner_course_week = (Spinner)v.findViewById(R.id.spinner_course_week);
			this.editText_course_content = (EditText)v.findViewById(R.id.edittext_course_content);
			this.button_course_submit = (Button)v.findViewById(R.id.button_course_submit);
			this.button_course_submit.setOnClickListener(listener);
			
			this.app = (MainApplication)this.getActivity().getApplication();
			this.initData();
			return v;
	}
	private void initData(){
		ClassRoom[] types = app.getClassRooms();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = String.valueOf(types[i].getId());
			item.value = types[i].getName();
			values.add(item);
		}
		SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(this.context,
				R.layout.spinner_item, values);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_course_classRoon.setAdapter(adapter);
		
		List<SpinnerItem> weeks = new ArrayList<SpinnerItem>();
		SpinnerItem item1 = new SpinnerItem();
		item1.key = "1";
		item1.value = "星期一";
		weeks.add(item1);
		SpinnerItem item2 = new SpinnerItem();
		item2.key = "2";
		item2.value = "星期二";
		weeks.add(item2);
		SpinnerItem item3 = new SpinnerItem();
		item3.key = "3";
		item3.value = "星期三";
		weeks.add(item3);
		SpinnerItem item4 = new SpinnerItem();
		item4.key = "4";
		item4.value = "星期四";
		weeks.add(item4);
		SpinnerItem item5 = new SpinnerItem();
		item5.key = "5";
		item5.value = "星期五";
		weeks.add(item5);
		SimpleSpinnerAdapter adapter2 = new SimpleSpinnerAdapter(this.context,
				R.layout.spinner_item, weeks);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_course_week.setAdapter(adapter2);
		
		List<SpinnerItem> lessons = new ArrayList<SpinnerItem>();
		SpinnerItem lesson1 = new SpinnerItem();
		lesson1.key = "1";
		lesson1.value = "第一节课";
		lessons.add(lesson1);
		SpinnerItem lesson2 = new SpinnerItem();
		lesson2.key = "2";
		lesson2.value = "第二节课";
		lessons.add(lesson2);
		SpinnerItem lesson3 = new SpinnerItem();
		lesson3.key = "3";
		lesson3.value = "第三节课";
		lessons.add(lesson3);
		SpinnerItem lesson4 = new SpinnerItem();
		lesson4.key = "4";
		lesson4.value = "第四节课";
		lessons.add(lesson4);
		SpinnerItem lesson5 = new SpinnerItem();
		lesson5.key = "5";
		lesson5.value = "第五节课";
		lessons.add(lesson5);
		SpinnerItem lesson6 = new SpinnerItem();
		lesson6.key = "6";
		lesson6.value = "第六节课";
		lessons.add(lesson6);
		SpinnerItem lesson7 = new SpinnerItem();
		lesson7.key = "7";
		lesson7.value = "第七节课";
		lessons.add(lesson7);
		SpinnerItem lesson8 = new SpinnerItem();
		lesson8.key = "8";
		lesson8.value = "第八节课";
		lessons.add(lesson8);
		
		SimpleSpinnerAdapter adapter3 = new SimpleSpinnerAdapter(this.context,
				R.layout.spinner_item, lessons);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_course_lesson.setAdapter(adapter3);
		
	}
	
	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final String classRoomid = ((SpinnerItem)spinner_course_classRoon.getSelectedItem()).key;
			final String week = ((SpinnerItem)spinner_course_week.getSelectedItem()).key;
			final String lesson = ((SpinnerItem)spinner_course_lesson.getSelectedItem()).key;
			final String content = editText_course_content.getText().toString();
			if (content.length()==0)
			{
				Toast.makeText(context, "内容不能为空！", Toast.LENGTH_LONG).show();
				return;
			}
			//Toast.makeText(context, classRoomid+"..."+week+"..."+lesson+"..."+content, Toast.LENGTH_LONG).show();
			pd = ProgressDialog.show(context, "提交中", "请稍后。。。。。。");
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String localhost = Constant.addr+":"+Constant.port;
					// spandTimeMethod();// 耗时的方法
					String url = "http://"+localhost+"/DataServer/addCourse.action";
					Map<String,String> pars = new HashMap<String,String>();
					pars.put("course.classRoom.id", classRoomid);
					pars.put("course.teacher.id", app.getUserId());
					pars.put("course.week", week);
					pars.put("course.lesson", lesson);
					pars.put("course.content", content);
					String ret = Constant.getData(url, pars);
					Message mes = Message.obtain();
					Bundle b = new Bundle();
					b.putString("data", ret);
					mes.setData(b);
					handler.sendMessage(mes);
				}
				
			}).start();
		}
		
	};
	private ProgressDialog pd;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message mes){
			if (mes.getData().getString("data")!=null&&mes.getData().getString("data").equals("1")){
				Toast.makeText(context, "提交成功！", Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(context, "提交失败！", Toast.LENGTH_LONG).show();
			pd.dismiss();
		}
	};
	
}