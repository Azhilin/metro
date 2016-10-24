package main;

import java.util.LinkedList;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Station {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true)
	public Line line;
	
	public LinkedList<Passenger> passengers;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Passenger> passengersField;

	public Station(String name) {
		super();
		this.name = name;
		this.id = ++num;
		this.passengers = new LinkedList<>();
	}
	
	public Station() {
		super();
	}

}
