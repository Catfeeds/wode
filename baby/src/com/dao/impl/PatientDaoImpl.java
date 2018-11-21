package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Fankuiyijian;
import com.bean.Patient;
import com.bean.User;
import com.dao.BaseDao;
import com.dao.PatientDao;

public class PatientDaoImpl extends BaseDao implements PatientDao{

	//病人信息查询
	public List<Patient> getpatients(String name,String phone, String sex, User user,int i,int uid) {
		// TODO Auto-generated method stub
		System.out.println("姓名"+name);
		String sql="select * from patient where 1=1 ";
		if(name!=null&&!name.equals("")) {
			sql+=" and pname like'"+"%"+name.trim()+"%"+"'";
		}
		if(phone!=null&&!phone.equals(""))
		{
			sql+=" and pphone like'"+"%"+phone.trim()+"%"+"'";
		}
		if(sex!=null&&!sex.equals("")) {
			sql+=" and pxb='"+sex.trim()+"'";
		}
		
		if(user.getUpower()==0&&uid>0) {
			sql+="and crid= '"+uid+"'";
		} 
		if(user.getUpower()==0&&uid==0) {
			sql+=" and crid= "+user.getUserid();
		}else if(user.getUpower()==1||user.getUpower()==2||user.getUpower()==3){
			sql+=" and fid = "+user.getFid();
			sql+=" and crid= "+user.getUserid();
		} 
		sql=sql+"ORDER BY PID DESC";
		System.out.println(sql);
//		sql="SELECT * FROM ( SELECT patient.*, ROWNUM RN FROM ("+sql+") patient WHERE ROWNUM <= "+5*i+" ) WHERE RN >="+(5*(i-1)+1);
		return this.executeQuery(sql, null, Patient.class);
	}
//病人信息-信息录入
	public  synchronized String save(Patient p) {	
		// TODO Auto-generated method stub 
		List list = new ArrayList();
		list.add(p.getPname());
		list.add(p.getPxb());
		list.add(p.getPborn());
		list.add(p.getPpname());
		list.add(p.getPphone());
		list.add(p.getPaddress());
		list.add(p.getCrid());
		list.add(p.getFid());
		list.add(p.getPage());
		list.add(p.getQq());
		list.add(p.getWeixin());
		String seq_patientid="";
		try {
			seq_patientid=this.executeUpdatepatient("insert into patient values(seq_patientid.nextval,?,?,?,?,?,?,null,?,?,?,?,?)", list);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("增加病号后的序列为："+seq_patientid);
		return seq_patientid;
	}

	//通过id查询病人（留用）
	public Patient getPatientById(int pid) {
		// TODO Auto-generated method stub
		List<Patient> l = this.executeQuery("select * from patient where pid="+pid, null, Patient.class);
		if(l.size()>0)
			return l.get(0);
		return null;
	}
//通过登陆账号判断登录的人员（user）
	public int getpatientCount(String name, String phone, String sex, User user,int uid) {
		// TODO Auto-generated method stub
		String sql="select * from patient where 1=1 ";
		if(name!=null&&!name.equals("")) {
			sql+=" and pname like'"+"%"+name+"%"+"'";
		}
		if(phone!=null&&!phone.equals(""))
		{
			sql+=" and pphone like'"+"%"+phone+"%"+"'";
		}
		if(sex!=null&&!sex.equals("")) {
			sql+=" and pxb='"+sex+"'";
		}
		
		if(user.getUpower()==0&&uid>0) {
			sql+="and crid= '"+uid+"'";
		}
		if(user.getUpower()==0&&uid==0) {
			sql+=" and crid= "+user.getUserid();
		}else if(user.getUpower()==1||user.getUpower()==2||user.getUpower()==3){
			sql+=" and fid = "+user.getFid();
			sql+=" and crid= "+user.getUserid();
		}
		return this.executeQuery(sql, null, Patient.class).size();
	}

	public String getPnameByPid(int pid) {
		// TODO Auto-generated method stuby
		List<Patient> list = this.executeQuery("select * from patient where pid="+pid, null, Patient.class);
		if(list.size()>0)
			return list.get(0).getPname();
		return null;
	}
	
	//在添加宝宝时，查看宝宝是否已经存在
	public int selPnameChongfu(String pname,int userid){
		String sql="select * from patient where PNAME like '"+pname+"' and CRID='"+userid+"'";
		return this.executeQuery(sql, null, Patient.class).size();
	}
	
	public int selPnPoChongfu(String pname, int userid,String pphone){
		String sql="select * from patient where PNAME like '"+pname+"' and CRID='"+userid+"' and pphone='"+pphone+"'";
		return this.executeQuery(sql, null, Patient.class).size();
	}
	
	//判断用户下是否有录入的宝宝
	public int selPatientShuliang(int userid){
		String sql="select * from patient where CRID='"+userid+"'";
		return this.executeQuery(sql, null, Patient.class).size();
	}
	
	//添加反馈意见
	public  synchronized String saveFankuiyijian(Fankuiyijian f) {	
		// TODO Auto-generated method stub 
		List list = new ArrayList();
		list.add(f.getUserid());
		list.add(f.getUname());
		list.add(f.getFankuiyijian());
		list.add(f.getEmail());
		String seq_fkyijianid="";
		try {
			seq_fkyijianid=this.executeUpdateFankuiyijian("insert into FANKUIYIJIAN values(seq_fkyijianid.nextval,?,?,?,?)", list);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("增加病号后的序列为："+seq_fkyijianid);
		return seq_fkyijianid;
	}

}
