package com.loading;

import com.animi.test.R;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class LoadingPopup {

	//private Context context;
	private PopupWindow pop;
	private LoadInterface lface;
	public LoadingPopup(Context context,View v){
		//this.context = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.loading, null, false);
		pop = new PopupWindow(view,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		//pop.setBackgroundDrawable(new BitmapDrawable());
		//pop.setOutsideTouchable(false);
		pop.setFocusable(true);
		pop.setBackgroundDrawable(null);
		pop.showAtLocation(v, Gravity.CENTER, 0, 0);
	}
	public void dismiss(String ret,boolean neterror){
		if (pop!=null)
			pop.dismiss();
		lface.onFinished(ret,neterror);
	}
	public void setLoadInterface(LoadInterface lface){
		this.lface = lface;
	}
}
