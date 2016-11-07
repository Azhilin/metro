package main;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Wagon implements IMetroElement {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	public boolean type;
	
	@DatabaseField(foreign=true)
	public Train train;

	public Wagon(boolean type) {
		super();
		this.type = type;
		this.id = ++num;
	}
	
	public Wagon() {
		super();
	}

	@Override
	public String toString() {
		return "Wagon [" + "type=" + type + "]";
	}

}
