package com.jypmis.ztools;




import com.google.gson.Gson;
import com.jypmis.func.department.DepartmentImpl;
import com.jypmis.func.login.LoginImpl;
import com.jypmis.func.project.ProjectImpl;
import com.jypmis.func.report.ReportImpl;
import com.jypmis.vo.BbgVO;
import com.jypmis.vo.ReportSearchFieldVO;

/**
 * 测试函数
 * @author Administrator
 *
 */
public class WebServiceTest {

	//获得部门信息
	public void DepartmentsTest()
	{
		System.out.println("测试部门信息");
		DepartmentImpl di= new DepartmentImpl();
		di.findDepartments();
		di.getDepartments();
	}
	
	//获得登陆信息
	public void LoginTest()
	{
		System.out.println("测试登陆信息");
		LoginImpl li=new LoginImpl();
		String username="test";
		String password="test";
		li.findUserBasicInfo(username, password);
		li.findUsernameByUserid("2");
		li.login(username, password);
	}
	
	//获得项目信息
	public void ProjectTest()
	{
		System.out.println("测试项目信息");
		String departmentid="123"; 
		ProjectImpl pi=new ProjectImpl();
		pi.findDepartmentProjects(departmentid);
		pi.findProjects(departmentid, "项目");
		pi.getDepartmentProjects(departmentid);
		//pi.getProjects(departmentid, "项目");
	}
	
	//获取报工信息
	public void ReportTest()
	{
		System.out.println("测试报工管理信息");
		Gson gson=new Gson();
		ReportSearchFieldVO rs=new ReportSearchFieldVO();
		rs.xmid="-1";
		rs.kssj="--";
		rs.jssj="2014-12-06";
		rs.xzwtg="1";
		rs.xzdsh="1";
		rs.xzysh="1";
		rs.yhid="269";
		rs.type="0";
		rs.xzdy="1";
		rs.xzxy="1";
		rs.xzeq="1";
		rs.bgxid="0001";
		String jsonStrtype0=gson.toJson(rs);
		System.out.println("jsonStr0:"+jsonStrtype0);
		
		ReportSearchFieldVO rs1=new ReportSearchFieldVO();
		rs1.xmid="-1";
		rs1.kssj="2014-02-19";
		rs1.jssj="2014-03-21";
		rs1.xzwtg="0";
		rs1.xzdsh="1";
		rs1.xzysh="0";
		rs1.yhid="263";
		rs1.type="1";
		rs1.xzdy="1";
		rs1.xzxy="1";
		rs1.xzeq="1";
		rs1.bgxid="-1";
		String jsonStrtype1=gson.toJson(rs1);
		System.out.println("jsonStr1:"+jsonStrtype1);
		
	
		String reportid="20140219111158265001";
		ReportImpl ri=new ReportImpl();
		//ri.findReportByID(reportid);
		//ri.findReportTypes();
		//ri.findReportBySearchStr(jsonStrtype0);
		//ri.getReports(jsonStrtype0);
		//ri.findReportBySearchStr(jsonStrtype1);
		ri.getReports(jsonStrtype1);
		
		//新增报工测试
		BbgVO bg=new BbgVO();
		bg.bgxid="001";
		bg.xmid="-1";
		bg.gzrq="2014-06-06";
		bg.gzxs="3";
		bg.gzdd="合肥";
		bg.gznr="部门管理";
		String insertStr=gson.toJson(bg);
		//System.out.println("insertStr:"+insertStr);		
		//ri.saveReport("2", insertStr);
		//ri.showReport(reportid);
		
		
		bg.bgid="20140219174249078000";
		bg.bgxid="01";
		bg.xmid="001";
		bg.gzrq="2014-04-13";
		bg.gzxs="5";
		bg.gzdd="黄山";
		bg.gznr="部门管理";
		bg.zt="-1";
		bg.shr="张三";
		bg.shxx="请修改审核信息";
		//bg.bgsj="";
		String updateStr=gson.toJson(bg);
		//System.out.println("updateStr:"+updateStr);
		//ri.updateReport("2", updateStr);
		
		//ri.deleteReport(reportid);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		WebServiceTest jt=new WebServiceTest();
//		
//		//测试获得部门信息：
//		jt.DepartmentsTest();
//		//测试登陆信息
//		jt.LoginTest();
//		//测试项目信息
//		jt.ProjectTest();
//		//测试报工
		jt.ReportTest();
		
		// TODO Auto-generated method stub
		//报工测试，将字符串转成json格式

		//List<BbgVO>list=new ArrayList<BbgVO>();

//		BHGenerator bh=new BHGenerator();
//		String time=bh.getCurrentTimeString();
		
		//bg.bgid=bgid;
//		TransTimetype trans=new TransTimetype();
//		Date bgrq=trans.String2Date("2010-02-10");

		

		

		
	}

}
