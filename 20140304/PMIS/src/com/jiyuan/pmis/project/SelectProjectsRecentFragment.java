package com.jiyuan.pmis.project;

import java.util.List;

import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.adapter.SimpleRecentAdapter;
import com.jiyuan.pmis.sqlite.DatabaseHandler;
import com.jiyuan.pmis.sqlite.RecentProjectInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SelectProjectsRecentFragment extends Fragment {
	private ListView select_projects_recent_listView;
	private Context context;
	private Activity activity;
	private MainApplication app;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		this.activity = this.getActivity();
		this.app = (MainApplication) this.activity.getApplication();
		View v = inflater.inflate(R.layout.select_projects_recent_fragment,
				container, false);
		this.select_projects_recent_listView = (ListView) v
				.findViewById(R.id.select_projects_recent_listView);
		this.listProjects();
		return v;
	}
	
	private void listProjects() {
		DatabaseHandler db = new DatabaseHandler(context);
		List<RecentProjectInfo> list = db.getRecentProjectInfos(app.getUser().yhid);
		SimpleRecentAdapter mAdapter = new SimpleRecentAdapter((Activity) this.context);
		Intent it = this.activity.getIntent();
		String search = it.getStringExtra("search");
		if (search.equals("1")){
			RecentProjectInfo info = new RecentProjectInfo();
			info.setXmid("-1");
			info.setXmjc("全部");
			mAdapter.addItem(info);
		}
		for (int i=0;i<list.size();i++){
			mAdapter.addItem(list.get(i));
		}

		this.select_projects_recent_listView.setAdapter(mAdapter);
		this.select_projects_recent_listView.setOnItemClickListener(item_listener);
	}
	
	private OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleRecentAdapter adapter = (SimpleRecentAdapter) arg0.getAdapter();
			RecentProjectInfo item = (RecentProjectInfo)adapter.getItem(arg2);
			Intent it = new Intent();
			it.putExtra("xmid", item.getXmid());
			it.putExtra("xmjc", item.getXmjc());
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};
}
