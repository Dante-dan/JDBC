package com.dante.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCtest {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class类
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root1234");//获取mysql的数据库连接
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void insert(){
		Connection conn = getConnection();
		try{
			String sql = "insert into tbl_user(user_name,user_age,signup_date,email)"+
						"values('TOM','25','2016-11-08','tom@gmail.com')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			//可以执行DML语句（数据操作语句：select,insert,update,delete）返回影响的记录条数
			//执行DDL语句（数据定义语句：CREATE,ALTER,DROP），返回零
			//能抛出sqlException和sqlTimeoutException异常
			System.out.println("向用户表中插入了 "+count+"条记录");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void update() {
		Connection conn = getConnection();
		try{
			String sql = "update tbl_user set user_name = 'Tom' where user_name='TOm'";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			//可以执行DML语句（数据操作语句：select,insert,update,delete）返回影响的记录条数
			//执行DDL语句（数据定义语句：CREATE,ALTER,DROP），返回零
			//能抛出sqlException和sqlTimeoutException异常
			System.out.println("向用户表中更新了 "+count+"条记录");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void delete(){
		Connection conn = getConnection();
		try{
			String sql = "Delete from tbl_user where ID=3";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			//可以执行DML语句（数据操作语句：select,insert,update,delete）返回影响的记录条数
			//执行DDL语句（数据定义语句：CREATE,ALTER,DROP），返回零
			//能抛出sqlException和sqlTimeoutException异常
			System.out.println("在用户表中删除了 "+count+"条记录");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	/*
	 * 	// TODO Auto-generated method stub
	 * String sql = "select * from tbl_user";
	 *	Connection conn = null;		//当前数据库连接
		Statement st = null;		//向数据库发送的sql语句		
		ResultSet rs = null;		//结果集，封装了从数据库中查询到的数据
		try {
			Class.forName("com.mysql.jdbc.Driver");		//注册Mysql的JDBC驱动程序
			//Class类继承自Object类，这个类封装被装载的JVM中的类的信息 ，比如类的成员方法，成员变量以及类实现的接口，父类等。
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root1234");//获取mysql的数据库连接
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//遍历对象
			while(rs.next()){
				System.out.print(rs.getInt("ID")+"\t");
				System.out.print(rs.getString("user_name")+"\t");
				System.out.print(rs.getString("user_age")+"\t");
				System.out.print(rs.getString("email")+"\t");
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch(Exception e2){
				// TODO: handle finally clause
			}
			try {
				st.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	 */
	//insert();
	//	update();
		delete();
	}
}
