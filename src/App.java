import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.glass.ui.SystemClipboard;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

public class App {

	public static void main(String[] args) {
		
		String file = args[0];
		
		int rows = 0, columns = 0, NB_MAX_VEHICLE = 0, NB_RIDES = 0, BONUS_TIME = 0, MAX_STEPS = 0;
		
		ArrayList<Passenger> passengers_list = new ArrayList<Passenger>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int id_line = 0;
		    try {
		    	
				while ((line = br.readLine()) != null) {
					
					System.out.println(line);
					
					String[] headers = new String[6];
					headers = line.split(" ");

					if (id_line == 0) {
						rows = Integer.parseInt(headers[0]);
						columns = Integer.parseInt(headers[1]);
						NB_MAX_VEHICLE = Integer.parseInt(headers[2]);
						NB_RIDES = Integer.parseInt(headers[3]);
						BONUS_TIME = Integer.parseInt(headers[4]);
						MAX_STEPS = Integer.parseInt(headers[5]);
					} else {
						int start_x = Integer.parseInt(headers[0]);
						int start_y = Integer.parseInt(headers[1]);
						int finish_x = Integer.parseInt(headers[2]);
						int finish_y = Integer.parseInt(headers[3]);
						int earliestStart = Integer.parseInt(headers[4]);
						int latestFinish = Integer.parseInt(headers[5]);
						
						Passenger v = new Passenger(id_line-1, new Point(start_x, start_y), new Point(finish_x, finish_y), earliestStart, latestFinish);
						
						passengers_list.add(v);
					}
				
					id_line++;
				}
			} catch (IOException e) { e.printStackTrace(); }
		} 
		catch (FileNotFoundException e1) { e1.printStackTrace(); }
		catch (IOException e1) { e1.printStackTrace(); }

		Grid grid = new Grid(passengers_list, rows, columns, NB_MAX_VEHICLE, BONUS_TIME, MAX_STEPS );
		
		
		System.out.println(grid);
		
	}

}
