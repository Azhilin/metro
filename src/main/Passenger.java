package main;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Passenger {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true)
	public Station station;
	
	@DatabaseField(foreign=true)
	public Wagon wagon;
	
	public Passenger(String name) {
		super();
		this.name = name;
		this.id = ++num;
	}
	
	public Passenger() {
		super();
	}

}
