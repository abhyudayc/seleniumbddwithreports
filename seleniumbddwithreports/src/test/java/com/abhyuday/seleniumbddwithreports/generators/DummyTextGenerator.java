package com.abhyuday.seleniumbddwithreports.generators;

import java.util.ArrayList;
import java.util.List;

public class DummyTextGenerator {

	public static String generateAlphaNumericText (int lengthOfText) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
   
        StringBuilder sb = new StringBuilder(lengthOfText); 
  
        for (int i = 0; i < lengthOfText; i++) { 
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index)); 
        } 
  
        return sb.toString();
	}
	
	public static String generateAlphabeticText (int lengthOfText) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
   
        StringBuilder sb = new StringBuilder(lengthOfText); 
  
        for (int i = 0; i < lengthOfText; i++) { 
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index)); 
        } 
  
        return sb.toString();
	}
	
	public static String generateRandomWords () {
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Bengaluru");
		listOfWords.add("Deer");
		listOfWords.add("National Geographic");
		listOfWords.add("Australia");
		listOfWords.add("Bay of Bengal");
		listOfWords.add("Indian National Flag");
		
		return listOfWords.get((int)(Math.random()*10) % listOfWords.size());
	}
}
