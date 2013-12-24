package com.sunrun.crportal.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.InfrastructureUtil;

public abstract class DBConnectionFactory {
	
	private static final Log LOG = LogFactory.getLog(DBConnectionFactory.class);

	public static Connection getLiferayDBConnection() {
		
		Connection connection = null;
		DataSource dataSource = InfrastructureUtil.getDataSource();
		try {
			connection = dataSource.getConnection();
			System.out.println("LF Connection is ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	
	
	public static Connection getPostgresDBConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/LQDatabase");
			connection = ds.getConnection();
			System.out.println("postdb -Connection is ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	} 
	
	
	public static void main(String args[]) {
		try {
			Connection con1  = getPostgresDBConnection();
			Connection con2  = getLiferayDBConnection();
			//System.out.println("Connection is ok");
			/*PreparedStatement ps = con.prepareStatement("select * from user_lq");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("Record exists");
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
