package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		
		DBManager dbManager = new DBManager();
		
		dbManager.dbSetUp();
/*		
		List<Wagon> depo = new ArrayList<>(50);
		
		Random rnd = new Random();
		for (int i=0; i<150; i++) {
			depo.add(new Wagon(rnd.nextInt(100)<30));//returns true in 30% cases
		}
		
		Set<Train> trains = new HashSet<Train>();
		
		Train train = new Train();
		for (Wagon wag: depo) {
			train.addWagon(wag);
			if(train.isFull()) {
				trains.add(train);
				train = new Train();
			}
		}
		
		Line line1 = new Line("Green");
		Line line2 = new Line("Blue");
		Line line3 = new Line("Red");
		
		Iterator<Train> iterator = trains.iterator();
		
		while (iterator.hasNext()) {
			line1.trains.add(iterator.next());
			iterator.remove();
			if (iterator.hasNext()) {
				line2.trains.add(iterator.next());
				iterator.remove();
				if (iterator.hasNext()) {
					line3.trains.add(iterator.next());
				}
			}
		}
		
		Metro metro = new Metro();
		metro.lines.add(line1);
		metro.lines.add(line2);
		metro.lines.add(line3);
		
		System.out.println(metro);
		
		
		int i = 0;
		for (Train trn: trains) {
			System.out.println(trn.toString());
			i++;
		}
		
		System.out.println("i = " + i);
		
		Driver dr1 = new Driver("Alex");
		Driver dr2 = new Driver("Bob");
		Driver dr3 = new Driver("Sam");
		Driver dr4 = new Driver("Tom");
		
		Comparator<Driver> comparator = new Comparator<Driver>() {
			@Override
			public int compare(Driver d1, Driver d2) {
				if (d1.expLevel > d2.expLevel) {
					return -1;
				}
				if (d1.expLevel < d2.expLevel) {
					return 1;
				}
				return 0;
			}
		};
		
		Queue<Driver> drivers = new PriorityQueue<>(comparator);
		drivers.add(dr4);
		drivers.add(dr3);
		drivers.add(dr2);
		drivers.add(dr1);
		
		System.out.println(drivers + "\n");
		
		for (Train trn: trains) {
			Driver dr = drivers.poll();
			trn.driver = dr;
			dr.expModify();
			drivers.add(dr);
			trn.driver = null;
			
			System.out.println("Driver " + dr + " train " + trn);
		}
		
		System.out.println("\n" + drivers);
*/
	}

}
