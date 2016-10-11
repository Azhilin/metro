package main;

import java.util.Random;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Driver {
	@DatabaseField(id=true)
	private int id;
	
	private static int num = 0;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	public int expLevel;
	
	@DatabaseField(foreign=true)
	public Train train;

	@Override
	public String toString() {
		return "Driver [name=" + name + ", expLevel=" + expLevel + "]";
	}

	public Driver(String name) {
		super();
		this.name = name;
		Random rnd = new Random();
		this.expLevel = rnd.nextInt(10);
		this.id = ++num;
	}
	
	public Driver() {
		super();
	}
	
	public void expModify() {
		Random rnd = new Random();
		this.expLevel = this.expLevel + rnd.nextInt(7)-3;
	}

}
