/**
 * 
 */
package com.dao;

import com.bean.Richang;
import com.bean.Shipin;
import com.bean.Tiaoli;
import com.bean.Zhuyi;

/**
 *
 */
//自主学习-注意事项
public interface ZhuyiDao {
	public Zhuyi getZhuyi(String str);
	public void updateZhuyi(String bh,String bz,String zy);
	public Richang getRichang(int rc);
	public Tiaoli getTiaoli(int bh);
	public Shipin getShipin(int bh);

}
