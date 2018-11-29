package DECATHLON.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Xml_output {

	Csv_info c = new Csv_info();
	Events_point_calculator ev = new Events_point_calculator();
	final String csvFile = "results.csv";
	final String cvsSplitBy = ";";
	String line = "";
	ArrayList<Integer> Totals_int = new ArrayList<Integer>();
	LinkedHashMap<Integer, String> linked_totals1 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals2 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals3 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals4 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals5 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals6 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals7 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals8 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals9 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals10 = new LinkedHashMap<>();
	LinkedHashMap<Integer, String> linked_totals11 = new LinkedHashMap<>();

	public void xml_creation() throws IOException {
		
		// Starts writing on the XML output
		try (FileWriter fos = new FileWriter("results_OUTPUT.xml")) {
			XMLOutputFactory f = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = f.createXMLStreamWriter(fos);
			
			// Lambda method to create an array of all total points from participants
			// ordering them in ascendant order
			c.complete_info().forEach(tp -> {
				Totals_int.add(Integer.parseInt(tp.get(11)));
			});
			Collections.sort(Totals_int);
			Collections.reverse(Totals_int);

			// Starts XML document
			writer.writeCharacters(System.getProperty("line.separator"));
			writer.writeCharacters(System.getProperty("line.separator"));
			
			// Loop to insert participant data from CSV starts here
			for (int i = 0; i < c.complete_info().size(); i++) {
				int p = i + 1;
				
				// Linked hash maps creates a relationship between Totals Points and Event performances
				// for each participant. This is to bind together participant's performances to their respective Total Points 
				// and having a way to output data depending of total points
				for (int x = 0; x < c.complete_info().size(); x++) {
					linked_totals1.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(0));
					linked_totals2.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(1));
					linked_totals3.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(2));
					linked_totals4.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(3));
					linked_totals5.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(4));
					linked_totals6.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(5));
					linked_totals7.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(6));
					linked_totals8.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(7));
					linked_totals9.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(8));
					linked_totals10.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(9));
					linked_totals11.put(Integer.parseInt(c.complete_info().get(x).get(11)), c.complete_info().get(x).get(10));
				}
				
				// Opening tag of Participants
				writer.writeStartElement("Participants");

				// Name of Participant
				writer.writeStartElement("Name");
				writer.writeCharacters(linked_totals1.get(Totals_int.get(i)));
				writer.writeEndElement();
				
				// Total of gained points
				writer.writeStartElement("Total_Points");
				writer.writeCharacters(Integer.toString(Totals_int.get(i)));
				writer.writeEndElement();
				
				// Placements
				writer.writeStartElement("Placement");
				if (p == 2) {
					writer.writeCharacters("Runner up in " + p + "nd Place!!");
				} else if (p >= 3) {
					writer.writeCharacters("In " + p + "th Place!!");
				} else if (p == 1) {
					writer.writeCharacters("The Champion!!! In " + p + "st Place!!");
				}
				writer.writeEndElement();

				// Events start here
				writer.writeStartElement("Events");

				// Event 100M
				writer.writeStartElement("Houndread_meters");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals2.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.houndread_meters(Double.parseDouble(linked_totals2.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event Long Jump
				writer.writeStartElement("Long_Jump");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals3.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.long_jump(Double.parseDouble(linked_totals3.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event Shot put
				writer.writeStartElement("Shot_Put");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals4.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.shot_put(Double.parseDouble(linked_totals4.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event High Jump
				writer.writeStartElement("High_Jump");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals5.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.high_jump(Double.parseDouble(linked_totals5.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event 400M
				writer.writeStartElement("Four_houndread_Meters");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals6.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.four_houndread_meters(Double.parseDouble(linked_totals6.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event 110m_hurdles
				writer.writeStartElement("Houndread_ten_hurdles");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals7.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.houndread_ten_hurdles(Double.parseDouble(linked_totals7.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event Discus Throw
				writer.writeStartElement("Discus_Throw");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals8.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.discuss_throw(Double.parseDouble(linked_totals8.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event Pole vault
				writer.writeStartElement("Pole_Vault");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals9.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.pole_vault(Double.parseDouble(linked_totals9.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event Javelin throw
				writer.writeStartElement("Javelin_Throw");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals10.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.javelin_throw(Double.parseDouble(linked_totals10.get(Totals_int.get(i))))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Event 1500M
				writer.writeStartElement("Fifteen_houndread_Meters");
				writer.writeStartElement("Performance");
				writer.writeCharacters(linked_totals11.get(Totals_int.get(i)));
				writer.writeEndElement();
				writer.writeStartElement("Points");
				writer.writeCharacters(Integer.toString(ev.fifteen_houndread_meters(linked_totals11.get(Totals_int.get(i)))));
				writer.writeEndElement();
				writer.writeEndElement();

				// Events end here
				writer.writeEndElement();

				// Ends the Participant tag
				writer.writeEndElement();
			}

			writer.close(); // Ends XML Document
			fos.close();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}




