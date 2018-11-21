package com.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ��ݿ�Ĳ�������
 */
public class BaseDao {

	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rst;

	/**
	 * ��ȡ���ӵķ���
	 */
	protected final void getConnection() throws SQLException {
		conn = DBConnection.getConnection();

	}

	/**
	 * �ͷ���Դ�ķ���
	 */
	protected final void closeAll() {
		if (rst != null) {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rst = null;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	/**
	 * ����ִ��insert��delete��udpate���ķ���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	/*
	 * insert
	 */
	
	//有自增的
	protected final String executeUpdatepatient(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_patientid = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_patientid.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_patientid = rst.getString(1);
				System.out.println(seq_patientid + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_patientid;
	}
	//添加意见反馈
	protected final String executeUpdateFankuiyijian(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_fkyijianid = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_fkyijianid.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_fkyijianid = rst.getString(1);
				System.out.println(seq_fkyijianid + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_fkyijianid;
	}

	
	protected final String executeUpdaterecord(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_recordid = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_recordid.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_recordid = rst.getString(1);
				System.out.println(seq_recordid + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_recordid;
	}
	
	
	
	protected final String executeUpdatebuser(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_buserid = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_buserid.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_buserid = rst.getString(1);
				System.out.println(seq_buserid + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_buserid;
	}
	
	protected final String executeUpdatefenbu(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_moneyid = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_moneyid.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_moneyid = rst.getString(1);
				System.out.println(seq_moneyid + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_moneyid;
	}
	
	
	
	
	protected final String executeUpdate(String sql, List params)
			throws Exception {
		int count = 0;
		String seq_id = "";
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			// stmt =
			// this.conn.prepareStatement("select seq_id.NEXTVAL from dual");
			stmt = this.conn
					.prepareStatement("select seq_id.currval from dual");
			rst = stmt.executeQuery();

			if (rst.next()) {
				seq_id = rst.getString(1);
				System.out.println(seq_id + "   id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return seq_id;
	}
	
	
	/**
	 * update
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	protected final int executeUpdate1(String sql, List params) {
		System.out.println(sql);
		int count = 0;
		try {
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			count = stmt.executeUpdate();
			System.out.println("修改！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("修改失败！");
		} finally {
			this.closeAll();
		}
		return count;
	}

	/**
	 * ִ�в�ѯ�ķ���
	 * 
	 * @param sql
	 * @param params
	 * @param cla
	 *            ���ڷ�װ��ݵ�ʵ����
	 * @return
	 * @throws SQLException
	 */
	protected final List executeQuery(String sql, List params, Class cla) {
		// ������ݿ��в�ѯ�����
		List list = new ArrayList();
		try {
			// ��ȡʵ����������
			Field[] field = cla.getDeclaredFields();
			String[] names = new String[field.length];
			for (int i = 0; i < names.length; i++) {
				// ��ȡ�������
				names[i] = field[i].getName();
			}
			this.getConnection();
			stmt = this.conn.prepareStatement(sql);
			setPreparedStatement(params);
			rst = stmt.executeQuery();
			while (rst.next()) {
				// ������ʹ�������
				Object obj = cla.newInstance();
				for (int i = 0; i < names.length; i++) {
					String v = null;
					try {
						// ���������������ͬ
						// ���������ƻ�ȡ��Ӧ�е�ֵ
						// ���û�в�ѯ�����Զ�Ӧ���У������쳣����ѭ��
						v = rst.getString(names[i]).trim();
					} catch (Exception e) {
						continue;
					}
					if (v != null) {
						// ���������������
						field[i].setAccessible(true);
						// ��ȡ�����Ե��������
						Class type = field[i].getType();
						// ������ͽ�����Ӧ�ĸ�ֵ
						if (type == int.class || type == Integer.class) {
							field[i].set(obj, Integer.valueOf(v));
						} else if (type == double.class || type == Double.class) {
							field[i].set(obj, Double.valueOf(v));
						} else if (type == long.class || type == Long.class) {
							field[i].set(obj, Long.valueOf(v));
						} else {
							field[i].set(obj, v);
						}
					}
				}
				// �Ѷ�����ӵ�������
				list.add(obj);
			}

			//
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			this.closeAll();
		}
		return list;
	}

	/**
	 * ��Ԥ�����sql��丳ֵ
	 * 
	 * @param params
	 * @throws SQLException
	 */
	private void setPreparedStatement(List params) throws SQLException {
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
		}
	}
}
