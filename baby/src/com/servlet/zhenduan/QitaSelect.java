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

public class QitaSelect extends HttpServlet {

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
		
		String zybh = null;

		String yeti = request.getParameter("yeti");
		String yiniao = request.getParameter("yiniao");
		String niaopin = request.getParameter("niaopin");
		String duohan = request.getParameter("duohan");
		String linbajie = request.getParameter("linbajie");
		String futong = request.getParameter("futong");
		String changtaodie = request.getParameter("changtaodie");
		String liudan = request.getParameter("liudan");
		String shizhen = request.getParameter("shizhen");
		String kouchuang = request.getParameter("kouchuang");
		String huangdan = request.getParameter("huangdan");
		String ezhangfeng = request.getParameter("ezhangfeng");
		String jishi = request.getParameter("jishi");
		
		String dushu=request.getParameter("dushu");

		String mianse = request.getParameter("mianse");
		String shezhi = request.getParameter("shezhi");
		String chun = request.getParameter("chun");
//		String shetai = request.getParameter("shetai");
		
		if(yeti==null||yeti.equals("")){
			yeti="00_正常";
		}
		if(yiniao==null){
			yiniao="00_正常";
		}
		if(niaopin==null){
			niaopin="00_正常";
		}
		if(duohan==null){
			duohan="00_正常";
		}
		if(linbajie==null){
			linbajie="00_正常";
		}
		if(futong==null){
			futong="00_正常";
		}
		if(changtaodie==null){
			changtaodie="00_正常";
		}
		if(liudan==null){
			liudan="00_正常";
		}
		if(shizhen==null){
			shizhen="00_正常";
		}
		if(kouchuang==null){
			kouchuang="00_正常";
		}
		if(huangdan==null){
			huangdan="00_正常";
		}
		if(ezhangfeng==null){
			ezhangfeng="00_正常";
		}
		if(jishi==null){
			jishi="00_正常";
		}
		
