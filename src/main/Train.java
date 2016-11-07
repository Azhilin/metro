package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Train implements IMetroElement {
	@DatabaseField(id=true)
	public int id;
	
	private static int num = 0;
	
	private int count;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true)
	public Driver driver;
	
	public Station station;
	
	@DatabaseField(foreign=true)
	public Line line;
	
	private LinkedList<Wagon> wagons;
	
	private CyclicBarrier barrier;
	
	@ForeignCollectionField(eager=true)
	public ForeignCollection<Wagon> wagonsField;

	public Train() {
		super();
		this.wagons = new LinkedList<>();
		this.count = 0;
		this.id = ++num;
	}
	
	public Train(String trainName) {
		super();
		this.count = 0;
		this.id = ++num;
		this.name = trainName + id;
		this.driver = new Driver("DefaultDriver" + id);
		this.wagons = new LinkedList<>();
		this.barrier = new CyclicBarrier(5);
	}
	
	public Visit_station moveToStation(Station st) {
		this.station = st;
		
		getPassInWagon(0, st);
		getPassInWagon(1, st);
		getPassInWagon(2, st);
		getPassInWagon(3, st);
		getPassInWagon(4, st);
		
		return new Visit_station(st, this);
	}
	
	public void getPassInWagon(int wagonNum, Station st) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Wagon wg = wagons.get(wagonNum);
				
				Random rd = new Random();
				
				while (!st.passengers.isEmpty()) {
					Passenger pass = st.passengers.remove(0);
					
					System.out.println("Passenger " + pass.name + " entered in wagon " + wagonNum);
					
					wg.passengers.add(pass);
					
					
					
					try {
						Thread.sleep((rd.nextInt(100)+1)*10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					System.out.println("Wagon " + wagonNum + " is full: " + wg.passengers.size() + " passengers");
					barrier.await();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BrokenBarrierException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}).start();
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
		return "\nTrain [id=" + id + ", name=" + name + ", wagons=" + wagons + "]";
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
