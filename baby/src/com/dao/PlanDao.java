package com.dao;

import com.bean.Plan;
import com.bean.Record;
import com.bean.Tizheng;
import com.bean.Zhuyi;

public interface PlanDao {

	public Plan getGanmaoPlanZzbh(String str);
	public Plan getGanmaofashaoPlanZzbh(String str);
	public Plan getPlanByZzbh02(String str);
	public Plan geJishiPlanZzbh(String str);
	public Plan getPlanByZzbh04(String str);
	public Plan getPlanByZzbh05(String str);
	public Plan getPlanByZzbh06(String str);
	public Plan getPlanByZzbh07(String str);
	public Plan getBianmiPlanZzbh(String str);
	public Plan getBaojianPlanZzbh(String str);
	public Plan getPlanByZzbh13(String str);
	public Plan getFuxiePlanZzbh(String str);
	public Plan getPlanByZzbh2(String str);
	public Plan getQidongZhihuiPlanZzbh(String str);
	public Plan getTigaoMianYiliPlanZzbh(String str);
	public Plan getJishiPlanZzbh(String str);
	public Plan getOutuPlanZzbh(String str);
	
	public Plan getGanmaoKesouPlanZzbh(String str);
	public Plan getBiyanPlanZzbh(String str);
	public Plan getManxingkesouPlanZzbh(String str);
	public Plan getYanyanPlanZzbh(String str);
	
	public int updateRecord(Record record);
	
	public int updatePlan01(Plan plan);
	public int updatePlan02(Plan plan);
	public int updatePlan03(Plan plan);
	public int updatePlan04(Plan plan);
	public int updatePlan05(Plan plan);
	public int updatePlan06(Plan plan);
	public int updatePlan07(Plan plan);
	
	public int updatePlan1(Plan plan);
	public int updatePlan21(Plan plan);
	public int updatePlan22(Plan plan);
	public int updatePlan23(Plan plan);
	public int updatePlan24(Plan plan);
	public int updatePlanqita(Plan plan);
	public int updatePlanzenzi(Plan plan);
	public int updatePlanbaojian(Plan plan);
	
	public int updatePlan4(Plan plan);
	
	/**
	 * @param pid
	 * @return
	 */
	public Plan getPlan01(int pid);
	public Plan getPlan02(int pid);
	public Plan getPlan03(int pid);
	public Plan getPlan04(int pid);
	public Plan getPlan05(int pid);
	public Plan getPlan06(int pid);
	public Plan getPlan07(int pid);
	public Plan getPlan1(int pid);
	public Plan getPlan21(int pid);
	public Plan getPlan22(int pid);
	public Plan getPlan23(int pid);
	public Plan getPlan24(int pid);
	public Plan getPlanqita(int pid);
	public Plan getPlanzenzi(int pid);
	
	public Tizheng selganmaoxw(String tizheng);
	public Tizheng seljishixw(String tizheng);
	public Tizheng selfuxiexw(String tizheng);
	public Tizheng selbianmixw(String tizheng);
	public Tizheng selbaojianxw(String tizheng);
	public Tizheng seltimianxw(String tizheng);
	public Tizheng selqizhixw(String tizheng);
}
