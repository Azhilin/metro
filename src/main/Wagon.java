package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Wagon implements IMetroElement {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	public boolean type;
	
	public List<Passenger> passengers;
	
	@DatabaseField(foreign=true)
	public Train train;

	public Wagon(boolean type) {
		super();
		this.type = type;
		this.id = ++num;
		this.passengers = Collections.synchronizedList(new LinkedList<>());
	}
	
	public Wagon() {
		super();
	}

	@Override
	public String toString() {
		return "Wagon [" + "type=" + type + "]";
	}

}
