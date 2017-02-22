package com.dante.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static final ConnectionFactory FACTORY = new ConnectionFactory();
	private Connection conn;
	static{
		/*
		 * 静态代码块，JVM在加载类的时候会执行静态代码块
		 */
		Properties prop = new Properties();
		try{
			InputStream  in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			//getClassLoader()类加载器，getResourceAsStream()可以将属性文件内容读取到输入流中
			prop.load(in);
			//利用properties中的load方法读取文件中的键值对。
		} catch(Exception e){
			System.out.println("==========配置文件读取错误============");
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	private ConnectionFactory(){
		
	}
	public static ConnectionFactory getInstance(){
		return FACTORY;
	}
	//单例模式可以保证在程序执行过程中只有一个connectionfactor实例存在
	public Connection makeConnection(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
