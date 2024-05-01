package com.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ReadDB {
	
	public static ResultSet readDb(String query) {
		Properties prop = ReadProp.readData("Config.properties");
		ResultSet results = null;
		
		try {
			Connection dbConnection = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbusername"), prop.getProperty("dbpassword"));
			results = dbConnection.createStatement().executeQuery(query);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return results;
	}
	
	public static List<Map<String,String>> readData(String query){
		
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();		
		
		try {
			ResultSet results = readDb(query);
			while(results.next()) {				
				Map<String,String> record = new HashMap<String,String>();
				for( int i=1; i<=results.getMetaData().getColumnCount() ; i++) {
					String columnName = results.getMetaData().getColumnName(i);
					String columnValue = results.getString(i);
					record.put(columnName, columnValue);
				}
				data.add(record);
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return data;	
		
	}

}
