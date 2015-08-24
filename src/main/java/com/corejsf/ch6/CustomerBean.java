package com.corejsf.ch6;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Named
@RequestScoped
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5556250598209138583L;

	public ResultSet getAll() throws SQLException, NamingException {

		Context initContext = new InitialContext();
        Context webContext = (Context)initContext.lookup("java:jboss");

        DataSource ds = (DataSource) webContext.lookup("datasources/MySQLDS");
		
		Connection conn = ds.getConnection();

		try {

			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM Customers");

			return result;

		} finally {
			//conn.close();
		}
	}
}
