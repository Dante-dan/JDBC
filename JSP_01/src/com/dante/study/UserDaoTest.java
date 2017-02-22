package com.dante.study;

import java.sql.Connection;


import com.dante.dao.UserDao;
import com.dante.dao.UserDaoImpl;
import com.dante.entity.User;
import com.dante.util.ConnectionFactory;

public class UserDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setName("Tom");
			tom.setAge("45");
			tom.setEmail("tom@gmail.com");
			userDao.save(conn, tom);
			conn.commit();
			System.out.println("事务执行成功");
		} catch (Exception e) {
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}

}
