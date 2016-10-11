package main;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Train_moving_line {
	@DatabaseField(id=true)
	public int id;
	
	@DatabaseField(foreign=true)
	public Train train;
	
	@DatabaseField(foreign=true)
	public Station station;
	
	@DatabaseField(foreign=true)
	public Driver driver;
	
	@DatabaseField
	public Date dateTime;

	public Train_moving_line() {
		super();
	}

}
