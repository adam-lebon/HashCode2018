import java.util.ArrayList;

public class Grid {
	
	private ArrayList<ArrayList<ArrayList<Positionable>>> tab = new ArrayList<ArrayList<ArrayList<Positionable>>>();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
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
		
		for(int x = 0 ; x < columns ; x++) {
			this.tab.add(x, new ArrayList<ArrayList<Positionable>>());
			for (int y = 0 ; y < rows ; y++) {
				this.tab.get(x).add(y, new ArrayList<Positionable>());
			}
		}

		for (int i = 0 ; i < NB_MAX_VEHICLE ; i++) {
			Vehicle v = new Vehicle(i);
			this.vehicles.add(v);
			this.tab.get(0).get(0).add(v);
		}

		for (int i = 0 ; i < this.passengers.size() ; i++) {
			Passenger p = this.passengers.get(i);
			this.tab.get(p.position.x).get(p.position.y).add(p);
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
		Passenger nearestPassenger = null;
        for (int i = 0 ; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).vehicle != null) {
				if (nearestPassenger == null) {
					nearestPassenger = this.passengers.get(i);
				} else if (
					this.getDistanceBetween(vehicle, this.passengers.get(i))
					< this.getDistanceBetween(vehicle, nearestPassenger)
				) {
					nearestPassenger = this.passengers.get(i);
				}
			}
        }
        return nearestPassenger;
	}

	private void tick() {
		this.vehicles.forEach(vehicle -> {
			// Ne fait rien
			if (vehicle.target == null) {
				vehicle.passenger = this.getNearestPassenger(vehicle);
			}

			// En route vers le passagé
			if (vehicle.passenger == null) {
				if(vehicle.target.position.x - vehicle.position.x > 0) {
					vehicle.position.x++;
				} else if (vehicle.target.position.x - vehicle.position.x < 0) {
					vehicle.position.x--;
				} else if (vehicle.target.position.y - vehicle.position.y > 0) {
					vehicle.position.y++;
				} else if (vehicle.target.position.y - vehicle.position.y < 0) {
					vehicle.position.y--;
				} else {
					vehicle.passenger = vehicle.target;
				}
			} else { // En route vers la destination
				if(vehicle.passenger.finish.x - vehicle.position.x > 0) {
					vehicle.position.x++;
				} else if (vehicle.passenger.finish.x - vehicle.position.x < 0) {
					vehicle.position.x--;
				} else if (vehicle.passenger.finish.y - vehicle.position.y > 0) {
					vehicle.position.y++;
				} else if (vehicle.passenger.finish.y - vehicle.position.y < 0) {
					vehicle.position.y--;
				} else {
					vehicle.passenger = null;
					vehicle.passenger = this.getNearestPassenger(vehicle);
				}
			}
		});
	}
}
