package com.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Fenbu;
import com.bean.User;
import com.dao.BaseDao;
import com.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	public boolean checkIp(String username, String clientIp) {
		boolean flag = false;
		String cip = clientIp; 
		
		String sql = "select * from BUSER where loginname='" + username + "'";
		List<User> userlist = this.executeQuery(sql, null, User.class);
		
		if(userlist.size()>0) {
			User u = userlist.get(0);
			
			if(u.getClientIp1()==null&&flag==false) {
				this.executeUpdate1("update buser set clientip1='"+cip+"' where userid="+u.getUserid(), null);
				System.out.println("一");
				flag = true;
			} else if(cip.equals(u.getClientIp1())) {
				System.out.println("二");
				flag = true;
			}
		}
		return flag;
	}

	
	public User checkUser(String loginname, String userpassword, Date dt) {
		List list = new ArrayList();
		list.add(loginname);
		System.out.println(loginname);
		String sql = "select * from BUSER where loginname='" + loginname + "'";
		List<User> userlist = this.executeQuery(sql, null, User.class);
		System.out.println(userlist.size()+"   iii");
		if (userlist.size() > 0) {
			User u = userlist.get(0);
			if (u.getUpassword().equals(userpassword)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sdt1 = sdf.format(dt);
				String sdt2 = u.getYstime();
				int res = sdt1.compareTo(sdt2);
				u.setHasLogin(res+"");
				/*注：res大于0，则t1>t2；
			       res等于0，则t1=t2；
			       res小于0，则t1<t2；*/
				try {
					this.executeUpdate1("update  buser set hasLogin='1' where userid="+u.getUserid(), null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return u;
			}
		}
		
		return null;
	}

	public List<User> getUserList(String name, String post, String fname, int i) {
		// TODO Auto-generated method stub
		String sql = "select * from buser where 1=1 ";
		if (name != null && !name.equals("")) {
			sql += " and uname='" + name.trim() + "'";
		}
		if (post != null && !post.equals("")) {
			sql += " and upower=" + post.trim();
		}

		if (fname != null && !fname.equals("")) {
			sql += " and fid=" + fname.trim();
		}
		System.out.println(sql);
		sql = "SELECT * FROM ( SELECT buser.*, ROWNUM RN FROM (" + sql
				+ ") buser WHERE ROWNUM <= " + 5 * i + " ) WHERE RN >="
				+ (5 * (i - 1) + 1);
		return this.executeQuery(sql, null, User.class);
	}

	public List<User> getUserNameById(int crid) {
		// TODO Auto-generated method stub
		List<User> l = this.executeQuery("select * from buser where userid="
				+ crid, null, User.class);
		if (l.size() > 0)
			return l;
		return null;
	}
	
	public List<User> getUserPhone(String phone) {
		// TODO Auto-generated method stub
		List<User> pho = this.executeQuery("select * from buser where LOGINNAME="
				+ phone, null, User.class);
		
		return pho;
	}

	public int getUserList(String name, String post, String fname) {
		// TODO Auto-generated method stub
		String sql = "select * from buser where 1=1 ";
		if (name != null && !name.equals("")) {
			sql += " and uname='" + name.trim() + "'";
		}
		if (post != null && !post.equals("")) {
			sql += " and upower=" + post.trim();
		}

		if (fname != null && !fname.equals("")) {
			sql += " and fid=" + fname.trim();
		}
		return this.executeQuery(sql, null, User.class).size();
	}

	public String save(String uname,String upassword,int fid,int sjid,int upower,String phone,String haslogin,String jieshutime,String clientip1,
			String diaming,String name,int xjclick,int sumuclick,int uclick,String  address,String qq,String weixin,String starttime,String zhujiaoname,
			String zhucetime,int course,String coursestart,String courseend) {
		// TODO Auto-generated method stub
		String agent=null;
		List list = new ArrayList();
		list.add(uname);
		list.add(upassword);
		list.add(fid);
		list.add(sjid);
		list.add(upower);
		list.add(phone);
		list.add(haslogin);
		list.add(jieshutime);
		list.add(clientip1);
		list.add(diaming);
		list.add(name);
		list.add(xjclick);
		list.add(sumuclick);
		list.add(uclick);
		list.add(address);
		list.add(qq);
		list.add(weixin);
		list.add(starttime);
		list.add(zhujiaoname);
		list.add(zhucetime);
		list.add(course);
		list.add(coursestart);
		list.add(courseend);
		try {
			agent=this.executeUpdatebuser("insert into buser values(seq_buserid.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agent;
	}

	public void resetPassword(String userid) {
		// TODO Auto-generated method stub
		this.executeUpdate1("update buser set upassword= '123' where userid="
				+ userid, null);
	}

	public User getUserById(String userid) {
		// TODO Auto-generated method stub
		List<User> l = this.executeQuery("select * from buser where userid="
				+ userid, null, User.class);
		if (l.size() > 0)
			return l.get(0);
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		this.executeUpdate1("update buser set uname='" + user.getUname()
				+ "' ,fid=" + user.getFid() + ",upower=" + user.getUpower()
				+ " where userid=" + user.getUserid(), null);
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#getUserPass(java.lang.String)
	 */
	public User getUserPass(int userid) {
		// TODO Auto-generated method stub
		List<User> l = this.executeQuery("select * from buser where userid="
				+ userid, null, User.class);
		if (l.size() > 0)
			return l.get(0);
		return null;
	}
	
	public void changePass(int userid,String newpass){
		this.executeUpdate1("update buser set upassword='" + newpass
				+ " 'where userid=" + userid, null);	
		System.out.println("修改密码！");
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#checklogname(java.lang.String)
	 */
	public List<User> checklogname(String loginname) {
		// TODO Auto-generated method stub
		List<User> l=this.executeQuery("select * from buser where loginname='"+loginname+"'", null, User.class);
		if (l.size() > 0)
			return l;
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.UserDao#updateSatus(int)
	 */
	public void updateSatus(int userid) {
		// TODO Auto-generated method stub
		try {
			this.executeUpdate1("update  buser set hasLogin='0' where userid="+userid, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int updateUlick(int uclick,int sumuclick,int userid){
		try {
			this.executeUpdate1("update  buser set uclick='"+uclick+"',sumuclick='"+sumuclick+"' where userid="+userid, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	public List<User> addagentchaxun() {
		// TODO Auto-generated method stub
		List<User> l=this.executeQuery("select * from buser", null, User.class);
		if (l.size() > 0)
			return l;
		return null;
	}
	//修改客户的助教老师时间
		public int updateZhujiao(int uid,int zhujiaoid,String zhujiaoname){
			List list = new ArrayList();
			list.add(zhujiaoid);
			list.add(zhujiaoname);
			list.add(uid);
			int u=0;
			try {
				u=this.executeUpdate1("update buser set sjid=?,zhujiao=? where userid=?", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return u;
		}
       
}
