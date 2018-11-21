package com.dao;

import java.util.List;

import com.bean.Fankuiyijian;
import com.bean.Patient;
import com.bean.User;

public interface PatientDao {

	public List<Patient> getpatients(String name, String phone, String sex, User user,int i,int uid);

	public String save(Patient p);

	public Patient getPatientById(int pid);

	public int getpatientCount(String name, String phone, String sex, User user,int uid);

	public String getPnameByPid(int pid);
	
	public int selPnameChongfu(String pname,int userid);
	
	public int selPnPoChongfu(String pname, int userid,String pphone);
	
	public int selPatientShuliang(int userid);
	
	public String saveFankuiyijian(Fankuiyijian f);

}
