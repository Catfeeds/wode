/**
 * 
 */
package com.dao;

import com.bean.Keneng;

/**
 * @author 杜欢  Email：huandu01@163.com
 *
 */
//自主学习——注意事项
public interface KenengDao {
	public Keneng getKeneng(String bh);
	public void updateKeneng(String bh,String bz,String qk);
	

}
