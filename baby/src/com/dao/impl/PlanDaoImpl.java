package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Plan;
import com.bean.Record;
import com.bean.Tizheng;
import com.bean.Zhuyi;
import com.dao.BaseDao;
import com.dao.PlanDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.test;

public class PlanDaoImpl extends BaseDao implements PlanDao{ 

	//查询感冒其中包括感冒、感冒发烧、感冒咳嗽中的手法和穴位
	public Plan getGanmaoPlanZzbh(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan11 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}

	public Plan getGanmaoKesouPlanZzbh(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan12 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	public Plan getPlanByZzbh02(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan05 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	//查询积食中的手法和穴位
	public Plan geJishiPlanZzbh(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan02 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	public Plan getPlanByZzbh04(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan04 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	public Plan getPlanByZzbh05(String str) {
		// TODO Auto-generated method stub  
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan05 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	public Plan getPlanByZzbh06(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan06 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	
	public Plan getPlanByZzbh07(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}

	public  int updateRecord(Record record){
		
//		Connection con = null; //表示数据库的连接对象  
//        Statement stmt = null;
//        test t=new test();
//        conn=test.getCon();
//        stmt=conn.createStatement();
//        stmt.executeUpdate("update RECORD set DYCF='"+record.getDycf()+"', DYSF='"+record.getDysf()+"' where PID='"+record.getPid()+"'")
		List list=this.executeQuery("select * from RECORD where PID='"+record.getCid()+"'", null, Record.class);
		int count=this.executeUpdate1("update RECORD set DYCF='"+record.getDycf()+"', DYSF='"+record.getDysf()+"' where CID='"+record.getCid()+"'", null);
		return count;
		
	}
	
		
	public  int updatePlan01(Plan plan) {
		//修改上呼吸道
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN01 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	public  int updatePlan02(Plan plan) {
		//修改积食
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN02 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public  int updatePlan03(Plan plan) {
		// 修改便秘

		
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN03 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public  int updatePlan04(Plan plan) {
		// TODO Auto-generated method stub

		
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN04 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public  int updatePlan05(Plan plan) {
		// TODO Auto-generated method stub

		
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN05 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public  int updatePlan06(Plan plan) {
		// TODO Auto-generated method stub

		
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN06 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public  int updatePlan07(Plan plan) {
		// TODO Auto-generated method stub

		
		//List list=this.executeQuery("select * from t_plan where zzbh='"+plan.getChufang()+"'", null, Plan.class);
		int count=this.executeUpdate1("update T_PLAN07 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	
	//查询便秘中的手法和穴位
	public Plan getBianmiPlanZzbh(String str) {
		// TODO Auto-generated method stub
				List l =new ArrayList();
				l.add(str);
				List list=this.executeQuery("select * from t_plan14 where zzbh='"+str+"'", null, Plan.class);
				if(list.size()>0) {
					return (Plan) list.get(0);
				}
				return null;
	}
	//查询保健中的手法和穴位
	public Plan getBaojianPlanZzbh(String str) {
		// TODO Auto-generated method stub
				List l =new ArrayList();
				l.add(str);
				List list=this.executeQuery("select * from t_plan16 where zzbh='"+str+"'", null, Plan.class);
				System.out.println("进入了保健-----t_plan04");
				if(list.size()>0) {
					return (Plan) list.get(0);
				}
				return null;
	}

	public Plan getPlanByZzbh13(String str) {
		// TODO Auto-generated method stub
				List l =new ArrayList();
				l.add(str);
				List list=this.executeQuery("select * from t_plan13 where zzbh='"+str+"'", null, Plan.class);
				if(list.size()>0) {
					return (Plan) list.get(0);
				}
				return null;
	}
	//查询腹泻中的手法和穴位
	public Plan getFuxiePlanZzbh(String str) {
		// TODO Auto-generated method stub
				List l =new ArrayList();
				l.add(str);
				List list=this.executeQuery("select * from t_plan13 where zzbh='"+str+"'", null, Plan.class);
				if(list.size()>0) {
					return (Plan) list.get(0);
				}
				return null;
	}

	//查询积食中的手法和穴位
		public Plan getJishiPlanZzbh(String str) {
		// TODO Auto-generated method stub
				List l =new ArrayList();
				l.add(str);
				List list=this.executeQuery("select * from t_plan15 where zzbh='"+str+"'", null, Plan.class);
				if(list.size()>0) {
					return (Plan) list.get(0);
				}
				return null;
		}

	public Plan getPlanByZzbh2(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan2 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
//查询启动智慧中的手法和穴位
	public Plan getQidongZhihuiPlanZzbh(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan18 where zzbh='"+str+"'", null, Plan.class);
		System.out.println("进入了启动智慧-----t_plan08");
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}
	//查询提高免疫力中的手法和穴位
	public Plan getTigaoMianYiliPlanZzbh(String str) {
		// TODO Auto-generated method stub
		List l =new ArrayList();
		l.add(str);
		List list=this.executeQuery("select * from t_plan17 where zzbh='"+str+"'", null, Plan.class);
		if(list.size()>0) {
			return (Plan) list.get(0);
		}
		return null;
	}

	/**
	 * @param plan
	 */
	public int updatePlan1(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/**
	 * @param plan
	 */
	public int updatePlan21(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN03 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/**
	 * @param plan
	 */
	public int updatePlan22(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN12 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/**
	 * @param plan
	 */
	public int updatePlan23(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN13 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/**
	 * @param plan
	 */
	public int updatePlan24(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN14 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/**
	 * @param plan
	 */
	public int updatePlanqita(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN3 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	public int updatePlanbaojian(Plan plan) {
		// 修改保健
		
		int count=this.executeUpdate1("update T_PLAN04 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	
	/**
	 * @param plan
	 */
	public int updatePlanzenzi(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN2 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}
	
	public int updatePlan4(Plan plan) {
		// TODO Auto-generated method stub
		int count=this.executeUpdate1("update T_PLAN4 set CHUFANG='"+plan.getChufang()+"', SHOUFA='"+plan.getShoufa()+"' where ZZBH='"+plan.getZzbh()+"'", null);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan01(int)
	 */
	public Plan getPlan01(int pid) {
		// TODO Auto-generated method stub
		List l=new ArrayList();
		l.add(pid+"");
		List<Plan> plans=this.executeQuery("select * from T_PLAN01 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan02(int)
	 */
	public Plan getPlan02(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN02 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan03(int)
	 */
	public Plan getPlan03(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN03 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan04(int)
	 */
	public Plan getPlan04(int pid) {
		// TODO Auto-generated method stub
		//
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN04 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan05(int)
	 */
	public Plan getPlan05(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN05 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan06(int)
	 */
	public Plan getPlan06(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN06 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan07(int)
	 */
	public Plan getPlan07(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN07 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan1(int)
	 */
	public Plan getPlan1(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan21(int)
	 */
	public Plan getPlan21(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN11 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan22(int)
	 */
	public Plan getPlan22(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN12 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan23(int)
	 */
	public Plan getPlan23(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN13 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlan24(int)
	 */
	public Plan getPlan24(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN14 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlanqita(int)
	 * 
	 */
	public Plan getPlanqita(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN3 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dao.PlanDao#getPlanzenzi(int)
	 */
	public Plan getPlanzenzi(int pid) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		l.add(pid+"");
		List<Plan> plans = this.executeQuery("select * from T_PLAN2 where pid=?", l, Plan.class);
		if(plans.size()>0)
			return plans.get(0);
		return null;
	}
	
	//通过体征得到感冒、感冒发烧、感冒咳嗽的穴位
		public Tizheng selganmaoxw(String tizheng){

			List l = new ArrayList();
			l.add(tizheng);
			List<Tizheng> plans = this.executeQuery("select * from TIZHENG_01 where TZBH=?", l, Tizheng.class);
			if(plans.size()>0)
				return plans.get(0);
			return null;
		}
		
		//通过体征得到积食的穴位
		public Tizheng seljishixw(String tizheng){

			List l = new ArrayList();
			l.add(tizheng);
			List<Tizheng> plans = this.executeQuery("select * from TIZHENG_02 where TZBH=?", l, Tizheng.class);
			if(plans.size()>0)
				return plans.get(0);
			return null;
		}

			//通过体征得到腹泻的穴位
			public Tizheng selfuxiexw(String tizheng){

				List l = new ArrayList();
				l.add(tizheng);
				List<Tizheng> plans = this.executeQuery("select * from TIZHENG_03 where TZBH=?", l, Tizheng.class);
				if(plans.size()>0)
					return plans.get(0);
				return null;
			}

			//通过体征得到便秘的穴位
			public Tizheng selbianmixw(String tizheng){

				List l = new ArrayList();
				l.add(tizheng);
				List<Tizheng> plans = this.executeQuery("select * from TIZHENG_04 where TZBH=?", l, Tizheng.class);
				if(plans.size()>0)
					return plans.get(0);
				return null;
			}

			//通过体征得到保健的穴位
			public Tizheng selbaojianxw(String tizheng){

				List l = new ArrayList();
				l.add(tizheng);
				List<Tizheng> plans = this.executeQuery("select * from TIZHENG_05 where TZBH=?", l, Tizheng.class);
				if(plans.size()>0)
					return plans.get(0);
				return null;
			}

			//通过体征得到提高免疫力的穴位
			public Tizheng seltimianxw(String tizheng){

				List l = new ArrayList();
				l.add(tizheng);
				List<Tizheng> plans = this.executeQuery("select * from TIZHENG_06 where TZBH=?", l, Tizheng.class);
				if(plans.size()>0)
					return plans.get(0);
				return null;
			}

			//通过体征得到启动智慧的穴位
			public Tizheng selqizhixw(String tizheng){

				List l = new ArrayList();
				l.add(tizheng);
				List<Tizheng> plans = this.executeQuery("select * from TIZHENG_07 where TZBH=?", l, Tizheng.class);
				if(plans.size()>0)
					return plans.get(0);
				return null;
			}

}
