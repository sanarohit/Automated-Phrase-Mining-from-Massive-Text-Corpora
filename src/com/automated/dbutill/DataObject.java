package com.automated.dbutill;

import java.sql.Connection;
import java.util.Properties;

public class DataObject{
	
	private static  Connection connection;
	private static Properties props;

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		DataObject.connection = connection;
	}

	/**
	 * @return the props
	 */
	public Properties getProperties() {
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProperties(Properties props) {
		DataObject.props = props;
	}

}
