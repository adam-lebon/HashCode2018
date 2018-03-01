import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Positionable>[][] tab;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Passenger> passengers;
	
	public int rows;
	public int columns;
	public int NB_MAX_VEHICLE;
	public int BONUS_TIME;
	public int MAX_STEPS;
	
	
	public Grid(ArrayList<Passenger> passengers, int rows, int columns, int NB_MAX_VEHICLE, int BONUS_TIME, int MAX_STEPS) {
		this.rows = rows;
		this.columns= columns;
		this.NB_MAX_VEHICLE = NB_MAX_VEHICLE;
		this.BONUS_TIME = BONUS_TIME;
		this.MAX_STEPS = MAX_STEPS;
		this.passengers = passengers;

		for (int i = 0 ; i < NB_MAX_VEHICLE ; i++) {
			Vehicle v = new Vehicle(i);
			this.vehicles.add(v);
			this.tab[0][0].add(v);
		}

		for (int i = 0 ; i < this.passengers.size() ; i++) {
			Passenger p = this.passengers.get(i);
			this.tab[p.start.x][p.start.y].add(p);
		}

		this.tick();
	}

	private int getDistanceBetween(Positionable a, Positionable b) {
        return Math.abs(a.position.x - b.position.x) + Math.abs(a.position.y - b.position.y);
	}

    private Vehicle getNearestVehicle(Passenger passenger) {
        Vehicle nearestVehicle = this.vehicles.get(0);
        for(int i = 1 ; i < this.vehicles.size(); i++) {
            if (
                this.getDistanceBetween(passenger, this.vehicles.get(i))
                < this.getDistanceBetween(passenger, nearestVehicle)
            ) {
                nearestVehicle = this.vehicles.get(i);
            }
        }
        return nearestVehicle;
	}
	
	private Passenger getNearestPassenger(Vehicle vehicle) {
		Passenger nearestPassenger = this.passengers.get(0);
        for (int i = 1 ; i < this.passengers.size(); i++) {
            if (
                this.getDistanceBetween(vehicle, this.passengers.get(i))
                < this.getDistanceBetween(vehicle, nearestPassenger)
            ) {
                nearestPassenger = this.passengers.get(i);
            }
        }
        return nearestPassenger;
	}

	private void tick() {

	}
}
