package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Record;
import com.bean.User;
import com.dao.BaseDao;
import com.dao.RecordDao;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	public void save(Record rd) {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		list.add(rd.getCtime());
		list.add(rd.getPid());
		list.add(rd.getUserid());
		list.add(rd.getFid());
		list.add(rd.getDyzz());
		list.add(rd.getDycf());
		list.add(rd.getDysf());
		list.add(rd.getDyzy());
		
		try {
			this.executeUpdaterecord(
					"insert into record values(seq_recordid.nextval,?,?,?,?,?,?,?,?,'0')",
					list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Record> sel(String nowTime){
		
		List<Record> tt = this.executeQuery("select * from record where CTIME = '"
				+ nowTime +"'", null, Record.class);
		return tt;
		
	}
	
	public List<Record> getRecordsByPid(int pid) {
		// TODO Auto-generated method stub
		List<Record> l = this.executeQuery("select * from record where pid = "
				+ pid + "ORDER BY CTIME desc", null, Record.class);
		return l;

	}

	public List<Record> getRecords(String name, String phone, String isdo, User user, int i) {
		// TODO Auto-generated method stub
		System.out.println("姓名是："+name);
		String sql = "select * from record where pid in"
				+ "(select pid from patient where 1=1 ";
		if (name != null && !name.equals("")) {
			sql += " and pname like '" +"%"+ name.trim()+"%" + "'";
		}
		if (phone != null && !phone.equals("")) {
			sql += " and pphone like '"+"%" + phone.trim()+"%" + "'";
		}
		sql += ") ";
		if (isdo != null && !isdo.equals("")) {
			sql += " and isdo='" + isdo + "'";
		}
		if(user.getUpower()==0) {
			
		} else if(user.getUpower()==1){
			sql+=" and fid = "+user.getFid();
			sql+="and userid="+user.getUserid();
		} else if(user.getUpower()==2){
			sql+="and userid="+user.getUserid();
			
		}
		sql = sql + "ORDER BY CTIME desc";
		System.out.println(sql);
		sql = "SELECT * FROM ( SELECT record.*, ROWNUM RN FROM (" + sql
				+ ") record WHERE ROWNUM <= " + 5 * i + " ) WHERE RN >="
				+ (5 * (i - 1) + 1);
		return this.executeQuery(sql, null, Record.class);
	}

	public void update(String id, int i) {
		// TODO Auto-generated method stub
		try {
			if (i == 0)
				this.executeUpdate1("update record set isdo='1' where cid="
						+ id, null);
			else
				this.executeUpdate1("update record set isdo='0' where cid="
						+ id, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRecordCount(String name, String phone, String isdo, User user) {
		String sql = "select * from record where pid in"
				+ "(select pid from patient where 1=1 ";
		if (name != null && !name.equals("")) {
			sql += " and pname like '"+"%" + name.trim()+"%" + "'";
		}
		if (phone != null && !phone.equals("")) {
			sql += " and pphone like '"+"%" + phone.trim()+"%" + "'";
		}
		sql += ") ";
		if (isdo != null && !isdo.equals("")) {
			sql += " and isdo='" + isdo + "'";
		}
		if(user.getUpower()==0) {
			
		} else if(user.getUpower()==1){
			sql+=" and fid = "+user.getFid();
			sql+=" and userid= "+user.getUserid();
		} else {
			sql+=" and fid = "+user.getFid();
			sql+=" and userid= "+user.getUserid();
		}
		System.out.println(sql);
		return this.executeQuery(sql, null, Record.class).size();
	}
	
	//为了限制一个宝宝一天中最多能录入三个病例
	public int getRecord(String sannowTime,int pid){
		String sql="select * from record where CTIME like '"+sannowTime+"' and PID='"+pid+"'";
		return this.executeQuery(sql, null, Record.class).size();
	}
	
	//查询宝宝病例中的详细信息然后展示到结果页面
	public Record getRecordsShow(String cid) {
		// TODO Auto-generated method stub
		List<Record> recordlist = this.executeQuery("select * from record where cid = "
				+ cid + "ORDER BY CTIME desc", null, Record.class);
		if(recordlist.size()>0)
			return recordlist.get(0);
		return null;

	}

}
