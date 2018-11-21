package com.bean;



public class Record {

	private int cid;
	private String ctime;// 诊断时间
	private int pid;// 外键，病人id，对应病人表pid;
	private int userid;// 外键，对应医师id，对应用户表uid
	private int fid;
	private String dyzz;// 对应症状
	private String dycf;// 对应处方
	private String dysf;// 对应手法
	private String dyzy;// 对应注意事项
	private String pname;
	private String isdo;
	private String tel;
	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIsdo() {
		return isdo;
	}

	public void setIsdo(String isdo) {
		this.isdo = isdo;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getDyzz() {
		return dyzz;
	}

	public void setDyzz(String dyzz) {
		this.dyzz = dyzz;
	}

	public String getDycf() {
		return dycf;
	}

	public void setDycf(String dycf) {
		this.dycf = dycf;
	}

	public String getDysf() {
		return dysf;
	}

	public void setDysf(String dysf) {
		this.dysf = dysf;
	}

	public String getDyzy() {
		return dyzy;
	}

	public void setDyzy(String dyzy) {
		this.dyzy = dyzy;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
