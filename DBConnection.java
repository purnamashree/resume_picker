package com.sagarsoft.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
		private static Connection connection;
		private DBConnection() {
			
		}
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shree","shree");
				//System.out.println("connected...");
			}//end of try
			catch(Exception e) {
				e.printStackTrace();
			}
		}//end of static block
		public static Connection getCon() {
			return connection;
		}
}

