import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		
		String file = args[0];
		
		int rows = 0, columns = 0, NB_MAX_VEHICLE = 0, BONUS_TIME = 0, MAX_STEPS = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int id_line = 0;
		    try {
		    	
				while ((line = br.readLine()) != null) {
					
					System.out.println(line);
					
					if (id_line == 0) {
						String[] headers = new String[5];
						headers = line.split(" ");
						
						rows = Integer.parseInt(headers[0]);
						columns = Integer.parseInt(headers[1]);
						NB_MAX_VEHICLE = Integer.parseInt(headers[2]);
						BONUS_TIME = Integer.parseInt(headers[3]);
						MAX_STEPS = Integer.parseInt(headers[4]);
					}
					
					id_line++;
				}
			}
		    catch (IOException e) { e.printStackTrace(); }
		} 
		catch (FileNotFoundException e1) { e1.printStackTrace(); }
		catch (IOException e1) { e1.printStackTrace(); }

		Grid grid = new Grid(rows, columns, NB_MAX_VEHICLE, BONUS_TIME, MAX_STEPS);
		
		System.out.println(grid);
		
	}

}
