package main;

import java.util.LinkedList;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Metro {
	public LinkedList<Line> lines;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Line> linesField;

	@Override
	public String toString() {
		return "Metro [lines=" + lines + "]";
	}

	public Metro() {
		super();
		this.lines = new LinkedList<>();
	}

}
