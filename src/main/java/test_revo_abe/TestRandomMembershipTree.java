package test_revo_abe;

import java.util.Random;

public class TestRandomMembershipTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random(54321);
		byte[] nb = new byte[4];
		rd.nextBytes(nb);
		
		for (byte b:nb) {
			
			System.out.print(String.format("%x, ", b));
		}
		rd.nextBytes(nb);
		
		for (byte b:nb) {
			
			System.out.print(String.format("%x, ", b));
		}
		
	}

}
