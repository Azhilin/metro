package main;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBManager {
	ConnectionSource connectionSource;
	
	private ConnectionSource dbConnector() {
		
		String login = "root";
		String password = "password";		
		String databaseURL = "jdbc:mysql://localhost/metro?" + "user=" + login + "&password=" + password;
		
		try {
			return new JdbcConnectionSource(databaseURL);			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public DBManager() {
		super();
		this.connectionSource = dbConnector();
	}

	public void dbSetUp() {
		createTable(Driver.class);
		createTable(Line.class);
		createTable(Passanger.class);
		createTable(Station.class);
		createTable(Train.class);
		createTable(Wagon.class);
		createTable(Train_moving_line.class);
		createTable(Visit_station.class);
		createTable(Metro.class);
	}
	
	public void createTable(Class<?> localClass) {
		try {
			TableUtils.dropTable(connectionSource, localClass, true);
			TableUtils.createTable(connectionSource, localClass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClear() {
		
	}

}
