package com.dante.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.dante.entity.User;

public interface UserDao {
	/*
	 * DA0:Data Access Object是一个数据访问接口，接口能够保证类的外观不变。
	 * 只要接口不变，实现类的改变都不会影响接口的插拔性
	 */
	public void save(Connection conn,User user)throws SQLException;
	public void update(Connection conn,Long id,User user)throws SQLException;
	public void delete(Connection conn,User user)throws SQLException;
}
