package DECATHLON.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv_info {

	public ArrayList<ArrayList<String>> complete_info() throws NumberFormatException, IOException {

		final String csvFile = "results.csv";
		final String cvsSplitBy = ";";
		final Events_point_calculator ev = new Events_point_calculator();
		int i = 0;
		int Total_Points = 0;
		String line = "";
		ArrayList<String> Totals = new ArrayList<String>();
		ArrayList<ArrayList<String>> data1 = new ArrayList<ArrayList<String>>();
		
		// Reads CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				ArrayList<String> ldata = new ArrayList<String>();
				
				// Populates data from CSV into an array, iterates between each CSV line until there's none
				for (String cell : line.split(cvsSplitBy)) {
					ldata.add(cell);
				}
				// We add CSV information to a multidimensional array to manage the information better
				data1.add(ldata);
			}
		}

		// Calculates total points of each participant, then add this to a new String Array
		for (i = 0; i < data1.size(); i++) {
			Total_Points = ev.houndread_meters(Double.parseDouble(data1.get(i).get(1)))
					+ ev.long_jump(Double.parseDouble(data1.get(i).get(2)))
					+ ev.shot_put(Double.parseDouble(data1.get(i).get(3)))
					+ ev.high_jump(Double.parseDouble(data1.get(i).get(4)))
					+ ev.four_houndread_meters(Double.parseDouble(data1.get(i).get(5)))
					+ ev.houndread_ten_hurdles(Double.parseDouble(data1.get(i).get(6)))
					+ ev.discuss_throw(Double.parseDouble(data1.get(i).get(7)))
					+ ev.pole_vault(Double.parseDouble(data1.get(i).get(8)))
					+ ev.javelin_throw(Double.parseDouble(data1.get(i).get(9)))
					+ ev.fifteen_houndread_meters(data1.get(i).get(10));
			
			String total_to_string = Integer.toString(Total_Points);
			Totals.add(total_to_string);
		}
		
		// Adds Total Points to the main CSV array information
		for (i = 0; i < data1.size(); i++) {
			data1.get(i).add(Totals.get(i));
		}
		
		// Returns the main CSV array
		return data1;
	}
	
}