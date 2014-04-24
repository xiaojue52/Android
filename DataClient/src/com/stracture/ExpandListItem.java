package com.stracture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class ExpandListItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244488681173194059L;
	public String title;
	public int count;
	public List<Item> items = new ArrayList<Item>();
	public boolean showCheckBox = false;
	public boolean isChecked = false;
	public int bgColor = Color.parseColor("#d1e5fe");
	public Integer bgImageId;
}
