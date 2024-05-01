package com.policy.policyVerify.helper;

import java.util.Random;

public class LeadIdGenerator {

	private static final String PREFIX = "JIO";
    private static final int ID_LENGTH =3;
    
	public static String generateID() {
		   StringBuilder sb = new StringBuilder(PREFIX);

	       Random random = new Random();
	       for (int i = 0; i < ID_LENGTH; i++) {
	           if (random.nextBoolean()) { 
	               char randomChar = (char) (random.nextInt(26) + 'A');
	               sb.append(randomChar);
	           } else {
	               int randomNumber = random.nextInt(10); 
	               sb.append(randomNumber);
	           }
	       }

	       return sb.toString();
	   }
}
