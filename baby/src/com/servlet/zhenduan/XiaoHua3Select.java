/**
 * 
 */
package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Plan;
import com.bean.Record;
import com.bean.User;
import com.bean.Zhuyi;
import com.dao.PatientDao;
import com.dao.PlanDao;
import com.dao.RecordDao;
import com.dao.ZhuyiDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.PlanDaoImpl;
import com.dao.impl.RecordDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 
 *
 */
public class XiaoHua3Select extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取系统时间
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String nowTime="";
		nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		System.out.println(nowTime);
		String ddfTime= ddf.format(dt);
		String pid=request.getParameter("pid");
		int ipid=0;
		if(pid!=null){
			ipid=Integer.parseInt(pid);
		}else {
			response.sendRedirect("xuanzejiemian.jsp");
			return ;
		}
		//限制添加病例开始
		String sannowTime = ddfTime+"%";
		System.out.println("时间为："+sannowTime);
		int intpid=Integer.parseInt(pid);
		RecordDao recsan=new RecordDaoImpl();
		int sange=recsan.getRecord(sannowTime,intpid);
		System.out.println("返回的孩子病例数"+sange);
		
		if(sange>=1000){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('对不起，此宝宝今天已经超出添加病例次数！');");
			out.println("window.location.href=\"inputinfor.jsp\"");
			out.println("</script>");
			return;
		}
		//限制添加病例结束
		
		
		String otxingzhuang=request.getParameter("otxingzhuang");
		String otqiwei=request.getParameter("otqiwei");
		String exin=request.getParameter("exin");
		String yanshi=request.getParameter("yanshi");
		String mianse=request.getParameter("mianse");
//		String shetai=request.getParameter("shetai");
		String chun=request.getParameter("chun");
		
		String []strotxingzhuang=otxingzhuang.split("_");
		String []strotqiwei=otqiwei.split("_");
		String []strexin=exin.split("_");
		String []stryanshi=yanshi.split("_");
		String []strmianse=mianse.split("_");
//		String []strshetai=shetai.split("_");
		String []strchun=chun.split("_");
		
		//1、获得诊断处方
//		String str=strotxingzhuang[0]+strotqiwei[0]+strexin[0]+stryanshi[0]+strmianse[0]+strshetai[0];
		String str=strotxingzhuang[0]+strotqiwei[0]+strexin[0]+stryanshi[0]+strmianse[0]+strchun[0];
//		String str2="呕吐形状："+strotxingzhuang[1]+"呕吐气味："+strotqiwei[1]+"恶心："+strexin[1]+"厌食："+stryanshi[1]+"面色："+strmianse[1]+"舌苔："+strshetai[1];
		String str2="呕吐形状："+strotxingzhuang[1]+"呕吐气味："+strotqiwei[1]+"恶心："+strexin[1]+"厌食："+stryanshi[1]+"面色："+strmianse[1]+"唇色："+strchun[1];

		System.out.println("编号为："+str);
        System.out.println("处方为："+str2);
        
        //用于修改处方标识
        String change_i="13";
    	request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("str2", str2);
		//标识结束
	
		PlanDao planDao=new PlanDaoImpl(); 
		Plan plan=planDao.getPlanByZzbh13(str);
		String zybh="023";
		request.getSession().setAttribute("zybh", zybh);
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
		plan.setZhuyi(zhuyi.getZhuyi());
		//设置处方错误
		try {
			System.out.println("消化道-呕吐编号："+str);
			System.out.println("消化道-呕吐处方为："+str2);
			
		plan.setZzbh(str2);
		
		System.out.println(123);
		request.getSession().setAttribute("plan",plan);
		//2、保存诊断记录
		Record rd=new Record();
		rd.setDyzz(str2);	
		rd.setDycf(plan.getChufang());
		rd.setDysf(plan.getShoufa());
		rd.setDyzy(plan.getZhuyi());
		
		Object objuser=request.getSession().getAttribute("user");
		if(pid==null||pid.equals("")) {
			Object objpatient=request.getSession().getAttribute("patient");
			System.out.println("pid="+pid);
			if(objuser!=null&&objpatient!=null) {
				Patient p =(Patient) objpatient;
				User u = (User) objuser;
				rd.setCtime(nowTime);
				rd.setPid(p.getPid());
				rd.setUserid(u.getUserid());
				rd.setFid(u.getFid());
				RecordDao recordDao=new RecordDaoImpl();
				recordDao.save(rd);
				
				List<Record> tt=recordDao.sel(nowTime);
				request.getSession().setAttribute("tt",tt);
				
//				Record tt=recordDao.sel(nowTime);
//				int cid=tt.getCid();
//				request.getSession().setAttribute("cid",cid);
				
				response.sendRedirect("planDetial.jsp");
			} else {
				System.out.println("提交失败！");
				//提交失败
			}
		} else {
			PatientDao patientDao=new PatientDaoImpl();
			Patient patient=patientDao.getPatientById(ipid);
			if(objuser!=null&&patient!=null) {
				User u = (User) objuser;
				rd.setCtime(nowTime);
				rd.setPid(patient.getPid());
				rd.setUserid(u.getUserid());
				rd.setFid(u.getFid());
				RecordDao recordDao=new RecordDaoImpl();
				recordDao.save(rd);
				
				List<Record> tt=recordDao.sel(nowTime);
				request.getSession().setAttribute("tt",tt);
//				Record tt=recordDao.sel(nowTime);
//				int cid=tt.getCid();
//				request.getSession().setAttribute("cid",cid);
				
				request.getSession().setAttribute("patient",patient);
				response.sendRedirect("planDetial.jsp");
			} else {
				//提交失败
			}
		}
		} catch (Exception e){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
	       	out.println("<script>");
	       	out.println("alert('暂无处方');");
	    	out.println("window.location.href=\"addzhenduaner3.jsp\"");
	       	out.println("</script>");
		}
		
		out.close();
	}

}
