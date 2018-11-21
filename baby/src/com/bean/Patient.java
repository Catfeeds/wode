package com.bean;

/**
 * 
 * @author 石可旺
 * 
 */
public class Patient {
	private int pid;
	private String pname;
	private String pxb;
	private String pborn;
	private String ppname;
	private String pphone;
	private String paddress;
	private String others;
	private int crid;// 外键，该用户的创建者id，对应用户表userid;
	private int fid;
	private String page;
	private String qq;
	private String weixin;

	
	
	
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPxb() {
		return pxb;
	}

	public void setPxb(String pxb) {
		this.pxb = pxb;
	}

	public String getPborn() {
		return pborn;
	}

	public void setPborn(String pborn) {
		this.pborn = pborn;
	}

	public String getPpname() {
		return ppname;
	}

	public void setPpname(String ppname) {
		this.ppname = ppname;
	}

	public String getPphone() {
		return pphone;
	}

	public void setPphone(String pphone) {
		this.pphone = pphone;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}

}
