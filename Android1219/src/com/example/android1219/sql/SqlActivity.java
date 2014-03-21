package com.example.android1219.sql;

import java.util.List;

import com.example.android1219.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SqlActivity extends Activity{
	private DBHelper dbhelper;

	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		this.setContentView(R.layout.sql_activity);
		this.dbhelper = new DBHelper(this);
	}
	public void insert(View v){
		Student student = new Student();
		student.setName("zhangsan");
		student.setScore("100");
		this.dbhelper.insert(student);
	}
	public void show(View v){
		Student student = this.dbhelper.show(1);
		if (student!=null){
			Toast.makeText(this, "name:"+student.getName()+"--score:"+student.getScore(), Toast.LENGTH_SHORT).show();
		}else
			Toast.makeText(this, "there is no recored!", Toast.LENGTH_SHORT).show();
	}
	public void clear(View v){
		this.dbhelper.clear();
	}
	public void update(View v){
		
	}
	public void delete(View v){
		
	}
	public void getRecords(View v){
		List<Object> list = this.dbhelper.getCustomizeObject();
		String content = "";
		for (int i=0;i<list.size();i++){
			Student student = (Student)list.get(i);
			content += "name:"+student.getName()+"--";
		}
		if(content.length()==0){
			Toast.makeText(this, "there is no record!", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
		}
	}
}
