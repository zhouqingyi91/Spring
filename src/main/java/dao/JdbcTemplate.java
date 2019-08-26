package dao;

import po.Customer;

import java.sql.*;

public abstract class JdbcTemplate {

	public Integer insert(Customer customer) {
		System.out.println("JdbcCustomerDaoImpl...");
		Integer line = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			// 1. 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///ssm";
			String username = "root";
			String password = "";
			// 2. 获取链接
			connection = DriverManager.getConnection(url, username, password);
			
			//statement
			line = executeStatement(connection,customer);
			
			// 5. 处理结果集
			// 返回值表示影响了几行
			System.out.println(line);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return line;

	}
	abstract int executeStatement(Connection connection,Object param)  throws ClassNotFoundException,SQLException;
}
