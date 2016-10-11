package main;

import java.util.LinkedList;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Line {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true)
	public Metro metro;
	
	public LinkedList<Station> stations;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Station> stationsField;
	
	public LinkedList<Train> trains;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Train> trainsField;

	@Override
	public String toString() {
		return "\nLine [name=" + name + ", stations=" + stations + ", trains=" + trains + "]";
	}

	public Line(String name) {
		super();
		this.name = name;
		this.id = ++num;
		this.stations = new LinkedList<>();
		this.trains = new LinkedList<>();
	}
	
	public Line() {
		super();
	}

}
