public class Vehicle {
    public int x;
    public int y;
    public Passenger passenger;

    Vehicle() {
        
    }

    /**
     * Take a passenger in the car
     * The passenger must be at the same position as the car
     * @param passenger New passenger to take
     * @throws Error If a passenger is already in the car
     */
    public void takePassenger(Passenger passenger) {
        if (this.passenger != null) {
            throw new Error("The car can't take 2 passengers");
        }

        if (this.x != passenger.x || this.y != passenger.y) {
            throw new Error("The car isn't at the same position as the passenger");
        }
        this.passenger = passenger;
    }

    /**
     * Drop a passenger on the current location
     */
    public Passenger dropPassenger() {
        Passenger p = this.passenger;
        this.passenger = null;
        return p;
    }

    /**
     * Move to the given direction
     * @param direction Direction to move (0: right, 1: bottom, 2: left, 3: top)
     */
    public void move(int d) {
        switch(d) {
            case 0:
                this.x++;
                break;

            case 1:
                this.y--;
                break;
            
            case 2:
                this.x--;
                break;

            case 3:
                this.y++;
                break;
        }
    }
}

