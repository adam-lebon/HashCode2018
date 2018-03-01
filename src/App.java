import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		String file = args[0];
		
		int rows = 0, columns = 0, NB_MAX_VEHICLE = 0, BONUS_TIME = 0, MAX_STEPS = 0;
		
		ArrayList<Vehicle> vehicle_list = new ArrayList<Vehicle>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int id_line = 0;
		    try {
		    	
				while ((line = br.readLine()) != null) {
					
					System.out.println(line);
					
					String[] headers = new String[6];
					
					if (id_line == 0) {
						headers = line.split(" ");
						
						rows = Integer.parseInt(headers[0]);
						columns = Integer.parseInt(headers[1]);
						NB_MAX_VEHICLE = Integer.parseInt(headers[2]);
						BONUS_TIME = Integer.parseInt(headers[3]);
						MAX_STEPS = Integer.parseInt(headers[4]);
					} else {
						
						int start_x = Integer.parseInt(headers[0]);
						int start_y = Integer.parseInt(headers[1]);
						int finish_x = Integer.parseInt(headers[2]);
						int finish_y = Integer.parseInt(headers[3]);
						int earliestStart = Integer.parseInt(headers[4]);
						int latestFinish = Integer.parseInt(headers[5]);
						
						Vehicle v = new Vehicle(id_line, new Point(start_x, start_y), new Point(finish_x, finish_y), earliestStart, latestFinish);
						
						vehicle_list.add(v);
					}
				
					id_line++;
				}
			} catch (IOException e) { e.printStackTrace(); }
		} 
		catch (FileNotFoundException e1) { e1.printStackTrace(); }
		catch (IOException e1) { e1.printStackTrace(); }

		Grid grid = new Grid(rows, columns, NB_MAX_VEHICLE, BONUS_TIME, MAX_STEPS );
		
		
		System.out.println(grid);
		
	}

}
