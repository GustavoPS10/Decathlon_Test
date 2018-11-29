package DECATHLON.Test;

public class Events_point_calculator {
	
	//These 3 arrays are the values necessary to calculate points, P comes from the actual performance and it's grabbed from the CSV main array
	final double[] A = new double[]{25.4347,0.14354,51.39,0.8465,1.53775,5.74352,12.91,0.2797,10.14,0.03768};
	final double[] B = new double[]{18,220,1.5,75,82,28.5,4,100,7,480};
	final double[] C = new double[]{1.81,1.4,1.05,1.42,1.81,1.92,1.1,1.35,1.08,1.85};
	
	public int houndread_meters(Double P) {
		return (int) (A[0]* Math.pow((B[0]-P),C[0]));
	}
	
	public int long_jump(Double P) {
		// Formula asks for meters, performance gives centimeters, have to multiply it to 100	
		return (int) (A[1]* Math.pow(((P*100)-B[1]),C[1]));
	}
	
	public int shot_put(Double P) {
		return (int) (A[2]* Math.pow((P-B[2]),C[2]));
	}
	
	public int high_jump(Double P) {
		// Formula asks for meters, performance gives centimeters, have to multiply it to 100
		return (int) (A[3]* Math.pow(((P*100)-B[3]),C[3]));
	}
	
	public int four_houndread_meters(Double P) {
		return (int) (A[4]* Math.pow((B[4]-P),C[4]));
	}
	
	public int houndread_ten_hurdles(Double P) {
		return (int) (A[5]* Math.pow((B[5]-P),C[5]));
	}
	
	public int discuss_throw(Double P) {
		return (int) (A[6]* Math.pow((P-B[6]),C[6]));
	}
	
	public int pole_vault(Double P) {
		// Formula asks for meters, performance gives centimeters, have to multiply it to 100
		return (int) (A[7]* Math.pow(((P*100)-B[7]),C[7]));
	}
	
	public int javelin_throw(Double P) {
		return (int) (A[8]* Math.pow((P-B[8]),C[8]));
	}
	
	public int fifteen_houndread_meters(String S) {
		// Because performance comes in Minutes dot Seconds, but formula is based on Seconds only
		// This separates minutes and seconds from performance to get total seconds
		Double min = Double.parseDouble(S.substring(0, S.indexOf(".")));
		Double sec = Double.parseDouble(S.substring(S.indexOf(".")+1, S.length()));
		
		// Multiplies minutes * 60 and adds up Seconds, to have total seconds and make the to formula work
    	Double P = (min * 60) + sec;
    	
    	return (int) (A[9]* Math.pow((B[9]-P),C[9]));
	}
	
}
