package com.dante.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
	public static Connection getConnection() {
		/*
		 * 将数据库连接代码，设置成一个静态方法，可以缩小代码量，
		 */
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册Mysql的JDBC驱动程序
			//Class类继承自Object类，这个类封装被装载的JVM中的类的信息 ，比如类的成员方法，成员变量以及类实现的接口，父类等。
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root1234");
			//getConnection的三个对象分别是数据库的URL，用户名，密码
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertUserData(Connection conn) throws SQLException {
		/*
		 * 插入用户表
		 */
		String sql = "insert into tbl_user(user_name,user_age,signup_date,email,ID)"
				+ "values('Tom','45','2015-01-25','tom@gmail.com',10)";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		//executeUpdate()可以执行DML语句（数据操作语句：select,insert,update,delete）返回影响的记录条数
		//执行DDL语句（数据定义语句：CREATE,ALTER,DROP），返回零
		//能抛出sqlException和sqlTimeoutException异常
		System.out.println("向用户表插入了" + count + "条记录");

	}

	public static void insertAddressData(Connection conn) throws SQLException {
		/*
		 * 插入地址表
		 */
		String sql = "insert into tbl_address(ID,city,country,user_id)" 
				+ "values(1,'USA','Califormia',10)";
		// 由于表中已存在ID为1的记录，所以这里会出现插入异常（主键重复），此时为保证数据库的一致性，先前的操作插入用户表操作应撤回
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向地址表插入了" + count + "条记录");

	}

	public static void main(String[] args) throws SQLException {

		Connection conn = getConnection();
		conn.setAutoCommit(false);
		try {
			insertUserData(conn);
			insertAddressData(conn);
		} catch (SQLException e) {
			System.out.println("=========捕获到SQL异常========");
			e.printStackTrace();
			try {
				conn.rollback();
				// 撤回的是try里面的语句，即try里面定义了一个事务
				System.out.println("=========事务回滚成功=======");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
