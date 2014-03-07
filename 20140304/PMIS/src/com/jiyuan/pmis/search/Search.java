package com.jiyuan.pmis.search;

import java.util.ArrayList;
import java.util.List;
import com.jiyuan.pmis.R;
import com.jiyuan.pmis.sqlite.ProjectInfo;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;

public class Search implements
OnEditorActionListener{

	private PopupWindow pop;
	private Context context;
	private View v;
	ListView mListView;
	SimpleSearchAdapter mAdapter;
	EditText mtxt;

	List<ProjectInfo> mAllData;
	private OnItemClickListener onItemClickListener;	
	
	public Search(Context context,View v,OnItemClickListener onItemClickListener,List<ProjectInfo> list,int tag){
		this.context = context;
		this.v = v;
		this.mAllData = list;
		if (tag==1){
			ProjectInfo info = new ProjectInfo();
			info.setXmid("-1");
			info.setXmjc("全部");
			info.setXmmc("全部");
			this.mAllData.add(0, info);
		}
		this.onItemClickListener = onItemClickListener;
		this.init();
	}
	public void init(){

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.search_popupwindow, null, false);
		pop = new PopupWindow(view,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		pop.setBackgroundDrawable(new BitmapDrawable());
		pop.setOutsideTouchable(true);
		pop.setFocusable(true);
		pop.showAtLocation(v, Gravity.CENTER, 0, 0);
		
		mListView = (ListView) view.findViewById(R.id.mListView);
		mAdapter = new SimpleSearchAdapter((Activity) this.context);
		//btnSearch = (Button) findViewById(R.id.btnSearch);
		//btnLeft = (Button) findViewById(R.id.btnLeft);
		mtxt = (EditText) view.findViewById(R.id.edSearch);
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
		//btnLeft.setOnClickListener(this);
		//btnSearch.setOnClickListener(this);
		setData();
	}
	
	

	/*String[] str = { "Hit me Hard", "GIJ, Rise Of Cobra", "Troy",
			"A walk To remember", "DDLJ", "Tom Peter Nmae", "David Miller",
			"Kings Eleven Punjab", "Kolkata Knight Rider", "Rest of Piece" };*/
	

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


	public void setSearchResult(String str) {
		mAdapter = new SimpleSearchAdapter((Activity) this.context);
		for (ProjectInfo temp : mAllData) {
			if (temp.getXmjc().toLowerCase().contains(str.toLowerCase())) {
				mAdapter.addItem(temp);
			}
		}
		mListView.setAdapter(mAdapter);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		return false;
	}
	public void dismiss(){
		if (pop!=null){
			pop.dismiss();
		}
	}

}
