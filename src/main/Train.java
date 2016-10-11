package main;

import java.util.LinkedList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Train {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	private int count;
	
	@DatabaseField(foreign=true)
	public Driver driver;
	
	@DatabaseField(foreign=true)
	public Line line;
	
	private LinkedList<Wagon> wagons;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Wagon> wagonsField;

	public Train() {
		super();
		this.wagons = new LinkedList<>();
		this.count = 0;
		this.id = ++num;
	}
	
	public void addWagon(Wagon wagon) {
		if (wagon.type && !isFirst()) {
			wagons.addFirst(wagon);;
		} else if (wagon.type && !isLast()) {
			wagons.addLast(wagon);
		} else if (!wagons.isEmpty() && this.count<2) {
			wagons.add(1, wagon);
		}
	//TODO modify count condition
	}
	
	@Override
	public String toString() {
		return "\nTrain [id=" + id + ", wagons=" + wagons + "]";
	}

	public boolean isFull() {
		return wagons.size()==5;
	}
	
	private boolean isFirst() {
		if (wagons.isEmpty()) {
			return false;
		} else {
			return wagons.getFirst().type;
		}
	}
	
	private boolean isLast() {
		if (wagons.isEmpty()) {
			return false;
		} else {
			return wagons.getLast().type;
		}
	}

}
