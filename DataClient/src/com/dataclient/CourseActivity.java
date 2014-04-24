package com.dataclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adapter.SimpleSpinnerAdapter;
import com.constant.Constant;
import com.example.dataclient.R;
import com.google.gson.Gson;
import com.stracture.ClassRoom;
import com.stracture.Course;
import com.stracture.SpinnerItem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CourseActivity extends Activity {
	private Context context;
	private Spinner spinner_course_classRoon,spinner_course_week,spinner_course_lesson;
	private EditText editText_course_content;
	private Button button_course_submit;
	private MainApplication app;
	private Course sourse;
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		this.setContentView(R.layout.course);
		this.spinner_course_classRoon = (Spinner)this.findViewById(R.id.spinner_course_classRoom);
		this.spinner_course_lesson = (Spinner)this.findViewById(R.id.spinner_course_lesson);
		this.spinner_course_week = (Spinner)this.findViewById(R.id.spinner_course_week);
		this.editText_course_content = (EditText)this.findViewById(R.id.edittext_course_content);
		this.button_course_submit = (Button)this.findViewById(R.id.button_course_submit);
		this.button_course_submit.setOnClickListener(listener);
		this.context = this;
		this.app = (MainApplication)this.getApplication();
		sourse = new Course();
		sourse.setId(Integer.valueOf(this.getIntent().getStringExtra("id")));
		this.initData();
	}

	
	private void initData(){
		pd = ProgressDialog.show(context, "获取数据中", "请稍后。。。。。。");
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String localhost = Constant.addr+":"+Constant.port;
				// spandTimeMethod();// 耗时的方法
				String url = "http://"+localhost+"/DataServer/showCourse.action";
				Map<String,String> pars = new HashMap<String,String>();
				pars.put("course.id", String.valueOf(sourse.getId()));
				String ret = Constant.getData(url, pars);
				Message mes = Message.obtain();
				Bundle b = new Bundle();
				b.putString("data", ret);
				b.putInt("identify", 1);
				mes.setData(b);
				handler.sendMessage(mes);
			}
			
		}).start();
		
		ClassRoom[] types = app.getClassRooms();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		for (int i = 0; i < types.length; i++) {
			SpinnerItem item = new SpinnerItem();
			item.key = String.valueOf(types[i].getId());
			item.value = types[i].getName();
			values.add(item);
		}
		SimpleSpinnerAdapter adapter = new SimpleSpinnerAdapter(context,
				R.layout.spinner_item, values);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_course_classRoon.setAdapter(adapter);
		
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
		SimpleSpinnerAdapter adapter2 = new SimpleSpinnerAdapter(context,
				R.layout.spinner_item, weeks);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_course_week.setAdapter(adapter2);
		
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
		
		SimpleSpinnerAdapter adapter3 = new SimpleSpinnerAdapter(context,
				R.layout.spinner_item, lessons);
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_course_lesson.setAdapter(adapter3);
		
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
					String url = "http://"+localhost+"/DataServer/updateCourse.action";
					Map<String,String> pars = new HashMap<String,String>();
					pars.put("course.classRoom.id", classRoomid);
					pars.put("course.teacher.id", app.getUserId());
					pars.put("course.week", week);
					pars.put("course.lesson", lesson);
					pars.put("course.content", content);
					pars.put("course.id", String.valueOf(sourse.getId()));
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
			if (mes.getData().getInt("identify")==1){
				String ret = mes.getData().getString("data");
				Course course = new Gson().fromJson(ret, Course.class);
				//ClassRoom[] types = app.getClassRooms();
				int count = spinner_course_classRoon.getAdapter().getCount();
				for(int i=0;i<count;i++){
					if(course.getClassRoom().getId()==Integer.valueOf(((SpinnerItem)spinner_course_classRoon.getAdapter().getItem(i)).key)){
						spinner_course_classRoon.setSelection(i);
					}
				}
				
				spinner_course_week.setSelection(Integer.valueOf(course.getWeek())-1);
				spinner_course_lesson.setSelection(Integer.valueOf(course.getLesson())-1);
				editText_course_content.setText(course.getContent());
				pd.dismiss();
				return;
				
			}
			
			
			if (mes.getData().getString("data")!=null&&mes.getData().getString("data").equals("1")){
				Toast.makeText(context, "提交成功！", Toast.LENGTH_LONG).show();
				finish();
			}
			else
				Toast.makeText(context, "提交失败！", Toast.LENGTH_LONG).show();
			pd.dismiss();
		}
	};

	/**
	 * 监听touch事件，关闭软键盘
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (isShouldHideInput(v, ev)) {
				hideSoftInput(v.getWindowToken());
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
	 * 
	 * @param v
	 * @param event
	 * @return
	 */
	private boolean isShouldHideInput(View v, MotionEvent event) {
		if (v != null && (v instanceof EditText)) {
			int[] l = { 0, 0 };
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (event.getX() > left && event.getX() < right
					&& event.getY() > top && event.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}

	/**
	 * 多种隐藏软件盘方法的其中一种
	 * 
	 * @param token
	 */
	private void hideSoftInput(IBinder token) {
		if (token != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(token,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
}
