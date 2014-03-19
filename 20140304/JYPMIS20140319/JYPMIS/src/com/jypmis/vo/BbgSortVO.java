package com.jypmis.vo;

import java.util.ArrayList;
import java.util.List;

public class BbgSortVO {
	/**
	 * 项目名称
	 */
	public String xmmc;
	/**
	 * 项目id
	 */
	public String xmid;
	/**
	 * 项目简称
	 */
	public String xmjc;
	/**
	 * 项目下面的报工列表
	 */
	public List<BbgVO> list = new ArrayList<BbgVO>();
}
