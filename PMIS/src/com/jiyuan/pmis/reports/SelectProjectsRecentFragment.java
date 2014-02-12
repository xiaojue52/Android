package com.jiyuan.pmis.reports;

import com.jiyuan.pmis.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SelectProjectsRecentFragment extends Fragment{
	@Override
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {
	      /**
	       * Inflate the layout for this fragment
	       */
	      return inflater.inflate(
	      R.layout.select_projects_recent_fragment, container, false);
	   }
}
