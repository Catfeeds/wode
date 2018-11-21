package com.dao;

import java.util.Date;
import java.util.List;

import com.bean.User;

public interface UserDao {

	public boolean checkIp(String username, String clientIp);
	
	public User checkUser(String username, String userpassword, Date ystime);

	public List<User> getUserList(String name, String post, String fname, int i);

	public List<User> getUserNameById(int crid);
	
	public List<User> getUserPhone(String phone);

	public int getUserList(String name, String post, String fname);
	

	public String save(String uname,String upassword,int fid,int sjid,int upower,String phone,String haslogin,String jieshutime,String clientip1,
			String diaming,String name,int xjclick,int sumuclick,int uclick,String  address,String qq,String weixin,String starttime,
			String zhujiaoname,String zhucetime,int course,String coursestart,String courseend);

	public void resetPassword(String userid);

	public User getUserById(String userid);

	public void update(User user);
	
	public User getUserPass(int userid);
	
	public void changePass(int userid,String newpass);
	
	
	public List<User> checklogname(String loginname);

	/**
	 * @param userid
	 */
	public void updateSatus(int userid);
	
	public int updateUlick(int uclick,int sumuclick,int userid);
	
	public List<User> addagentchaxun();
	
	//修改客户的助教老师时间
	public int updateZhujiao(int uid,int zhujiaoid,String zhujiaoname);
	

}
