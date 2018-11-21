package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Fenbu;
import com.bean.Money;
import com.bean.User;
import com.dao.BaseDao;
import com.dao.FenbuDao;

public class FenbuDaoImpl extends BaseDao implements FenbuDao {

	public List<User> getFenbuList(int uid,String name,String phone,String upower,User user,int i) {
		// TODO Auto-generated method stub
		System.out.println("姓名"+name);
		String sql="select * from buser where 1=1 ";
		if(uid>0&&user.getUpower()==1) {
			sql+=" and sjid like'"+uid+"'";
		}
		if(name!=null&&!name.equals("")) {
			sql+=" and uname like'"+"%"+name.trim()+"%"+"'";
		}
		if(phone!=null&&!phone.equals(""))
		{
			sql+=" and loginname like'"+"%"+phone.trim()+"%"+"'";
		}
		if(upower!=null&&!upower.equals("")) {
			sql+=" and upower='"+upower.trim()+"'";
		}
		
//		if(user.getUpower()==0) {
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		} else if(user.getUpower()==1){
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		} else {
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		}
		sql=sql+"ORDER BY starttime DESC";
		System.out.println(sql);
		sql="SELECT * FROM ( SELECT BUSER.*, ROWNUM RN FROM ("+sql+") BUSER WHERE ROWNUM <= "+20*i+" ) WHERE RN >="+(20*(i-1)+1);
		return this.executeQuery(sql, null, User.class);
	}
	
	
	public int getfenbuCount(int uid,String name,String phone,String upower,User user){

		// TODO Auto-generated method stub
		String sql="select * from buser where 1=1 ";
		if(uid>0&&user.getUpower()==1) {
			sql+=" and sjid like'"+uid+"'";
		}
		if(name!=null&&!name.equals("")) {
			sql+=" and uname like'"+"%"+name+"%"+"'";
		}
		if(phone!=null&&!phone.equals(""))
		{
			sql+=" and loginname like'"+"%"+phone+"%"+"'";
		}
		if(upower!=null&&!upower.equals("")) {
		sql+=" and upower='"+upower+"'";
	}
//		
//		if(user.getUpower()==0&&user.getFid()==1) {
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		} else if(user.getUpower()==1){
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		} else {
//			sql+=" and fid = "+user.getFid();
//			sql+=" and crid= "+user.getUserid();
//		}
		return this.executeQuery(sql, null, User.class).size();
	
	}

	public String getFenbuNameById(int fid) {
		// TODO Auto-generated method stub
		List<Fenbu> l = this.executeQuery("select * from fenbu where fid="
				+ fid, null, Fenbu.class);
		if (l.size() > 0)
			return l.get(0).getFname();
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.FenbuDao#check(java.lang.String)
	 */
	public String check(String trim) {
		// TODO Auto-generated method stub
		List<Fenbu> l = this.executeQuery("select * from fenbu where fname='"
				+ trim+"'", null, Fenbu.class);
		if(l!=null&&l.size()>0)
			return "yes";
		return "no";
	}

	/* (non-Javadoc)
	 * @see com.dao.FenbuDao#save(java.lang.String)
	 */
	public String moneysave(String fname,String fphone,int moneys,int userid) {
		// TODO Auto-generated method stub
		String agent=null;
		List list = new ArrayList();
		list.add(fname);
		list.add(fphone);
		list.add(moneys);
		list.add(userid);
		try {
			agent=this.executeUpdatefenbu("insert into money values(seq_moneyid.nextval,?,?,?,?)", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agent;
	}

	/* (non-Javadoc)
	 * @see com.dao.FenbuDao#update(java.lang.String, java.lang.String)
	 */
	public void update(String fid, String fname) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add(fname);
		list.add(fid);
		try {
			this.executeUpdate1("update fenbu set fname=? where fid=?", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改人员的信息前的查询
	public List<Fenbu> getFenbuxinxi(String checkbox){
		// TODO Auto-generated method stub
		String sql="select * from fenbu where fid='"+checkbox+"'";
		System.out.print("sql=="+sql);
		List<Fenbu> l=this.executeQuery(sql, null, Fenbu.class);
		return l;
	
	}
	
	public List<User> getXjList(int intuid){
		// TODO Auto-generated method stub
		String sql="select * from buser where sjid='"+intuid+"'";
		System.out.print("sql=="+sql);
		List<User> l=this.executeQuery(sql, null, User.class);
		return l;
	
	}
	
	
	public int updateXjList(int intuid) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add(intuid);
		int count=0;
		try {
			count=this.executeUpdate1("update buser set uclick=0 where sjid=?", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	//每次登录时，用于查询在money表中所登录的userid，登录一次减一次钱数
	public List<Money> getUserid(int userid){
		String sql="select * from money where userid='"+userid+"'";
		System.out.print("getUserid---sql=="+sql);
		List<Money> l=this.executeQuery(sql, null, Money.class);
		return l;
		
	}
	//和上面是一起的，上面查出登录人的所剩次数，然后用此方法修改——登录一次减少一次
	//充值的时候也用这两个方法，只是由减变为加。
	public int updateNumber(int uid,int numbers){
		List list = new ArrayList();
		list.add(numbers);
		list.add(uid);
		int u=0;
		try {
			u=this.executeUpdate1("update money set numbers=? where userid=?", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	//修改客户的结束时间
		public int updateJieShuDate(String jstime,int uid,int upowers,String starttime){
			List list = new ArrayList();
			list.add(jstime);
			list.add(upowers);
			list.add(starttime);
			list.add(uid);
			int u=0;
			try {
				u=this.executeUpdate1("update buser set ystime=?,upower=?,starttime=? where userid=?", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return u;
		}
		//得到money表的剩余次数
		public int getMoneynmb(int userid) {
			// TODO Auto-generated method stuby
			List<Money> list = this.executeQuery("select * from money where userid="+userid, null, Money.class);
			if(list.size()>0)
				return list.get(0).getNumbers();
			return 0;
		}
		
		//给用户重置密码
		public int updatePass(int uid){
			List list = new ArrayList();
			list.add(uid);
			int u=0;
			try {
				u=this.executeUpdate1("update buser set upassword=123 where userid=?", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return u;
		}

}
