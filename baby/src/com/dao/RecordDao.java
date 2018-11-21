package com.dao;

import java.util.List;

import com.bean.Record;
import com.bean.User;

public interface RecordDao {

	public void save(Record rd);
	
	public List<Record> sel(String nowTime);

	public List<Record> getRecordsByPid(int pid);

	public List<Record> getRecords(String name, String phone, String isdo, User user, int i);

	public void update(String id, int i);

	public int getRecordCount(String name, String phone, String isdo, User user);
	
	public int getRecord(String sannowTime,int pid);
	
	public Record getRecordsShow(String cid);

}
