package com.dao;

import java.util.List;

import com.bean.Photo;
import com.bean.User;

public interface PhotoDao {
	List<Photo> getphoto(String purl, String pname, String ppower);

	public String save(Photo p);

}
