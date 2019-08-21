package com.abhyuday.seleniumbddwithreports.generators;

import com.abhyuday.seleniumbddwithreports.fileio.FileHandler.CSVFileHandler;

public class LogGenerator {

	private static String FILE_PATH = null;
	private static CSVFileHandler csvFileHandler = null;
	
	public static void openLogSession() {
		FILE_PATH = System.getProperty("user.dir") + "\\output\\logs.csv";
		System.out.println(FILE_PATH);
		csvFileHandler = new CSVFileHandler(FILE_PATH);
	}
	
	public static void log(String[] data) {
		StringBuilder logData = new StringBuilder();
		for(String datum: data) {
			logData.append(datum);
			logData.append(",");
		}
		logData.deleteCharAt(logData.length() - 1);
		csvFileHandler.writeToCSV(logData.toString());
	}
	
	public static void closeLogSession() {
		csvFileHandler.closeCSVFileSession();
	}
}
