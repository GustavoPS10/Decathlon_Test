package DECATHLON.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Test;

public class AppTest {
	// Validates event formulas work
	@Test
	public void Formulas_validation() {
		System.out.println("Assesting events formulas work");
		final Events_point_calculator ev = new Events_point_calculator();
		assertEquals(ev.houndread_meters(12.61), 536);
		assertEquals(ev.long_jump(5.00), 382);
		assertEquals(ev.shot_put(9.22), 439);
		assertEquals(ev.high_jump(1.50), 389);
		assertEquals(ev.four_houndread_meters(60.39), 400);
		assertEquals(ev.houndread_ten_hurdles(16.43), 685);
		assertEquals(ev.discuss_throw(21.60), 302);
		assertEquals(ev.pole_vault(2.60), 264);
		assertEquals(ev.javelin_throw(35.81), 382);
		assertEquals(ev.fifteen_houndread_meters("5.25.72"), 421);
		System.out.println("......... DONE");
	}

	// Validates none of the CSV information is empty
	@Test
	public void Csv_data_NotEmpty_validation() throws NumberFormatException, IOException {
		System.out.println("Assesting CSV data");
		Csv_info c = new Csv_info();
		
		c.complete_info().forEach(tp -> {
			for (int i = 0; i <= 11; i++) {
				assertFalse(tp.get(i).isEmpty());
			}
		});
		System.out.println("......... DONE");
	}
	
	// Validates XML data
	@Test
	public void Xml_data_validation() throws NumberFormatException, IOException {
		System.out.println("Assesting XML data");
		System.out.println("......... DONE");
	}

}
