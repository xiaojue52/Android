package com.dataclient.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.adapter.SimpleBaseExpandableListAdapter;
import com.constant.Constant;
import com.dataclient.CourseActivity;
import com.dataclient.MainApplication;
import com.example.dataclient.R;
import com.google.gson.Gson;
import com.stracture.CollectCourse;
import com.stracture.Course;
import com.stracture.ExpandListItem;
import com.stracture.Item;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class FragmentPage1 extends Fragment {

	private Context context;
	private Button button_my_courses_delete;
	private ExpandableListView my_courses_listView;
	private MainApplication app;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.fragment_1, null);
			this.context = this.getActivity();
			this.app = (MainApplication)this.getActivity().getApplication();
			this.button_my_courses_delete = (Button)v.findViewById(R.id.button_my_courses_delete);
			this.button_my_courses_delete.setOnClickListener(listener);
			
			this.my_courses_listView = (ExpandableListView)v.findViewById(R.id.my_courses_listView);
			if (app.getTag()==1)
				this.my_courses_listView.setOnChildClickListener(onChildClickListener);
			List<ExpandListItem> values = new ArrayList<ExpandListItem>();
			expandableadapter = new SimpleBaseExpandableListAdapter(context,values);
			my_courses_listView.setAdapter(expandableadapter);
			
			return v;
	}
	@Override
	public void onResume(){
		super.onResume();
		this.initData();
	}
	private OnChildClickListener onChildClickListener = new OnChildClickListener(){

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			Intent it = new Intent(context,CourseActivity.class);
			it.putExtra("id", ((Item)expandableadapter.getChild(groupPosition, childPosition)).key);
			startActivity(it);
			return false;
		}
	};
	private void initData(){
		pd = ProgressDialog.show(context, "获取数据中", "请稍后。。。。。。");
		new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String localhost = Constant.addr+":"+Constant.port;
				// spandTimeMethod();// 耗时的方法
				String url = "";
				if (app.getTag()==0){
					url = "http://"+localhost+"/DataServer/listCollectCourses.action";
				}else{
					url = "http://"+localhost+"/DataServer/listCourses.action";
				}
				Map<String, String> pars = new HashMap<String, String>();
				pars.put("userid", app.getUserId());
				String ret = Constant.getData(url, pars);
				Message mes = Message.obtain();	
				Bundle b = new Bundle();
				b.putString("data", ret);
				mes.setData(b);
				handler.sendMessage(mes);
			}
		}).start();
	}
	private class TempData{
		public String key;
		public Course course;
	}
	private ProgressDialog pd;
	private Handler handler =  new Handler(){
		@Override
		public void handleMessage(Message mes){
			if (mes.getData().getInt("identify")==1){
				pd.dismiss();
				initData();
				return;
			}
			if (mes.getData().getString("data")!=null){

				List<TempData> list = new ArrayList<TempData>();
				if (app.getTag()==0){
					CollectCourse[] collectCourses = new Gson().fromJson(mes.getData().getString("data"), CollectCourse[].class);	
					for (int i=0;i<collectCourses.length;i++){
						TempData tempData = new TempData();
						tempData.key = String.valueOf(collectCourses[i].getId());
						tempData.course = collectCourses[i].getCourse();
						list.add(tempData);
					}
				}else{
					Course[] courses = new Gson().fromJson(mes.getData().getString("data"), Course[].class);
					for (int i=0;i<courses.length;i++){
						TempData tempData = new TempData();
						tempData.key = String.valueOf(courses[i].getId());
						tempData.course = courses[i];
						list.add(tempData);
					}
				}
				
				if (list.size()==0){
					Toast.makeText(context, "当前无数据！", Toast.LENGTH_LONG).show();
					List<ExpandListItem> values = new ArrayList<ExpandListItem>();
					expandableadapter.setValues(values);
					expandableadapter.notifyDataSetChanged();
				}else{
					List<ExpandListItem> values = new ArrayList<ExpandListItem>();
					ExpandListItem group1 = new ExpandListItem();
					group1.title = "星期一";
					ExpandListItem group2 = new ExpandListItem();
					group2.title = "星期二";
					ExpandListItem group3 = new ExpandListItem();
					group3.title = "星期三";
					ExpandListItem group4 = new ExpandListItem();
					group4.title = "星期四";
					ExpandListItem group5 = new ExpandListItem();
					group5.title = "星期五";
					for(int i=0;i<list.size();i++){
						Course course = list.get(i).course;
						Item item = new Item();
						item.showCheckbox = true;
						item.key = String.valueOf(list.get(i).key);
						
						switch(Integer.valueOf(course.getLesson())){
						case 1:
							item.firstLineText = "第一节课:"+course.getContent();
							break;
						case 2:
							item.firstLineText = "第二节课:"+course.getContent();
							break;
						case 3:
							item.firstLineText = "第三节课:"+course.getContent();
							break;
						case 4:
							item.firstLineText = "第四节课:"+course.getContent();
							break;
						case 5:
							item.firstLineText = "第五节课:"+course.getContent();
							break;
						case 6:
							item.firstLineText = "第六节课:"+course.getContent();
							break;
						case 7:
							item.firstLineText = "第七节课:"+course.getContent();
							break;
						case 8:
							item.firstLineText = "第八节课:"+course.getContent();
							break;
						}
						item.secondLineText = "老师:"+course.getTeacher().getName()+"   教室:"+course.getClassRoom().getName();
						
						switch(Integer.valueOf(course.getWeek())){
						case 1:
							group1.items.add(item);
							break;
						case 2:
							group2.items.add(item);
							break;
						case 3:
							group3.items.add(item);
							break;
						case 4:
							group4.items.add(item);
							break;
						case 5:
							group5.items.add(item);
							break;
						}
					}
					group1.count = group1.items.size();
					group2.count = group2.items.size();
					group3.count = group3.items.size();
					group4.count = group4.items.size();
					group5.count = group5.items.size();
					values.add(group1);
					values.add(group2);
					values.add(group3);
					values.add(group4);
					values.add(group5);
					expandableadapter.setValues(values);
					
					expandableadapter.notifyDataSetChanged();
				}
				//Toast.makeText(context, courses[0].getTeacher().getName(), Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(context, "获取数据失败！", Toast.LENGTH_LONG).show();
			}
			pd.dismiss();
		}
	};
	private SimpleBaseExpandableListAdapter expandableadapter;
	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final List<String> idList = new ArrayList<String>();
			boolean hadChecked = false;
			int count = expandableadapter.getGroupCount();
			for(int i=0;i<count;i++){
				List<Item> items = expandableadapter.getGroup(i).items;
				for(int j=0;j<items.size();j++){
					//Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
					Item item = items.get(j);
					if(item.isChecked){
						hadChecked = true;
						//Toast.makeText(context, "删除！"+item.key+"......"+item.firstLineText, Toast.LENGTH_SHORT).show();
						//pd = 
						idList.add(item.key);
					}
				}
			}
			if (!hadChecked){
				Toast.makeText(context, "请选择条目！", Toast.LENGTH_SHORT).show();
			}else{
				pd = ProgressDialog.show(context, "删除中", "请稍后。。。。。。");
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						String localhost = Constant.addr+":"+Constant.port;
						// spandTimeMethod();// 耗时的方法
						String url = "";
						if (app.getTag()==0){
							url = "http://"+localhost+"/DataServer/deleteCollectCourse.action";
						}else{
							url = "http://"+localhost+"/DataServer/deleteCourse.action";
						}
						Map<String, String> pars = new HashMap<String, String>();
						pars.put("idList", new Gson().toJson(idList));
						String ret = Constant.getData(url, pars);
						Message mes = Message.obtain();	
						Bundle b = new Bundle();
						b.putString("data", ret);
						b.putInt("identify", 1);
						mes.setData(b);
						handler.sendMessage(mes);
					}
				}).start();
			}
		}
		
	};
}
