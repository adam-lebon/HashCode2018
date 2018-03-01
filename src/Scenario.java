public class Scenario {
    private int tick = 0;
    private Grid grid;
    
    Scenario() {
        this.tick();
    }

    private int getDistanceBetween(IPositionable a, IPositionable b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private Vehicle getNearestVehicle(Passenger passenger) {
        Vehicle nearestVehicle = this.grid.vehicles.get(0);
        for(int i = 1 ; i < this.grid.vehicles.size(); i++) {
            if (
                this.getDistanceBetween(passenger, this.grid.vehicles.get(i))
                < this.getDistanceBetween(passenger, nearestVehicle)
            ) {
                nearestVehicle = this.grid.vehicles.get(i);
            }
        }
        return nearestVehicle;
    }

	public void tick() {
		this.tick++;
	}
}