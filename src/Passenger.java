public class Passenger {
    /**
     * Current x and y location
     */
    public int x;
    public int y;
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
    Passenger(int x, int y, int minStart, int maxDrop) {
        this.x = x;
        this.y = y;
        this.minStart = minStart;
        this.maxDrop = maxDrop;
    }
}
