package com.dante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dante.entity.User;

public class UserDaoImpl implements UserDao {

	/*
	 * 保存用户信息
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn
				.prepareCall("insert into tbl_user(user_name,user_age,email)"
						+ "values(?,?,?)");
		//PreparedStatement继承自Statement，但是两者不同，PreparedStatement实例包含预编译的SQL语句，
		//可以用来查询含参的查询语句，其中?代表站位符，即参数值未被设定，需要通过适当的setxxx方法来提供
		ps.setString(1, user.getName());
		ps.setString(2, user.getAge());
		ps.setString(3, user.getEmail());
		ps.execute();
	}
	/*
	 * 根据用户指定的ID更新用户信息
	 */

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {

		String updateSql = "update tbl_user set user_name=?,user_age=?,email=? where id=?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2,user.getAge());
		ps.setString(3, user.getEmail());
		ps.setLong(5, id);
		ps.execute();
	}
	/*
	 * 删除指定的用户信息
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {

		String deleteSql = "Delete from tbl_user where id=?";
		PreparedStatement ps = conn.prepareStatement(deleteSql);
		ps.setLong(1, user.getId());
		ps.execute();
	}

}
