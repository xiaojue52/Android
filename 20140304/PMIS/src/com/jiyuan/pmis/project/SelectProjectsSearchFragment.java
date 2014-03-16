package com.jiyuan.pmis.project;

import java.util.ArrayList;
import java.util.List;
import com.jiyuan.pmis.MainApplication;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.search.Pinyin4jUtil;
import com.jiyuan.pmis.search.SimpleSearchAdapter;
import com.jiyuan.pmis.sqlite.ProjectInfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

@SuppressLint("DefaultLocale")
public class SelectProjectsSearchFragment extends Fragment implements
OnEditorActionListener{
	private Context context;
	private MainApplication app;
	private Activity activity;	
	ListView mListView;
	SimpleSearchAdapter mAdapter;
	EditText mtxt;

	List<ProjectInfo> mAllData;
	


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Inflate the layout for this fragment
		 */
		this.context = this.getActivity();
		this.activity = this.getActivity();
		app = (MainApplication) this.getActivity().getApplication();
		View v = inflater.inflate(R.layout.select_projects_search_fragment,
				container, false);
		this.mListView = (ListView) v
				.findViewById(R.id.select_projects_search_listView);
		this.mtxt = (EditText)v.findViewById(R.id.edittext_select_projects_search_project_name);
		
		mAdapter = new SimpleSearchAdapter((Activity) this.context);
		mtxt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (0 != mtxt.getText().length()) {
					String spnId = mtxt.getText().toString();
					setSearchResult(spnId);
				} else {
					setData();
				}
			}
		});
		pd = ProgressDialog.show(context, "数据加载", "数据加载中，请稍后。。。。。。");
		new Thread(){
			@Override
			public void run(){
				mAllData = app.getAllProjectInfos();
				handler.sendEmptyMessage(0);
			}
		}.start();
		
		return v;
	}

	private ProgressDialog pd;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message mes){
			setData();
			pd.dismiss();
		}
	};
	public void setData() {
		if (mAllData==null)
			mAllData = new ArrayList<ProjectInfo>();
		mAdapter = new SimpleSearchAdapter((Activity) this.context);
		for (int i = 0; i < mAllData.size()&&i<30; i++) {
			mAdapter.addItem(mAllData.get(i));
		}
		mListView.setOnItemClickListener(onItemClickListener);
		mListView.setAdapter(mAdapter);
	}

	private OnItemClickListener onItemClickListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SimpleSearchAdapter adapter = (SimpleSearchAdapter) arg0.getAdapter();
			ProjectInfo item = (ProjectInfo)adapter.getItem(arg2);
			Intent it = new Intent();
			it.putExtra("xmid", item.getXmid());
			it.putExtra("xmjc", item.getXmjc());
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};
	@SuppressLint("DefaultLocale")
	public void setSearchResult(String str) {
		mAdapter = new SimpleSearchAdapter((Activity) this.context);
		for (ProjectInfo temp : mAllData) {
			if (temp.getXmjc().toLowerCase().contains(str.toLowerCase())||Pinyin4jUtil.converterToFirstSpell(temp.getXmjc()).toLowerCase().contains(str.toLowerCase())) {
				mAdapter.addItem(temp);
			}
		}
		mListView.setAdapter(mAdapter);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
