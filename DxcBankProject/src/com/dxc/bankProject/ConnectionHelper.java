package com.dxc.bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {

	public static Connection getConnection() {
		Connection connection = null;
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String pwd = rb.getString("password");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,pwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;	
}
}
