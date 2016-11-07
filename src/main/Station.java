package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Station implements IMetroElement {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true)
	public Line line;
	
	public List<Passenger> passengersInHall;
	
	public List<Passenger> passengers;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Passenger> passengersField;

	public Station(String name) {
		super();
		this.name = name;
		this.id = ++num;
		this.passengersInHall = Collections.synchronizedList(new LinkedList<>());
		this.passengers = Collections.synchronizedList(new LinkedList<>());
	}
	
	public Station() {
		super();
	}

}
