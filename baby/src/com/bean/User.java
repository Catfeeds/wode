package com.bean;

import java.util.Date;

/**
 * @author 石可旺
 */
public class User {
	private int userid;
	private String uname;
	private String upassword;
	private int fid;// 外键，所属地区（分部），对应分部表fid
	private int crid;// 外键，该用户的创建者id，对应本表userid
	private int upower;// 用户权限
	private String loginName;
	private String ystime;
	
	private String dianming;
	private String hasLogin;
	
	private String clientIp1;
	private String name;
	private int sjid;
	private int uclick;
	private int sumuclick;
	private String starttime;
	private String zhujiao;
	private int numbers;
	private String zhucetime;
	
	
	
	
	
	
	
	/**
	 * @return the zhucetime
	 */
	public String getZhucetime() {
		return zhucetime;
	}

	/**
	 * @param zhucetime the zhucetime to set
	 */
	public void setZhucetime(String zhucetime) {
		this.zhucetime = zhucetime;
	}

	/**
	 * @return the numbers
	 */
	public int getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public String getZhujiao() {
		return zhujiao;
	}

	/**
	 * @param zhujiao the zhujiao to set
	 */
	public void setZhujiao(String zhujiao) {
		this.zhujiao = zhujiao;
	}

	public int getSumuclick() {
		return sumuclick;
	}

	public void setSumuclick(int sumuclick) {
		this.sumuclick = sumuclick;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public int getUclick() {
		return uclick;
	}

	public void setUclick(int uclick) {
		this.uclick = uclick;
	}

	public String getDianming() {
		return dianming;
	}

	public int getSjid() {
		return sjid;
	}

	public void setSjid(int sjid) {
		this.sjid = sjid;
	}

	public void setDianming(String dianming) {
		this.dianming = dianming;
	}
	
	
	public String getClientIp1() {
		return clientIp1;
	}

	
	public void setClientIp1(String clientip1) {
		this.clientIp1 = clientip1;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	String fenbuName;
	String createName;
	String postName;
	
	
	public String getHasLogin() {
		return hasLogin;
	}

	/**
	 * @param hasLogin the hasLogin to set
	 */
	public void setHasLogin(String hasLogin) {
		this.hasLogin = hasLogin;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getFenbuName() {
		return fenbuName;
	}

	public void setFenbuName(String fenbuName) {
		this.fenbuName = fenbuName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	// /
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}

	public int getUpower() {
		return upower;
	}

	public void setUpower(int upower) {
		this.upower = upower;
	}
	
	public void setYstime(String ystime) {
		this.ystime = ystime;
	}
	
	public String getYstime() {
		return ystime;
	}

}
