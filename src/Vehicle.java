import java.util.ArrayList;

public class Vehicle extends Positionable {
	
	private int id;
   
    public Passenger passenger;
    public Passenger target;

    public ArrayList<int> passengers = new ArrayList<int>();


    Vehicle(int id) {
        this.id = id;
    }

    /**
     * Set a passenger in the car
     * The passenger must be at the same position as the car
     * @param passenger New passenger to take
     * @throws Error If a passenger is already in the car
     */
    public void setPassenger(Passenger passenger) {
        if ( hasPassenger() ) {
            throw new Error("The car can't take 2 passengers");
        }

        if (this.position.x != passenger.position.x || this.position.y != passenger.position.y) {
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
    
    public boolean hasPassenger() {
    	return (this.passenger != null);
    }

    /**
     * Move to the given direction
     * @param direction Direction to move (0: right, 1: bottom, 2: left, 3: top)
     */
    public void move(int d) {
        switch(d) {
            case 0:
                this.position.x++;
                break;

            case 1:
                this.position.y--;
                break;
            
            case 2:
                this.position.x--;
                break;

            case 3:
                this.position.y++;
                break;
        }
    }
    
}

