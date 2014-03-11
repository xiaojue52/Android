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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
		this.mAllData = this.app.getAllProjectInfos();
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
		setData();
		
		/*Department[] ments = app.getDepartments();
		List<SpinnerItem> values = new ArrayList<SpinnerItem>();
		SpinnerItem first = new SpinnerItem();
		first.key = "-1";
		first.value = "全部";
		values.add(first);
		for(int i=0;i<ments.length;i++){
			SpinnerItem item = new SpinnerItem();
			item.key = ments[i].bmid;
			item.value = ments[i].bmmc;
			values.add(item);
		}
		this.select_projects_search_listView.setOnItemClickListener(item_listener);
		items = new ArrayList<Item>();
		SimpleAdapter listAdapter = new SimpleAdapter(this.context,items);

		// Listen for Click events
		this.select_projects_search_listView.setAdapter(listAdapter);*/
		return v;
	}
	/*
	private void listProjects() {
		String xmjc = this.edittext_select_projects_search_project_name.getText().toString();
		
		Project[] projects = null;

		for (int i=0;i<projects.length;i++){
			Item item = new Item();
			item.firstLineText = projects[i].xmmc;
			item.secondLineText = projects[i].xmjc;
			item.key = projects[i].xmid;
			item.showCheckbox = false;
			items.add(item);
		}
		// Create the ListView Adapter
	}
	
	private Project[] getProjects(String bmid,String xmjc) throws PmisException{
		final String METHOD_NAME = "getProjects";
		Soap soap = new Soap(Constant.project_namespace,METHOD_NAME);
		List<PropertyInfo> args = new ArrayList<PropertyInfo>();
		PropertyInfo arg0 = new PropertyInfo();
		arg0.setName("bmid");
		arg0.setValue(bmid);
		arg0.setType(String.class);
		args.add(arg0);
		
		PropertyInfo arg1 = new PropertyInfo();
		arg1.setName("xmjc");
		arg1.setValue(xmjc);
		arg1.setType(String.class);
		args.add(arg1);
		soap.setPropertys(args);
		String ret = "";
		try {
			ret = soap.getResponse(Constant.project_url, Constant.project_url+"/"+METHOD_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PmisException("获取项目列表是失败！");
		}
		Gson gson = new Gson();
		try	{
			return gson.fromJson(ret, Project[].class);
		}catch(Exception e){
			throw new PmisException("当前没有项目！");
		}
	}
	
	private OnItemClickListener item_listener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			SeparatedListAdapter adapter = (SeparatedListAdapter) arg0.getAdapter();
			Item item = (Item)adapter.getItem(arg2);
			//Log.v("pmis", item.toString());
			Intent it = new Intent();
			//it.putExtra("ret", "2");
			it.putExtra("xmid", item.key);
			it.putExtra("xmjc", item.secondLineText);
			
			DatabaseHandler db = new DatabaseHandler(context);
			//ProjectInfo info = db.getProjectInfo();
			if(!db.projectInfoExist(item.key)){
				ProjectInfo info = new ProjectInfo();
				info.setXmid(item.key);
				info.setXmjc(item.secondLineText);
				info.setXmmc(item.firstLineText);
				db.addProjectInfo(info);
			}
			
			activity.setResult(Activity.RESULT_OK,it);
			activity.finish();
		}
		
	};*/

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
