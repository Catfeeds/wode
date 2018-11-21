/**
 * 
 */
package com.dao.impl;

import java.util.List;

import com.bean.Keneng;
import com.dao.BaseDao;
import com.dao.KenengDao;

/**
 * 
 *  
 *
 */
public class KenengDaoImpl extends BaseDao implements KenengDao{

	/* (non-Javadoc)
	 * @see com.dao.KenengDao#getKeneng(java.lang.String)
	 */
	public Keneng getKeneng(String bh) {
		// TODO Auto-generated method stub
		List<Keneng> l=this.executeQuery("select * from KENENG where bh='"+bh+"'", null, Keneng.class);
		if(l.size()>0)
			return l.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.KenengDao#updateKeneng(java.lang.String)
	 */
	public void updateKeneng(String bh,String bz,String qk) {
		// TODO Auto-generated method stub
		
		this.executeUpdate1("update KENENG set BINGZHENG='"+bz+"',QINGKUANG='"+qk+"' where BH='"+bh+"'", null);
		
	}

} 
