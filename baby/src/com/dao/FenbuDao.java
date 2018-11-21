package com.dao;

import java.util.List;

import com.bean.Fenbu;
import com.bean.Money;
import com.bean.User;

//系统管理-地区管理
public interface FenbuDao {

	List<User> getFenbuList(int uid,String name,String phone,String upower,User user,int i);
	
	int getfenbuCount(int uid,String name,String phone,String upower,User user);

	String getFenbuNameById(int fid);

	/**
	 * @param trim
	 * @return
	 */
	String check(String trim);

	/**
	 * @param fname
	 */
	public String moneysave(String fname,String fphone,int moneys,int userid);

	/**
	 * @param fid
	 * @param fname
	 */
	void update(String fid, String fname);
	
	List<Fenbu> getFenbuxinxi(String checkbox);
	
	List<User> getXjList(int intuid);
	
	public int updateXjList(int intuid);
	
	public List<Money> getUserid(int userid);
	
	public int updateNumber(int uid,int numbers);
	
	public int updateJieShuDate(String jstime,int uid,int upowers,String starttime);
	
	//得到money表的剩余次数
	public int getMoneynmb(int userid);
	//给用户充值密码
	public int updatePass(int uid);
}
