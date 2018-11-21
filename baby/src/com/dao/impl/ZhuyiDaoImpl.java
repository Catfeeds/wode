/**
 * 
 */
package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Plan;
import com.bean.Richang;
import com.bean.Shipin;
import com.bean.Tiaoli;
import com.bean.Zhuyi;
import com.dao.BaseDao;
import com.dao.PlanDao;
import com.dao.ZhuyiDao;

/**
 * @author 石可旺  Email：huandu01@163.com
 *
 */
public class ZhuyiDaoImpl extends BaseDao implements ZhuyiDao{

	public Zhuyi getZhuyi(String str){
		
		List<Zhuyi> list=this.executeQuery("select * from zhuyi where bh='"+str+"'", null, Zhuyi.class);
		if(list.size()>0) {
			return  list.get(0);
		}
		return null;	
	}
	//健康护理中，各个调理的查询
	public Tiaoli getTiaoli(int bh){
		
		List<Tiaoli> list=this.executeQuery("select * from tiaoli where TLID="+bh+"", null, Tiaoli.class);
		if(list.size()>0) {
			return  list.get(0);
		}
		return null;	
	}

	
	public void updateZhuyi(String bh,String bz,String zy){
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update ZHUYI set BINGZHENG='"+bz+"', ZHUYI='"+zy+"' where BH='"+bh+"'", null);
	
	}
	
	public Richang getRichang(int rc){
		
		List<Richang> list=this.executeQuery("select * from richang where rcid='"+rc+"'", null, Richang.class);
		if(list.size()>0) {
			return  list.get(0);
		}
		return null;
		
	}
	
	//父母必看中，各个视频的查询
		public Shipin getShipin(int bh){
			
			List<Shipin> list=this.executeQuery("select * from shipin where SPID="+bh+"", null, Shipin.class);
			if(list.size()>0) {
				return  list.get(0);
			}
			return null;	
		}

}
