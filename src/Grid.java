import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Vehicle>[][] tab;
	
	public int rows;
	public int columns;
	public int NB_MAX_VEHICLE;
	public int BONUS_TIME;
	public int MAX_STEPS;
	
	
	public Grid(int rows, int columns, int NB_MAX_VEHICLE, int BONUS_TIME, int MAX_STEPS) {
		this.rows = rows;
		this.columns= columns;
		this.NB_MAX_VEHICLE = NB_MAX_VEHICLE;
		this.BONUS_TIME = BONUS_TIME;
		this.MAX_STEPS = MAX_STEPS;
	}
	
}
