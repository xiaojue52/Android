package com.jiyuan.pmis.structure;

import java.util.ArrayList;
import java.util.List;

public class ReportSort {

	/**
	 * 项目id
	 */
	public String xmid;
	/**
	 * 标题
	 */
	public String title;
	/**
	 * 项目下面的报工列表
	 */
	public List<Report> list = new ArrayList<Report>();
	/**
	 * 个数
	 */
	public int count = 0;
}
