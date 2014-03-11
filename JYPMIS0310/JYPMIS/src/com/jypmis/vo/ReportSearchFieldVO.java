package com.jypmis.vo;

	public class ReportSearchFieldVO {
		/**
		 * 项目id
		 */
		public String xmid;
		/**
		 * 开始时间
		 */
		public String kssj;
		/**
		 * 结束时间
		 */
		public String jssj;
		/**
		 * 状态是否选中未通过（0未选，1选中）
		 */
		public String xzwtg;
		/**
		 * 状态是否选中待审核（0未选，1选中）
		 */
		public String xzdsh;
		/**
		 * 状态是否选中已审核（0未选，1选中）
		 */
		public String xzysh;
		/**
		 * 选中工作小时大于8小时（0未选，1选中）
		 */
		public String xzdy;
		/**
		 * 小于8小时（0未选，1选中）
		 */
		public String xzxy;
		/**
		 * 等于8小时（0未选，1选中）
		 */
		public String xzeq;
		/**
		 * 用户id
		 */
		public String yhid;
		/**
		 * 类型（0为查询我的报工，1为查询指派给我审核的报工）
		 */
		public String type;
		/**
		 * 报工项id
		 */
		public String bgxid;
	}

