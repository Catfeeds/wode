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
 * @author 石可旺
 *
 */
public class InputBihoudilou extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取系统时间
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置显示格式
		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = "";
		nowTime = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
		System.out.println(nowTime);
		String ddfTime= ddf.format(dt);
		String pid = request.getParameter("pid");
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
		
		System.out.println(1 + " " + pid + " " + 2);
		
		String shxdao = request.getParameter("shxdao");
		String fare = request.getParameter("fare");
		String dushu = request.getParameter("dushu");
		String chuzhen = request.getParameter("chuzhen");
		String tingzhen = request.getParameter("tingzhen");
		String chun = request.getParameter("chun");
		String shezhi = request.getParameter("shezhi");
		String shetai = request.getParameter("shetai");
//		String yanhou = request.getParameter("yanhou");
		String bingzheng=request.getParameter("bingzheng");

		
		String[] strshxdao = shxdao.split("_");
		String[] strfare = fare.split("_");
		String[] strchuzhen = chuzhen.split("_");
		String[] strtingzhen = tingzhen.split("_");
		String[] strchun = chun.split("_");
		String[] strshezhi = shezhi.split("_");
		String[] strshetai = shetai.split("_");
//		String[] stryanhou = yanhou.split("_");
		
		// 1、获得诊断编号
		String str = strshxdao[0] + strfare[0]+strchuzhen[0]
				   + strtingzhen[0] + strchun[0]+ strshezhi[0] + strshetai[0]+"01";
		// 1、获得诊断处方
		 String	 str2="病症"+bingzheng+ "   上呼吸道症状："+strshxdao[1] +"  发热："+ strfare[1] +"  度数："+dushu+"°C"+ "  唇色："+strchun[1]+"  触诊："+ strchuzhen[1]
				   +"  听诊："+ strtingzhen[1]  + "  舌质："+strshezhi[1] + "  舌苔："+strshetai[1];
		System.out.println(str+"tiaojian");
		String zybh="01";
		request.getSession().setAttribute("zybh", zybh);
		PlanDao planDao = new PlanDaoImpl();
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
		
		//判断在哪个数据库表格里面查询
		int i=Integer.parseInt(strshxdao[0]);
		//判断在哪个数据表格修改处方诊断
		String change_i=null;
		Plan plan=new Plan();
		
		System.out.println(i+"转换后的编号");
		if(i>=0&&i<=10){
			 plan = planDao.getGanmaoPlanZzbh(str);
			 change_i="01";
		}
		if(i>10&&i<=20){
			 plan = planDao.getPlanByZzbh02(str);
			 change_i="02";
		}
		if(i>20&&i<=30){
			 plan = planDao.geJishiPlanZzbh(str);
			 change_i="03";
		}
//		if(i>30&&i<=40){
//			 plan = planDao.getPlanByZzbh04(str);
//			 change_i="04";
//		}
//		if(i>40&&i<=50){
//			 plan = planDao.getPlanByZzbh05(str);
//			 change_i="05";
//		}
//		if(i>50&&i<=60){
//			 plan = planDao.getPlanByZzbh06(str);
//			 change_i="06";
//		}
//		if(i>60&&i<=73){
//			 plan = planDao.getPlanByZzbh07(str);
//			 change_i="07";
//		}
		request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("pid", pid);
//		request.getSession().setAttribute("str2", str2);
		// 设置处方错误
		try {

			plan.setZzbh(str2);
			plan.setZhuyi(zhuyi.getZhuyi());

			System.out.println(123);
			request.getSession().setAttribute("plan", plan);
			System.out.println(plan.getChufang()+"1011111111111111111111111111111");
			// 2、保存诊断记录
			Record rd = new Record();
			rd.setDyzz(str2);
			//rd.setZzbh(str);
			rd.setDycf(plan.getChufang());
			rd.setDysf(plan.getShoufa());
			rd.setDyzy(zhuyi.getZhuyi());
			
			Object objuser = request.getSession().getAttribute("user");
			
			if (pid == null || pid.equals("")) {
				Object objpatient = request.getSession().getAttribute("patient");
				System.out.println("pid=" + pid);
				if (objuser != null && objpatient != null) {
					Patient p = (Patient) objpatient;
					User u = (User) objuser;
					rd.setCtime(nowTime);
					rd.setPid(p.getPid());
					rd.setUserid(u.getUserid());
					rd.setFid(u.getFid());
					RecordDao recordDao = new RecordDaoImpl();
					//System.out.println(rd.getZzbh()+"3333333333333333333333333333333");
					recordDao.save(rd);
					
					
					List<Record> tt=recordDao.sel(nowTime);
//					int cid=tt.getCid();
					request.getSession().setAttribute("tt",tt);
					
					response.sendRedirect("planDetial.jsp");
				} else {
					System.out.println("提交失败！");
					// 提交失败
				}
			} else {
				
				PatientDao patientDao = new PatientDaoImpl();
				Patient patient = patientDao.getPatientById(ipid);	
				if (objuser != null && patient != null) {
					User u = (User) objuser;
					rd.setCtime(nowTime);
					rd.setPid(patient.getPid());
					rd.setUserid(u.getUserid());
					rd.setFid(u.getFid());
					RecordDao recordDao = new RecordDaoImpl();
					recordDao.save(rd);
					
					System.out.println(nowTime+"小朋友！！！！！！！！！！！！！！！！");
					List<Record> tt=recordDao.sel(nowTime);
					System.out.println("你好啊！！！！！！！！！！！！！！！！");
//					int cid=tt.getCid();
					System.out.println("你好啊小朋友！！！！！！！！！！！！！！！！");
					request.getSession().setAttribute("tt",tt);
					
					request.getSession().setAttribute("patient", patient);
					response.sendRedirect("planDetial.jsp");
				} else {
					out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
					out.println("<script>");
					out.println("window.location.href=\"addzhenduanyi.jsp\"");
					out.println("</script>");
				}
			}
		} catch (Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('暂无处方');");
			out.println("window.location.href=\"addzhenduanyi.jsp\"");
			out.println("</script>");
		}
		
		out.close();
	}



}
