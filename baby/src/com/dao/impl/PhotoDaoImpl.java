package com.dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.PatientDao;
import com.bean.Patient;
import com.bean.Photo;
import com.bean.User;
import com.dao.BaseDao;
import com.dao.PhotoDao;

public class PhotoDaoImpl extends BaseDao implements PhotoDao {

	public List<Photo> getphoto(String purl, String pname, String ppower) {
		// TODO Auto-generated method stub
		String sql = "select * from photo_new where 1=1 ";
		if (ppower != null && !ppower.equals("")) {
			sql += " and ppower='" + ppower.trim() + "'";
		}
		System.out.println(sql);
		return this.executeQuery(sql, null, Photo.class);
	}

	public String save(Photo p) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add(p.getPurl());
		list.add(p.getPname());
		list.add(p.getPpower());
		
		String sql = "";
		try {
			sql = this.executeUpdate(
					"insert into photo values(seq_id.nextval,?,?,?)", list);
			System.out.println("图片保存成功");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sql;
	}

}
