public class Passenger extends Positionable {
    public int id;
    /**
     * Current x and y location
     */
    public Point start;
    public Point finish;

    /**
     * Minimum tick to take the passenger
     */
    public int minStart;
    /**
     * Maximum tick to drop the passenger
     */
    public int maxDrop;

    /**
     * Passenger constructor
     * @param minStart Minimum tick to take the passenger
     * @param maxDrop Maximum tick to drop the passenger
     */
    Passenger(int id, Point start, Point finish, int minStart, int maxDrop) {
        this.id = id;
        this.position = start;
        this.minStart = minStart;
        this.maxDrop = maxDrop;
    }

    public int getPriority(int tick) {
        return 0;
    }
    
}
