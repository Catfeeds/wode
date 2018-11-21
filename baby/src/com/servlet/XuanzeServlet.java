package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XuanzeServlet extends HttpServlet {

	public XuanzeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String str2ganke = "否";//鼻塞
		String str2kechuan= "否";//流涕
		String str2kesouyoutan = "否";//打喷嚏
		
		String str2bisai = "否";//鼻塞
		String str2liuti = "否";//流涕
		String str2dapenti = "否";//打喷嚏
		String str2yantong = "否";//咽痛
		//String str2ganke = "否";
		//String str2kesouyoutan = "否";
		//String str2mcyfmwd = "否";
		//String str2liuhan = "否";
		String str2yanshi = "否";//厌食
		String str2outu = "否";//呕吐
		String str2ganmaofuxie = "否";//腹泻
		String str2futong = "否";//腹痛
		String str2toutong = "否";//头痛
		String str2touyun = "否";//头晕
		String str2bttzd = "否";//扁桃体肿大
		
		String str2shiyucha = "否";//食欲差
		String str2tiaoshi = "否";//挑食
//		String str2yanshi = "否";//厌食
		String str2youkouqi = "否";//有口气
		String str2shetaihou = "舌苔不厚";//舌苔厚
		
		String str2yanshen = "目光有神";
		String str2chuzhen = "正常";
		String str2wenzhen = "正常";
		String str2mianse = "淡黄";
		String str2xiayandai = "红";
		String str2biliang = "正常";
		String str2biyiliangce = "正常";
		String str2chunse = "淡红";
		String str2shezhi = "正常";
		String str2shezhiyanse = "正常";
		String str2shetai = "薄白";
		String str2yanhou = "正常";
		String str2sheti = "正常";
		String str2xingzhuang = "坚硬";
		String str2fuxiexingzhuang = "不消化物";
		String str2qiwei = "正常";
		String str2dabianyanse = "黄";
		String str2kouqiang = "正常";
		String str2dushu = "单击输入";
		
		String ganke = "01_不干咳";
		String kechuan = "01_不咳喘";
		String bisai = "01_不鼻塞";
		String liuti = "01_不流涕";
		String dapenti = "01_不打喷嚏";
		String yantong = "01_不咽痛";
		String yanshi = "01_不厌食";
		String outu = "01_不呕吐";
		String ganmaofuxie = "01_不腹泻";
		String futong = "01_不腹痛";
		String toutong = "01_不头痛";
		String touyun = "01_不头晕";
		String kesouyoutan = "01_咳嗽无痰";
		String bttzd = "01_扁桃体不肿大";
		
		
		String shiyucha = "01_食欲不差";//食欲差
		String tiaoshi = "01_不挑食";//挑食
//		String str2yanshi = "否";//厌食
		String youkouqi = "01_无口气";//有口气
		String shetaihou = "01_舌苔不厚";//舌苔厚
		
		
		String mcyfmwd = "01_否";
		String liuhan = "01_否";
		String yanshen = "01_目光有神";
		String chuzhen = "01_正常";
		String wenzhen = "01_正常";
		String mianse = "01_淡黄_01";
		String xiayandai = "01_红_04";
		String biliang = "01_正常";
		String biyiliangce = "01_正常";
		String chunse = "01_淡红_07";
		String shezhi = "01_正常_13";
		String shezhiyanse = "01_正常";
		String shetai = "01_薄白_19";
		String yanhou = "01_正常";
		String sheti = "01_正常_10";
		String xingzhuang = "01_坚硬";
		String fuxiexingzhuang = "01_不消化物";
		String qiwei = "01_正常";
		String dabianyanse = "01_黄";
		String kouqiang = "01_正常_24";
		String dushu = "_";

		
		request.getSession().setAttribute("ganke", ganke);
		request.getSession().setAttribute("kechuan", kechuan);
		request.getSession().setAttribute("kesouyoutan", kesouyoutan);
		
		request.getSession().setAttribute("bisai", bisai);
		request.getSession().setAttribute("liuti", liuti);
		request.getSession().setAttribute("dapenti", dapenti);
		request.getSession().setAttribute("yantong", yantong);
//		request.getSession().setAttribute("ganke", ganke);
		request.getSession().setAttribute("yanshi", yanshi);
		request.getSession().setAttribute("outu", outu);
		request.getSession().setAttribute("ganmaofuxie", ganmaofuxie);
		request.getSession().setAttribute("futong", futong);
		request.getSession().setAttribute("toutong", toutong);
		request.getSession().setAttribute("touyun", touyun);
		request.getSession().setAttribute("bttzd", bttzd);
		
		request.getSession().setAttribute("shiyucha", shiyucha);
		request.getSession().setAttribute("tiaoshi", tiaoshi);
		request.getSession().setAttribute("youkouqi", youkouqi);
		request.getSession().setAttribute("shetaihou", shetaihou);
		
		
		
		
		
		request.getSession().setAttribute("mcyfmwd", mcyfmwd);
		request.getSession().setAttribute("liuhan", liuhan);
		request.getSession().setAttribute("yanshen", yanshen);
		request.getSession().setAttribute("chuzhen", chuzhen);
		request.getSession().setAttribute("wenzhen", wenzhen);
		request.getSession().setAttribute("mianse", mianse);
		request.getSession().setAttribute("xiayandai", xiayandai);
		request.getSession().setAttribute("biliang", biliang);
		request.getSession().setAttribute("str2biyiliangce", biyiliangce);
		request.getSession().setAttribute("chunse", chunse);
		request.getSession().setAttribute("shezhi", shezhi);
		request.getSession().setAttribute("shezhiyanse", shezhiyanse);
		request.getSession().setAttribute("shetai", shetai);
		request.getSession().setAttribute("yanhou", yanhou);
		request.getSession().setAttribute("sheti", sheti);
		request.getSession().setAttribute("xingzhuang", xingzhuang);
		request.getSession().setAttribute("fuxiexingzhuang", fuxiexingzhuang);
		request.getSession().setAttribute("qiwei", qiwei);
		request.getSession().setAttribute("dabianyanse", dabianyanse);
		request.getSession().setAttribute("kouqiang", kouqiang);
		request.getSession().setAttribute("dushu", dushu);

		
		request.getSession().setAttribute("str2ganke", str2ganke);
		request.getSession().setAttribute("str2kechuan", str2kechuan);
		request.getSession().setAttribute("str2kesouyoutan", str2kesouyoutan);
		request.getSession().setAttribute("str2shiyucha", str2shiyucha);
		request.getSession().setAttribute("str2tiaoshi", str2tiaoshi);
		request.getSession().setAttribute("str2youkouqi", str2youkouqi);
		request.getSession().setAttribute("str2shetaihou", str2shetaihou);
		
//		request.getSession().setAttribute("str2mcyfmwd", str2mcyfmwd);
//		request.getSession().setAttribute("str2liuhan", str2liuhan);
		
		
		request.getSession().setAttribute("str2bisai", str2bisai);
		request.getSession().setAttribute("str2liuti", str2liuti);
		request.getSession().setAttribute("str2dapenti", str2dapenti);
		request.getSession().setAttribute("str2yantong", str2yantong);
		request.getSession().setAttribute("str2yanshi", str2yanshi);
		request.getSession().setAttribute("str2outu", str2outu);
		request.getSession().setAttribute("str2ganmaofuxie", str2ganmaofuxie);
		request.getSession().setAttribute("str2futong", str2futong);
		request.getSession().setAttribute("str2toutong", str2toutong);
		request.getSession().setAttribute("str2touyun", str2touyun);
		request.getSession().setAttribute("str2bttzd", str2bttzd);
		
		
		request.getSession().setAttribute("str2yanshen", str2yanshen);
		request.getSession().setAttribute("str2chuzhen", str2chuzhen);
		request.getSession().setAttribute("str2wenzhen", str2wenzhen);
		request.getSession().setAttribute("str2mianse", str2mianse);
		request.getSession().setAttribute("str2xiayandai", str2xiayandai);
		request.getSession().setAttribute("str2biliang", str2biliang);
		request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
		request.getSession().setAttribute("str2chunse", str2chunse);
		request.getSession().setAttribute("str2shezhi", str2shezhi);
		request.getSession().setAttribute("str2shezhiyanse", str2shezhiyanse);
		request.getSession().setAttribute("str2shetai", str2shetai);
		request.getSession().setAttribute("str2yanhou", str2yanhou);
		request.getSession().setAttribute("str2sheti", str2sheti);
		request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
		request.getSession().setAttribute("str2fuxiexingzhuang", str2fuxiexingzhuang);
		request.getSession().setAttribute("str2qiwei", str2qiwei);
		request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
		request.getSession().setAttribute("str2kouqiang", str2kouqiang);
		request.getSession().setAttribute("str2dushu", str2dushu);
		
		String leibie = request.getParameter("xz");
		
		 if(leibie!=null){
			 if (leibie.equals("00")) {
					
					request.getRequestDispatcher("addzhenduanshanghuxidao.jsp").forward(request,
							response);
				}
			if (leibie.equals("01")) {
				
				request.getRequestDispatcher("addzhenduanganmaofashao.jsp").forward(request,
						response);
			}
			if (leibie.equals("02")) {
				request.getRequestDispatcher("addzhenduanganmaokesou.jsp").forward(request,
						response);
			}
			if (leibie.equals("03")) {
				request.getRequestDispatcher("addzhenduanfuxie.jsp").forward(request,
						response);
			}
			if (leibie.equals("04")) {
				request.getRequestDispatcher("addzhenduanbianmi.jsp").forward(request,
						response);
			}
			if (leibie.equals("05")) {
				request.getRequestDispatcher("addzhenduanjishi.jsp").forward(request,
						response);
			}
			if (leibie.equals("06")) {
				request.getRequestDispatcher("addzhenduanbaojian.jsp").forward(request,
						response);
			}
			if (leibie.equals("07")) {
				request.getRequestDispatcher("addzhenduantigaomianyili.jsp").forward(request,
						response);
			}
			if (leibie.equals("08")) {
				request.getRequestDispatcher("addzhenduanqidongzhihui.jsp").forward(request,
						response);
			}
			if (leibie.equals("09")) {
				request.getRequestDispatcher("addzhenduanoutu.jsp").forward(request,
						response);
			}
			if (leibie.equals("10")) {
				request.getRequestDispatcher("addzhenduanbiyan.jsp").forward(request,
						response);
			}
			if (leibie.equals("11")) {
				request.getRequestDispatcher("addzhenduanmxkesou.jsp").forward(request,
						response);
			}
			if (leibie.equals("12")) {
				request.getRequestDispatcher("addzhenduanyanyan.jsp").forward(request,
						response);
			}
		
		 }else{
			 request.getRequestDispatcher("xuanzejiemian.jsp").forward(request,
						response);
				return;
		 }
	}

}