		String[] stryeti = yeti.split("_");
		String[] stryiniao = yiniao.split("_");
		String[] strniaopin = niaopin.split("_");
		String[] strduohan = duohan.split("_");
		String[] strlinbajie = linbajie.split("_");
		String[] strfutong = futong.split("_");
		String[] strchangtaodie = changtaodie.split("_");
		String[] strliudan = liudan.split("_");
		String[] strshizhen = shizhen.split("_");
		String[] strkouchuang = kouchuang.split("_");
		String[] strmianse = mianse.split("_");
		String[] strshezhi = shezhi.split("_");
		String[] strchun = chun.split("_");
//		String[] strshetai = shetai.split("_");
		String[] strhuangdan = huangdan.split("_");
		String[] strezhangfeng = ezhangfeng.split("_");
		String[] strjishi = jishi.split("_");

		
		if (!stryeti[0].equals("00")) {
			zybh = "041";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}
		if (!stryiniao[0].equals("00")) {
			zybh = "042";
			stryeti[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strniaopin[0].equals("00")) {
			zybh = "043";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strduohan[0].equals("00")) {
			zybh = "044";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strlinbajie[0].equals("00")) {
			zybh = "045";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strfutong[0].equals("00")) {
			zybh = "046";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strchangtaodie[0].equals("00")) {
			zybh = "047";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strliudan[0].equals("00")) {
			zybh = "048";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strshizhen[0].equals("00")) {
			zybh = "049";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}

		if (!strkouchuang[0].equals("00")) {
			zybh = "0410";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}
		if (!strhuangdan[0].equals("00")) {
			zybh = "040";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strezhangfeng[0] = "00";
			strjishi[0] = "00";
		}
		if (!strezhangfeng[0].equals("00")) {
			zybh = "040";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strjishi[0] = "00";
		}
		if (!strjishi[0].equals("00")) {
			zybh = "040";
			stryeti[0] = "00";
			stryiniao[0] = "00";
			strniaopin[0] = "00";
			strduohan[0] = "00";
			strlinbajie[0] = "00";
			strfutong[0] = "00";
			strchangtaodie[0] = "00";
			strliudan[0] = "00";
			strshizhen[0] = "00";
			strkouchuang[0] = "00";
			strhuangdan[0] = "00";
			strezhangfeng[0] = "00";
		}

		String str = stryeti[0] + stryiniao[0] + strniaopin[0] + strduohan[0]
				+ strlinbajie[0] + strfutong[0] + strchangtaodie[0]
				+ strliudan[0] + strshizhen[0] + strkouchuang[0]
				+ strhuangdan[0] + strezhangfeng[0] + strjishi[0]
				+ strmianse[0] + strshezhi[0] + strchun[0];
		String str2 = stryeti[1] + stryiniao[1] + strniaopin[1] + strduohan[1]
				+ strlinbajie[1] + strfutong[1] + strchangtaodie[1]
				+ strliudan[1] + strshizhen[1] + strkouchuang[1]
				+ strhuangdan[1] + strezhangfeng[1] + strjishi[1]
				+"面色："+ strmianse[1] + "  舌质："+strshezhi[1] +"  唇色："+ strchun[1];

		System.out.println(str + "9999999999999999999999998888888888888888888");
		System.out.println(stryeti[1] + "中国好系统666666666666666666666666");

		if (stryeti[0].equals("00") && stryiniao[0].equals("00")
				&& strniaopin[0].equals("00") && strduohan[0].equals("00")
				&& strlinbajie[0].equals("00") && strfutong[0].equals("00")
				&& strchangtaodie[0].equals("00") && strliudan[0].equals("00")
				&& strshizhen[0].equals("00") && strkouchuang[0].equals("00")
				&& strhuangdan[0].equals("00") && strezhangfeng[0].equals("00")
				&& strjishi[0].equals("00")) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请选择病症！');");
			out.println("window.location.href=\"addzhenduanqita.jsp\"");
			out.println("</script>");
			return;
		}
		if (zybh == null || zybh.equals("")) {
			zybh = "040";
		}
		System.out.println(zybh + "niaoooooooooooooooooooooooooooooo");
		request.getSession().setAttribute("zybh", zybh);
		PlanDao planDao = new PlanDaoImpl();
		System.out.println(str + "   ppp");
		Plan plan = planDao.getQidongZhihuiPlanZzbh(str);
		ZhuyiDao zhuyiDao = new ZhuyiDaoImpl();
		System.out.println("1" + zybh + "1");
		Zhuyi zhuyi = zhuyiDao.getZhuyi(zybh);
		System.out.println(zhuyi.getZhuyi() + "feiangkkkkkkkkkkkkkkkkkkkkkkkkk");
		plan.setZhuyi(zhuyi.getZhuyi());

		System.out.println("其他编号：" + str);
		System.out.println("其他处方为：" + str2);

		// 用于修改处方标识
		String change_i = "3";
		request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("str2", str2);
		// 标识结束
		// 设置处方错误
		try {
			plan.setZzbh(str2);
			System.out.println(123);
			request.getSession().setAttribute("plan", plan);
			// 2、保存诊断记录
			Record rd = new Record();
			rd.setDyzz(str2);
			rd.setDycf(plan.getChufang());
			rd.setDysf(plan.getShoufa());
			rd.setDyzy(plan.getZhuyi());

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
					recordDao.save(rd);

					List<Record> tt = recordDao.sel(nowTime);
					request.getSession().setAttribute("tt", tt);
					// Record tt=recordDao.sel(nowTime);
					// int cid=tt.getCid();
					// request.getSession().setAttribute("cid",cid);

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

					List<Record> tt = recordDao.sel(nowTime);
					request.getSession().setAttribute("tt", tt);
					// Record tt=recordDao.sel(nowTime);
					// int cid=tt.getCid();
					// request.getSession().setAttribute("cid",cid);

					request.getSession().setAttribute("patient", patient);
					response.sendRedirect("planDetial.jsp");
				} else {
					// 提交失败
				}
			}
		} catch (Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('暂无处方');");
			out.println("window.location.href=\"addzhenduanqita.jsp\"");
			out.println("</script>");
		}

		out.close();
	}

}
