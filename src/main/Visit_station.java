package main;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Visit_station {
	@DatabaseField(id=true)
	public int id;
	
	public Station station;
	
	public Train train;
	
	@DatabaseField(foreign=true)
	public Train_moving_line trMovLine ;
	
	@DatabaseField
	public int passIn;
	
	@DatabaseField
	public int passOut;

	public Visit_station(Station st, Train tr) {
		super();
		this.station = st;
		this.train = tr;
	}

}
